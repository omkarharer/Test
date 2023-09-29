package notepadtoexcel;

public interface IAuto {
	
	String writeexcel = "./data/CIBIL_COMMERCIAL_ER.xlsx"; //  Excel file path.
	String inputFilePath = "./data/CIBIL_COMMERCIAL_ER.tap"; //  input file path.
	String excelFilePath = "./data/Cibil2.xlsx"; //  Excel file path.
	String delimiter = "\\|"; // Pipe character as the delimiter.
	 String[] BSheader = {
     	    "Segment Identifier",
     	    "Member Branch Code",
     	    "Previous Member Branch Code",
     	    "Borrower’s Name",
     	    "Borrower Short Name",
     	    "Company Registration Number",
     	    "Date of Incorporation",
     	    "PAN",
     	    "CIN",
     	    "TIN",
     	    "Service Tax #",
     	    "Udyam Registration Number",
     	    "Borrower’s Legal Constitution",	
     	    "Business Category",
     	    "Business/ Industry Type",
     	    "Class of Activity 1",
     	    "Class of Activity 2",
     	    "Class of Activity 3",
     	    "SIC Code",
     	    "Sales Figure",
     	    "Financial Year",
     	    "Number of Employees",
     	    "Credit Rating",
     	    "Assessment Agency / Authority",
     	    "Credit Rating As On",
     	    "Credit Rating Expiry Date",
     	    "CKYC",
     	    "Loan ID"
     	};
	 
	 String[] ASheader = {
			    "Segment Identifier",
			    "Borrower Office Location Type",
			    "Borrower Office DUNS Number",
			    "Address Line 1",
			    "Address Line 2",
			    "Address Line 3",
			    "City/Town",
			    "District",
			    "State/Union Territory",
			    "Pin Code",
			    "Country",
			    "Mobile Number(s)",
			    "Telephone Area Code",
			    "Telephone Number(s)",
			    "Fax Area Code",
			    "Fax Number(s)",
			    "Filler",
			    "Loan ID"
			};

	 String[] RSheader = {
			    "Segment Identifier",
			    "Relationship DUNS Number",
			    "Related Type",
			    "Relationship",
			    "Business Entity Name",
			    "Business Category",
			    "Business / Industry Type",
			    "Individual Name Prefix",
			    "Full Name",
			    "Gender",
			    "Company Registration Number",
			    "Date of Incorporation",
			    "Date of Birth",
			    "PAN",
			    "Voter ID",
			    "Passport Number",
			    "Driving Licence ID",
			    "UID",
			    "Ration Card No",
			    "CIN",
			    "DIN",
			    "TIN",
			    "Service Tax #",
			    "CKYC",
			    "Percentage of Control",
			    "Address Line 1",
			    "Address Line 2",
			    "Address Line 3",
			    "City/Town",
			    "District",
			    "State/Union Territory",
			    "PIN Code",
			    "Country",
			    "Mobile Number(s)",
			    "Telephone Number(s)",
			    "Telephone Area Code",
			    "Fax Number(s)",
			    "Fax Area Code",
			    "Udyam Registration Number",
			    "Loan ID"
			};
			
	 String[] CRheader = {
			    "Segment Identifier",
			    "Account Number",
			    "Previous Account Number",
			    "Facility / Loan Activation / Sanction Date",
			    "Sanctioned Amount/ Notional Amount of Contract",
			    "Currency Code",
			    "Credit Type",
			    "Tenure / Weighted Average maturity period of Contracts",
			    "Repayment Frequency",
			    "Drawing Power",
			    "Current Balance / Limit Utilized /Mark to Market",
			    "Notional Amount of Out-standing Restructured Contracts",
			    "Loan Expiry / Maturity Date",
			    "Loan Renewal Date",
			    "Asset Classification/Days Past Due (DPD)",
			    "Asset Classification Date",
			    "Amount Overdue / Limit Overdue",
			    "Overdue Bucket 01 (1 – 30 days)",
			    "Overdue Bucket 02 (31 – 60 days)",
			    "Overdue Bucket 03 (61 – 90 days)",
			    "Overdue Bucket 04 (91 – 180 days)",
			    "Overdue Bucket 05 (Above 180 days)",
			    "High Credit",
			    "Installment Amount",
			    "Last Repaid Amount",
			    "Account Status",
			    "Account Status Date",
			    "Written Off Amount",
			    "Settled Amount",
			    "Major reasons for Restructuring",
			    "Amount of Contracts Classified as NPA",
			    "Asset based Security coverage",
			    "Guarantee Coverage",
			    "Bank Remark Code",
			    "Wilful Default Status",
			    "Date Classified as Wilful Default",
			    "Suit Filed Status",
			    "Suit Reference Number",
			    "Suit Amount in Rupees",
			    "Date of Suit",
			    "Date of Suit",
			    "Transaction Type Code",
			    "OTHER_BK",
			    "UFCE (Amount)",
			    "UFCE Date",
			    "Loan ID"
			};

	// Define the header row as an array of strings.
	 String[] GSheader = {
	     "Segment Identifier",
	     "Guarantor DUNS Number",
	     "Guarantor Type",
	     "Business Category",
	     "Business / Industry Type",
	     "Guarantor Entity Name",
	     "Individual Name Prefix",
	     "Full Name",
	     "Gender",
	     "Company Registration Number",
	     "Date of Incorporation",
	     "Date of Birth",
	     "PAN",
	     "Voter ID",
	     "Passport Number",
	     "Driving Licence ID",
	     "UID",
	     "Ration Card No",
	     "CIN",
	     "DIN",
	     "TIN",
	     "Service Tax #",
	     "CKYC",
	     "Address Line 1",
	     "Address Line 2",
	     "Address Line 3",
	     "City/Town",
	     "District",
	     "State/Union Territory",
	     "Pin Code",
	     "Country",
	     "Mobile Number(s)",
	     "Telephone Area Code",
	     "Telephone Number(s)",
	     "Fax Area Code",
	     "Fax Number(s)",
	     "Guarantee Invocation Date",
	     "Udyam Registration Number",
	     "Loan ID"
	 };
	 
	 String[] SSheader = {
			    "Segment Identifier",
			    "Value of Security",
			    "Currency Type",
			    "Type of Security",
			    "Security Classification",
			    "Date of Valuation",
			    "Filler",
			    "Loan ID"
			};

	 String[] CDheader = {
			    "Segment Identifier",
			    "Date of Dishonour",
			    "Amount",
			    "Instrument / Cheque Number",
			    "Number of times dishonoured",
			    "Cheque Issue Date",
			    "Reason for Dishonour",
			    "Filler",
			    "Loan ID"
			};
	 
	 String[] TSheader = {
			    "Segment Identifier",
			    "Number of Borrower Segments",
			    "Number of Credit Facility Segments",
			    "Filler",
			    "Loan ID"
			};
	 
	 
	 String[] HDheader = {
			    "Segment Identifier",
			    "Member ID",
			    "Previous Member ID",
			    "Date of Creation & Certification of Input File ",
			    "Reporting / Cycle Date",
			    "Information Type",
			    "Filler"
			    
			};

	 



	
}
