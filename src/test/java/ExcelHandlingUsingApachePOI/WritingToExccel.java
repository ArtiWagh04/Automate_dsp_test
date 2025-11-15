package ExcelHandlingUsingApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingToExccel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Created.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
//		//static data
//		
//		XSSFRow row1 = sheet.createRow(0);
//		
//		row1.createCell(0).setCellValue("Java");
//		
//		row1.createCell(1).setCellValue("1");
//		
//		XSSFRow row2 = sheet.createRow(1);
//		
//		row2.createCell(0).setCellValue("python");
//		
//		row2.createCell(1).setCellValue("2");
//		
//		XSSFRow row3 = sheet.createRow(2);
//		
//		row3.createCell(0).setCellValue("selenium");
//		
//		row3.createCell(1).setCellValue("3");
//	

		Scanner sc = new Scanner(System.in);
		
		System.out.println("rows:");
		int rows = sc.nextInt();
		System.out.println("cells");
		int cells = sc.nextInt();
		
		for(int r =0; r<rows; r++) {
			
			XSSFRow row = sheet.createRow(r);
			
			for(int c = 0; c<cells; c++) {
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(sc.next());
			}
		}
		
		
		workbook.write(file); //attaching workbook to file
		
		workbook.close();
		
		file.close();
		
		System.out.println("file created");
		
		
	}

}
