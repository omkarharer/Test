package excelvalidation;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

public class Validate2 implements IAuto {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ValidateMethods v = new ValidateMethods();

		//----------------stg_borrower_detail-----------------------
		
//		v.ddate();
//		v.sbloanno();
//		v.scin();
//		v.sbname();
//		v.dbdob();
//		v.sbcitizenship();
//		v.sbpanno();
//		v.saadhaar();
//		v.sidtype();
//		v.sidnumber();
//		v.nbmonthlyincome();
//		v.sbreligion();
//		v.sbcast();
//		v.sbgender();
//		v.sboccupation();

		
		//----------------stg_coborrowerdetails-----------------------
//		v.ddate2();
//		v.sbloanno2();
//		v.scin2();
//		v.scbcin();
//		v.scbname();
//		v.dcbdob();
//		v.scbcitizenship();
//
//		v.scbpanno();
//		v.scbaadhaar();
//		v.sidtype2();
//		v.sidnumber2();
//		v.ncbmonthlyincome();
//		v.scbreligion();
//		v.scbcast();
//		v.scbgender();
//		v.scboccupation();

		
		//------------stg_borrower_loan sheet--------------
		//v.ddate3();
//		v.sbloanno3();
//		v.sloantype();
//		v.sloanpurpose();
//		v.nsanctamount();
//		v.dsanctdate();
//		v.sdwellingunit();
//		v.imoratoriumperiod();
//		v.iloantencont();
//		v.iloantenresidual();
//		v.nroi();
//		v.sinttype();
//		v.nemi();
//		v.npreemi();
//		v.dfirstdisbdate();
//		v.demistartdate();
	//	v.dpreemistartdate();
//		v.nloandisbduringmonth();
//		v.ncummuloandisb();
//		v.sloanstatus();
//		v.namtundercons();
//		v.spartyname();
//		v.smortguratee();
//		v.namoutunderguar();
//		v.ntotalloanout();
//		v.npout();
//		v.niout();
//		v.notherdueout();
//		v.nloandsbp();
//		v.nloanrepaydurmth();
//		v.ntotalloanoverdue();
//		v.npoverdue();
//		v.nioverdue();
//		v.notheroverdue();
//		v.saccntcloseddurmth();
//		v.sassetcat();
//		v.secl();
//		v.dclassdate();

		v.npd();
		v.nlgd();
		v.nrw();
		v.sreffromnhb();
		v.sunderpmayclss();
		v.sserfaseiact();
		v.namtclaimundernotice();
		v.namtrecovered();
		v.sstaygranted();

		
		//Validation for ---------------stg_borrower_mortgage----------- sheet
		
		v.ddate4();
		v.scin4();
		v.sbloanno4();
		v.sporptype();
		v.spropadd();
		v.nlandarea();
		v.nbuildingarea();
		v.sdistrict();
		v.stownname();
		v.sdistrict();
		v.sstate();
		v.ipin();
		v.sruralurban();
		v.npropvalatsanct();
		v.npresentvalue();
		v.sinsurance();

		
		//Validation ------------stg_borrower_mortgageother sheet-----------
		v.ddate5();
		v.scin5();
		v.sbloanno5();
		v.scolltype();
		v.nvalueatsanct();
		v.npresentvalue2();
	
		
		
		
		
		
		

	}

}
