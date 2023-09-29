package rpulse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Flib {
	
	public String readDataW(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet s = wb.getSheet(sheetname);
	    Row r = s.getRow(rc);
	    Cell c = r.getCell(cc);
	    String data = c.getStringCellValue();
	    return data;
	}
	
	public double readDataN(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		double data = c.getNumericCellValue();
		return data;
	}
	
	public String readDataNString(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		//double data = c.getNumericCellValue();
		String myString = String.valueOf((long) c.getNumericCellValue());
		return myString;
	}
	
	public int readDataIN(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		int data = (int) c.getNumericCellValue();
		return data;
	}
	

	public long readDataLONG(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		 long data = (long) c.getNumericCellValue();
		return data;
	}
	
	public String readDataLONGString(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		 long data = (long) c.getNumericCellValue();
		 String myString = String.valueOf(data);
		return myString;
	}
	
	
	public int rowcount(String excelp,String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		int last = s.getLastRowNum();
		return last;
	}
	
	
	public Date date(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		Date data = c.getDateCellValue();
		return data;
	}
	
	

}
