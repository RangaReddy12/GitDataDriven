package utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
XSSFWorkbook wb;
//constructor for reading excel file path
public ExcelFileUtil(String ReadExcel)throws Throwable
{
	FileInputStream fi = new FileInputStream(ReadExcel);
	wb = new XSSFWorkbook(fi);
}
//method for counting no of rows
public int rowCount(String SheetName)
{
	return wb.getSheet(SheetName).getLastRowNum();
}
//method for getting cell data
public String getCellData(String sheetName,int row,int column)
{
	String data ="";
	if(wb.getSheet(sheetName).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
		int celldata =(int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		data= String.valueOf(celldata);
	}
	else
	{
		data =wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	return data;
	
}
//method for writing
public void setCellData(String sheetName,int row,int column,String Status,String WriteExcel)throws Throwable
{
	//get sheet from wb
	XSSFSheet ws = wb.getSheet(sheetName);
	//get row from sheet
	XSSFRow rowNum =ws.getRow(row);
	//create cell in a row
	XSSFCell cell =rowNum.createCell(column);
	//write status 
	cell.setCellValue(Status);
	if(Status.equalsIgnoreCase("Pass"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
	}
	else if(Status.equalsIgnoreCase("Fail"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
	}
	else if(Status.equalsIgnoreCase("Blocked"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.BLUE.getIndex());
		font.setBold(true);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
	}
	FileOutputStream fo = new FileOutputStream(WriteExcel);
	wb.write(fo);
}
	public static void main(String[] args)throws Throwable {
		ExcelFileUtil xl = new ExcelFileUtil("D:/Sample.xlsx");
		int rc =xl.rowCount("EmpData");
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			String fname =xl.getCellData("EmpData", i, 0);
			String mname =xl.getCellData("EmpData", i, 1);
			String lname =xl.getCellData("EmpData", i, 2);
			String eid = xl.getCellData("EmpData", i, 3);
			System.out.println(fname+"   "+mname+"   "+lname+"   "+eid);
		//	xl.setCellData("EmpData", i, 4, "Pass", "D:/Results.xlsx");
			//xl.setCellData("EmpData", i, 4, "Fail", "D:/Results.xlsx");
			xl.setCellData("EmpData", i, 4, "Blocked", "D:/Results.xlsx");
		}
		

	}

}
