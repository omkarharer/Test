package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import test.EdgeBL;



public class EdgeRm {
	
	
	
	
	@FindBy(xpath="//*[@id='Input_CommonUsername']") private WebElement username; //username
	@FindBy(xpath="//*[@id='b29-Button']/button") private WebElement login_button ; //login button
	@FindBy(xpath="//input[@id='RadioButton2-input']") private WebElement pwdrbutton; //password radiobutton
	@FindBy(xpath="//input[@id='Input_CommonPassword']") private WebElement pwd_textbox; //password textbox
	@FindBy(xpath="//*[@id='b38-Button']/button") private WebElement login;//login
	@FindBy(xpath="//*[@id='b14-ContinueLogin']") private WebElement continue_login; // click on continue login button
	@FindBy(xpath="//*[@id='b3-Content']") private WebElement sme_loans; // SME-Loans  
	
	//check wheather we are in BL or SL
	@FindBy(xpath=" //div[@id='b3-b1-Menu']") private WebElement buisness_loan; // Buisness Loans-LOS text
	@FindBy(xpath="//div[@class='submenu-icon']") private WebElement LOS; // LOS dropdown
	@FindBy(xpath="//select[@id='b3-Dropdown1']") private WebElement select_program; // select programs (BL/HL)
	@FindBy(xpath="//button[@id='b3-YesButton']") private WebElement yes_button; // click yes button
	
	@FindBy(xpath="//*[@id='b14-Button']") private WebElement Plus_button; // click on "+" button
	@FindBy(xpath="//*[@id='b15-Label']") private WebElement new_case; // New Case  button
	@FindBy(xpath="//div[@id='b5-b59-b1-Column1']") private WebElement PAN; // PAN textbox 
	@FindBy(xpath="//*[@id='b5-b59-OuterContainer']") private WebElement enter_pan_manually; //click Enter Pan Manualy
	@FindBy(xpath="//*[@id='b5-b59-Pan_Number']") private WebElement pan_number; // enter pan number
	@FindBy(xpath="//*[@id='b5-b59-b6-Button']/button") private WebElement verify_pan; // click verify_pan button
	@FindBy(xpath="//*[@id=\"b5-GSTNEditable\"]") private WebElement GSTN; // GSTN textbox
	@FindBy(xpath="//*[@id='b5-BusinessType']") private WebElement buisness_name_type;//enter buisness name type
	@FindBy(xpath="//*[@id='choices--b5-b18-DropdownSelect-item-choice-3']") private WebElement buisness_name_type1;
	@FindBy(xpath="//*[@id='b5-Input_DateOfCorporation']") private WebElement date_of_pan;// date of incorporation pan
	@FindBy(xpath="//*[@id='b5-Input_DateOfCorporationManual']") private WebElement date_of_gst; //date of incorporation gst
	@FindBy(xpath="//input[@id='b5-Input_DateOfCorporationUdyam']") private WebElement date_of_udyam;//date of UDYAM
	@FindBy(xpath="//*[@id='b5-$b8']/div/div[1]/div/div") private WebElement date_of_incorporation;//date of incorporation
	@FindBy(xpath="//*[@id='b5-Input_Pincode']") private WebElement pincode;//pincode text box
	
	@FindBy(xpath="//*[@id='b5-Input_NameOfBusiness']") private WebElement name_of_business;// enter name of business
	
