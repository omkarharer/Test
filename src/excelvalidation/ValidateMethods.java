package excelvalidation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

public class ValidateMethods implements IAuto {
	
	
	//Validating if formula present or not
	
	/*
	 * public void formula() throws EncryptedDocumentException, IOException { Logger
	 * log = Logger.getLogger(ValidateMethods.class);
	 * PropertyConfigurator.configure("log4j.properties");
	 * 
	 * Flib f = new Flib();
	 * 
	 * int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual"); int cc
	 * = f.columnCount(FinanceIndividualAllFields, "FinanceIndividual");
	 * System.out.println(cc); }
	 */
	
	
	//validation for -------------ddate-------------
	
	public void ddate() throws EncryptedDocumentException, IOException
	{
		Logger log = Logger.getLogger(ValidateMethods.class);
        PropertyConfigurator.configure("log4j.properties");

        log.info("//validation for -------------ddate-------------");
        Flib f = new Flib();

        int rc = f.rowcount(excel_path, "stg_borrower_detail");
       

        for(int i=6;i<=rc;i++)
        {
        String date = f.dateString(excel_path, "stg_borrower_detail", i, 0);
        System.out.println(date);

        // Desired date format
        String desiredDateFormat = "yyyy-MM-dd";

        // Create DateTimeFormatter with desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

        try {
            // Parse the date from the Excel cell using DateTimeFormatter
            LocalDate.parse(date, formatter);
            //log.info("Date is in the desired format. A" + i + "=" + date);
            //System.out.println("Date is in the desired format.");
        } catch (DateTimeParseException e) {
        	log.error("Date is not in the desired format A" + i + "=" + date + "***************");
           // System.out.println("Date is not in the desired format.");
        }
        //log.info("column " + "A" + " row No " + i + " Value:= " + date );
        //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
        }
        log.info("//validation for -------------ddate-------------FInished");
	}
        
        //Validation for -----------sbloanno------------
         
        public void sbloanno() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
        	  log.info("//validation for -------------sbloanno-------------");
            PropertyConfigurator.configure("log4j.properties");
            int rc = f.rowcount(excel_path, "stg_borrower_detail");

