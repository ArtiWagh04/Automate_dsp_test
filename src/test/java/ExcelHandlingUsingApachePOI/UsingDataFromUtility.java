package ExcelHandlingUsingApachePOI;

import java.io.IOException;

public class UsingDataFromUtility {
	public static void main(String[] args) throws IOException {
		String file = System.getProperty("user.dir") + "\\TestData\\Book2.xlsx";
		int row = ExcelUtils.getRowCount(file, "Sheet1");
		for(int i=1;i<=row; i++) {
		int cell = ExcelUtils.getCellCount(file, "Sheet1", row);
		String price = ExcelUtils.getCellData(file, "Sheet1", i, 0);
		String roi = ExcelUtils.getCellData(file, "Sheet1", i, 1);
		String period = ExcelUtils.getCellData(file, "Sheet1", i, 2);
System.out.print("PRICE:" + price);
System.out.print("roi:" + roi);
System.out.print("period:" + period);
System.out.println();
		}
	}
}