	@FindBy(xpath="//*[@id='b5-TextArea_BusinessAddress']") private WebElement business_address; //enter buisness address
	@FindBy(xpath="//input[@id='b5-Switch3']") private WebElement same_as_business_address; // togal button Same as Business Address as per GST 
	@FindBy(xpath="//*[@id='b5-Input_CINNumber']") private WebElement cin_number; // CIN/LLIPN textbox
	@FindBy(xpath="//*[@id='b5-Input_Pincode2']") private WebElement current_business_pincode; // current business pincode textbox 
	@FindBy(xpath="//*[@id='b5-TextArea_AlternateBusinessAddress']") private WebElement current_business_address; // current buisness address textbox
	@FindBy(xpath="//*[@id='b5-CompanyEmail2']") private WebElement regd_email; // enter regd_email
	@FindBy(xpath="//*[@id='b5-b11-b1-Column1']/button") private WebElement owned_button; // click on Owned button
	@FindBy(xpath="//*[@id='b5-BusinessStructure2']/div/div[1]/div/div") private WebElement business_structure;// enter Hindu Undivided Family in business_structure 
	@FindBy(xpath="//*[@id=\"b5-Input_Applicationdate\"]") private WebElement application_date; // enter application number
	@FindBy(xpath="//*[@id='b5-b17-b1-Column1']/button") private WebElement owned_button2; // click Owned button
	@FindBy(xpath="//*[@id='b5-HSNCode2']") private WebElement hsn_code; // enter HSN Code
	@FindBy(xpath="//*[@id='b5-indusType']/div/div[1]/div/div") private WebElement industry_type; // enter Accounting/Finance  in Industry textbox
	@FindBy(xpath=" //*[@id='b5-$b41']/div/div[1]/div/div") private WebElement segment_type; // enter Service in Segment Type textbox
	@FindBy(xpath="//*[@id='b5-$b51']/div/div[1]/div/div") private WebElement negative_profile; // enter Not a Negative Profile in Negative Profile
	@FindBy(xpath="//*[@id='b5-MobileNo2']") private WebElement phone_no; //enter phone number
	@FindBy(xpath="//*[@id='b5-Input_CompanyContactName']") private WebElement company_no; // enter company contact number
	@FindBy(xpath="//*[@id='b5-MobileNo']") private WebElement mobile_no;// enter mobile number
	@FindBy(xpath="//*[@id='b5-SourceDropdown']/div/div") private WebElement source; // enter DSA in source
	@FindBy(xpath="//*[@id='b5-SourceDropdown']/div[2]/div/div[3]") private WebElement source_direct; //source direct
	@FindBy(xpath="//*[@id='b5-$b44']/div/div[1]/div/div") private WebElement product;// enter ECL- SME UBL IDFC product backlog
	@FindBy(xpath="//*[@id='b5-$b53']/div/div[1]/div/div") private WebElement scheme; // enter IDFC_BL_CLM_30 in scheme textbox 
	@FindBy(xpath="//*[@id='b5-LoanAmounInput']") private WebElement loan_amount;// enter loan amount
	@FindBy(xpath="//*[@id='b5-BranchDropdown']/div/div[1]/div/div") private WebElement branch; //enter branch name
	@FindBy(xpath="//*[@id='b5-AddInput_Email']") private WebElement email_id;// enter email id
	@FindBy(xpath="//*[@id='b5-Navigate']/button") private WebElement add_coapplicant; // click the button ADD CO-APPLICANT
	