        	  for(int i=6; i<=rc ;i++)
  	        {
  	        try
  	        {
  	        	 String sbloanno = f.readDataNString(excel_path, "stg_borrower_detail", i, 1);
  	        	  //System.out.println(sbloanno);
  	        
  	        	  //log.info("cell contains value B"+ i + "=" + sbloanno);
  	        	//System.out.println("cell has value");
  	      
  	        }
  	        catch(NullPointerException e)
  	        {
  	        	log.error("cell does not contains value B"+ i + "=" + "_______________________");
  	        	System.out.println("does not has value");
  	        }
  	        }
        	  log.info("//validation for -------------sbloanno-------------Finished");
        }
        
        //Validation ---------------scin--------------------
        
        public void scin() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
         	log.info("validation for -------------scin----------------------");
             PropertyConfigurator.configure("log4j.properties");
             int rc = f.rowcount(excel_path, "stg_borrower_detail");
             
             for(int i=6; i<=rc ;i++)
 	        {
 	       try
 	       {
 	        	String scin = f.readDataNString(excel_path, "stg_borrower_detail", i, 2);
 	        	// System.out.println(scin);
 	 	        
 	        	//  log.info("cell contains value C"+ i + "=" + scin);
 	        	//System.out.println("cell has value");
 	        	
 	       }
 	       catch(NullPointerException e)
 	        {
 	        	log.error("cell does not contains value C"+ i + "=_______________");
 	        	//System.out.println("does not has value");
 	        }
 	        }
             log.info("validation for -------------scin--------------------finiahed");
        }
        
        //Validation -------------------sbname------------------
        
        public void sbname() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
          	log.info("validation for -------------sbname----------------------");
              PropertyConfigurator.configure("log4j.properties");
              int rc = f.rowcount(excel_path, "stg_borrower_detail");
              
              for(int i=6 ; i<=rc ; i++)
              {
              try
              {
            	  String sbname = f.readDataWords(excel_path, "stg_borrower_detail", i, 3);
            	  //System.out.println(sbname);
   	 	        
 	        	 // log.info("cell contains value D"+ i + "=" + sbname); 
              }
              catch(NullPointerException e)
              {
            	  log.error("cell does not contains value D"+ i + "=_____________");
            	  
              }
              }
              log.info("validation for -------------sbname--------------------FInished");
        }
        

        //Validation ---------------dbdob-----------------
        
        public void dbdob() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
           	log.info("validation for -------------dbdob----------------------");
               PropertyConfigurator.configure("log4j.properties");
               int rc = f.rowcount(excel_path, "stg_borrower_detail");
               
               for(int i=6;i<=rc;i++)
               {
               String date = f.dateString(excel_path, "stg_borrower_detail", i, 4);
               System.out.println(date);

               // Desired date format
               String desiredDateFormat = "yyyy-MM-dd";

               // Create DateTimeFormatter with desired date format
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

               try {
                   // Parse the date from the Excel cell using DateTimeFormatter
                   LocalDate.parse(date, formatter);
                  // log.info("Date is in the desired format E" + i +"=" + date);
                  // System.out.println("Date is in the desired format.");
               } catch (DateTimeParseException e) {
            	   log.error("Date is  not  in the desired format E" + i +"=" + date + "************");
                  // System.out.println("Date is not in the desired format.");
               }
              
               }
            	log.info("validation for -------------dbdob---------------------Finished");
        }
        
        //Validation --------------sbcitizenship----------------
        
        public void sbcitizenship()throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation --------------sbcitizenship----------------");
                int rc = f.rowcount(excel_path, "stg_borrower_detail");
                
                for(int i=6 ;i<=rc ; i++)
                {
                try
                {
                	
                	 String sbcitizenship = f.readDataWords(excel_path, "stg_borrower_detail", i, 5);
                	 System.out.println(sbcitizenship);
                	 String Resident="CIT-01";
                	 String NonResident="CIT-02";
                	 String Others="CIT-03";
                	 if(sbcitizenship.equals(Resident) || sbcitizenship.equals(NonResident) || sbcitizenship.equals(Others))
                	 {
                		 //log.info("Citizenship is correct F" + i + "=" + sbcitizenship);
                	 }
                	 else
                	 {
                		 log.error("Citizenship is not correct F" + i + "=" + sbcitizenship + "*******************");
                	 }
                }
                catch(NullPointerException e)
                {
                	log.error("Cell does not contain any data F" + i + "____________________");
                }
                }
             	log.info("validation for -------------sbcitizenship--------------------Finished");
        }
        
        //Validation -----------sbpanno---------------
        
        public void sbpanno() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation --------------sbpanno----------------");
             int rc = f.rowcount(excel_path, "stg_borrower_detail");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
            	 String sbpanno = f.readDataWords(excel_path, "stg_borrower_detail", i, 6); 
            	 String pan = sbpanno.trim();
            	 System.out.println(pan);
            	 
            	 boolean isvalid = f.isPanValid(pan);
            	 if(isvalid)
            	 {
            		// log.info("Pan No is in valid format G" + i + "=" + sbpanno );
            	 }
            	 else
            	 {
            		 log.error("Pan No not in  valid format G" + i + "=" + sbpanno + "**************" );
            	 }
             }
            	 catch(NullPointerException e)
            	 {
            		 log.error("Cell does not contain any data G" + i + "____________________");
            	 }
             }
             log.info("Validation --------------sbpanno----------------Finished");
             }
        
        //Validation ----------------saadhaar-------------------
        
        public void saadhaar() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation --------------saadhaar----------------");
              int rc = f.rowcount(excel_path, "stg_borrower_detail");
              
              for(int i=6 ;i<=rc ; i++)
              {
              try
              {
            	  String saadhaar = f.readDataWords(excel_path, "stg_borrower_detail", i, 7); 
            	  System.out.println(saadhaar);
            	  if(saadhaar.equals("Yes") || saadhaar.equals("No") )
            	  {
            		 // log.info("saadhaar Status H" + i + "=" + saadhaar);
            	  }
            	  else
            	  {
            		  log.error("saadhaar Status not matched H" + i + "=" + saadhaar + "*************");
            	  }
              }
              catch(NullPointerException e)
         	 {
         		 log.error("Cell does not contain any data H" + i + "____________________");
         	 }
              }    
              log.info("Validation --------------saadhaar----------------Finished");
        }
        
        //validation -------------sidtype-----------------
        
        public void sidtype() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation --------------sidtype----------------");
               int rc = f.rowcount(excel_path, "stg_borrower_detail");
               
               for(int i=6 ;i<=rc ; i++)
               {
              try
              {
            	  String sidtype = f.readDataWords(excel_path, "stg_borrower_detail", i, 8); 
            	  System.out.println(sidtype);
            	  String VoterID="UIDT-01";
            	  String Others="UIDT-02";
            	  if(sidtype.equals(VoterID) || sidtype.equals(Others))
            	  {
            		  //log.info("sidtype is valid I" + i + "=" + sidtype);
            	  }
            	  else
            	  {
            		  log.error("sidtype is not valid I" + i + "=" + sidtype + "******************");
            	  }
              }
            	  catch(NullPointerException e)
              	 {
              		 log.error("Cell does not contain any data H" + i + "____________________");
              	 }
              }
               log.info("Validation --------------sidtype--------------Finished");
        }
        
        //Validation --------sidnumber---------------
        
        public void sidnumber() {
        	
        }
        
        //Validation ------------------nbmonthlyincome---------------
        
        public void nbmonthlyincome() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation --------------nbmonthlyincome----------------");
                int rc = f.rowcount(excel_path, "stg_borrower_detail");
                
                for(int i=6 ;i<=rc ; i++)
                {
                try
                {
                	long nbmonthlyincome = f.readDataLONG(excel_path, "stg_borrower_detail", i, 10);
                	System.out.println(nbmonthlyincome);
                	if(nbmonthlyincome>=0)
                	{
                		//log.info("monthly income is K" + i + "=" + nbmonthlyincome);
                	}
                	else
                	{
                		log.error("monthly income invalid is K" + i + "=" + nbmonthlyincome + "*****************");
                	}
                	
                }
                catch(NullPointerException e)
             	 {
             		 log.error("Cell does not contain any data K" + i + "___________________________");
             	 }
                }
                log.info("Validation --------------nbmonthlyincome----------------FInished");
        }
        
        
        //Validation -----------------sbreligion-----------------------
        
        public void sbreligion() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation --------------sbreligion----------------");
             int rc = f.rowcount(excel_path, "stg_borrower_detail");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
            	 String sbreligion = f.readDataWords(excel_path, "stg_borrower_detail", i, 11);
            	 System.out.println(sbreligion);
            	 String Hindu="RE-01";
            	 String Muslim="RE-02";
            	 String Sikh="RE-03";
            	 String Christian="RE-04";
            	 String Jain="RE-05";
            	 String Buddhist="RE-06";
            	 String Zoroastrian="RE-07";
            	 String Other="RE-08";
            	  
            	 if(sbreligion.equals(Hindu) || sbreligion.equals(Muslim) || sbreligion.equals(Sikh) || sbreligion.equals(Christian) || sbreligion.equals(Jain) || sbreligion.equals(Buddhist) || sbreligion.equals(Zoroastrian) || sbreligion.equals(Other))
            	 {
            		// log.info("sbreligion is valid L" + i + "=" + sbreligion);
            	 }
            	 else
            	 {
            		 log.error("sbreligion is not valid L" + i + "=" + sbreligion + "******************");
            	 }
             }
             catch(NullPointerException e)
         	 {
         		 log.error("Cell does not contain any data K" + i + "___________________________");
         	 }
             }
             log.info("Validation --------------sbreligion----------------Finished");
        }
        
        //Validation -------------sbcast----------------
        
        public void sbcast() throws EncryptedDocumentException, IOException 
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ------------------sbcast-------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_detail");
        	
              for(int i=6 ;i<=rc ; i++)
              {
              try
              {
            	  String sbcast = f.readDataWords(excel_path, "stg_borrower_detail", i, 12);
            	  System.out.println(sbcast);
            	  String General="CA-01";
            	  String EWS="CA-02";
            	  String OBC="CA-03";
            	  String SC="CA-04";
            	  String ST="CA-05";
            	  if(sbcast.equals(General) || sbcast.equals(EWS) || sbcast.equals(OBC) || sbcast.equals(SC) || sbcast.equals(ST))
            	  {
            		 // log.info("sbcast is valid M" + i + "=" + sbcast);
            	  }
            	  else
            	  {
            		  log.error("sbcast is not  valid M" + i + "=" + sbcast + "******************************");
            	  }
              }
              catch(NullPointerException e)
          	 {
          		 log.error("Cell does not contain any data K" + i + "___________________________");
          	 }
              }
              log.info("Validation ------------------sbcast-------------------FInished");
        }
        
        //Validation -----------------------sbgender-------------------
        
        public void sbgender() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ------------------sbgender-------------------");
               int rc = f.rowcount(excel_path, "stg_borrower_detail");
         	
               for(int i=6 ;i<=rc ; i++)
               {  
               try
               {
            	   String sbcast = f.readDataWords(excel_path, "stg_borrower_detail", i, 13);
            	   System.out.println(sbcast);
            	   String Male="G-01"; 
            	   String Female="G-02";
            	   String Others="G-03";
            	   if(sbcast.equals(Male) || sbcast.equals(Female) || sbcast.equals(Others))
            	   {
            		  // log.info("sbgender is valid N" + i + "=" + sbcast);
            	   }
            	   else
            	   {
            		   log.error("sbgender is not valid N" + i + "=" + sbcast + "*************************");
            	   }   
               }
               catch(NullPointerException e)
            	 {
            		 log.error("Cell does not contain any data N" + i + "_____________________________________");
            	 }
               }
               log.info("Validation ------------------sbgender-------------------Finished");
        }
        
        //Validation ---------------------sboccupation------------------------
        
        public void sboccupation() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation ------------------sboccupation-------------------");
                int rc = f.rowcount(excel_path, "stg_borrower_detail");
          	
                for(int i=6 ;i<=rc ; i++)
                {
                try
                {
                	String sbcast = f.readDataWords(excel_path, "stg_borrower_detail", i, 14);
                	System.out.println(sbcast);
                	String Salaried="OC-01";
                	String SelfEmployedBusiness="OC-02";
                	String Professional="OC-03"; 
                	String Others="OC-04";
                	String Housewife="OC-05";
                	if(sbcast.equals(Salaried) || sbcast.equals(SelfEmployedBusiness) || sbcast.equals(Professional) || sbcast.equals(Others) || sbcast.equals(Housewife))
                	{
                		//log.info("sbcast is valid O" + i + "=" + sbcast);
                		
                	}
                	else
                	{
                		log.error("sbcast is not  valid O" + i + "=" + sbcast + "**********************************" );
                		
                	}
                	
                }
                catch(NullPointerException e)
           	 {
           		 log.error("Cell does not contain any data O" + i + "_____________________________________");
           	 }
              }
                log.info("Validation ------------------sboccupation-------------------Finished");
        }

        //validation ----for stg_coborrowerdetails sheet----------------------------------
        
        //validation --------------ddate--------------------------------
        
        public void ddate2() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");

            log.info("validation ----for stg_coborrowerdetails sheet----------------------------------");
            log.info("validation ---------------------ddate2--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
            System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_coborrowerdetails", i, 0);
            System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "************88");
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }
            log.info("validation ---------------------ddate2--------------------------------Finished");
        	
        }
        
        //Validation ---------------------sbloanno2------------------------------
        
        public void sbloanno2() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------sbloanno2------------------------------");
             int rc = f.rowcount(excel_path, "stg_coborrowerdetails");

         	  for(int i=6; i<=rc ;i++)
   	        {
   	        try
   	        {
   	        	 String sbloanno = f.readDataNString(excel_path, "stg_coborrowerdetails", i, 1);
   	        	 // System.out.println(sbloanno);
   	        
   	        	  //log.info("cell contains value B"+ i + "=" + sbloanno);
   	        //	System.out.println("cell has value");
   	      
   	        }
   	        catch(NullPointerException e)
   	        {
   	        	log.error("cell does not contains value B"+ i + "=");
   	        	//System.out.println("does not has value");
   	        }
   	        }	
         	 log.info("Validation ---------------------sbloanno2------------------------------Finished");
        }
        
        //Validation ----------------scin2------------------
        
        public void scin2() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ----------------scin2------------------");
              int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
              
              for(int i=6; i<=rc ;i++)
  	        {
  	       try
  	       {
  	        	String scin = f.readDataNString(excel_path, "stg_coborrowerdetails", i, 2);
  	        	 System.out.println(scin);
  	 	        
  	        	//  log.info("cell contains value C"+ i + "=" + scin);
  	        	//System.out.println("cell has value");
  	        	
  	       }
  	       catch(NullPointerException e)
  	        {
  	        	log.info("cell does not contains value C"+ i + "=_______________________");
  	        	//System.out.println("does not has value");
  	        	log.info("Check scbcin contains pan value or not");
  	        	
  	        	 try
  	             {
  	            	 String sbpanno = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 3); 
  	            	 String pan = sbpanno.trim();
  	            	 System.out.println(pan);
  	            	 
  	            	 boolean isvalid = f.isPanValid(pan);
  	            	 if(isvalid)
  	            	 {
  	            		// log.info("Pan No is in valid format for C" + i + " || " + "D" + i + "=" + sbpanno );
  	            	 }
  	            	 else
  	            	 {
  	            		 log.error("Pan No not in  valid format for C" + i + " || " + "D" + i + "=" + sbpanno + "*******************************");
  	            	 }
  	             }
  	            	 catch(NullPointerException h)
  	            	 {
  	            		 log.error("Cell is empty for C" + i + " || " + "D" + i + "_____________________________");
  	            	 }
  	            
  	        }
  	        }
              log.info("Validation ----------------scin2------------------Finished");
        }
        
        //Validation -------------------scbcin---------------
        
        public void scbcin() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation --------------scbcin----------------");
               int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
               
               for(int i=6; i<=rc ;i++)
               {
               try
               {
            	   String scin = f.readDataNString(excel_path, "stg_coborrowerdetails", i, 2);
    	        	 System.out.println(scin);

               }
               catch(NullPointerException e)
               {
            	   //System.out.println("CIN not present");
            	   log.info("CIN not present ");
            	   try
    	             {
    	            	 String sbpanno = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 3); 
    	            	 String pan = sbpanno.trim();
    	            	 System.out.println(pan);
    	            	 
    	            	 boolean isvalid = f.isPanValid(pan);
    	            	 if(isvalid)
    	            	 {
    	            		 log.info("Pan No is in valid format for C" + i + " || " + "D" + i + "=" + sbpanno );
    	            	 }
    	            	 else
    	            	 {
    	            		 log.error("Pan No not in  valid format for C" + i + " || " + "D" + i + "=" + sbpanno + "*******************************");
    	            	 }
    	             }
    	            	 catch(NullPointerException h)
    	            	 {
    	            		 log.error("Pan no not present for C" + i + " || " + "D" + i + "_______________________________");
    	            	 }
            	   
               }
               }
               log.info("Validation --------------scbcin----------------Finished");
        }
        
        //Validation ---------------scbname---------------------------
        
        public void scbname() throws EncryptedDocumentException, IOException 
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation --------------scbname----------------");
                int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
                
                for(int i=6; i<=rc ;i++)
                {
                try
                {
                	String scbname = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 4);
                	System.out.println(scbname);
                	// log.info("cell contains value E"+ i + "=" + scbname); 
                	
                }
                catch(NullPointerException e)
                {
                	log.error("cell not contains value E"+ i + "=" + "_____________________________________");
                }
                }
                log.info("Validation --------------scbname----------------Finished");
     
        }
        
        //Validation ------------dcbdob-------------------
        
        public void dcbdob() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");

            log.info("Validation --------------dcbdob----------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
            System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_coborrowerdetails", i, 5);
            System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                log.info("Date is in the desired format. F" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } 
			/*
			 * catch (NullPointerException e) { log.info("Cell is empty F" + i +
			 * "_________________________________"); }
			 */ 
            catch (DateTimeParseException e) 
            {
            	log.error("Date is not in the desired format F" + i + "=" + date + "****************************");
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }
            log.info("Validation --------------dcbdob----------------Finished");
        }
        
        //Validation --------------------scbcitizenship-------------------
        
        public void scbcitizenship() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation --------------scbcitizenship----------------");
             int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
             	
             	 String sbcitizenship = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 6);
             	 System.out.println(sbcitizenship);
             	 String Resident="CIT-01";
             	 String NonResident="CIT-02";
             	 String Others="CIT-03";
             	 if(sbcitizenship.equals(Resident) || sbcitizenship.equals(NonResident) || sbcitizenship.equals(Others))
             	 {
             		// log.info("Citizenship is correct G" + i + "=" + sbcitizenship);
             	 }
             	 else
             	 {
             		 log.error("Citizenship is not correct G" + i + "=" + sbcitizenship + "*************************");
             	 }
             }
             catch(NullPointerException e)
             {
             	log.error("Cell does not contain any data G" + i + "_____________________________");
             }
             }
             log.info("Validation --------------scbcitizenship----------------Finished");
        }
        
        //Validation -----------------scbpanno-----------------
        
        public void scbpanno() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation --------------scbpanno----------------");
                int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
                
                for(int i=6; i<=rc ;i++)
                {
                try
                {
             	   String scin = f.readDataNString(excel_path, "stg_coborrowerdetails", i, 2);
     	        	 System.out.println(scin);

                }
                catch(NullPointerException e)
                {
             	   //System.out.println("CIN not present");
             	   log.info("CIN not present Checking if Pan No present or not C" + i);
             	   try
     	             {
     	            	 String scbpanno = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 7); 
     	            	 String pan = scbpanno.trim();
     	            	 System.out.println(pan);
     	            	 
     	            	 boolean isvalid = f.isPanValid(pan);
     	            	 if(isvalid)
     	            	 {
     	            		// log.info("Pan No is in valid format for C" + i + " || " + "H" + i + "=" + scbpanno );
     	            	 }
     	            	 else
     	            	 {
     	            		 log.error("Pan No not in  valid format for C" + i + " || " + "H" + i + "=" + scbpanno + "*******************************");
     	            	 }
     	             }
     	            	 catch(NullPointerException h)
     	            	 {
     	            		 log.error("Pan no not present for C" + i + " || " + "H" + i + "_______________________________");
     	            	 }
             	   
                }
                }
                log.info("Validation --------------scbpanno----------------Finsihed");
        }
        
        //Validation for -----------------------scbaadhaar---------------
        
        public void scbaadhaar() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation --------------scbaadhaar----------------");
               int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
               
               for(int i=6 ;i<=rc ; i++)
               {
               try
               {
             	  String scbaadhaar = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 8); 
             	  System.out.println(scbaadhaar);
             	  if(scbaadhaar.equals("Yes") || scbaadhaar.equals("No") )
             	  {
             		//  log.info("scbaadhaar Status I" + i + "=" + scbaadhaar);
             	  }
             	  else
             	  {
             		  log.error("scbaadhaar Status not present I" + i + "=" + scbaadhaar + "****************");
             	  }
               }
               catch(NullPointerException e)
          	 {
          		 log.error("Cell does not contain any data I" + i + "__________________________");
          	 }
               }    
               log.info("Validation --------------scbaadhaar----------------Finished");
        }
        
        //Validation -----------------sidtype2--------------------
        
        public void sidtype2() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation --------------sidtype2----------------");
                int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
                
                for(int i=6 ;i<=rc ; i++)
                {
               try
               {
             	  String sidtype2 = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 9); 
             	  System.out.println(sidtype2);
             	  String VoterID="UIDT-01";
             	  String Others="UIDT-02";
             	  if(sidtype2.equals(VoterID) || sidtype2.equals(Others))
             	  {
             		 // log.info("sidtype is valid J" + i + "=" + sidtype2);
             	  }
             	  else
             	  {
             		  log.error("sidtype is not valid J" + i + "=" + sidtype2 + "******************");
             	  }
               }
             	  catch(NullPointerException e)
               	 {
               		 log.error("Cell does not contain any data H" + i + "____________________");
               	 }
               }
                log.info("Validation --------------sidtype2----------------Finished");
        }
        
        //Validation ---------------sidnumber--------------
        
        public void sidnumber2() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation --------------sidnumber2----------------");
             int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
            	 String s = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 10);
                 System.out.println(s);
                // log.info("sidnumber2 contain K" + i + "=" + s);
             }
             catch(IllegalStateException e)
             {
            	 String sl = f.readDataLONGString(excel_path, "stg_coborrowerdetails", i, 10);
            	 System.out.println(sl);
            	 log.error("sidnumber2 contain K" + i + "=" + sl);
             }
             catch(NullPointerException h)
             {
            	 log.error("Cell not contain K" + i + "=" + "_______");
             }
             }
             log.info("Validation --------------sidnumber2----------------Finished");
        }
        
        //Validation -------------ncbmonthlyincome--------------
        
        public void ncbmonthlyincome() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation --------------ncbmonthlyincome----------------");
             int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
             	long ncbmonthlyincome = f.readDataLONG(excel_path, "stg_coborrowerdetails", i, 11);
             	System.out.println(ncbmonthlyincome);
             	if(ncbmonthlyincome>=0)
             	{
             		//log.info("monthly income is L" + i + "=" + ncbmonthlyincome);
             	}
             	else
             	{
             		log.error("monthly income invalid is L" + i + "=" + ncbmonthlyincome + "*****************");
             	}
             	
             }
             catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any data L" + i + "___________________________");
          	 }
             }
             log.info("Validation --------------ncbmonthlyincome----------------Finished");
        }
        
        //Validation ------------------scbreligion---------------------
        
        public void scbreligion() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation --------------scbreligion----------------");
              int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
              
              for(int i=6 ;i<=rc ; i++)
              {
              try
              {
             	 String scbreligion = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 12);
             	 System.out.println(scbreligion);
             	 String Hindu="RE-01";
             	 String Muslim="RE-02";
             	 String Sikh="RE-03";
             	 String Christian="RE-04";
             	 String Jain="RE-05";
             	 String Buddhist="RE-06";
             	 String Zoroastrian="RE-07";
             	 String Other="RE-08";
             	  
             	 if(scbreligion.equals(Hindu) || scbreligion.equals(Muslim) || scbreligion.equals(Sikh) || scbreligion.equals(Christian) || scbreligion.equals(Jain) || scbreligion.equals(Buddhist) || scbreligion.equals(Zoroastrian) || scbreligion.equals(Other))
             	 {
             		// log.info("sbreligion is valid M" + i + "=" + scbreligion);
             	 }
             	 else
             	 {
             		 log.error("sbreligion is not valid M" + i + "=" + scbreligion + "******************");
             	 }
              }
              catch(NullPointerException e)
          	 {
          		 log.error("Cell does not contain any data K" + i + "___________________________");
          	 }
              }
              log.info("Validation finish");
        }
        
        //Validation -----------scbcast-----------
        
        public void scbcast() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ------------------scbcast-------------------");
               int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
         	
               for(int i=6 ;i<=rc ; i++)
               {
               try
               {
             	  String sbcast = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 13);
             	  System.out.println(sbcast);
             	  String General="CA-01";
             	  String EWS="CA-02";
             	  String OBC="CA-03";
             	  String SC="CA-04";
             	  String ST="CA-05";
             	  if(sbcast.equals(General) || sbcast.equals(EWS) || sbcast.equals(OBC) || sbcast.equals(SC) || sbcast.equals(ST))
             	  {
             		 // log.info("sbcast is valid N" + i + "=" + sbcast);
             	  }
             	  else
             	  {
             		  log.error("sbcast is not  valid N" + i + "=" + sbcast + "******************************");
             	  }
               }
               catch(NullPointerException e)
           	 {
           		 log.error("Cell does not contain any data K" + i + "___________________________");
           	 }
               }
               log.info("Validation Finished");
        }
        
        //Validation ---------------scbgender-----------------
        
        public void scbgender() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation ------------------scbgender-------------------");
                int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
          	
                for(int i=6 ;i<=rc ; i++)
                {  
                try
                {
             	   String sbcast = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 14);
             	   System.out.println(sbcast);
             	   String Male="G-01"; 
             	   String Female="G-02";
             	   String Others="G-03";
             	   if(sbcast.equals(Male) || sbcast.equals(Female) || sbcast.equals(Others))
             	   {
             		  // log.info("scbgender is valid O" + i + "=" + sbcast);
             	   }
             	   else
             	   {
             		   log.error("scbgender is not valid O" + i + "=" + sbcast + "*************************");
             	   }   
                }
                catch(NullPointerException e)
             	 {
             		 log.error("Cell does not contain any data O" + i + "_____________________________________");
             	 }
                }
                log.info("Validation ------------------scbgender-------------------Finished");
        }
        
        
        
        //Validation ------------------scboccupation----------------
        
        public void scboccupation() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ------------------scboccupation-------------------");
            int rc = f.rowcount(excel_path, "stg_coborrowerdetails");
      	
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String sbcast = f.readDataWords(excel_path, "stg_coborrowerdetails", i, 15);
            	System.out.println(sbcast);
            	String Salaried="OC-01";
            	String SelfEmployedBusiness="OC-02";
            	String Professional="OC-03"; 
            	String Others="OC-04";
            	String Housewife="OC-05";
            	if(sbcast.equals(Salaried) || sbcast.equals(SelfEmployedBusiness) || sbcast.equals(Professional) || sbcast.equals(Others) || sbcast.equals(Housewife))
            	{
            		//log.info("sbcast is valid O" + i + "=" + sbcast);
            		
            	}
            	else
            	{
            		log.error("sbcast is not  valid O" + i + "=" + sbcast + "**********************************" );
            		
            	}
            	
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any data O" + i + "_____________________________________");
       	 }
          }

            log.info("Validation Finished");
        }
        
        //Validation -----------stg_borrower_loan Sheet ------------------
        
        //Validation --------------ddate----------------------
        
        public void ddate3() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");

            log.info("validation ----for stg_borrower_loan sheet----------------------------------");
            log.info("validation ---------------------ddate3--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_loan", i, 0);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date);
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }
            log.info("validation ---------------------ddate3-----------------------------Finished");
        }
        
        //Validation -----------------------scin3-----------------
        
        public void scin3() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation -----------------------scin3-----------------");
              int rc = f.rowcount(excel_path, "stg_borrower_loan");
              
              for(int i=6; i<=rc ;i++)
  	        {
  	       try
  	       {
  	        	String scin = f.readDataNString(excel_path, "stg_borrower_loan", i, 1);
  	        	 System.out.println(scin);
  	 	        
  	        	 // log.info("cell contains value C"+ i + "=" + scin);
  	        	//System.out.println("cell has value");
  	        	
  	       }
  	       catch(NullPointerException e)
  	        {
  	        	log.error("cell does not contains value C"+ i + "=_________________________________");
  	        	//System.out.println("does not has value");
  	        }
  	        }
              log.info("Validation -----------------------scin3-----------------Finished");
        }
        
        //Validation ------------sbloanno3------------------
        
        public void sbloanno3() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------sbloanno3------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_loan");

          	  for(int i=6; i<=rc ;i++)
    	        {
    	        try
    	        {
    	        	 String sbloanno = f.readDataNString(excel_path, "stg_borrower_loan", i, 2);
    	        	  System.out.println(sbloanno);
    	        
    	        	//  log.info("cell contains value C"+ i + "=" + sbloanno);
    	        	//System.out.println("cell has value");
    	      
    	        }
    	        catch(NullPointerException e)
    	        {
    	        	log.error("cell does not contains value C"+ i + "=" + "*************************************");
    	        	//System.out.println("does not has value");
    	        }
    	        }	
          	  log.info("Validation ---------------------sbloanno3------------------------------Finished");
        }
        
        //Validation ---------------sloantype----------------
        
        public void sloantype() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ---------------------sloantype------------------------------");
               int rc = f.rowcount(excel_path, "stg_borrower_loan");
               
               for(int i=6; i<=rc ;i++)
               {
               try
               {
            	   String sloantype = f.readDataWords(excel_path, "stg_borrower_loan", i, 3);
            	   System.out.println(sloantype);
            	   String Housing="TOL-01";
            	   String NonHousing="TOL-02";
            	   if(sloantype.equals(Housing) || sloantype.equals(NonHousing))
            	   {
            		   log.info("sloantype is valid D" + i + "=" + sloantype);
            	   }
            	   else
            	   {
            		   log.error("sloantype is not valid D" + i + "=" + sloantype + "*********************");
            	   }
               }
               catch(NullPointerException e)
   	        {
   	        	log.error("cell does not contains value D"+ i + "=" + "*************************************");
   	        	//System.out.println("does not has value");
   	        }
               }
               log.info("Validation ---------------------sloantype---------------------------Finished");
        }
        
        //validation --------------------sloanpurpose------------------
        
        public void sloanpurpose() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation ---------------------sloanpurpose------------------------------");
                int rc = f.rowcount(excel_path, "stg_borrower_loan");
                
                for(int i=6; i<=rc ;i++)
                {
                try
                {
                	String sloanpurpose = f.readDataWords(excel_path, "stg_borrower_loan", i, 4);
                	System.out.println(sloanpurpose);
                	String ConstructionNewDU="POL-01"; 
                	String PurchaseNewDU="POL-02"; 
                	String PurchaseOldDU="POL-03"; 
                	String PurchaseOldNew="POL-04"; 
                	String PlotConstruction="POL-05"; 
                	String RenovationReconstruction="POL-06"; 
                	String ConstructionLoan="POL-07"; 
                	String AgainstSecurityofShares="POL-08"; 
                	String GoldJewellery="POL-09";
                	String Plot="POL-10"; 
                	String Personal="POL-11"; 
                	String Business="POL-12"; 
                	String Topup="POL-13"; 
                	String Other="POL-14";
                	if(sloanpurpose.equals(Other) || sloanpurpose.equals(Topup) || sloanpurpose.equals(Business) || sloanpurpose.equals(Personal) || sloanpurpose.equals(Plot) || sloanpurpose.equals(GoldJewellery) || sloanpurpose.equals(AgainstSecurityofShares) || sloanpurpose.equals(ConstructionLoan) || sloanpurpose.equals(RenovationReconstruction) || sloanpurpose.equals(PlotConstruction) || sloanpurpose.equals(PurchaseOldNew) || sloanpurpose.equals(PurchaseOldDU) || sloanpurpose.equals(PurchaseNewDU) || sloanpurpose.equals(ConstructionNewDU))
                	{
                		//log.info("sloanpurpose is valid E" + i + "=" + sloanpurpose);
                	}
                	else
                	{
                		log.error("sloanpurpose is not valid E" + i + "=" + sloanpurpose);
                	}
                }
                catch(NullPointerException e)
       	        {
       	        	log.error("cell does not contains value E"+ i + "=" + "*************************************");
       	        	//System.out.println("does not has value");
       	        }
                }
                log.info("Validation ---------------------sloanpurpose---------------------------Finished");
        }
        
        //Validation ------------------nsanctamount----------------------
        
        public void nsanctamount() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------nsanctamount------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_loan");
             
             for(int i=6 ;i<=rc ; i++)
             {
             try
             {
             	long nsanctamount = f.readDataLONG(excel_path, "stg_borrower_loan", i, 5);
             	System.out.println(nsanctamount);
             	if(nsanctamount>=0)
             	{
             	//	log.info("Sanctioned Amount (Rs.) is F" + i + "=" + nsanctamount);
             	}
             	else
             	{
             		log.error("Sanctioned Amount (Rs.) not invalid F" + i + "=" + nsanctamount + "************************");
             	}
             	
             }
             catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any data F" + i + "__________________________________");
          	 }
             }
             log.info("Validation finish"); 
        }
        
        //Validation ----------------dsanctdate--------------
        
        public void dsanctdate() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------dsanctdate------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_loan");
              
              for(int i=6;i<=rc;i++)
              {
              String date = f.dateString(excel_path, "stg_borrower_loan", i, 6);
              System.out.println(date);

              // Desired date format
              String desiredDateFormat = "yyyy-MM-dd";

              // Create DateTimeFormatter with desired date format
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

              try {
                  // Parse the date from the Excel cell using DateTimeFormatter
                  LocalDate.parse(date, formatter);
                 // log.info("Date is in the desired format. G" + i + "=" + date);
                  //System.out.println("Date is in the desired format.");
              } catch (DateTimeParseException e) {
              	log.error("Date is not in the desired format G" + i + "=" + date + "*********************************");
                 // System.out.println("Date is not in the desired format.");
              }
              //log.info("column " + "A" + " row No " + i + " Value:= " + date );
              //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
              }
              log.info("Validation ---------------------dsanctdate----------------------------FInished");
        }
        
        //Validation --------------------sdwellingunit-------------------
        
        public void sdwellingunit() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ---------------------sdwellingunit------------------------------");
               int rc = f.rowcount(excel_path, "stg_borrower_loan");
               
               for(int i=6;i<=rc;i++)
               {
               try
               {
            	   String sdwellingunit = f.readDataWords(excel_path, "stg_borrower_loan", i, 7);
            	   
            	   
            	   //System.out.println(sdwellingunit);
            	   String st1="DU-01"; 
            	   String st2="DU-02"; 
            	   String st3="DU-03"; 
            	   String st4="DU-04";
            	   String st5="DU-05";
            	   if(sdwellingunit.equals(st5) || sdwellingunit.equals(st4) || sdwellingunit.equals(st3) || sdwellingunit.equals(st2) || sdwellingunit.equals(st1))
            	   {
            		  // log.info("sdwellingunit is valid H" + i + "=" + sdwellingunit);
            	   }
            	   else
            	   {
            		   log.error("sdwellingunit is not valid H" + i + "=" + sdwellingunit + "*******************************");
            	   }
               }
               catch(NullPointerException e)
            	 {
            		log.error("Cell does not contain any data H" + i + "______________________________________");
            	 }
               }
               log.info("Validation finished for sdwellingunit");
        }
        
        //Validation --------------imoratoriumperiod----------------
        
        public void imoratoriumperiod() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation ---------------------imoratoriumperiod------------------------------");
                int rc = f.rowcount(excel_path, "stg_borrower_loan");
                
                for(int i=6;i<=rc;i++)
                {
                try
                {
                	int imoratoriumperiod = f.readDataIN(excel_path, "stg_borrower_loan", i, 8);
                	System.out.println(imoratoriumperiod);
                	if(imoratoriumperiod>=0)
                	{
                		//log.info("Moratorium Period is I" + i + "=" + imoratoriumperiod);
                	}
                	else
                	{
                		log.error("Moratorium Period is not valid I" + i + "=" + imoratoriumperiod + "******************************");
                	}
                }
                catch(NullPointerException e)
           	 {
           		log.error("Cell does not contain any data I" + i + "________________________________________________");
           	 }
                }
                log.info("Validation ---------------------imoratoriumperiod----------------------------Finished");
        }
        
        //Validation -------------------iloantencont-----------------
        
        public void iloantencont() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------iloantencont------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	int imoratoriumperiod = f.readDataIN(excel_path, "stg_borrower_loan", i, 9);
            	//System.out.println(imoratoriumperiod);
            	log.info("Loan Tenure is J" + i + "=" + imoratoriumperiod );
				/*
				 * String numberStr = String.valueOf(imoratoriumperiod); char firstDigitChar =
				 * numberStr.charAt(0); int firstDigit =
				 * Character.getNumericValue(firstDigitChar); System.out.println(firstDigit);
				 * if(firstDigit==0 || firstDigit==1 || firstDigit==2) {
				 * log.info("Loan Tenure is valid J" + i + "=" + imoratoriumperiod ); } else {
				 * log.info("Loan Tenure is not valid J" + i + "=" + imoratoriumperiod +
				 * "**********************************" ); }
				 */
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any data J" + i + "________________________________________________");
          	 }
            }
            log.info("Validation ---------------------iloantencont---------------------------FInished");
        }
        
        //Validation ----------------iloantenresidual----------------
        
        public void iloantenresidual() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------iloantenresidual------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	int iloantenresidual = f.readDataIN(excel_path, "stg_borrower_loan", i, 10);
            	//System.out.println(iloantenresidual);
            	//log.info("Loan Tenure - Residual is K" + i + "=" + iloantenresidual );
            	
