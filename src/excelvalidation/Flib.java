package excelvalidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Flib {
	
	public String readDataWords(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet s = wb.getSheet(sheetname);
	    Row r = s.getRow(rc);
	    Cell c = r.getCell(cc);
	    String data = c.getStringCellValue();
	    return data;
	}
	
	public java.util.Iterator<Row> data(String excelp,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet s = wb.getSheetAt(cc);
	    java.util.Iterator<Row> rowIterator = s.iterator();
	    return rowIterator;
	}
	
	public double readdouble(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
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
	
	public int columnCount(String excelp,String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		 // Get the last row (null check is important if the sheet is empty)
        Row lastRow = s.getRow(s.getLastRowNum());
        
        // Get the last cell number
        int lastCellNumber = lastRow != null ? lastRow.getLastCellNum() : -1;
        return lastCellNumber;
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
	
	public String dateString(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		 DataFormatter dataFormatter = new DataFormatter();
         String dateString = dataFormatter.formatCellValue(c);
		//Date data = c.getDateCellValue();
		return dateString;
	}
	
	public boolean isPanValid(String input) {
        // Regular expression for PAN number format
        String regexPattern = "[A-Z]{5}\\d{4}[A-Z]{1}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regexPattern);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Check if the input matches the PAN number format
        return matcher.matches();
    }
	
	public String readdoubleToString(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rc);
		Cell c = r.getCell(cc);
		double data = (double) c.getNumericCellValue();
		String ds = String.valueOf(data);
		return ds;
	}
	
	public boolean isDecimalFormat(String value)
	{
		// Regular expression to match a number with two decimal places
        String decimalPattern = "\\d{1,6}(\\.\\d{1,2})?";

        // Compile the regular expression into a pattern
        Pattern pattern = Pattern.compile(decimalPattern);

        // Create a Matcher object to match the value against the pattern
        Matcher matcher = pattern.matcher(value);

        // Check if the value matches the pattern
        return matcher.matches();
	}
	
	public boolean isDecimalFormat2(String value)
	{
		// Regular expression to match a number with two decimal places
        String decimalPattern = "\\d{1,14}(\\.\\d{1,2})?";

        // Compile the regular expression into a pattern
        Pattern pattern = Pattern.compile(decimalPattern);

        // Create a Matcher object to match the value against the pattern
        Matcher matcher = pattern.matcher(value);

        // Check if the value matches the pattern
        return matcher.matches();
	}
	
	public Cell cell(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet s = wb.getSheet(sheetname);
	    Row r = s.getRow(rc);
	    Cell c = r.getCell(cc);
	    return c;
	}
	
	public Cell cellStyle(String excelp,String sheetname,int rc,int cc) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelp);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet s = wb.getSheet(sheetname);
	    Row r = s.getRow(rc);
	    Cell c = r.getCell(cc);
	    CellStyle c1 = c.getCellStyle();
	    return (Cell) c1;
	}
	
	public boolean pincode(String value)
	{
		// Regular expression to match a number with two decimal places
        String decimalPattern = "\\d{6}";

        // Compile the regular expression into a pattern
        Pattern pattern = Pattern.compile(decimalPattern);

        // Create a Matcher object to match the value against the pattern
        Matcher matcher = pattern.matcher(value);

        // Check if the value matches the pattern
        return matcher.matches();
	}

}