    public EdgeRm(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    
    
    

	public WebElement getSource_direct() {
		return source_direct;
	}





	public WebElement getName_of_business() {
		return name_of_business;
	}



	public WebElement getUsername() {
		return username;
	}

	public WebElement getLogin_button() {
		return login_button;
	}

	public WebElement getPwdrbutton() {
		return pwdrbutton;
	}

	public WebElement getPwd_textbox() {
		return pwd_textbox;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getSme_loans() {
		return sme_loans;
	}

	public WebElement getBuisness_loan() {
		return buisness_loan;
	}

	public WebElement getLOS() {
		return LOS;
	}

	public WebElement getSelect_program() {
		return select_program;
	}

	public WebElement getYes_button() {
		return yes_button;
	}

	public WebElement getPlus_button() {
		return Plus_button;
	}

	public WebElement getNew_case() {
		return new_case;
	}

	public WebElement getPAN() {
		return PAN;
	}

	public WebElement getEnter_pan_manually() {
		return enter_pan_manually;
	}

	public WebElement getPan_number() {
		return pan_number;
	}

	public WebElement getVerify_pan() {
		return verify_pan;
	}

	public WebElement getGSTN() {
		return GSTN;
	}

	public WebElement getBuisness_name_type() {
		return buisness_name_type;
	}

	public WebElement getDate_of_pan() {
		return date_of_pan;
	}

	public WebElement getDate_of_gst() {
		return date_of_gst;
	}

	public WebElement getDate_of_udyam() {
		return date_of_udyam;
	}

	public WebElement getDate_of_incorporation() {
		return date_of_incorporation;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getBusiness_address() {
		return business_address;
	}

	public WebElement getSame_as_business_address() {
		return same_as_business_address;
	}

	public WebElement getCin_number() {
		return cin_number;
	}

	public WebElement getCurrent_business_pincode() {
		return current_business_pincode;
	}

	public WebElement getCurrent_business_address() {
		return current_business_address;
	}

	public WebElement getRegd_email() {
		return regd_email;
	}

	public WebElement getOwned_button() {
		return owned_button;
	}

	public WebElement getBusiness_structure() {
		return business_structure;
	}

	public WebElement getApplication_date() {
		return application_date;
	}

	public WebElement getOwned_button2() {
		return owned_button2;
	}

	public WebElement getHsn_code() {
		return hsn_code;
	}

	public WebElement getIndustry_type() {
		return industry_type;
	}

	public WebElement getSegment_type() {
		return segment_type;
	}

	public WebElement getNegative_profile() {
		return negative_profile;
	}

	public WebElement getPhone_no() {
		return phone_no;
	}

	public WebElement getCompany_no() {
		return company_no;
	}

	public WebElement getMobile_no() {
		return mobile_no;
	}

	public WebElement getSource() {
		return source;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getScheme() {
		return scheme;
	}

	public WebElement getLoan_amount() {
		return loan_amount;
	}

	public WebElement getBranch() {
		return branch;
	}

	public WebElement getEmail_id() {
		return email_id;
	}

	public WebElement getAdd_coapplicant() {
		return add_coapplicant;
	}
	
	public WebElement getContinue_login() {
		return continue_login;
	}
	
	
    
	
    //operational methods
	
	

	
	public WebElement getBuisness_name_type1() {
		return buisness_name_type1;
	}

	public void login(String enter_usrname,String enter_pwd) throws InterruptedException
	{
		Thread.sleep(2000);
		username.sendKeys(enter_usrname);
		
		Thread.sleep(3000);
		login_button.click();
		
		pwdrbutton.click();
		
		pwd_textbox.sendKeys(enter_pwd);
		login.click();
		Thread.sleep(3000);
		continue_login.click();
		sme_loans.click();
		Thread.sleep(3000);
		//String type="Business Loans - LOS";
		String bi = buisness_loan.getText();
		
		//String v = bi.getText();
		System.out.println(bi);
		Thread.sleep(3000);
		
		if(bi.equals("Business Loans - LOS"))
		{
			System.out.println("done1");
			//buisness_loan.click();
		}
		else
		{
			System.out.println("done");
			
			LOS.click();
			
			WebElement selectp = select_program;
			Thread.sleep(3000);
			
			Select s = new Select(selectp);
			s.selectByVisibleText("Business Loans - LOS");
			yes_button.click();
		}
		
		Plus_button.click();
		new_case.click();
		Thread.sleep(5000);
		//PAN.click();
	}
		
		public void newCase(String pan_no) throws InterruptedException
		{
			
			enter_pan_manually.click();
			pan_number.sendKeys(pan_no);
			Thread.sleep(4000);
			verify_pan.click();
			//Thread.sleep(4000);
			
		}
		
		public void entity() throws InterruptedException
		{
			GSTN.sendKeys("GST EXEMPT");
			Thread.sleep(2000);
			date_of_pan.sendKeys("01011990");
			Thread.sleep(2000);
			date_of_udyam.sendKeys("01011990");
			Thread.sleep(2000);
			name_of_business.sendKeys("Trading group");
			Thread.sleep(2000);
			pincode.sendKeys("401201");
			Thread.sleep(2000);
			business_address.sendKeys("casaswsqw4rfdcdc");
			Thread.sleep(2000);
			owned_button.click();
			Thread.sleep(2000);
			application_date.sendKeys("29032023");
			Thread.sleep(2000);
			//same_as_business_address.click();
			Thread.sleep(2000);
			cin_number.sendKeys("4423423");
			Thread.sleep(2000);
			regd_email.sendKeys("omkar19@gmail.com");
			Thread.sleep(2000);
			hsn_code.sendKeys("34243");
			Thread.sleep(2000);
			phone_no.sendKeys("9082436442");
			Thread.sleep(2000);
			company_no.sendKeys("nhwqd77");
			Thread.sleep(2000);
			mobile_no.sendKeys("7364535623");
			Thread.sleep(2000);
			loan_amount.sendKeys("2000000");
			Thread.sleep(2000);
			email_id.sendKeys("abc@gmail.com");
			Thread.sleep(2000);
			source.click();
			source_direct.click();
			//add_coapplicant.click();	
			
		}
		
		public void remaningEntity()
		{
			name_of_business.sendKeys("trade group");
		}
		
	
	}