//				  String numberStr = String.valueOf(iloantenresidual); 
//				  char firstDigitChar =
//				  numberStr.charAt(0); int firstDigit =
//				  Character.getNumericValue(firstDigitChar); System.out.println(firstDigit);
//				  if(firstDigit==0 || firstDigit==1 || firstDigit==2) {
//				  log.info("Loan Tenure is valid J" + i + "=" + iloantenresidual ); } else {
//				  log.info("Loan Tenure is not valid J" + i + "=" + iloantenresidual +
//				  "**********************************" ); }
				 
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any data K" + i + "________________________________________________");
          	 }
            }
            log.info("Validation ---------------------iloantenresidual---------------------------Finished");
        }
        
        //Validation --------------------nroi-----------------------
        
        public void nroi() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nroi------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
           try
           {
            	String nroi = f.readdoubleToString(excel_path, "stg_borrower_loan", i, 11);
            	System.out.println(nroi);
            	
            	boolean isvalid = f.isDecimalFormat(nroi);
            	if(isvalid)
            	{
            		System.out.println("Is in Decimal(6,2)");
            		//log.info("Rate of Interest is valid L" + i + "=" + nroi );
            	}
            	else
            	{
            		System.out.println("is not in Decimal(6,2) ");
            		log.error("Rate of Interest is not  valid L" + i + "=" + nroi + "*********************");
            	}
           }
           catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value L" + i + "________________________________________________");
        	 }
            
            }
        }
        
        //Validation -------------------------sinttype-------------------------
        
        public void sinttype() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sinttype------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String sinttype = f.readDataWords(excel_path, "stg_borrower_loan", i, 12);
            	System.out.println(sinttype);
            	String Fixed="TOI-01";
            	String Floating="TOI-02";
            	String Other="TOI-03";
            	if(sinttype.equals(Other) || sinttype.equals(Floating) || sinttype.equals(Fixed))
            	{
            		//log.info("Type of Interest is valid M" + i + "=" + sinttype);
            	}
            	else
            	{
            		log.error("Type of Interest is not valid M" + i + "=" + sinttype);
            	}
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any Value L" + i + "________________________________________________");
       	 }
            
            }
        }
        
        //Validation -----------------nemi---------------
        
        public void nemi() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nemi------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	long nemi = f.readDataLONG(excel_path, "stg_borrower_loan" , i, 13);
            	//System.out.println(nemi);
            	
            	
            	try 
            	{
            		String dfirstdisbdate = f.dateString(excel_path, "stg_borrower_loan", i, 15);
            		//System.out.println(dfirstdisbdate);
            		
            		// Desired date format
                    String desiredDateFormat = "yyyy-MM-dd";

                    // Create DateTimeFormatter with desired date format
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);
                    try {
                        // Parse the date from the Excel cell using DateTimeFormatter
                        LocalDate.parse(dfirstdisbdate, formatter);
                        //log.info("(EMI) cannot be zero N" + i +"=" + nemi + "***************");
                       // log.info("Date is in the desired format. N" + i + "=" + dfirstdisbdate);
                        //System.out.println("Date is in the desired format.");
                        if(nemi>0)
                      	{
                      		//log.info("(EMI) cannot be zero" + "||" + " (EMI) is valid N" + "=" + nemi );
                      	}
                      	else
                      	{
                      		log.error("(EMI) cannot be zero" + "||" +" (EMI) is not valid N" + i + "=" + nemi + "**************************************");
                      	}
                    } catch (DateTimeParseException e) {
                    	log.error("Date is not in the desired format A" + i + "=" + dfirstdisbdate + "*********************************");
                       // System.out.println("Date is not in the desired format.");
                    }
            		
            	}
            	 catch(NullPointerException e)
             	 {
            		 if(nemi>=0)
                 	{
                 		//log.info(" (EMI) is valid N" + "=" + nemi );
                 	}
                 	else
                 	{
                 		log.error(" (EMI) is not valid N" + "=" + nemi + "**************************************");
                 	}
             		
             	 }
            	
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value N" + i + "________________________________________________");
          	 }
            }
        }
        
        //Validation -------------npreemi---------------------
        
        public void npreemi() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------npreemi------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	long nemi = f.readDataLONG(excel_path, "stg_borrower_loan" , i, 14);
            	//System.out.println(nemi);
            	
            	
            	try 
            	{
            		String dfirstdisbdate = f.dateString(excel_path, "stg_borrower_loan", i, 15);
            		//System.out.println(dfirstdisbdate);
            		
            		// Desired date format
                    String desiredDateFormat = "yyyy-MM-dd";

                    // Create DateTimeFormatter with desired date format
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);
                    try {
                        // Parse the date from the Excel cell using DateTimeFormatter
                        LocalDate.parse(dfirstdisbdate, formatter);
                        //log.info("(EMI) cannot be zero N" + i +"=" + nemi + "***************");
                       // log.info("Date is in the desired format. N" + i + "=" + dfirstdisbdate);
                        //System.out.println("Date is in the desired format.");
                        if(nemi>0)
                      	{
                      	//	log.info("Pre-EMI interest (PEMI) cannot be zero" + "||" + " (EMI) is valid O" + "=" + nemi );
                      	}
                      	else
                      	{
                      		log.error("Pre-EMI interest (PEMI) cannot be zero" + "||" +" (EMI) is not valid O" + i + "=" + nemi + "**************************************");
                      	}
                    } catch (DateTimeParseException e) {
                    	//log.info("Date is not in the desired format A" + i + "=" + dfirstdisbdate + "*********************************");
                       // System.out.println("Date is not in the desired format.");
                    }
            		
            	}
            	 catch(NullPointerException e)
             	 {
            		 if(nemi>=0)
                 	{
                 		//log.info(" (EMI) is valid N" + "=" + nemi );
                 	}
                 	else
                 	{
                 		log.error(" Pre-EMI interest (PEMI) is not valid O" + "=" + nemi + "**************************************");
                 	}
             		
             	 }
            	
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value O" + i + "________________________________________________");
          	 }
            }

        }
            
        //Validation -----Date of first Disbursement ----------------------
        
        public void dfirstdisbdate() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------dfirstdisbdate--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            //System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_loan", i, 15);
            String date1 = f.dateString(excel_path, "stg_borrower_loan", i, 6);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate d1 = LocalDate.parse(date, formatter);
                LocalDate d2 = LocalDate.parse(date1, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
                if(d1.isAfter(d2))
                {
                	log.info("Date is in the desired format. P" + i + "=" + date + "||" + date + " Greater than " + date1);
                }
                else 
                {
                	log.error("Date is in the desired format. P" + i + "=" + date + "||" + date + " Less than " + date1 + "******************");
                }
                
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format P" + i + "=" + date + "************************");
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }

        }
        
        //Vaidation --------------------demistartdate------------------
        
        public void demistartdate() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------demistartdate--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_loan", i, 16);	
            String date1= f.dateString(excel_path, "stg_borrower_loan", i, 15);
            String date2 = f.dateString(excel_path, "stg_borrower_loan", i, 6);
           // System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate d1 = LocalDate.parse(date, formatter);
                LocalDate d2 = LocalDate.parse(date1, formatter);
                LocalDate d3 = LocalDate.parse(date2, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
                if(d1.isAfter(d2) || d1.isAfter(d3))
                {
                	log.info("Date is in the desired format. Q" + i + "=" + date + "||" + date + " Greater than " + date1);
                }
                else 
                {
                	log.error("Date is in the desired format. Q" + i + "=" + date + "||" + date + " Less than " + date1 + "******************");
                }
                
            } catch (DateTimeParseException e) {
            	log.error("Date is not present in the desired format Q" + i + "=" + date + "************************");
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }

        }
   
        //Validation -------------dpreemistartdate----------------
        
        public void dpreemistartdate() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------dpreemistartdate--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            System.out.println(rc);	

            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_loan", i, 17);	
            String date1= f.dateString(excel_path, "stg_borrower_loan", i, 15);
            String date2 = f.dateString(excel_path, "stg_borrower_loan", i, 6);
           // System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate d1 = LocalDate.parse(date, formatter);
               // LocalDate d2 = LocalDate.parse(date1, formatter);
               LocalDate d3 = LocalDate.parse(date2, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
                if(d1.isAfter(d3))
                {
                	log.info("Date is in the desired format. R" + i + "=" + date + "||" + date + " Greater than " + date2);
                }
                else 
                {
                	try
                	{
                	LocalDate d2 = LocalDate.parse(date1, formatter);
                	if(d1.isAfter(d2))
                	{
                	
                	log.info("Date is in the desired format. R" + i + "=" + date + "||" + date + " Greater than " + date1);
                    }
                	else
                	{
                		log.error("Date is in the desired format. R" + i + "=" + date + "||" + date + " Less than " + date1);
                	}
                	}
                	 catch (DateTimeParseException e) {
                     	
                     	log.error("Date is not present  P" + i + "=" + date + "************************");
                        // System.out.println("Date is not in the desired format.");
                     }
                }
                
            } 
            catch (DateTimeParseException e) {
            	
            	log.info("Date is not present  R" + i + "=" + date + "************************");
               // System.out.println("Date is not in the desired format.");
            }
            //log.info("column " + "A" + " row No " + i + " Value:= " + date );
            //System.out.println("column " + "A" + " row No " + i + " Value:= " + date );
            }

        }
        
        //Validation for------------------nloandisbduringmonth-------------
        
        public void nloandisbduringmonth() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------nloandisbduringmonth--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            //System.out.println(rc);	
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long nloandisbduringmonth = f.readDataLONG(excel_path, "stg_borrower_loan", i, 18);
            	long nsanctamount = f.readDataLONG(excel_path, "stg_borrower_loan", i, 5);
            	
            	if(nloandisbduringmonth<=nsanctamount && nloandisbduringmonth>=0)
            	{
            		//log.info("Loan Amount Disbursed is valid S" + i + "=" + nloandisbduringmonth );
            	}
            	else
            	{
            		log.error("Loan Amount Disbursed is not valid S" + i + "=" + nloandisbduringmonth + "************************");
            	}
            }
            	 catch (DateTimeParseException e) {
                 	
                 	log.error("Date is not present  S" + i + "=" + i + "______________________________" );
                    // System.out.println("Date is not in the desired format.");
                 }
            }
            log.info("validation for dpreemistartdate finished");
            }
        
        //Validation --------------ncummuloandisb-----------------
        
        public void ncummuloandisb() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------ncummuloandisb--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long nloandisbduringmonth = f.readDataLONG(excel_path, "stg_borrower_loan", i, 19);
            	long nsanctamount = f.readDataLONG(excel_path, "stg_borrower_loan", i, 5);
            	
            	if(nloandisbduringmonth<=nsanctamount && nloandisbduringmonth>=0)
            	{
            		//log.info("Loan Amount Disbursed is valid S" + i + "=" + nloandisbduringmonth );
            	}
            	else
            	{
            		log.error("Loan Amount Disbursed is not valid T" + i + "=" + nloandisbduringmonth + "************************");
            	}
            }
            	 catch (DateTimeParseException e) {
                 	
                 	log.error("Date is not present  T" + i + "=" + i + "______________________________" );
                    // System.out.println("Date is not in the desired format.");
                 }
            }
            log.info("validation for ncummuloandisb finished");
        
        }
        
        //Validation  ------------sloanstatus-----------------
        
        public void sloanstatus() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------sloanstatus--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	String sloanstatus = f.readDataWords(excel_path, "stg_borrower_loan", i, 20);
            	String Securitised="LS-01";
            	String DirectAssignment="LS-02"; 
            	String LoanPurchased="LS-03"; 
            	String Cooriginatedlending="LS-04"; 
            	String Noneofthem="LS-05";
            	String NotApplicable="LS-06";
            	if(sloanstatus.equals(Securitised) || sloanstatus.equals(DirectAssignment) || sloanstatus.equals(LoanPurchased) || sloanstatus.equals(Cooriginatedlending) || sloanstatus.equals(Noneofthem) || sloanstatus.equals(NotApplicable))
            	{
            		//log.info("Loan Status is valid 	U" + i + "=" + sloanstatus);
            	}
            	else
            	{
            		log.error("Loan Status is not valid 	U" + i + "=" + sloanstatus + "**********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value U" + i + "________________________________________________");
         	 }
            }
            log.info("validation ---------------------sloanstatus--------------------------------finished");
        }
        
        //Validation -----------------namtundercons---------------------------
        
        public void namtundercons() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------namtundercons--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long namtundercons = f.readDataLONG(excel_path, "stg_borrower_loan", i, 21);
            	if(namtundercons>=0)
            	{
            		//log.info("Amount outstanding under consideration (Rs.) is valid  V" + i + "=" + namtundercons );
            	}
            	else
            	{
            		log.error("Amount outstanding under consideration (Rs.) is not valid  V" + i + "=" + namtundercons + "*******************" );
            	}
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any Value U" + i + "________________________________________________");
       	 }
           }
           log.info("validation ---------------------namtundercons--------------------------------finished");
        }
        
        //Validation --------------spartyname----------------------
        
        public void spartyname() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------spartyname--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	String spartyname = f.readDataWords(excel_path, "stg_borrower_loan", i, 22);	
            	String PSBs="CP-01";
            	String OtherBanks="CP-02";
            	String HFCs="CP-03";
            	String ARCs="CP-04";
            	String Others="CP-05";
            	String Noneofthem="CP-06";
            	if(spartyname.equals(PSBs) || spartyname.equals(OtherBanks) || spartyname.equals(HFCs) || spartyname.equals(ARCs) || spartyname.equals(Others) || spartyname.equals(Noneofthem))
            	{
            		//log.info("Counter Party is  valid W" + i + "=" + spartyname);
            	}
            	else
            	{
            		log.error("Counter Party is not valid W" + i + "=" + spartyname + "*************************");
            	}
            }
            catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value U" + i + "________________________________________________");
        	 }
            }
            log.info("validation ---------------------spartyname--------------------------------finished");
        }
        
        //Validation --------------smortguratee--------------------
        
        public void smortguratee() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------smortguratee--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	String smortguratee = f.readDataWords(excel_path, "stg_borrower_loan", i, 23);
            	if(smortguratee.equals("MG-01") || smortguratee.equals("MG-02") || smortguratee.equals("MG-03") || smortguratee.equals("MG-04") ||smortguratee.equals("MG-05"))
            	{
            		//log.info("Mortgage Guarantee is valid X" + i + "=" + smortguratee);
            	}
            	else
            	{
            		log.error("Mortgage Guarantee is not valid X" + i + "=" + smortguratee + "*********************");
            	}
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any Value U" + i + "________________________________________________");
       	 }
           }
           log.info("validation ---------------------smortguratee--------------------------------finished");
        }
        
        //Validation --------------namoutunderguar---------------
        
        public void namoutunderguar() throws EncryptedDocumentException, IOException 
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------namoutunderguar--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long namoutunderguar = f.readDataLONG(excel_path, "stg_borrower_loan", i, 24);
            	if(namoutunderguar>0)
            	{
            		//log.info("Amount outstanding under Guarantee (Rs.)  is valid Y" + i + namoutunderguar);
            	}
            	else
            	{
            		log.error("Amount outstanding under Guarantee (Rs.)  is not valid Y" + i + namoutunderguar);	
            	}
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value Y" + i + "________________________________________________");
          	 }
              }
              log.info("validation ---------------------namoutunderguar--------------------------------finished");
        
        }
        
        //Validation ------------ntotalloanout---------------
        
        public void ntotalloanout() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------ntotalloanout--------------------------------");
            Flib f = new Flib();

            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long ntotalloanout = f.readDataLONG(excel_path, "stg_borrower_loan", i, 25);
            	if(ntotalloanout>0)
            	{
            		//log.info("Total Loan Outstanding  is valid Z" + i + ntotalloanout);
            	}
            	else
            	{
            		log.info("Total Loan Outstanding  is not valid Z" + i + ntotalloanout + "*********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.info("Cell does not contain any Value Z" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------ntotalloanout--------------------------------finished");
        }
        
        //Validation --------------npout--------------------
        
        public void npout() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------npout--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long npout = f.readDataLONG(excel_path, "stg_borrower_loan", i, 26);
            	if(npout>0)
            	{
            		//log.info("Principal Outstanding  is valid AA" + i + npout);
            	}
            	else
            	{
            		log.error("Total Loan Outstanding  is not valid AA" + i + npout + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AA" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------npout--------------------------------finished");

        }
        
        //Validation -----------niout---------------
        
        public void niout() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------niout--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long niout = f.readDataLONG(excel_path, "stg_borrower_loan", i, 27);
            	if(niout>=0)
            	{
            		//log.info("Interest Outstanding is valid AB" + i + niout);
            	}
            	else
            	{
            		log.error("Interest Outstanding is not valid AB" + i + niout + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AB" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------niout--------------------------------finished");

        }
        
        //Validation ---------------notherdueout---------------
        
        public void notherdueout() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------notherdueout--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long notherdueout = f.readDataLONG(excel_path, "stg_borrower_loan", i, 28);
            	if(notherdueout>=0)
            	{
            		//log.info("Other Dues is valid AC" + i + notherdueout);
            	}
            	else
            	{
            		log.error("Other Dues is not valid AC" + i + notherdueout + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AC" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------notherdueout--------------------------------finished");
        }
        
        //Validation ---------------nloandsbp-----------------
        
        public void nloandsbp() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------nloandsbp--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long nloandsbp = f.readDataLONG(excel_path, "stg_borrower_loan", i, 29);
            	if(nloandsbp>=0)
            	{
            		//log.info("Loan Schedule Balance (Principal) (Rs.) is valid AD" + i + nloandsbp);
            	}
            	else
            	{
            		log.error("Loan Schedule Balance (Principal) (Rs.) is not valid AD" + i + nloandsbp + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AD" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------nloandsbp--------------------------------finished");
        
        }
        
        //Validation ----------nloanrepaydurmth-------------
        
        public void nloanrepaydurmth() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------nloanrepaydurmth--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long nloanrepaydurmth = f.readDataLONG(excel_path, "stg_borrower_loan", i, 30);
            	if(nloanrepaydurmth>=0)
            	{
            		//log.info("Loan Repayment During the Month (Rs.) is valid AE" + i + nloanrepaydurmth);
            	}
            	else
            	{
            		log.error("Loan Repayment During the Month (Rs.) is not valid AE" + i + nloanrepaydurmth + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AE" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------nloanrepaydurmth--------------------------------finished");

        }
        
        
        //Validation ------------ntotalloanoverdue--------------------
        
        public void ntotalloanoverdue() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------ntotalloanoverdue--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long ntotalloanoverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 31);
            	long npoverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 32);
            	long nioverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 33);
            	long notheroverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 34);
            	
            	long sum = npoverdue+nioverdue+notheroverdue;
            	if(ntotalloanoverdue==sum && ntotalloanoverdue>=0)
            	{
            		//log.info("Total Loan Overdue  [npoverdue+nioverdue+notheroverdue)] (Rs.): is valid AF" + i + ntotalloanoverdue);
            	}
            	else
            	{
            		log.error("Loan Repayment During the Month (Rs.) is not valid AF" + i + "=" + ntotalloanoverdue + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AF" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------ntotalloanoverdue--------------------------------finished");
        }
        
        //Validation ---------------npoverdue-----------------
        
        public void npoverdue() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------npoverdue--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long npoverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 32);
            	if(npoverdue>=0)
            	{
            		//log.info("Principal Overdue is valid AG" + i + npoverdue);
            	}
            	else
            	{
            		log.error("Principal Overdue is not valid AG" + i + "=" + npoverdue + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AG" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------npoverdue--------------------------------finished");

        }
        
        
        //Validation --------------nioverdue-------------
        
        public void nioverdue() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------npoverdue--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long nioverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 33);
            	if(nioverdue>=0)
            	{
            		//log.info("Interest Overdue is valid AH" + i + npoverdue);
            	}
            	else
            	{
            		log.error("Interest Overdue is not valid AH" + i + "=" + nioverdue + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AH" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------nioverdue--------------------------------finished");
        }
        
        //Validation ----------------notheroverdue----------
        
        public void notheroverdue() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------notheroverdue--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	long notheroverdue = f.readDataLONG(excel_path, "stg_borrower_loan", i, 34);
            	if(notheroverdue>=0)
            	{
            		//log.info("Other Dues Overdues is valid AI" + i + notheroverdue);
            	}
            	else
            	{
            		log.error("Other Dues Overdues is not valid AI" + i + "=" + notheroverdue + "***********************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AI" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------notheroverdue--------------------------------finished");
        }
        
        //Validation ----------saccntcloseddurmth-------
        
        public void saccntcloseddurmth() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------saccntcloseddurmth--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	String saccntcloseddurmth=f.readDataWords(excel_path, "stg_borrower_loan", i, 35);
            	if(saccntcloseddurmth.equals("Yes") || saccntcloseddurmth.equals("No"))
            	{
            		//log.info("Whether account closed during the month ? is valid AJ" + i + saccntcloseddurmth);
            	}
            	else
            	{
            		log.error("Whether account closed during the month ? is not valid AJ" + i + saccntcloseddurmth + "**************************");
            	}
            }
            catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value AJ" + i + "________________________________________________");
        	 }
            }
            log.info("validation ---------------------saccntcloseddurmth-----------------------------Finished");
        }
        
        //Validation ------------------sassetcat--------------------------
        
        public void sassetcat() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------sassetcat--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            try
            {
            	String sassetcat=f.readDataWords(excel_path, "stg_borrower_loan", i, 36);
            	if(sassetcat.equals("ACC-00") || sassetcat.equals("ACC-01") || sassetcat.equals("ACC-02") || sassetcat.equals("ACC-03") || sassetcat.equals("ACC-04") || sassetcat.equals("ACC-05") || sassetcat.equals("ACC-06") || sassetcat.equals("ACC-07") || sassetcat.equals("ACC-08"))
            	{
            	     //log.info("Asset Category/Classification (IRAC) is valid AK" + i + "=" + sassetcat);	
            	}
            	else
            	{
            		log.error("Asset Category/Classification (IRAC) is not valid AK" + i + "=" + sassetcat);	
            	}
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any Value AK" + i + "________________________________________________");
       	 }
           }
           log.info("validation ---------------------sassetcat-----------------------------Finished");
        }
        
        //Validation ------------secl---------------
        
        public void secl() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------secl--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
           try
           {
        	   String secl=f.readDataWords(excel_path, "stg_borrower_loan", i, 37);
        	   if(secl.equals("ACCI-01") || secl.equals("ACCI-02") || secl.equals("ACCI-03"))
        	   {
        		   //log.info("Asset Category/Classification (IndAs)-Expected Credit Loss (ECL) is  valid AL" + i + "=" + secl);	 
        	   }
        	   else
        	   {
        		   log.error("Asset Category/Classification (IndAs)-Expected Credit Loss (ECL) is not valid AL" + i + "=" + secl + "************************");	
        	   }
           }
           catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AL" + i + "________________________________________________");
         	 }
             }
             log.info("validation ---------------------secl-----------------------------Finished");
        }
        
        //Validation --------------------dclassdate-----------------------
        
        public void dclassdate() throws EncryptedDocumentException, IOException
        {
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("validation ---------------------dclassdate--------------------------------");
            Flib f = new Flib();
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6;i<=rc;i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_loan", i, 38);
            String date1 = f.dateString(excel_path, "stg_borrower_loan", i, 15);
            System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate d1 = LocalDate.parse(date, formatter);
                LocalDate d2 = LocalDate.parse(date1, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
                if(d1.isAfter(d2))
                {
                	//log.info("Date is in the desired format. AM" + i + "=" + date + "||" + " Greater than " + date1);
                }
                else 
                {
                	log.error("Date is in the desired format. AM" + i + "=" + date + "||" + " Less than " + date1 + "******************");
                }
                
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format P" + i + "=" + date + "***************************");
               // System.out.println("Date is not in the desired format.");
            }
            
        }
            log.info("validation ---------------------secl--------------------------------Finished");
        }
        
        
        //Valiadation -----------------npd----------------
        
        public void npd() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------npd------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
           try
           {
            	String npd = f.readdoubleToString(excel_path, "stg_borrower_loan", i, 39);
            	double npd1 = f.readdouble(excel_path, "stg_borrower_loan", i, 39);
            	System.out.println(npd);
            	
            	boolean isvalid = f.isDecimalFormat(npd);
            	if(isvalid && npd1>=0)
            	{
            		//System.out.println("Is in Decimal(6,2)");
            		//log.info("Probability of Default (PD) [%] is valid AN" + i + "=" + npd );
            	}
            	else
            	{
            		System.out.println("is not in Decimal(6,2) ");
            		log.error("Probability of Default (PD) [%] is not  valid AN" + i + "=" + npd + "*************************");
            	}
           }
           catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value L" + i + "________________________________________________");
        	 }
            }
            log.info("Validation ---------------------npd------------------------------Finished");
        }
      
        //Validation -----------------nlgd-----------------------
        
        public void nlgd() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nlgd------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
           try
           {
            	String nlgd = f.readdoubleToString(excel_path, "stg_borrower_loan", i, 40);
            	double nlgd1 = f.readdouble(excel_path, "stg_borrower_loan", i, 40);
            	System.out.println(nlgd);
            	
            	boolean isvalid = f.isDecimalFormat(nlgd);
            	if(isvalid && nlgd1>=0)
            	{
            		//System.out.println("Is in Decimal(6,2)");
            		//log.info("Loss Given Default (LGD)  is valid AN" + i + "=" + nlgd );
            	}
            	else
            	{
            		System.out.println("is not in Decimal(6,2) ");
            		log.error("Loss Given Default (LGD)  is not  valid AN" + i + "=" + nlgd + "*************************");
            	}
           }
           catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value L" + i + "________________________________________________");
        	 }
            }
            log.info("Validation ---------------------nlgd------------------------------Finished");
        }
        
        //Validation ------------------nprovamt-------------------
        
        public void nprovamt() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nprovamt------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
           try
           {
            	double nprovamt = f.readDataLONG(excel_path, "stg_borrower_loan", i, 41);
            	
            	if(nprovamt>=0)
            	{
            		//System.out.println("Is in Decimal(6,2)");
            		//log.info("Provisions  (Rs.)  is valid AN" + i + "=" + nlgd );
            	}
            	else
            	{
            		System.out.println("is not in Decimal(6,2) ");
            		log.error("Provisions  (Rs.)  is not  valid AN" + i + "=" + nprovamt + "*************************");
            	}
           }
           catch(NullPointerException e)
        	 {
        		log.error("Cell does not contain any Value L" + i + "________________________________________________");
        	 }
            }
            log.info("Validation ---------------------nprovamt------------------------------Finished");
        }
        
        //Validation -----------------nrw---------------------
        
        public void nrw() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nrw------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String nrw = f.readDataWords(excel_path, "stg_borrower_loan", i, 42);
            	if(nrw.equals("RWA-01") || nrw.equals("RWA-02") || nrw.equals("RWA-03") || nrw.equals("RWA-04") || nrw.equals("RWA-06"))
            	{
            		//log.info("Risk Weight [%] is valid AQ" + i + "=" + nrw);
            	}
            	else
            	{
            		log.error("Risk Weight [%] is not valid AQ" + i + "=" + nrw + "*********************************");
            	}
            }
            catch(NullPointerException e)
       	 {
       		log.error("Cell does not contain any Value AQ" + i + "________________________________________________");
       	 }
           }
           log.info("Validation ---------------------nrw------------------------------Finished");
        }
        
        //Validation ----------------sreffromnhb---------------------
        
        public void sreffromnhb() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sreffromnhb------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String sreffromnhb = f.readDataWords(excel_path, "stg_borrower_loan", i, 43);
            	if(sreffromnhb.equals("Yes") || sreffromnhb.equals("No"))
            	{
            		//log.info("sreffromnhb is valid AR" + i + "=" + sreffromnhb);	
            	}
            	else
            	{
            		log.error("sreffromnhb is not valid AR" + i + "=" + sreffromnhb);	
            	}
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value AR" + i + "________________________________________________");
          	 }
              }
              log.info("Validation ---------------------sreffromnhb------------------------------Finished");
        }
        
        //Validation --------------------------sunderpmayclss--------------------
        
        public void sunderpmayclss() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sunderpmayclss------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String sunderpmayclss = f.readDataWords(excel_path, "stg_borrower_loan", i, 44);
            	if(sunderpmayclss.equals("Yes") || sunderpmayclss.equals("No"))
            	{
            		//log.info("sreffromnhb is valid AS" + i + "=" + sunderpmayclss);	
            	}
            	else
            	{
            		log.error("sunderpmayclss is not valid AS" + i + "=" + sunderpmayclss);	
            	}
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value AS" + i + "________________________________________________");
          	 }
              }
              log.info("Validation ---------------------sunderpmayclss------------------------------Finished");
        }
        
        //Validation --------------------sserfaseiact-------------------
        
        public void sserfaseiact() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sserfaseiact------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String sserfaseiact = f.readDataWords(excel_path, "stg_borrower_loan", i, 45);
            	if(sserfaseiact.equals("Yes") || sserfaseiact.equals("No"))
            	{
            		//log.info("sserfaseiact is valid AT" + i + "=" + sserfaseiact);	
            	}
            	else
            	{
            		log.error("sunderpmayclss is not valid AT" + i + "=" + sserfaseiact);	
            	}
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value AT" + i + "________________________________________________");
          	 }
              }
              log.info("Validation ---------------------sserfaseiact------------------------------Finished");
        }
        
        //Validation ------------------namtclaimundernotice---------------
        
        public void namtclaimundernotice() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------namtclaimundernotice------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	long namtclaimundernotice=f.readDataLONG(excel_path, "stg_borrower_loan", i, 46);
            	log.info("Amount Involved (please mention amount claimed in the notice) is valid AU" + i + "=" + namtclaimundernotice);
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AT" + i + "________________________________________________");
         	 }
             }
             log.info("Validation ---------------------namtclaimundernotice------------------------------Finished");
            
        }
        
        //Validation --------------namtrecovered-------------------
        
        public void namtrecovered() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------namtrecovered------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	long namtclaimundernotice=f.readDataLONG(excel_path, "stg_borrower_loan", i, 47);
            	log.info("Amount Recovered is valid AV" + i + "=" + namtclaimundernotice);
            }
            catch(NullPointerException e)
         	 {
         		log.error("Cell does not contain any Value AV" + i + "________________________________________________");
         	 }
             }
             log.info("Validation ---------------------namtrecovered------------------------------Finished");
        }
       
        //Validation --------sstaygranted----------------
        
        public void sstaygranted() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sstaygranted------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_loan");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	String sstaygranted = f.readDataWords(excel_path, "stg_borrower_loan", i, 48);
            	if(sstaygranted.equals("Yes") || sstaygranted.equals("No"))
            	{
            		//log.info("sstaygranted is valid AW" + i + "=" + sstaygranted);	
            	}
            	else
            	{
            		log.error("sstaygranted is not valid AW" + i + "=" + sstaygranted);	
            	}
            }
            catch(NullPointerException e)
          	 {
          		log.error("Cell does not contain any Value AW" + i + "________________________________________________");
          	 }
              }
              log.info("Validation ---------------------sstaygranted------------------------------Finished");
        }
        
        //Validation for ---------------stg_borrower_mortgage----------- sheet
        
        //Validation -----------------ddate-------------------
        
        public void ddate4() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
        	Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info(" //Validation for ---------------stg_borrower_mortgage----------- sheet");
            log.info("Validation ---------------------ddate4------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
            
            for(int i=6 ; i<=rc ; i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_mortgage", i, 0);
           // System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } 
            catch (DateTimeParseException e) 
            {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            }
            log.info("Validation ---------------------ddate4------------------------------Finished");
        }
        
        //Validation -------------------scin----------------------
        
        public void scin4() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------scin4------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
              
              for(int i=6; i<=rc ;i++)
  	        {
  	       try
  	       {
  	        	String scin = f.readDataNString(excel_path, "stg_borrower_mortgage", i, 1);
  	        	  //log.info("scin contains value B"+ i + "=" + scin);
  	       }
  	       catch(NullPointerException e)
  	        {
  	        	log.error("cell does not contains value B"+ i + "=_________________________________");
  	        	//System.out.println("does not has value");
  	        }
  	        }
              log.info("Validation ---------------------scin4------------------------------Finished");
        }
        
        //Validation ------------sbloanno------------
        
        public void sbloanno4() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------sbloanno4------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_mortgage");

         	for(int i=6; i<=rc ;i++)
   	        {
   	        try
   	        {
   	        	 String sbloanno = f.readDataNString(excel_path, "stg_borrower_mortgage", i, 2);
   	        	  log.info("sbloanno contains value C"+ i + "=" + sbloanno);
   	        }
   	        catch(NullPointerException e)
   	        {
   	        	log.error("sbloanno  does not contains value C"+ i + "=" + "****************************");
   	        	System.out.println("does not has value");
   	        }
   	        }
         	log.info("Validation ---------------------sbloanno4------------------------------Finished");
        }
        
        //Validation -----------------sporptype----------------------------
        
        public void sporptype() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------sporptype------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
              
              for(int i=6; i<=rc ;i++)
     	      {
              try
              {
            	  String sporptype = f.readDataWords(excel_path, "stg_borrower_mortgage", i, 3);
            	  if(sporptype.equals("TOP-01") || sporptype.equals("TOP-02") || sporptype.equals("TOP-03") || sporptype.equals("TOP-04") || sporptype.equals("TOP-05") ||sporptype.equals("TOP-06"))
            	  {
            		  //log.info("Type of Property is valid D" + i + "=" + sporptype);
            	  }
            	  else
            	  {
            		log.error("Type of Property is not valid D" + i + "=" + sporptype + "*************************");
            	  }
              }
              catch(NullPointerException e)
     	        {
     	        	log.error("Cell  does not contains value D"+ i + "=" + "___________________________________");
     	        }
     	        }
           	log.info("Validation ---------------------sporptype------------------------------Finished");
        }
        
        //Validation ---------------spropadd-------------------------
        
        public void spropadd() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ---------------------spropadd------------------------------");
               int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
               
               for(int i=6; i<=rc ;i++)
      	      {
               try
               {
            	   String spropadd = f.readDataWords(excel_path, "stg_borrower_mortgage", i, 4);
            	  // log.info("Asset / Property Address contains value E" + i + "=" + spropadd);
               }
               catch(NullPointerException e)
    	        {
    	        	log.error("Cell  does not contains value E"+ i + "=" + "___________________________________");
    	        }
      	      }
           	log.info("Validation ---------------------spropadd------------------------------Finished");
        }
        
        //Validation --------------nlandarea-------------
        
        public void nlandarea() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
            	Logger log = Logger.getLogger(ValidateMethods.class);
                PropertyConfigurator.configure("log4j.properties");
                log.info("Validation ---------------------nlandarea------------------------------");
                int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
                
                for(int i=6 ; i<=rc ; i++)
                {
                try
                {
                 	String npd = f.readdoubleToString(excel_path, "stg_borrower_mortgage", i, 5);
                 	double npd1 = f.readdouble(excel_path, "stg_borrower_mortgage", i, 5);
                 	
                 	
                 	boolean isvalid = f.isDecimalFormat2(npd);
                 	if(isvalid && npd1>=0)
                 	{
                 		log.info("Area of Land (in sqm.) is valid F" + i + "=" + npd );
                 	}
                 	else
                 	{
                 		//System.out.println("is not in Decimal(6,2) ");
                 		log.error("Area of Land (in sqm.) is not  valid F" + i + "=" + npd + "*************************");
                 	}
                }
                catch(NullPointerException e)
    	        {
    	        	log.error("Cell  does not contains value F"+ i + "=" + "___________________________________");
    	        }
                }
             	log.info("Validation ---------------------nlandarea------------------------------Finished");
        }
        
        //Validation -------------------nbuildingarea------------------
        
        public void nbuildingarea() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
         	Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------nbuildingarea------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
             
             for(int i=6 ; i<=rc ; i++)
             {
             try
             {
              	String npd = f.readdoubleToString(excel_path, "stg_borrower_mortgage", i, 6);
              	double npd1 = f.readdouble(excel_path, "stg_borrower_mortgage", i, 6);
              	
              	
              	boolean isvalid = f.isDecimalFormat2(npd);
              	if(isvalid && npd1>=0)
              	{
              		log.info("Carpet Area of Building (in sqm.) is valid G" + i + "=" + npd );
              	}
              	else
              	{
              		//System.out.println("is not in Decimal(6,2) ");
              		log.error("Carpet Area of Building (in sqm.) is not  valid G" + i + "=" + npd + "*************************");
              	}
             }
             catch(NullPointerException e)
 	        {
 	        	log.error("Cell  does not contains value G"+ i + "=" + "___________________________________");
 	        }
             }
          	log.info("Validation ---------------------nbuildingarea------------------------------Finished");
        }
        
        //Validation ------------------stownname---------------------
        
        public void stownname() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------stownname------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
              
              for(int i=6 ; i<=rc ; i++)
              {
              try
              {
            	  String stownname = f.readDataWords(excel_path, "stg_borrower_mortgage", i, 7);
            	  //log.info("Name of Town/Village is valid H" + i + "=" + stownname );
              }
              catch(NullPointerException e)
   	        {
   	        	log.error("Cell  does not contains value H"+ i + "=" + "___________________________________");
   	        }
              }
          	log.info("Validation ---------------------stownname------------------------------Finished");
        }
        //Validation ------------------sdistrict------------
        
        public void sdistrict() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
          	Logger log = Logger.getLogger(ValidateMethods.class);
              PropertyConfigurator.configure("log4j.properties");
              log.info("Validation ---------------------nbuildingarea------------------------------");
              int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
              
              for(int i=6 ; i<=rc ; i++)
              {
              try
              {
              String stownname = f.readDataWords(excel_path, "stg_borrower_mortgage", i, 8);
              //System.out.println(stownname);
              //log.info("District is valid I" + i + "=" + stownname);
              }
              catch(IllegalStateException e)
     	        {
            	   long stownname1 = f.readDataLONG(excel_path, "stg_borrower_mortgage", i, 8);
            	   //log.info("District is valid I" + i + "=" + stownname1);
     	        	
     	        }
              catch(NullPointerException e)
     	        {
     	        	log.error("Cell  does not contains value I"+ i + "=" + "___________________________________");
     	        }
              }
          	log.info("Validation ---------------------sdistrict------------------------------Finished");   
        }
        
        //Validation ----------------sstate----------------
        
        public void sstate() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
           	Logger log = Logger.getLogger(ValidateMethods.class);
               PropertyConfigurator.configure("log4j.properties");
               log.info("Validation ---------------------sstate------------------------------");
               int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
               
               for(int i=6 ; i<=rc ; i++)
               {
               try
               {
               String sstate = f.readDataWords(excel_path, "stg_borrower_mortgage", i, 9);
               //System.out.println(stownname);
              // log.info("State is valid J" + i + "=" + sstate);
               }
               catch(IllegalStateException e)
      	        {
             	   long sstate1 = f.readDataLONG(excel_path, "stg_borrower_mortgage", i, 9);
             	  // log.info("State is valid J" + i + "=" + sstate1);
      	        	//log.info("Cell does not contains value H"+ i + "=" + "___________________________________");
      	        }
               catch(NullPointerException e)
      	        {
      	        	log.error("Cell  does not contains value J"+ i + "=" + "___________________________________");
      	        }
               }
           	log.info("Validation ---------------------sstate------------------------------Finished");   
        }
        
        //Validation -----------------ipin-----------------
        
        public void ipin() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
             Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------ipin------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
             
             for(int i=6 ; i<=rc ; i++)
             {
            try
            {
            
            String ipin = f.readDataWords(excel_path,"stg_borrower_mortgage" , i, 10);
            
             boolean valid = f.pincode(ipin);
             if(valid)
             {
            	 //log.info("Pincode is valid K" + i + "=" + ipin );
             }
             else
             {
            	 log.error("Pincode is not valid K" + i + "=" + ipin + "***********************" );
             }
            }
            catch(IllegalStateException e)
  	        {
            	long ipin2 = f.readDataLONG(excel_path,"stg_borrower_mortgage" , i, 10);
            	String numberAsString = String.valueOf(ipin2);
            	 boolean valid1 = f.pincode(numberAsString);
                 if(valid1)
                 {
                	 //log.info("Pincode is valid K" + i + "=" + ipin2 );
                 }
                 else
                 {
                	 log.error("Pincode is not valid K" + i + "=" + ipin2 + "*******************************" );
                 }
            	 
  	        }
            catch(NullPointerException h)
  	        {
  	        	log.error("Cell  does not contains value K" + i + "=" + "___________________________________");
  	        }
            	 
             }
             log.info("Validation ---------------------ipin-----------------------------Finished"); 
        }
        
        //Validation -------------sruralurban-------------------
        
        public void sruralurban() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
             Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------sruralurban------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
             
             for(int i=6 ; i<=rc ; i++)
             {
             try
             {
            	 String sruralurban = f.readDataWords(excel_path,"stg_borrower_mortgage" , i, 11);
            	 if(sruralurban.equals("URBAN") || sruralurban.equals("Urban") || sruralurban.equals("RURAL") || sruralurban.equals("Rural"))
            	 {
            		 //log.info("Urban / Rural (as per Census) is valid L" + i + "=" + sruralurban);
            	 }
            	 else
            	 {
            		 log.error("Urban / Rural (as per Census) is not valid L" + i + "=" + sruralurban);
            	 }
             }
             catch(NullPointerException e)
   	        {
   	        	log.error("Cell  does not contains value L" + i + "=" + "___________________________________");
   	        }
             }
             log.info("Validation ---------------------sruralurban-----------------------------Finished"); 
        }
        
        //Validation -------------npropvalatsanct---------------------
        
        public void npropvalatsanct() throws EncryptedDocumentException, IOException
        {

       	 Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------npropvalatsanct------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	long npropvalatsanct = f.readDataLONG(excel_path,"stg_borrower_mortgage" , i, 12);
            	if(npropvalatsanct>=0)
            	{
            		//log.info("Value of Property at the Time of Sanction (Rs.) is valid M" + i + "=" + npropvalatsanct);
            	}
            	else
            	{
            		log.error("Value of Property at the Time of Sanction (Rs.) not  is valid M" + i + "=" + npropvalatsanct + "********************************");
            	}
            }
            catch(NullPointerException e)
   	        {
   	        	log.error("Cell  does not contains value M" + i + "=" + "___________________________________");
   	        }
            }
            log.info("Validation ---------------------npropvalatsanct-----------------------------Finished"); 
        }
        
        //Validation ---------------------npresentvalue----------------------
        
        public void npresentvalue() throws EncryptedDocumentException, IOException
        {
        	 Flib f = new Flib();
             Logger log = Logger.getLogger(ValidateMethods.class);
             PropertyConfigurator.configure("log4j.properties");
             log.info("Validation ---------------------npresentvalue------------------------------");
             int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
             
             for(int i=6 ; i<=rc ; i++)
             {
             try
             {
             	long npresentvalue = f.readDataLONG(excel_path,"stg_borrower_mortgage" , i, 13);
             	if(npresentvalue>=0)
             	{
             		//log.info("Value of Property at the Time of Sanction (Rs.) is valid N" + i + "=" + npresentvalue);
             	}
             	else
             	{
             		log.error("Value of Property at the Time of Sanction (Rs.) not  is valid N" + i + "=" + npresentvalue + "********************************");
             	}
             }
             catch(NullPointerException e)
    	        {
    	        	log.error("Cell  does not contains value N" + i + "=" + "___________________________________");
    	        }
             }
             log.info("Validation ---------------------npresentvalue-----------------------------Finished"); 
        }
        
        //Validation --------------sinsurance--------------
        
        public void sinsurance() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sinsurance------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgage");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
            	 String npresentvalue = f.readDataWords(excel_path,"stg_borrower_mortgage" , i, 14);
            	 if(npresentvalue.equals("Yes") || npresentvalue.equals("No"))
            	 {
            		// log.info("Asset Insurance is valid O" + i + "=" + npresentvalue );
            	 }
            	 else
            	 {
            		 log.error("Asset Insurance is not valid O" + i + "=" + npresentvalue );
            	 }
            }
            catch(NullPointerException e)
	        {
	        	log.error("Cell  does not contains value N" + i + "=" + "___________________________________");
	        }
            }
            log.info("Validation ---------------------sinsurance-----------------------------Finished"); 
        }
        
        //Validation --------------------stg_borrower_mortgageother sheet---------
        
        //Validation -----------ddate5-----------------
        
        public void ddate5() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation --------------------stg_borrower_mortgageother sheet---------");
            log.info("Validation ---------------------ddate5------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
            
            for(int i=6 ; i<=rc ; i++)
            {
            String date = f.dateString(excel_path, "stg_borrower_mortgageother", i, 0);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try 
            {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                log.info("Date is in the desired format. A" + i + "=" + date);
              
            }
            catch (DateTimeParseException e)
            {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               
            }
            }
            log.info("Validation ---------------------ddate5-----------------------Finished");
        }
        
        //Validation ------------scin5-------------------
        
        public void scin5() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------scin5------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
        	
        	   for(int i=6; i<=rc ;i++)
    	        {
    	       try
    	       {
    	        	String scin = f.readDataNString(excel_path, "stg_borrower_mortgageother", i, 1);
    	        	//log.info("cell contains value B"+ i + "=" + scin);
    	        	
    	        	
    	       }
    	       catch(NullPointerException e)
    	        {
    	        	log.error("cell does not contains value B"+ i + "=_______________");
    	        	//System.out.println("does not has value");
    	        }
    	        }
        	   log.info("Validation ---------------------scin5--------------------------Finished");
        }
        
        //Validation ---------------sbloanno5-----
        
        public void sbloanno5() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------sbloanno5------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
            
        	  for(int i=6; i<=rc ;i++)
    	        {
    	        try
    	        {
    	        	 String sbloanno = f.readDataNString(excel_path, "stg_borrower_mortgageother", i, 2);
    	        	 
    	        	 // log.info("cell contains value C"+ i + "=" + sbloanno);
    	        }
    	        catch(NullPointerException e)
    	        {
    	        	log.error("cell does not contains value C"+ i + "=" + "__________________________");
    	        	
    	        }
    	        }
        	  log.info("Validation ---------------------sbloanno5----------------------------Finished");
        }
        
        //Validation -----------------scolltype----------------
        
        public void scolltype() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------scolltype------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
            
            for(int i=6; i<=rc ;i++)
	        {
            try
            {
            	String scolltype = f.readDataWords(excel_path, "stg_borrower_mortgageother", i, 3);
            	if(scolltype.equals("TOOC-01") || scolltype.equals("TOOC-02") || scolltype.equals("TOOC-03") || scolltype.equals("TOOC-04"))
            	{
            		//log.info("Type of Other Collateral is valid D" + i + "=" + scolltype);
            	}
            	else
            	{
            		log.error("Type of Other Collateral is not valid D" + i + "=" + scolltype);
            	}
            }
            catch(NullPointerException e)
	        {
	        	log.error("cell does not contains value D"+ i + "=" + "__________________________");
	        	
	        }
	        }
            log.info("Validation ---------------------scolltype----------------------------Finished");
        }
        
        //Validation -------------------nvalueatsanct-------------
        
        public void nvalueatsanct() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------nvalueatsanct------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
            
            for(int i=6; i<=rc ;i++)
	        {
            try
            {
            	long nvalueatsanct = f.readDataLONG(excel_path, "stg_borrower_mortgageother", i, 4);
            	
            	if(nvalueatsanct>0)
            	{
            		//log.info("Value at the Time of Sanction (Rs.) is valid E" + i + "=" + nvalueatsanct);
            	}
            	else
            	{
            		log.error("Value at the Time of Sanction (Rs.) is not valid E" + i + "=" + nvalueatsanct);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value D"+ i + "=" + "__________________________");
	        	
	        }
	        }
            log.info("Validation ---------------------nvalueatsanct----------------------------Finished");
        }
        
        //Validation ---------------npresentvalue---------------
        
        public void npresentvalue2() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------npresentvalue2------------------------------");
            int rc = f.rowcount(excel_path, "stg_borrower_mortgageother");
            
            for(int i=6; i<=rc ;i++)
	        {
            try
            {
            	long npresentvalue2 = f.readDataLONG(excel_path, "stg_borrower_mortgageother", i, 5);
            	
            	if(npresentvalue2>=0)
            	{
            		//log.info("Value at the Time of Sanction (Rs.) is valid E" + i + "=" + npresentvalue2);
            	}
            	else
            	{
            		log.error("Value at the Time of Sanction (Rs.) is not valid E" + i + "=" + npresentvalue2);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value D"+ i + "=" + "__________________________");
	        	
	        }
	        }
            log.info("Validation ---------------------npresentvalue2----------------------------Finished");
        }
        
        //Validation for FinanceIndividualAllFields excel
        
        //Validation --------------FinanceIndividual sheet-----------------
        
        //Validation---------------FinanceIndividualddate------------------
        
        public void FinanceIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceIndividualddate------------------------------");
            int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual");
            
            for(int i=6; i<=rc ;i++)
	        {
            String date = f.dateString(FinanceIndividualAllFields, "FinanceIndividual", i, 0);
            System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } 
            catch (DateTimeParseException e) 
            {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               
            }
	        }
            log.info("Validation ---------------------FinanceIndividualddate----------------------------Finiashed");
            }
        
        //Validation ----------------FinanceIndividualsbloanno-----------------
        
        public void FinanceIndividualsbloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceIndividualsbloanno------------------------------");
            int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual");
            System.out.println(rc);
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sbloanno=f.readDataWords(FinanceIndividualAllFields, "FinanceIndividual", i, 1);
            	//log.info("sbloanno is present B" + i + "=" + sbloanno);
            }
            catch(IllegalStateException e)
  	        {
         	   long sbloanno1 = f.readDataLONG(FinanceIndividualAllFields, "FinanceIndividual", i, 1);
         	   log.info("sbloanno is present B" + i + "=" + sbloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "__________________________");
	        	
	        }
            }
            log.info("Validation ---------------------FinanceIndividualsbloanno---------------------------Finished");
        }
        
       
       
        //Validation ------------------FinanceIndividualnrw-----------------
        
        public void FinanceIndividualnrw() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceIndividualnrw------------------------------");
            int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String nrw=f.readDataWords(FinanceIndividualAllFields, "FinanceIndividual", i, 2);
            	if(nrw.equals("RWA-01") || nrw.equals("RWA-02") || nrw.equals("RWA-03") || nrw.equals("RWA-04") || nrw.equals("RWA-05"))
            	{
            		//log.info("Loan Details -> Risk Weight [%] is valid C" + i + "=" + nrw);
            	}
            	else
            	{
            		log.info("Loan Details -> Risk Weight [%] is not valid C" + i + "=" + nrw);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value C"+ i + "=" + "_____________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------FinanceIndividualnrw----------------------------Finished");
        }
        
        //Validation ---------------------FinanceIndividualnprovamt--------------------
        
        public void FinanceIndividualnprovamt() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceIndividualnprovamt------------------------------");
            int rc = f.rowcount(FinanceIndividualAllFields, "FinanceIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long nprovamt=f.readDataLONG(FinanceIndividualAllFields, "FinanceIndividual", i, 3);
            	if(nprovamt>=0)
            	{
            		//log.info("Loan Details -> Provisions(Rs.) is valid D" + i + "=" + nprovamt);
            	}
            	else
            	{
            		log.error("Loan Details -> Provisions(Rs.) is not valid D" + i + "=" + nprovamt);
            	}
            }
            catch(IllegalStateException s)
            {
            	double nprovamt1=f.readdouble(FinanceIndividualAllFields, "FinanceIndividual", i, 3);
            	if(nprovamt1>=0)
            	{
            		//log.info("Loan Details -> Provisions(Rs.) is valid D" + i + "=" + nprovamt1);
            	}
            	else
            	{
            		log.error("Loan Details -> Provisions(Rs.) is not valid D" + i + "=" + nprovamt1);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value D"+ i + "=" + "_____________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------FinanceIndividualnprovamt---------------------------Finished");
        }
        
        
        //Validation for ---LegalIndividual excel-----
        //Validation ----------LegalIndividualddate------------
        
        public void LegalIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------LegalIndividualddate------------------------------");
            int rc = f.rowcount(LegalIndividualAllFieldsJun, "LegalIndividual");
            System.out.println(rc);
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(LegalIndividualAllFieldsJun, "LegalIndividual", i, 0);
            System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            }
            log.info("Validation ---------------------LegalIndividualddate------------------------------Finished");
            }
        
        
        //Validation -----------------LegalIndividualsbloanno-------------
        
        public void LegalIndividualsbloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------LegalIndividualsbloanno------------------------------");
           
            int rc = f.rowcount(LegalIndividualAllFieldsJun, "LegalIndividual");
 
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sbloanno=f.readDataWords(LegalIndividualAllFieldsJun, "LegalIndividual", i, 1);
            	log.info("sbloanno is present B" + i + "=" + sbloanno);
            }
            catch(IllegalStateException e)
  	        {
         	   long sbloanno1 = f.readDataLONG(FinanceIndividualAllFields, "FinanceIndividual", i, 1);
         	   log.info("sbloanno is present B" + i + "=" + sbloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "__________________________");
	        	
	        }
            }
            log.info("Validation ---------------------LegalIndividualsbloanno---------------------------Finished");
        }
        
        //Validation ------------LegalIndividualsserfaseiact---------------------
        
        
        public void LegalIndividualsserfaseiact() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------LegalIndividualsserfaseiact------------------------------");
            int rc = f.rowcount(LegalIndividualAllFieldsJun, "LegalIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String serfaseiact=f.readDataWords(LegalIndividualAllFieldsJun, "LegalIndividual", i, 2);
            	if(serfaseiact.equals("Yes") || serfaseiact.equals("No"))
            	{
            		log.info("sserfaseiact is valid C" + i + "=" + serfaseiact);
            	}
            	else
            	{
            		log.info("sserfaseiact is not valid C" + i + "=" + serfaseiact);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value C"+ i + "=" + "___________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------LegalIndividualsserfaseiact--------------------------Finished");
              
        }
        
        //validation for OpsIndividual30062023AllFields excel
        
        //Validation -----------------OpsIndividualddate-----------
        
        public void OpsIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualddate------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            System.out.println(rc);
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(OpsIndividual30062023AllFields, "OpsIndividual", i, 0);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. A" + i + "=" + date);
               
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
             
            }
            }
            log.info("Validation ---------------------OpsIndividualddate------------------------------Finished");
        }
        
        //validation -------------OpsIndividualsbloanno-----------
        
        public void OpsIndividualsbloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsbloanno------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sbloanno = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 1);
            	//log.info("sbloanno is present B" + i + "=" + sbloanno);
            }
            catch(IllegalStateException e)
  	        {
         	   f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 1);
         	   //log.info("sbloanno is present B" + i + "=" + sbloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "__________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsbloanno---------------------------Finished");
        }
        
        //Validation -------------------OpsIndividualspartyname----------------
        
        public void OpsIndividualspartyname() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualspartyname------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String spartyname = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 2);
            	if(spartyname.equals("CP-01") || spartyname.equals("CP-02") || spartyname.equals("CP-03") || spartyname.equals("CP-04") || spartyname.equals("CP-05") || spartyname.equals("CP-06"))
            	{
            		//log.info("sbloanno is valid C" + i + "=" + spartyname);
            	}
            	else
            	{
            		log.error("sbloanno is not valid C" + i + "=" + spartyname);
            	}	
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value C"+ i + "=" + "_____________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualspartyname---------------------------Finished");
        }
        
        //validation for --------------OpsIndividualsmortguratee-----------
        
        public void OpsIndividualsmortguratee() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsmortguratee------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String smortguratee = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 3);
            	if(smortguratee.equals("MG-01") || smortguratee.equals("MG-02") || smortguratee.equals("MG-03") || smortguratee.equals("MG-04") || smortguratee.equals("MG-05"))
            	{
            		//log.info("Loan Details -> Mortgage Guarantee is valid D" + i + "=" + smortguratee);
            	}
            	else
            	{
            		log.error("Loan Details -> Mortgage Guarantee is not valid D" + i + "=" + smortguratee);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value D"+ i + "=" + "_____________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsmortguratee-----------------------Finished");
        }
        
        //Validation --------------------OpsIndividualsnamoutunderguar----------
        
        public void OpsIndividualsnamoutunderguar() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsnamoutunderguar------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long namoutunderguar = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 4);
            	if(namoutunderguar>=0)
            	{
            		//log.info("namoutunderguar is valid E" + i + "=" + namoutunderguar);
            	}
            	else
            	{
            		log.info("namoutunderguar is not valid E" + i + "=" + namoutunderguar);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value E"+ i + "=" + "_______________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsnamoutunderguar---------------------------Finished");
        }
        
        //Validation -------------------OpsIndividualnpout---------
        
        public void OpsIndividualnpout() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualnpout------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long npout = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 5);
            	if(npout>=0)
            	{
            		//log.info("Principal Outstanding is valid F" + i + "=" + npout);
            	}
            	else
            	{
            		log.error("Principal Outstanding is valid F" + i + "=" + npout);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value F"+ i + "=" + "_________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualnpout--------------------------Finished");
        }
        
        //Validation ---------OpsIndividualsassetcat---------------
        
        public void OpsIndividualsassetcat() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsassetcat------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sassetcat = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 6);
            	if(sassetcat.equals("ACC-00") || sassetcat.equals("ACC-01") || sassetcat.equals("ACC-02") || sassetcat.equals("ACC-03") || sassetcat.equals("ACC-04") || sassetcat.equals("ACC-05") || sassetcat.equals("ACC-06") || sassetcat.equals("ACC-07") || sassetcat.equals("ACC-08") )
            	{
            		log.info("sassetcat is valid G" + i + "=" + sassetcat);
            	}
            	else
            	{
            		log.error("sassetcat is not valid G" + i + "=" + sassetcat + "*************************");
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value G"+ i + "=" + "_________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsassetcat---------------------------Finished");
        }
        
        //Validation ---------------OpsIndividualdclassdate-------------
        
        public void OpsIndividualdclassdate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualdclassdate------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(OpsIndividual30062023AllFields, "OpsIndividual", i, 7);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            
            }
            log.info("Validation ---------------------OpsIndividualdclassdate---------------------------FInished");
        }
        
        //Validation -------------------OpsIndividualsreffromnhb-----------------
        
        public void OpsIndividualsreffromnhb() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsreffromnhb------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String sreffromnhb = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 8);
            	 if(sreffromnhb.equals("Yes") || sreffromnhb.equals("yes") || sreffromnhb.equals("No") || sreffromnhb.equals("no"))
            	 {
            		 log.info("sreffromnhb is valid I" + i + "=" + sreffromnhb);
            	 }
            	 else
            	 {
            		 log.error("sreffromnhb is not valid I" + i + "=" + sreffromnhb + "**********************");
            	 }
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value I"+ i + "=" + "____________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsreffromnhb-----------------------------Finished");
        }
        
        //Validation ----------------OpsIndividualsunderpmayclss----------------
        
        public void OpsIndividualsunderpmayclss() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsunderpmayclss------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String sunderpmayclss = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 9);
            	 if(sunderpmayclss.equals("Yes") || sunderpmayclss.equals("yes") || sunderpmayclss.equals("No") || sunderpmayclss.equals("no"))
            	 {
            		 //log.info("sreffromnhb is valid J" + i + "=" + sunderpmayclss);
            	 }
            	 else
            	 {
            		 log.error("sreffromnhb is not valid J" + i + "=" + sunderpmayclss + "**********************");
            	 }
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value J"+ i + "=" + "____________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsunderpmayclss----------------------------Finished");
        }
        
        //Validation ------------------OpsIndividualstownname--------------------
        
        public void OpsIndividualstownname() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualstownname------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String stownname = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 10);
            	 log.info("stownname is valid K" + i + "=" + stownname);
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value K"+ i + "=" + "____________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualstownname---------------------------Finished");
        }
        
        //Validation --------------OpsIndividualsdistrict-----------------
        
        public void OpsIndividualsdistrict() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsdistrict------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String sdistrict = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 11);
            	 log.info("sdistrict is valid L" + i + "=" + sdistrict);
            }
            catch(IllegalStateException e)
  	        {
            	long sdistrict = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 11);
         	    log.info("sdistrict is present L" + i + "=" + sdistrict);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value L"+ i + "=" + "____________________________________________");
	        	
	        }
            }
            log.info("Validation ---------------------OpsIndividualsdistrict--------------------------FInished");
            
        }
        
        //Validation ---------------OpsIndividualsruralurban--------------
        
        public void OpsIndividualsruralurban() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualsruralurban------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sruralurban = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 12);
            	
            	if(sruralurban.equals("RURAL") || sruralurban.equals("Rural") || sruralurban.equals("URBAN") || sruralurban.equals("Urban"))
            	{
            		 log.info("sruralurban is valid M" + i + "=" + sruralurban);
            	}
            	else
            	{
            		log.error("sruralurban is not valid M" + i + "=" + sruralurban + "*********************");
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value M"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualsruralurban---------------------------Finished");
        }
        
        
        //Validation ------------------OpsIndividualnpresentvalue-----------
        
        public void OpsIndividualnpresentvalue() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualnpresentvalue------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	
            	long npresentvalue = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 13);
            	if(npresentvalue>0)
            	{
            		 //log.info("sruralurban is valid N" + i + "=" + npresentvalue);
            	}
            	else
            	{
            		log.error("sruralurban is valid N" + i + "=" + npresentvalue);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value N"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualnpresentvalue----------------------------FInished");
        }
        
        //Validation ----------------OpsIndividualscin----------------
        
        public void OpsIndividualscin() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualscin------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long scin = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 14);
            	// log.info("sruralurban is valid O" + i + "=" + scin);
            }
            catch(IllegalStateException e)
  	        {
            	String scin2 = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 14);
         	    //log.info("sdistrict is present O" + i + "=" + scin2);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value O"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualscin----------------------------Finished");
        }
        
        
        //Validation ----------------OpsIndividualscolltype----------------
        
        public void OpsIndividualscolltype() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualscolltype------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String scolltype = f.readDataWords(OpsIndividual30062023AllFields, "OpsIndividual", i, 15);
            	if(scolltype.equals("TOOC-01") || scolltype.equals("TOOC-02") || scolltype.equals("TOOC-03") || scolltype.equals("TOOC-04"))
            	{
            		// log.info("scolltype is valid P" + i + "=" + scolltype);
            	}
            	else
            	{
            		log.error("scolltype is not valid P" + i + "=" + scolltype);
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value P"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualscolltype--------------------------Finished");
        }
        
        
        //Validation ---------------------OpsIndividualnvalueatsanct----------------
        
        public void OpsIndividualnvalueatsanct() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualnvalueatsanct------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long nvalueatsanct = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 16);
            	if(nvalueatsanct>=0)
            	{
            		log.info("nvalueatsanct is valid Q" + i + "=" + nvalueatsanct);
            	}
            	else
            	{
            		log.error("nvalueatsanct is not valid Q" + i + "=" + nvalueatsanct + "****************88");
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value Q"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualnvalueatsanct---------------------------Finsihed");
        }
        
        //Validation --------------------OpsIndividualnpresentvalue1--------------
        
        public void OpsIndividualnpresentvalue1() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsIndividualnpresentvalue1------------------------------");
            int rc = f.rowcount(OpsIndividual30062023AllFields, "OpsIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long nvalueatsanct = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 17);
            	if(nvalueatsanct>=0)
            	{
            		log.info("nvalueatsanct is valid R" + i + "=" + nvalueatsanct);
            	}
            	else
            	{
            		log.error("nvalueatsanct is not valid R" + i + "=" + nvalueatsanct + "*******************");
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value R"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsIndividualnpresentvalue1---------------------------Finsihed");
        }
        
        
        //Validation -----FinanceNonIndividualAllFieldsJune2023 excel---------
        
        //Validation ---FinanceNonIndividual sheet----------
        
        //validation -------------FinanceNonIndividualddate----------
        
        public void FinanceNonIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceNonIndividualddate------------------------------");
            int rc = f.rowcount(FinanceNonIndividualAllFields, "FinanceNonIndividual");
            System.out.println(rc);
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(FinanceNonIndividualAllFields, "FinanceNonIndividual", i, 0);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value A"+ i + "=" + "____________________________________________");
	        }
            
            }
            log.info("Validation ---------------------FinanceNonIndividualddate--------------------------Finished");
        }
        
        //Validation -----------------FinanceNonIndividualscorporateloanno--------------
        
        public void FinanceNonIndividualscorporateloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceNonIndividualscorporateloanno	------------------------------");
            int rc = f.rowcount(FinanceNonIndividualAllFields, "FinanceNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String scorporateloanno = f.readDataWords(FinanceNonIndividualAllFields, "FinanceNonIndividual", i, 1);
            	 // log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno);
            }
            catch(IllegalStateException e)
  	        {
            	long scorporateloanno1 = f.readDataLONG(OpsIndividual30062023AllFields, "OpsIndividual", i, 1);
            	// log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------FinanceNonIndividualscorporateloanno	---------------------------Finished");
            
        }
        
        //Validation --------------FinanceNonIndividualscorprw-------------
        
        public void FinanceNonIndividualscorprw() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceNonIndividualscorprw	------------------------------");
            int rc = f.rowcount(FinanceNonIndividualAllFields, "FinanceNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String scorprw = f.readDataWords(FinanceNonIndividualAllFields, "FinanceNonIndividual", i, 2);
            	 if(scorprw.equals("RWA-05") || scorprw.equals("RWA-04") || scorprw.equals("RWA-03") || scorprw.equals("RWA-02") || scorprw.equals("RWA-01") )
            	 {
            		 // log.info("Loan Details -> Risk Weight (%) is valid C" + i + "=" + scorprw);
            	 }
            	 else
            	 {
            		  log.error("Loan Details -> Risk Weight (%) is not valid C" + i + "=" + scorprw);
            	 }
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value C"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------FinanceNonIndividualscorprw---------------------------Finished");
        }
        
        //Validation -----------FinanceNonIndividualncorpprovamt------------
        
        public void FinanceNonIndividualncorpprovamt() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------FinanceNonIndividualncorpprovamt------------------------------");
            int rc = f.rowcount(FinanceNonIndividualAllFields, "FinanceNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	long scorprw = f.readDataLONG(FinanceNonIndividualAllFields, "FinanceNonIndividual", i, 3);
            	if(scorprw>0)
            	{
            		// log.info("Loan Details -> Provisions  (Rs.) is valid D" + i + "=" + scorprw);
            	}
            	else
            	{
            		log.error("Loan Details -> Provisions  (Rs.) is not valid D" + i + "=" + scorprw + "*****************************");
            	}
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value D"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------FinanceNonIndividualncorpprovamt	---------------------------Finsished");
        }
        
        //Validation for LegalNonIndividualJun2023 excel file
        
        //Validation for Legal Non Individual sheet
        
        //Validation --------------LegalNonIndividualddate----------------
        
        public void LegalNonIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------LegalNonIndividualddate------------------------------");
            try
            {
            int rc = f.rowcount(LegalNonIndividual, "LegalNonIndividual");
            System.out.println(rc);
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(LegalNonIndividual, "LegalNonIndividual", i, 0);
            //System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
               // log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException a) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value A"+ i + "=" + "____________________________________________");
	        }
            
            }

            }
            catch(IOException e)
            {
            	int rc = f.rowcount(LegalNonIndividual, "LegalNonIndividual");
            	System.out.println(rc);
                for(int i=6; i<=rc ;i++)
                {
                String date = f.dateString(LegalNonIndividual, "LegalNonIndividual", i, 0);
                //System.out.println(date);

                // Desired date format
                String desiredDateFormat = "yyyy-MM-dd";

                // Create DateTimeFormatter with desired date format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

                try {
                    // Parse the date from the Excel cell using DateTimeFormatter
                    LocalDate.parse(date, formatter);
                   // log.info("Date is in the desired format. A" + i + "=" + date);
                    //System.out.println("Date is in the desired format.");
                } catch (DateTimeParseException a) {
                	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
                   // System.out.println("Date is not in the desired format.");
                }
                catch(NullPointerException p)
                {
    	        	log.error("cell does not contains value A"+ i + "=" + "____________________________________________");
    	        }
                
                }

            }
                        log.info("Validation ---------------------LegalNonIndividualddate--------------------------Finished");
        }
        
        
        //validation for OpsNonIndividual30062023AllFields excel
        
        //Validation for ---Sheet1---
        
        //Validation --------------Sheet1ddate----------------
        
        public void Sheet1ddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1ddate------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(OpsNonIndividual30062023AllFields, "Sheet1", i, 0);
           // System.out.println(date);

            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            } catch (DateTimeParseException e) {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1ddate----------------------------Finsihed");
        }
        
        //Validation ----------------Sheet1scorporateloanno--------------------
        
        public void Sheet1scorporateloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorporateloanno------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String scorporateloanno = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 1);
            	 // log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno);
            }
            catch(IllegalStateException e)
  	        {
            	long scorporateloanno1 = f.readDataLONG(OpsNonIndividual30062023AllFields, "Sheet1", i, 1);
            	// log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorporateloanno	---------------------------Finished");
            
        }
        
        //Validation -----------------Sheet1sloantenincmoraperiod-------------
        
        public void Sheet1sloantenincmoraperiod() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1sloantenincmoraperiod------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
          	  String sloantenincmoraperiod = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 2); 
          	  
          	  if(sloantenincmoraperiod.equals("Yes") || sloantenincmoraperiod.equals("No") )
          	  {
          		  //log.info("sloantenincmoraperiod Status C" + i + "=" + sloantenincmoraperiod);
          	  }
          	  else
          	  {
          		  log.error("sloantenincmoraperiod Status not matched C" + i + "=" + sloantenincmoraperiod + "*************");
          	  }
            }
            catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data C" + i + "____________________");
       	 }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1sloantenincmoraperiod------------------Finished");
        }
        
        //Validation -------------Sheet1scorpcounterparty----------------
        
        public void Sheet1scorpcounterparty() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorpcounterparty------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String scorpcounterparty = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 3);
            	if(scorpcounterparty.equals("CP-01") || scorpcounterparty.equals("CP-02") || scorpcounterparty.equals("CP-03") || scorpcounterparty.equals("CP-04") || scorpcounterparty.equals("CP-05") || scorpcounterparty.equals("CP-06") )
            	{
            		 //log.info("scorpcounterparty Status is valid D" + i + "=" + scorpcounterparty);
            	}
            	else
            	{
            		log.error("scorpcounterparty Status is not valid D" + i + "=" + scorpcounterparty + "********************************");
            	}
            }
            catch(NullPointerException e)
          	 {
          		 log.error("Cell does not contain any data D" + i + "___________________________");
          	 }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorpcounterparty------------------Finished");
        }
   
        //Validation ------------Sheet1scorpmortgua------------------------
        
        public void Sheet1scorpmortgua() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorpmortgua------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String scorpmortgua = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 4);
            	
            	if(scorpmortgua.equals("MG-01") || scorpmortgua.equals("MG-02")  || scorpmortgua.equals("MG-03") || scorpmortgua.equals("MG-04") || scorpmortgua.equals("MG-05"))
            	{
            		 //log.info("scorpmortgua Status is valid E" + i + "=" + scorpmortgua);
            	}
            	else
            	{
            		log.error("scorpmortgua Status is not valid E" + i + "=" + scorpmortgua + "*************************");
            	}
            }
            catch(NullPointerException e)
         	 {
         		 log.error("Cell does not contain any data E" + i + "___________________________");
         	 }
           }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1scorpmortgua------------------------Finished");
        }
        
        //Validation ---------------------Sheet1namtunderguar---------------------
        
        public void Sheet1namtunderguar() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1namtunderguar------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	long namtunderguar = f.readDataLONG(OpsNonIndividual30062023AllFields, "Sheet1", i, 4);
            	if(namtunderguar>0)
            	{
            		 //log.info("namtunderguar is valid F" + i + "=" + namtunderguar);
            	}
            	else
            	{
            		log.error("namtunderguar is not valid F" + i + "=" + namtunderguar + "*************************");
            	}
            }
            catch(NullPointerException e)
        	 {
        		 log.error("Cell does not contain any data F" + i + "___________________________");
        	 }
            }
            
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=Sheet1namtunderguar------------------------------");
        }
        
        
        //Validation ---------------------Sheet1ncorppo---------------
        
        public void Sheet1ncorppo() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=ncorppo------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	long ncorppo = f.readDataLONG(OpsNonIndividual30062023AllFields, "Sheet1", i, 6);
            	if(ncorppo>=0)
            	{
            		 //log.info("ncorppo is valid G" + i + "=" + ncorppo);
            	}
            	else
            	{
            		log.error("namtunderguar is not valid G" + i + "=" + ncorppo + "*************************");
            	}
            }
            catch(NullPointerException e)
        	 {
        		 log.error("Cell does not contain any data G" + i + "___________________________");
        	 }
            }
            
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=ncorppo------------------------------");
        }
        
        //Validation ------------------Sheet1scorpassetclass--------------------
        
        public void Sheet1scorpassetclass() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=scorpassetclass------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String scorpassetclass = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 7);
            	if(scorpassetclass.equals("CAC-00") || scorpassetclass.equals("CAC-01") || scorpassetclass.equals("CAC-02") || scorpassetclass.equals("CAC-03") || scorpassetclass.equals("CAC-04") || scorpassetclass.equals("CAC-05") || scorpassetclass.equals("CAC-06") || scorpassetclass.equals("CAC-07") || scorpassetclass.equals("CAC-08"))
            	{
            		 //log.info("Principal Outstanding is valid H" + i + "=" + scorpassetclass);
            	}
            	else
            	{
            		log.error("Principal Outstanding is not valid H" + i + "=" + scorpassetclass + "*******************");
            	}
            }
            catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data G" + i + "___________________________");
       	 }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=scorpassetclass------------------------Finished");  
        }
        
        //Validation -------------------Sheet1ddateofclass-----------------
        
        public void Sheet1ddateofclass() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=ddateofclass------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(OpsNonIndividual30062023AllFields, "Sheet1", i, 8);
      
            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                //log.info("Date is in the desired format. I" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            }
            catch (DateTimeParseException e) 
            {
            	log.error("Date is not in the desired format I" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=ddateofclass----------------------------Finsihed");
        }
        
        //Validation -------------------Sheet1scorpdefhfc-------------------------
        
        public void Sheet1scorpdefhfc() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=scorpdefhfc------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
          	  String scorpdefhfc = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1", i, 9); 
          	  
          	  if(scorpdefhfc.equals("Yes") || scorpdefhfc.equals("No") )
          	  {
          		  //log.info("sloantenincmoraperiod Status J" + i + "=" + scorpdefhfc);
          	  }
          	  else
          	  {
          		  log.error("sloantenincmoraperiod Status not matched J" + i + "=" + scorpdefhfc + "*************");
          	  }
            }
            catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data J" + i + "____________________");
       	 }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=scorpdefhfc------------------Finished");
        }
        
        
        //Validation -----------------------Sheet1rprojruralurban-------------------
        
        public void Sheet1rprojruralurban() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=rprojruralurban------------------------------");
            int rc = f.rowcount(OpsNonIndividual30062023AllFields, "Sheet1");
            
            for(int i=6 ; i<=rc ; i++)
            {
            try
            {
           	 String sruralurban = f.readDataWords(OpsNonIndividual30062023AllFields, "Sheet1" , i, 10);
           	 if(sruralurban.equals("URBAN") || sruralurban.equals("Urban") || sruralurban.equals("RURAL") || sruralurban.equals("Rural"))
           	 {
           		 //log.info("Urban / Rural (as per Census) is valid K" + i + "=" + sruralurban);
           	 }
           	 else
           	 {
           		 log.info("Urban / Rural (as per Census) is not valid K" + i + "=" + sruralurban + "**************************");
           	 }
            }
            catch(NullPointerException e)
  	        {
  	        	log.info("Cell  does not contains value K" + i + "=" + "___________________________________");
  	        }
            }
            log.info("Validation ---------------------OpsNonIndividual30062023AllFields=rprojruralurban----------------------------Finished");
        }
        
        //Validation ------------------------CFNonIndividualAllFieldsJune23  excel
        
        //Validation for CFNonIndividual sheet
        
        //Validation ------------CFNonIndividualddate-------------
        
        public void CFNonIndividualddate() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualddate------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            String date = f.dateString(CFNonIndividualAllFields, "CFNonIndividual", i, 0);
      
            // Desired date format
            String desiredDateFormat = "yyyy-MM-dd";

            // Create DateTimeFormatter with desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredDateFormat);

            try {
                // Parse the date from the Excel cell using DateTimeFormatter
                LocalDate.parse(date, formatter);
                log.info("Date is in the desired format. A" + i + "=" + date);
                //System.out.println("Date is in the desired format.");
            }
            catch (DateTimeParseException e) 
            {
            	log.error("Date is not in the desired format A" + i + "=" + date + "*********************************");
               // System.out.println("Date is not in the desired format.");
            }
            
            }
            log.info("Validation ---------------------CFNonIndividualddate----------------------------Finsihed");
            
        }
        
        //Validation ----------CFNonIndividualscorporateloanno
        
        public void CFNonIndividualscorporateloanno() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualscorporateloanno------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	 String scorporateloanno = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 1);
            	 // log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno);
            }
            catch(IllegalStateException e)
  	        {
            	long scorporateloanno1 = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 1);
            	// log.info("Loan Account Number is valid B" + i + "=" + scorporateloanno1);
  	        }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value B"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------CFNonIndividualscorporateloanno---------------------------Finished");
        }
        
        //Validation ---------------CFNonIndividualsgroupname-------------
        
        public void CFNonIndividualsgroupname() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsgroupname------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6; i<=rc ;i++)
            {
            try
            {
            	String sgroupname = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 2);
            	// log.info("sgroupname is valid C" + i + "=" + sgroupname);
            }
            catch(NullPointerException e)
            {
	        	log.error("cell does not contains value C"+ i + "=" + "____________________________________________");
	        }
            }
            log.info("Validation ---------------------CFNonIndividualsgroupname---------------------------FInished");
        }
        
        //Validation ------------------CFNonIndividualsgroupcomphfc------------------------
        
        public void CFNonIndividualsgroupcomphfc() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsgroupcomphfc------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
          	  String scorpdefhfc = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 3); 
          	  
          	  if(scorpdefhfc.equals("Yes") || scorpdefhfc.equals("No") )
          	  {
          		  //log.info("scorpdefhfc Status matched D" + i + "=" + scorpdefhfc);
          	  }
          	  else
          	  {
          		  log.error("scorpdefhfc Status not matched D" + i + "=" + scorpdefhfc + "*************************");
          	  }
            }
            catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data D" + i + "_______________________________");
       	 }
            }
            log.info("Validation ---------------------CFNonIndividualsgroupcomphfc------------------Finished");
        }
        
        //Validation --------------------CFNonIndividualntotalexptobg------------------
        
        public void CFNonIndividualntotalexptobg() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualntotalexptobg------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	long ntotalexptobg = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 4); 
            	if(ntotalexptobg>0)
            	{
            		 //log.info("ntotalexptobg is valid E" + i + "=" + ntotalexptobg);
            	}
            	else
            	{
            		log.error("ntotalexptobg is not valid E" + i + "=" + ntotalexptobg);
            	}
            }
            catch(NullPointerException e)
          	 {
          		 log.error("Cell does not contain any data E" + i + "_______________________________");
          	 }
            }
            log.error("Validation ---------------------CFNonIndividualntotalexptobg------------------------------");
        }
        
        //Validation ---------------------CFNonIndividualstypeofexposure------------------------
        
        public void CFNonIndividualstypeofexposure() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualstypeofexposure------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String stypeofexposure = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 5); 
            	 //log.info("Borrower Details -> Type of Exposure is present F" + i + "=" + stypeofexposure);
            }
            catch(NullPointerException e)
         	 {
         		 log.error("Cell does not contain any data F" + i + "_______________________________");
         	 }
            }
            log.info("Validation ---------------------CFNonIndividualstypeofexposure-----------------------------Finished");
        }
        
        //Validation ----------CFNonIndividualscorploansubcat--------------
        
        public void CFNonIndividualscorploansubcat() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualscorploansubcat------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	String scorploansubcat = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 6); 
            	if(scorploansubcat.equals("SCOL-01") || scorploansubcat.equals("SCOL-02") || scorploansubcat.equals("SCOL-03"))
            	{
            		 //log.info("scorploansubcat is present G" + i + "=" + scorploansubcat);
            	}
            	else
            	{
            		log.error("scorploansubcat is not present G" + i + "=" + scorploansubcat);
            	}
            }
            catch(NullPointerException e)
        	 {
        		 log.error("Cell does not contain any data G" + i + "_______________________________");
        	 }
            }
            log.info("Validation ---------------------CFNonIndividualscorploansubcat--------------------------Finsihed");
        }
        
        //Validation ------------------CFNonIndividualndsrasancamt----------------
        
        public void CFNonIndividualndsrasancamt() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualscorploansubcat------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	long ndsrasancamt = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 7);
            	if(ndsrasancamt>0)
            	{
            		//log.info("ndsrasancamt is Valid H" + i + "=" + ndsrasancamt);
            	}
            	else
            	{
            		log.error("ndsrasancamt is not Valid H" + i + "=" + ndsrasancamt + "******************");
            	}
            }
          catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data H" + i + "_____________________________________");
       	 }
            }
            log.info("Validation ---------------------CFNonIndividualscorploansubcat-----------------------------Finsihed");
        }
        
        //Validation ----------------CFNonIndividualndsraamtateop-------------------
        
        public void CFNonIndividualndsraamtateop() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualndsraamtateop------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	long ndsraamtateop = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 8);
            	if(ndsraamtateop>0)
            	{
            		//log.info("ndsraamtateop is Valid I" + i + "=" + ndsraamtateop);
            	}
            	else
            	{
            		log.error("ndsraamtateop is not Valid I" + i + "=" + ndsraamtateop + "******************");
            	}
            }
          catch(NullPointerException e)
       	 {
       		 log.error("Cell does not contain any data I" + i + "_____________________________________");
       	 }
            }
            log.info("Validation ---------------------CFNonIndividualndsraamtateop-----------------------------Finsihed");
        }
        
        
        //Validation ----------------------CFNonIndividualsprojectid-----------------
        
        public void CFNonIndividualsprojectid() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojectid------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	String sprojectid = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 9);
            	//log.info("sprojectid is Valid J" + a + "=" + sprojectid);
            }
            catch(NullPointerException e)
          	 {
            	int a=i + 1;
          		 log.error("Cell does not contain any data J" + a + "_____________________________________");
          	 }
            }
            log.info("Validation ---------------------CFNonIndividualsprojectid-----------------------------Finsihed");
        }
        
        //Validation ----------------------CFNonIndividualnborrowerequity-----------------
        
        public void CFNonIndividualnborrowerequity() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualnborrowerequity------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	long nborrowerequity = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 10);
            	if(nborrowerequity>0)
            	{
            	  // log.info("sprojectid is Valid K" + a + "=" + nborrowerequity);
            	}
            	else
            	{
            		log.error("sprojectid is not Valid K" + a + "=" + nborrowerequity + "****************************");
            	}
            }
            catch(NullPointerException e)
         	 {
           	int a=i + 1;
         		 log.error("Cell does not contain any data K" + a + "_____________________________________");
         	 }
            }
            log.info("Validation ---------------------CFNonIndividualnborrowerequity----------------------------Finished");
        }
        
        //Validation --------------------CFNonIndividualncollfromallotee-----------------
        
        public void CFNonIndividualncollfromallotee() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualncollfromallotee------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	long ncollfromallotee = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 11);
            	if(ncollfromallotee>0)
            	{
            	   //log.info("ncollfromallotee is Valid L" + a + "=" + ncollfromallotee);
            	}
            	else
            	{
            		log.error("ncollfromallotee is not Valid L" + a + "=" + ncollfromallotee + "****************************");
            	}
            }
            catch(NullPointerException e)
         	 {
           	int a=i + 1;
         		 log.error("Cell does not contain any data L" + a + "_____________________________________");
         	 }
            }
            log.info("Validation ---------------------CFNonIndividualncollfromallotee----------------------------Finished");
        }
        
        //Validation ------------------CFNonIndividualnloantakenfromother------------------
        
        public void CFNonIndividualnloantakenfromother() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualnloantakenfromother------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	long nloantakenfromother = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 12);
            	if(nloantakenfromother>0)
            	{
            	  // log.info("nloantakenfromother is Valid M" + a + "=" + nloantakenfromother);
            	}
            	else
            	{
            		log.error("nloantakenfromother is not Valid M" + a + "=" + nloantakenfromother + "****************************");
            	}
            }
            catch(NullPointerException e)
         	 {
           	     int a=i + 1;
         		 log.error("Cell does not contain any data M" + a + "_____________________________________");
         	 }
            }
            log.info("Validation ---------------------CFNonIndividualnloantakenfromother----------------------------Finished");
        }
        
        //Validation ------------------CFNonIndividualnothersources------------------
        
        public void CFNonIndividualnothersources() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualnothersources------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	long nothersources = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 13);
            	if(nothersources>0)
            	{
            	  // log.info("nothersources is Valid N" + a + "=" + nothersources);
            	}
            	else
            	{
            		log.error("nothersources is not Valid N" + a + "=" + nothersources + "****************************");
            	}
            }
            catch(NullPointerException e)
         	 {
           	     int a=i + 1;
         		 log.error("Cell does not contain any data N" + a + "_____________________________________");
         	 }
            }
            log.info("Validation ---------------------CFNonIndividualnothersources----------------------------Finished");
        }
        
        //Validation ------------------CFNonIndividualsprojotherlenders------------------
        
        public void CFNonIndividualsprojotherlenders() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojotherlenders------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	String sprojotherlenders = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 14);
            	if(sprojotherlenders.equals("OL-01") || sprojotherlenders.equals("OL-02") || sprojotherlenders.equals("OL-03") || sprojotherlenders.equals("OL-04") || sprojotherlenders.equals("OL-05"))
            	{
            		// log.info("sprojotherlenders is Valid O" + a + "=" + sprojotherlenders);
            	}
            	else
            	{
            		log.error("sprojotherlenders is not Valid O" + a + "=" + sprojotherlenders + "***************************");
            	}
            }
            catch(NullPointerException e)
        	 {
          	     int a=i + 1;
        		 log.error("Cell does not contain any data O" + a + "_____________________________________");
        	 }
            }
            log.info("Validation ---------------------CFNonIndividualsprojotherlenders---------------------------Finished");
        }
        
        //Validation ---------------------CFNonIndividualsprojaffordable--------------
        
        public void CFNonIndividualsprojaffordable() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojaffordable------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	String sprojaffordable = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 15);
            	if(sprojaffordable.equals("Yes") || sprojaffordable.equals("No"))
            	{
            		// log.info("sprojaffordable is Valid P" + a + "=" + sprojaffordable);
            	}
            	else
            	{
            		log.error("sprojaffordable is not Valid P" + a + "=" + sprojaffordable + "***************************");
            	}
            }
            catch(NullPointerException e)
       	 {
         	     int a=i + 1;
       		 log.error("Cell does not contain any data P" + a + "_____________________________________");
       	 }
            }
            log.info("Validation ---------------------CFNonIndividualsprojaffordable----------------------------FInished");
        }
       
        //validation ----------------------------CFNonIndividualinoofunitudnerafforhou------------
        
        public void CFNonIndividualinoofunitudnerafforhou() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojaffordable------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	long inoofunitudnerafforhou = f.readDataLONG(CFNonIndividualAllFields, "CFNonIndividual", i, 16);
            	if(inoofunitudnerafforhou>=0)
            	{
            		// log.info("inoofunitudnerafforhou is Valid Q" + a + "=" + inoofunitudnerafforhou);
            	}
            	else
            	{
            		 log.error("inoofunitudnerafforhou is not Valid Q" + a + "=" + inoofunitudnerafforhou);
            	}
            }
            catch(NullPointerException e)
          	 {
            	 int a=i + 1;
          		 log.error("Cell does not contain any data Q" + a + "_____________________________________");
          	 }
            }
            log.info("Validation ---------------------CFNonIndividualsprojaffordable-------------------------Finished");
        }
        
        //Validation  --------------------CFNonIndividualsprojrerareg------------
        
        public void CFNonIndividualsprojrerareg() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojrerareg------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
            for(int i=6 ;i<=rc ; i++)
            {
            try
            {
            	int a=i + 1;
            	String sprojrerareg = f.readDataWords(CFNonIndividualAllFields, "CFNonIndividual", i, 17);
            	if(sprojrerareg.equals("Yes") || sprojrerareg.equals("No"))
            	{
            		//log.info("sprojrerareg is valid R" + a + "=" + sprojrerareg);
            	}
            	else
            	{
            		log.error("sprojrerareg is not valid R" + a + "=" + sprojrerareg);
            	}
            }
            catch(NullPointerException e)
         	 {
           	 int a=i + 1;
         		 log.error("Cell does not contain any data R" + a + "_____________________________________");
         	 }
            }
            
            log.info("Validation ---------------------CFNonIndividualsprojrerareg---------------------------Finished");
        }
        
      //Validation  --------------------CFNonIndividualsprojrerano------------
        
        public void CFNonIndividualsprojrerano() throws EncryptedDocumentException, IOException
        {
        	Flib f = new Flib();
            Logger log = Logger.getLogger(ValidateMethods.class);
            PropertyConfigurator.configure("log4j.properties");
            log.info("Validation ---------------------CFNonIndividualsprojrerareg------------------------------");
            int rc = f.rowcount(CFNonIndividualAllFields, "CFNonIndividual");
            
           
        }
            
}
        
        
        
        

        
        
        
        
        
        
        

       

