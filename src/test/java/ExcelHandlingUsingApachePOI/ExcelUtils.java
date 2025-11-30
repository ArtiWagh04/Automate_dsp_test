//package ExcelHandlingUsingApachePOI;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtils {
//
//	public static FileInputStream fi;
//	public static FileOutputStream fo;
//	public static XSSFWorkbook wb;
//	public static XSSFSheet ws;
//	public static XSSFRow row;
//	public static XSSFCell cell;
//	public static CellStyle style;
//	
//	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
//			fi = new FileInputStream(xlFile);
//			wb = new XSSFWorkbook(fi);
//			ws = wb.getSheet(xlSheet);
//			int rowCount = ws.getLastRowNum();
//			wb.close();
//			fi.close();
//			return rowCount;
//	}
//	
//	public static int getCelCount(String xlFile, String xlSheet, int rowNum) throws IOException {
//		fi = new FileInputStream(xlFile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlSheet);
//		row = ws.getRow(rowNum);
//		int cellCount = row.getLastCellNum();
//		wb.close();
//		fi.close();
//		return cellCount;
//	}
//	
//	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException {
//		
//		fi = new FileInputStream(xlfile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlsheet);
//		row = ws.getRow(rownum);
//		cell = row.getCell(cellnum);
//		
//		String data;
//		//data = cell.toString();  --- this toString will throw exception when got empty cell
//		// so using DataFormatter class from APchePOI library
//		try {
//			
//		
//		DataFormatter df = new DataFormatter();
//		data = df.formatCellValue(cell);
//		}
//		catch(Exception e){
//			data="";
//		}
//		wb.close();
//		fi.close();
//		
//		
//		return data;
//	}
//	
//	public static void setCellData(String xlfile, String xlsheet, int rownum, int column, String data) throws IOException {
//		fi = new FileInputStream(xlfile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlsheet);
//		row = ws.getRow(rownum);
//		
//		cell= row.createCell(column);
//		cell.setCellValue(data);
//		fo = new FileOutputStream(xlfile);
//		wb.write(fo);
//		wb.close();
//		fi.close();
//		fo.close();
//	}
//	
//}




package ExcelHandlingUsingApachePOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlFile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlSheet);
            return (ws == null) ? 0 : ws.getLastRowNum(); // last row index (0-based)
        }
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlFile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlSheet);
            XSSFRow row = (ws == null) ? null : ws.getRow(rowNum);
            return (row == null) ? 0 : row.getLastCellNum();
        }
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
        DataFormatter df = new DataFormatter();
        try (FileInputStream fi = new FileInputStream(xlFile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlSheet);
            if (ws == null) return "";
            XSSFRow row = ws.getRow(rowNum);
            if (row == null) return "";
            XSSFCell cell = row.getCell(cellNum);
            if (cell == null) return "";
            return df.formatCellValue(cell);
        } catch (Exception e) {
            return "";
        }
    }

    public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlFile);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet ws = wb.getSheet(xlSheet);
            if (ws == null) {
                ws = wb.createSheet(xlSheet);
            }

            XSSFRow row = ws.getRow(rowNum);
            if (row == null) {
                row = ws.createRow(rowNum);
            }

            XSSFCell cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }
            cell.setCellValue(data);

            try (FileOutputStream fo = new FileOutputStream(xlFile)) {
                wb.write(fo);
            }
        }
    }
}
