package ExcelHandlingUsingApachePOI;

import java.text.DecimalFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterestAutomation {

    // Excel column indexes (0-based)
    private static final int COL_PRINCIPLE = 0;
    private static final int COL_RATE = 1;
    private static final int COL_PERIOD = 2;
    private static final int COL_PERIOD_TYPE = 3; // "year(s)"/"month(s)"/"day(s)"
    private static final int COL_FREQUENCY = 4;    // e.g., "Simple Interest"
    private static final int COL_MATURITY = 5;     // Maturity Value (from Excel or to overwrite)
    private static final int COL_EXPECTED = 6;     // Expected
    private static final int COL_RESULT = 7;       // Result (Pass/Fail)
    private static final int COL_CALCULATED = 8;   // Calculated value (we will store)
    private static final int COL_WEBVALUE = 9;     // Web page value (we will store)

    public static void main(String[] args) throws Exception {
        // change this to your excel file path
        String excelPath = "C:\\Users\\Wagh\\eclipse-workspace\\automating-dsp-test\\TestData.Created.xlsx";
        String sheetName = "Sheet1";

        // Change to your app URL
        String url = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true"; // <-- replace

        // Tolerance for numeric comparison
        double tolerance = 0.5; // set as required

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get(url);

            int lastRowIndex = ExcelUtils.getRowCount(excelPath, sheetName); // last index
            // assume header row at index 0
            for (int r = 1; r <= lastRowIndex; r++) {
                String sPrincipal = ExcelUtils.getCellData(excelPath, sheetName, r, COL_PRINCIPLE).trim();
                if (sPrincipal.isEmpty()) continue; // skip empty

                String sRate = ExcelUtils.getCellData(excelPath, sheetName, r, COL_RATE).trim();
                String sPeriod = ExcelUtils.getCellData(excelPath, sheetName, r, COL_PERIOD).trim();
                String sPeriodType = ExcelUtils.getCellData(excelPath, sheetName, r, COL_PERIOD_TYPE).trim().toLowerCase();
                String sFrequency = ExcelUtils.getCellData(excelPath, sheetName, r, COL_FREQUENCY).trim();
                String sExpected = ExcelUtils.getCellData(excelPath, sheetName, r, COL_EXPECTED).trim();

                double principal = parseDoubleSafe(sPrincipal, 0.0);
                double ratePercent = parseDoubleSafe(sRate, 0.0);
                double periodNum = parseDoubleSafe(sPeriod, 0.0);

                // Calculate simple interest maturity
                // Convert period to years if needed
                double years = periodNum;
                if (sPeriodType.contains("month")) {
                    years = periodNum / 12.0;
                } else if (sPeriodType.contains("day")) {
                    years = periodNum / 365.0;
                } // else assume year

                // For Simple Interest: M = P * (1 + r * t)  where r is decimal per year
                double rDecimal = ratePercent / 100.0;
                double calculatedMaturity = principal * (1.0 + rDecimal * years);

                // format to 2 decimals
                DecimalFormat df = new DecimalFormat("#.##");
                String sCalculated = df.format(calculatedMaturity);

                // Enter values on webpage
                // --- CHANGE LOCATORS BELOW to match your page ---
                // Example placeholders:
                // ids: principalInput, rateInput, periodInput, periodTypeSelect, calcBtn, maturityValue
                WebElement principalInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("principal")));
                principalInput.clear();
                principalInput.sendKeys(String.valueOf(principal));

                WebElement rateInput = driver.findElement(By.id("interest"));
                rateInput.clear();
                rateInput.sendKeys(String.valueOf(ratePercent));

                WebElement periodInput = driver.findElement(By.id("tenure"));
                periodInput.clear();
                periodInput.sendKeys(String.valueOf(periodNum));

                // period type selection (if a <select>)
                try {
                    Select periodSelect = new Select(driver.findElement(By.id("tenurePeriod")));
                    // try to match visible text, e.g., "year(s)", "month(s)", "day(s)"
                    periodSelect.selectByVisibleText(convertToSelectText(sPeriodType));
                } catch (Exception e) {
                    // fallback for custom dropdowns: try clicking element by visible text
                    try {
                        WebElement opt = driver.findElement(By.xpath("//*[text()[contains(.,'" + sPeriodType + "')]]"));
                        opt.click();
                    } catch (Exception ex) {
                        // ignore if not present
                    }
                }

                // frequency (if needed)
                try {
                    Select freqSelect = new Select(driver.findElement(By.id("frequency")));
                    freqSelect.selectByVisibleText(sFrequency);
                } catch (Exception e) {
                    // ignore if not present
                }

                // Click calculate
                WebElement calcBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img"));
                calcBtn.click();

                // read website maturity value
                WebElement maturityEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturityValue")));
                String webMaturityText = maturityEl.getText().trim();
                double webMaturityNumeric = parseDoubleSafe(webMaturityText.replaceAll("[^0-9.\\-]", ""), Double.NaN);

                // parse expected value from Excel (sExpected)
                double expectedNumeric = parseDoubleSafe(sExpected.replaceAll("[^0-9.\\-]", ""), Double.NaN);

                // Comparison logic:
                boolean calcMatchesExpected = !Double.isNaN(expectedNumeric) &&
                        (Math.abs(calculatedMaturity - expectedNumeric) <= tolerance);

                boolean calcMatchesWeb = !Double.isNaN(webMaturityNumeric) &&
                        (Math.abs(calculatedMaturity - webMaturityNumeric) <= tolerance);

                String result;
                if (calcMatchesExpected && calcMatchesWeb) {
                    result = "Pass";
                } else if (calcMatchesExpected && !calcMatchesWeb) {
                    result = "Fail - UI mismatch";
                } else if (!calcMatchesExpected && calcMatchesWeb) {
                    result = "Fail - Expected mismatch";
                } else {
                    result = "Fail - Both mismatch";
                }

                // Write back calculated, web value, and result
                ExcelUtils.setCellData(excelPath, sheetName, r, COL_CALCULATED, df.format(calculatedMaturity));
                ExcelUtils.setCellData(excelPath, sheetName, r, COL_WEBVALUE, webMaturityText);
                ExcelUtils.setCellData(excelPath, sheetName, r, COL_RESULT, result);

                System.out.println("Row " + r + " => calc: " + sCalculated + ", web: " + webMaturityText + ", expected: " + sExpected + " => " + result);
            }

            System.out.println("Automation finished. Check Excel for results.");

        } finally {
            driver.quit();
        }
    }

    private static double parseDoubleSafe(String s, double fallback) {
        if (s == null || s.isEmpty()) return fallback;
        try {
            return Double.parseDouble(s.replaceAll(",", ""));
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    private static String convertToSelectText(String sPeriodTypeLower) {
        if (sPeriodTypeLower.contains("year")) return "year(s)";
        if (sPeriodTypeLower.contains("month")) return "month(s)";
        if (sPeriodTypeLower.contains("day")) return "day(s)";
        return sPeriodTypeLower;
    }
}
