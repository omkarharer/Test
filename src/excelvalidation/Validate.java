package excelvalidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.ous.jtoml.ParseException;
import rpulse.RpulsePOMDataDriven;





public class Validate implements IAuto {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Flib f = new Flib();
        Logger log = Logger.getLogger(ValidateMethods.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Validation ---------------------FinanceIndividualnprovamt------------------------------");
        int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual");
        
       
	    
	
	
	}
}


