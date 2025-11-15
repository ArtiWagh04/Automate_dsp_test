package ExcelHandlingUsingApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Book1.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	int totalRows = sheet.getLastRowNum();
	int totalCells = sheet.getRow(1).getLastCellNum();
	
	System.out.println(totalRows + " " + totalCells);
	
	for(int r=0; r<totalRows; r++) {
		
		XSSFRow currentRow = sheet.getRow(r);
		
		for(int c=0; c<totalCells; c++) {
			XSSFCell cell = currentRow.getCell(c);
			System.out.println(cell.toString()+"\t");
		}
		System.out.println();
	}
	
	workbook.close();
	fis.close();
	
}
}
