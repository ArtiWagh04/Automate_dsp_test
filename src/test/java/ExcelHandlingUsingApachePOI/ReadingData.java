package ExcelHandlingUsingApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Book1.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	int totalRows = sheet.getLastRowNum();
	int totalCells = sheet.getRow(1).getLastCellNum();
	
	
}
}
