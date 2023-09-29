package datadriven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.CloneUATSL;

public class PomUatSL extends CloneUATSL implements IAuto {
	

	@FindBy(xpath="//input[@id='Input_CommonUsername']") private WebElement username; //username
	@FindBy(xpath="//*[@id='b29-Button']/button") private WebElement login_button ; //login button
	@FindBy(xpath="//input[@id='RadioButton2-input']") private WebElement pwdrbutton; //password radiobutton
	@FindBy(xpath="//input[@id='Input_CommonPassword']") private WebElement pwd_textbox; //password textbox
	@FindBy(xpath="//*[@id='b38-Button']/button") private WebElement login;//login
	@FindBy(xpath="//*[@id='b14-ContinueLogin']") private WebElement continue_login; // click on continue login button
	@FindBy(xpath="//*[@id='b3-Content']") private WebElement sme_loans; // SME-Loans  
	
	//check wheather we are in BL or SL
	@FindBy(xpath=" //div[@id='b3-b1-Menu']") private WebElement Secured_loan; // Buisness Loans-LOS text
	@FindBy(xpath="//div[@class='submenu-icon']") private WebElement LOS; // LOS dropdown
	@FindBy(xpath="//select[@id='b3-Dropdown1']") private WebElement select_program; // select programs (BL/HL)
	@FindBy(xpath="//button[@id='b3-YesButton']") private WebElement yes_button; // click yes button
	
	@FindBy(xpath="//*[@id='b14-Button']") private WebElement Plus_button; // click on "+" button
	@FindBy(xpath="//*[@id='b15-Label']") private WebElement new_case; // New Case  button
	@FindBy(xpath="//div[@id='b5-b59-b1-Column1']") private WebElement PAN; // PAN textbox 
	@FindBy(xpath="//*[@id='b5-b59-OuterContainer']") private WebElement enter_pan_manually; //click Enter Pan Manualy
	@FindBy(xpath="//*[@id='b5-b59-Pan_Number']") private WebElement pan_number; // enter pan number
	@FindBy(xpath="//*[@id='b5-b59-b6-Button']/button") private WebElement verify_pan; // click verify_pan button
	@FindBy(xpath="//input[@id='b5-GSTNEditable']") private WebElement GSTN; // GSTN textbox
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
	@FindBy(xpath="//div[@id='b5-b11-b1-Column1']//button[normalize-space()='Owned']") private WebElement owned_button; // click on Owned button
	@FindBy(xpath="//*[@id='b5-BusinessStructure2']/div/div[1]/div/div") private WebElement business_structure;// enter Hindu Undivided Family in business_structure 
	@FindBy(xpath="//input[@id='b5-Input_Applicationdate']") private WebElement application_date; // enter application number
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
	@FindBy(xpath="//select[@id='b5-b38-DropdownSelect']") private WebElement transaction_type;//select any option
	@FindBy(xpath="//span[.='DSA']") private WebElement source_dsa;//select dsa source
	
	//karza Link
	
	@FindBy(xpath="//button[.='Add Karza Verification']") private WebElement add_karza_verification;//click on Add Karza Verification button
	@FindBy(xpath="//input[@id='Input_pan']") private WebElement karza_pan_textbox;//enter pan in karza link
	@FindBy(xpath="//input[@id='Input_name']") private WebElement karza_name;//enter name in karza link
	@FindBy(xpath="//input[@id='Input_dob']") private WebElement karza_dob;//enter dob in karza link
	@FindBy(xpath="//input[@id='Input_consent']") private WebElement karza_consent;//enter Y in content textbox
	@FindBy(xpath="//button[.='Save']") private WebElement karza_save_button;//click on save button
	@FindBy(xpath="//div[@id='b2-b2-Menu']") private WebElement karza_utility;//click on utility
	@FindBy(xpath="//a[@id='b2-MockDataUpload']") private WebElement karza_mockdataupload;// click on mockdataupload verification under utility
	@FindBy(xpath="//a[.='KarzaVerifications']") private WebElement karza_verification;// click on karza verification under utility
	@FindBy(xpath="//select[@id='Dropdown1']") private WebElement karza_selectservice;// select any service from the dropdown
	@FindBy(xpath="//input[@id='Input_Pan']") private WebElement karza_cibilpan;// enter pan in cibil
	@FindBy(xpath="//textarea[@id='TextArea_JsonData']") private WebElement karza_cibildata;// enter jason file
	@FindBy(xpath="//textarea[@id='TextArea_Html']") private WebElement karza_cibilhtml;// enter html data
	@FindBy(xpath="//textarea[@id='TextArea_Xml']") private WebElement karza_cibilxml;// enter xml data
	@FindBy(xpath="//button[.='Save']") private WebElement karza_cibilsave;//click on save button
	
	//Co-Applicant Phase
	@FindBy(xpath="//div[@id='b5-b2-b1-Column1']") private WebElement co_applicant_pan;//click co applicant pan number
	@FindBy(xpath="//span[.='Enter PAN Manually']") private WebElement co_applicant_enterpanmanually;//click on enter pan manually
	@FindBy(xpath="//input[@id='b5-b2-Pan_Number']") private WebElement co_applicant_panmumber;//enter coapplicant pan number
	@FindBy(xpath="//*[@id='b5-b2-b6-Button']/button") private WebElement co_applicant_verifypan_button;//click on verify pan button	
	@FindBy(xpath="//input[@id='b5-b2-RadioButton1-input']") private WebElement co_applicant_persontype;//click on person radio button
	@FindBy(xpath="//button[.='Continue']") private WebElement co_applicant_continue_button;//click on contiue button
	@FindBy(xpath="//*[@id='b5-AddInput_CoApplicantName']") private WebElement co_applicant_first_name;// enter co-applicant first name
	@FindBy(xpath="//input[@id='b5-TierALinkage']") private WebElement co_applicant_isa_primary; //click on is a primary togal
	@FindBy(xpath="//*[@id='b5-Input_DOB']") private WebElement co_applicant_DOB;//enter co applicant DOB
	@FindBy(xpath="//*[@id='b5-AddInput_CoApplicantName2']") private WebElement co_applicant_middle_name;//enter coapplicant middle name
	@FindBy(xpath="//*[@id='b5-AddInput_ShareHolding']") private WebElement co_applicant_share_holding;//enter share holding  No
	@FindBy(xpath="//*[@id='b5-AddInput_CoApplicantName3']") private WebElement co_applicant_last_name;//enter co applicant last name
	@FindBy(xpath="//*[@id='b5-ButtonGroupItem4']") private WebElement co_applicant_male;//click on male button
	@FindBy(xpath="//select[@id='b5-b35-DropdownSelect']") private WebElement co_applicant_relationship;//select relationship with entity
	@FindBy(xpath="//*[@id='b5-AddInput_Email']") private WebElement co_applicant_email;//enter co applicant email
	@FindBy(xpath="//*[@id='b5-AddInput_MobileNo']") private WebElement co_applicant_mobile_no;//enter co applicant mobile number
	@FindBy(xpath="//*[@id='b5-Add_Pincode']") private WebElement co_applicant_pincode;//enter co applicant pincode
	@FindBy(xpath="//*[@id='b5-AddInput_Address']") private WebElement co_applicant_address1;// enter co applicant
	@FindBy(xpath="//*[@id='b5-AddInput_Address2']") private WebElement co_applicant_address2;//enter co applicant address 2
	@FindBy(xpath="//*[@id='b5-AddInput_Address3']") private WebElement co_applicant_address3;//enter co applicant address 3
	@FindBy(xpath="//*[@id='b5-b48-b1-Column1']/button") private WebElement co_applicant_owned_button;//click on owned button
	@FindBy(xpath="//*[@id='b5-Switch1']") private WebElement co_applicant_ispermanent;//click on is permanent same as currnt toggle
	@FindBy(xpath="//button[.='SAVE APPLICANT']") private WebElement co_applicant_save_applicant;//click on save button
	@FindBy(xpath="//button[@class='btn btn-primary btnwidth100per ThemeGrid_Width4']") private WebElement co_applicant_next_button; // click on this button and go to next page
	@FindBy(xpath="//*[@id='b5-Navigate']/div[2]/button") private WebElement co_applicant_next_button2;//click on this to goto bureo stage
	@FindBy(xpath="//span[.='Co-Applicants']") private WebElement co_applicant_page;//click
	@FindBy(xpath="//span[.='Bureau Check']") private WebElement co_applicant_bureau;//click
	@FindBy(xpath="//button[.='Search CKYC']") private WebElement co_applicant_CKYC;//click
	@FindBy(xpath="//span[.='(Co-Applicant)']") private WebElement co_applicant_forCKYC;//click
	@FindBy(xpath="//span[.='About the Co-Applicant']") private WebElement co_applicant_abouttext;//click
	
	//co-applicant else
	@FindBy(xpath="//button[.='Male']") private WebElement co_applicantelse_male;//click on male button
	@FindBy(xpath="//button[.='Female']") private WebElement co_applicantelse_female;//click on female button
	@FindBy(xpath="//button[.='Other']") private WebElement co_applicantelse_other;//click on other button
	@FindBy(xpath="(//input[contains(@id,'CoApplicantName')])[1]") private WebElement co_applicantelse_firstname;//enter first name 
	@FindBy(xpath="//input[contains(@id,'CoApplicantName2')]") private WebElement co_applicantelse_middlename;//enter middle name
	@FindBy(xpath="//input[contains(@id,'CoApplicantName3')]") private WebElement co_applicantelse_lastname;//enter last name
	@FindBy(xpath="//input[contains(@id,'Input_DateofBirth')]") private WebElement co_applicantelse_dob;//enter dob
	@FindBy(xpath="//input[contains(@id,'Input_ShareHolding')]") private WebElement co_applicantelse_shareholding;//enter share holding %
	@FindBy(xpath="//input[contains(@id,'TierALinkage2')]") private WebElement co_applicantelse_primarytoggle;//click on primary co-applicant 
	@FindBy(xpath="//select[contains(@id,'DropdownSelect')]") private WebElement co_applicantelse_relationship;//select any relation with entity
	@FindBy(xpath="//input[contains(@id,'MobileNo')]") private WebElement co_applicantelse_mobilenumber;//enter co-applicant mobile number
	@FindBy(xpath="//input[contains(@id,'Input_Email')]") private WebElement co_applicantelse_email;//enter co=applicant email
	@FindBy(xpath="(//input[contains(@id,'Input_Pincode')])[1]") private WebElement co_applicantelse_pincode;//enter pincode 
	@FindBy(xpath="//input[contains(@id,'Input_Address1')]") private WebElement co_applicantelse_address1;//enter address 1
	@FindBy(xpath="//input[contains(@id,'Input_Address2')]") private WebElement co_applicantelse_address2;//enter address 2
	@FindBy(xpath="//input[contains(@id,'put_Address3')]") private WebElement co_applicantelse_address3;//enter address 3
	@FindBy(xpath="(//div[contains(@id,'b1-Column1')])[1]") private WebElement co_applicantelse_owned;//click on owned button
	@FindBy(xpath="//input[contains(@id,'Switch2')]") private WebElement co_applicantelse_ispermanent;//click on owned button

	//Bureau Phase
	@FindBy(xpath="//span[.='Upload Consent Form']") private WebElement bureau_upload_form;//click on upload consent form
	@FindBy(xpath="//*[@id='b5-b15-b3-TitleWrapper']") private WebElement bureau_browseandupload;//click on this button to upload any file
	@FindBy(xpath="//*[@id='b5-b15-File_Upload']") private WebElement bureau_selectfile;//select any file
	@FindBy(xpath="//*[@id='b5-b15-UploadFile']/div[2]/span") private WebElement bureau_fileupload;//after selecting any file click on this button
	@FindBy(xpath="//*[@id='b5-btn_Check_CIBIL_Score']") private WebElement bureau_checkscore;//click on check bureu score button
	@FindBy(xpath="//*[@id='b5-b15-b2-$b2']/div[3]/button") private WebElement bureau_capture_button;//click on capture button
	@FindBy(xpath="//span[.='Upload']") private WebElement bureau_upload_button;//click on upload button after capture the  img
	@FindBy(xpath="//img[@src='/BusinessLoanNew/img/BusinessLoanNew.RepullCibil.png?IqhEcr5d5RPZseKK8+kAmg']") private WebElement bureau_repull;//click to pull the bureau
	@FindBy(xpath="//*[@id='b5-RepullPopup']/div/div[2]/button") private WebElement bureau_repull_popup;//click in this repull popup
	@FindBy(xpath="//*[@id='b5-btn_Continue']") private WebElement bureau_continue;//click on continue button
	
	//document
	@FindBy(xpath="(//div[contains(@class,'display-inline cursorpointer')])[1]") private WebElement document_poi;//click on POI symbol
	@FindBy(xpath="(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]") private WebElement document_poidocumenttype;//select any document type
	@FindBy(xpath="(//input[@class='form-control allownum OSFillParent'])[1]") private WebElement document_poidocumentno;//enter document name
	@FindBy(xpath="//span[.='Capture']") private WebElement document_poicapture;//click on capture button
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_poisave;//click on save button
	@FindBy(xpath="//span[text()='POA']/ancestor::div[contains(@class,'display-inline')]/preceding-sibling::div[contains(@class,'display-inline')]/i[contains(@class,'fa-upload')]") private WebElement document_poa;//click on POA
	@FindBy(xpath="(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]") private WebElement document_POAdocumenttype;//select any document type
	@FindBy(xpath="(//input[@class='form-control allownum OSFillParent'])[1]") private WebElement document_POAdocumentno;//enter document number
	@FindBy(xpath="(//input[@class='form-control OSFillParent'])[1]") private WebElement document_POAdate;//enter date
	@FindBy(xpath="//span[.='Capture']") private WebElement document_POAcapture;//click capture button
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_POAsave;//click on save button
	@FindBy(xpath="//span[.='Application Form']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_Appform;//click on Application form
	@FindBy(xpath="//span[.='Capture']") private WebElement document_Appformcapture;//click on capture
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_Appformsave;//click on save button
	@FindBy(xpath="//span[.='Partnership Deed']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_partership;//click on parship deed
	@FindBy(xpath="//span[.='Capture']") private WebElement document_patershipcapture;//click on capture button
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_patershipsave;//click on save
	@FindBy(xpath="(//span[.='PAN CARD']/ancestor::div[@class='OSInline']/ancestor::div[@class='columns-item']/ancestor::div[@class='columns columns2 gutter-base tablet-break-none phone-break-none ']/ancestor::div[@class='OSBlockWidget']/ancestor::div[@class='display-inline uploadLable OSInline ThemeGrid_MarginGutter']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')])[1]") private WebElement document_pan;//click on pan card 
	@FindBy(xpath="//span[.='Capture']") private WebElement document_pancapture;//click on capture 
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_pansave;//click on save
	@FindBy(xpath="(//div[@class='section-expandable-icon'])[2]") private WebElement document_coappdropdown;//click on this dropdown to go to co-applicant
	@FindBy(xpath="//span[.='POI']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_coappdroppoi;//click on co app POi
	@FindBy(xpath="(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]") private WebElement document_coapp_POI_doctype;//select any document type
	@FindBy(xpath="(//input[@class='form-control allownum OSFillParent'])[1]") private WebElement document_coapp_poi_docno;//enter any document number
	@FindBy(xpath="//span[.='Capture']") private WebElement document_coapp_poicapture;//click on capture button
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_coapp_poisave;//click on save button
	@FindBy(xpath="//span[.='POA - Current']/ancestor::div[@class='OSInline']/ancestor::div[@class='columns-item']/ancestor::div[@class='columns columns2 gutter-base tablet-break-none phone-break-none ']/ancestor::div[@class='OSBlockWidget']/ancestor::div[@class='display-inline uploadLable OSInline ThemeGrid_MarginGutter']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_coapp_poa;//click on poa current
	@FindBy(xpath="(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]") private WebElement document_coapp_poa_doctype;//select any document type
	@FindBy(xpath="(//input[@class='form-control allownum OSFillParent'])[1]") private WebElement document_coapp_poa_docno;//enter document no
	@FindBy(xpath="//span[.='Capture']") private WebElement document_coapp_poacapture;//click on capture button
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_coapp_poasave;//click on save button
	@FindBy(xpath="//span[.='PHOTO']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_coapp_photo;//click on photo
	@FindBy(xpath="//span[.='Capture']") private WebElement document_coapp_photocapture;//click on capture
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_coapp_photosave;//click on save
	@FindBy(xpath="//span[.='SIGNATURE']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement document_coapp_sign;//click on signature
	@FindBy(xpath="//span[.='Capture']") private WebElement document_coapp_signcapture;//click on capture 
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_coapp_signsave;//click on save button 
	@FindBy(xpath="(//span[.='PAN CARD']/ancestor::div[@class='OSInline']/ancestor::div[@class='columns-item']/ancestor::div[@class='columns columns2 gutter-base tablet-break-none phone-break-none ']/ancestor::div[@class='OSBlockWidget']/ancestor::div[@class='display-inline uploadLable OSInline ThemeGrid_MarginGutter']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')])[2]") private WebElement document_coapp_pan;//click on pan
	@FindBy(xpath="//span[.='Capture']") private WebElement document_coapp_pancapture;//click on capture
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_coapp_pansave;//click on save
	@FindBy(xpath="//button[.='Save OVD']") private WebElement document_coapp_saveovd;//click to save 
	@FindBy(xpath="//span[.='BANKING']") private WebElement document_banking;//click on banking 
	@FindBy(xpath="(//div[@class='display-inline cursorpointer '])[1]") private WebElement document_banking_bankstate;//click on bank statement to upload the file
	@FindBy(xpath="//select[@class='dropdown-search-select choices__input is-hidden']") private WebElement document_banking_bankname;//select any bank name
	@FindBy(xpath="//input[@accept='.pdf']") private WebElement document_banking_selectfile;//select banking statement
	@FindBy(xpath="(//div[.='Save'])[2]") private WebElement document_banking_save;//click on save 
	@FindBy(xpath="(//div[@class='section-expandable-icon'])[4]") private WebElement document_banking_coApp;
	@FindBy(xpath="(//div[@class='display-inline cursorpointer '])[2]") private WebElement document_banking_coAppselectdoc;//select any bank name
	@FindBy(xpath="(//button[@class='button-group-item'])[3]") private WebElement document_banking_coApp_iestatement;//select document type
	@FindBy(xpath="//button[@id='b5-SalesRole']") private WebElement document_banking_AssigntoCO;//click on Assign to CO button
	
	//property
	@FindBy(xpath="//span[.='PROPERTY']") private WebElement property;//goto property page 
	@FindBy(xpath="//span[.='Property Registration Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_registration_doc;//click on registration
	@FindBy(xpath="(//div[@class='choices__list choices__list--single'])[1]") private WebElement propertyno_dropdown;//select property number
	@FindBy(xpath="//span[.='PROPERTY']") private WebElement property_registration_name;//write property name
	@FindBy(xpath="//span[.='Capture']") private WebElement property_capture;//capture
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]") private WebElement property_save;//click on save

	@FindBy(xpath="//span[.='Property Transfer Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_transfer ;//click on property transfer button
	@FindBy(xpath="//span[.='Property Valuation Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_valuation;//click on property valuation 
	@FindBy(xpath="(//div[@class='choices__list choices__list--single'])[2]") private WebElement property_documenttype;//select any doc type
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]") private WebElement property_document_save;//click on save
	@FindBy(xpath="//span[.='Property Owner Ship Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_owned;//click property owner shio document
	@FindBy(xpath="//span[.='Other Property Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_otherdoc;//click on other property document
	@FindBy(xpath="//span[.='Legal Document']/ancestor::div[@class='display-inline uploadLable ']/preceding-sibling::div[contains(@class,'display-inline cursorpointer')]") private WebElement property_legal;//click on property legal document
	
	
	
	
    public PomUatSL(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    
       
	public WebElement getCo_applicantelse_male() {
		return co_applicantelse_male;
	}

	public WebElement getCo_applicantelse_female() {
		return co_applicantelse_female;
	}

	public WebElement getCo_applicantelse_other() {
		return co_applicantelse_other;
	}

	public WebElement getCo_applicantelse_firstname() {
		return co_applicantelse_firstname;
	}

	public WebElement getCo_applicantelse_middlename() {
		return co_applicantelse_middlename;
	}






	public WebElement getCo_applicantelse_lastname() {
		return co_applicantelse_lastname;
	}






	public WebElement getCo_applicantelse_dob() {
		return co_applicantelse_dob;
	}






	public WebElement getCo_applicantelse_shareholding() {
		return co_applicantelse_shareholding;
	}






	public WebElement getCo_applicantelse_primarytoggle() {
		return co_applicantelse_primarytoggle;
	}






	public WebElement getCo_applicantelse_relationship() {
		return co_applicantelse_relationship;
	}






	public WebElement getCo_applicantelse_mobilenumber() {
		return co_applicantelse_mobilenumber;
	}






	public WebElement getCo_applicantelse_email() {
		return co_applicantelse_email;
	}






	public WebElement getCo_applicantelse_pincode() {
		return co_applicantelse_pincode;
	}






	public WebElement getCo_applicantelse_address1() {
		return co_applicantelse_address1;
	}






	public WebElement getCo_applicantelse_address2() {
		return co_applicantelse_address2;
	}






	public WebElement getCo_applicantelse_address3() {
		return co_applicantelse_address3;
	}






	public WebElement getCo_applicantelse_owned() {
		return co_applicantelse_owned;
	}






	public WebElement getCo_applicantelse_ispermanent() {
		return co_applicantelse_ispermanent;
	}






	public WebElement getProperty() {
		return property;
	}





	public WebElement getProperty_registration_doc() {
		return property_registration_doc;
	}





	public WebElement getPropertyno_dropdown() {
		return propertyno_dropdown;
	}





	public WebElement getProperty_registration_name() {
		return property_registration_name;
	}





	public WebElement getProperty_capture() {
		return property_capture;
	}





	public WebElement getProperty_save() {
		return property_save;
	}





	public WebElement getProperty_transfer() {
		return property_transfer;
	}





	public WebElement getProperty_valuation() {
		return property_valuation;
	}





	public WebElement getProperty_documenttype() {
		return property_documenttype;
	}





	public WebElement getProperty_document_save() {
		return property_document_save;
	}





	public WebElement getProperty_owned() {
		return property_owned;
	}





	public WebElement getProperty_otherdoc() {
		return property_otherdoc;
	}





	public WebElement getProperty_legal() {
		return property_legal;
	}





	public WebElement getSource_dsa() {
		return source_dsa;
	}

	public WebElement getTransaction_type() {
		return transaction_type;
	}


	public WebElement getCo_applicant_abouttext() {
		return co_applicant_abouttext;
	}

	public WebElement getCo_applicant_CKYC() {
		return co_applicant_CKYC;
	}

	public WebElement getCo_applicant_forCKYC() {
		return co_applicant_forCKYC;
	}


	public WebElement getCo_applicant_bureau() {
		return co_applicant_bureau;
	}


	public WebElement getDocument_POAdate() {
		return document_POAdate;
	}

	public WebElement getDocument_Appform() {
		return document_Appform;
	}

	public WebElement getDocument_Appformcapture() {
		return document_Appformcapture;
	}

	public WebElement getDocument_Appformsave() {
		return document_Appformsave;
	}

	public WebElement getDocument_partership() {
		return document_partership;
	}


	public WebElement getDocument_patershipcapture() {
		return document_patershipcapture;
	}



	public WebElement getDocument_patershipsave() {
		return document_patershipsave;
	}



	public WebElement getDocument_pan() {
		return document_pan;
	}



	public WebElement getDocument_pancapture() {
		return document_pancapture;
	}



	public WebElement getDocument_pansave() {
		return document_pansave;
	}



	public WebElement getDocument_coappdropdown() {
		return document_coappdropdown;
	}



	public WebElement getDocument_coappdroppoi() {
		return document_coappdroppoi;
	}



	public WebElement getDocument_coapp_POI_doctype() {
		return document_coapp_POI_doctype;
	}



	public WebElement getDocument_coapp_poi_docno() {
		return document_coapp_poi_docno;
	}



	public WebElement getDocument_coapp_poicapture() {
		return document_coapp_poicapture;
	}



	public WebElement getDocument_coapp_poisave() {
		return document_coapp_poisave;
	}



	public WebElement getDocument_coapp_poa() {
		return document_coapp_poa;
	}



	public WebElement getDocument_coapp_poa_doctype() {
		return document_coapp_poa_doctype;
	}



	public WebElement getDocument_coapp_poa_docno() {
		return document_coapp_poa_docno;
	}



	public WebElement getDocument_coapp_poacapture() {
		return document_coapp_poacapture;
	}



	public WebElement getDocument_coapp_poasave() {
		return document_coapp_poasave;
	}



	public WebElement getDocument_coapp_photo() {
		return document_coapp_photo;
	}



	public WebElement getDocument_coapp_photocapture() {
		return document_coapp_photocapture;
	}



	public WebElement getDocument_coapp_photosave() {
		return document_coapp_photosave;
	}



	public WebElement getDocument_coapp_sign() {
		return document_coapp_sign;
	}



	public WebElement getDocument_coapp_signcapture() {
		return document_coapp_signcapture;
	}



	public WebElement getDocument_coapp_signsave() {
		return document_coapp_signsave;
	}



	public WebElement getDocument_coapp_pan() {
		return document_coapp_pan;
	}



	public WebElement getDocument_coapp_pancapture() {
		return document_coapp_pancapture;
	}



	public WebElement getDocument_coapp_pansave() {
		return document_coapp_pansave;
	}



	public WebElement getDocument_coapp_saveovd() {
		return document_coapp_saveovd;
	}



	public WebElement getDocument_banking() {
		return document_banking;
	}



	public WebElement getDocument_banking_bankstate() {
		return document_banking_bankstate;
	}



	public WebElement getDocument_banking_bankname() {
		return document_banking_bankname;
	}



	public WebElement getDocument_banking_selectfile() {
		return document_banking_selectfile;
	}



	public WebElement getDocument_banking_save() {
		return document_banking_save;
	}



	public WebElement getDocument_banking_coApp() {
		return document_banking_coApp;
	}



	public WebElement getDocument_banking_coAppselectdoc() {
		return document_banking_coAppselectdoc;
	}



	public WebElement getDocument_banking_coApp_iestatement() {
		return document_banking_coApp_iestatement;
	}



	public WebElement getDocument_banking_AssigntoCO() {
		return document_banking_AssigntoCO;
	}



	public WebElement getDocument_poa() {
		return document_poa;
	}

	public WebElement getDocument_POAdocumenttype() {
		return document_POAdocumenttype;
	}

	public WebElement getDocument_POAdocumentno() {
		return document_POAdocumentno;
	}


	public WebElement getDocument_POAcapture() {
		return document_POAcapture;
	}

	public WebElement getDocument_POAsave() {
		return document_POAsave;
	}

	public WebElement getDocument_poi() {
		return document_poi;
	}

	public WebElement getDocument_poidocumenttype() {
		return document_poidocumenttype;
	}

	public WebElement getDocument_poidocumentno() {
		return document_poidocumentno;
	}

	public WebElement getDocument_poicapture() {
		return document_poicapture;
	}

	public WebElement getDocument_poisave() {
		return document_poisave;
	}

	public WebElement getCo_applicant_page() {
		return co_applicant_page;
	}


	public WebElement getBureau_repull() {
		return bureau_repull;
	}

	public WebElement getBureau_repull_popup() {
		return bureau_repull_popup;
	}

	public WebElement getBureau_continue() {
		return bureau_continue;
	}

	public WebElement getBureau_capture_button() {
		return bureau_capture_button;
	}


	public WebElement getBureau_upload_button() {
		return bureau_upload_button;
	}


	public WebElement getBureau_upload_form() {
		return bureau_upload_form;
	}

	public WebElement getBureau_browseandupload() {
		return bureau_browseandupload;
	}

	public WebElement getBureau_selectfile() {
		return bureau_selectfile;
	}


	public WebElement getBureau_fileupload() {
		return bureau_fileupload;
	}

	public WebElement getBureau_checkscore() {
		return bureau_checkscore;
	}

	public WebElement getCo_applicant_next_button2() {
		return co_applicant_next_button2;
	}

	public WebElement getCo_applicant_next_button() {
		return co_applicant_next_button;
	}


	public WebElement getCo_applicant_pan() {
		return co_applicant_pan;
	}

	public WebElement getCo_applicant_enterpanmanually() {
		return co_applicant_enterpanmanually;
	}



	public WebElement getCo_applicant_panmumber() {
		return co_applicant_panmumber;
	}



	public WebElement getCo_applicant_verifypan_button() {
		return co_applicant_verifypan_button;
	}



	public WebElement getCo_applicant_persontype() {
		return co_applicant_persontype;
	}



	public WebElement getCo_applicant_continue_button() {
		return co_applicant_continue_button;
	}



	public WebElement getCo_applicant_first_name() {
		return co_applicant_first_name;
	}



	public WebElement getCo_applicant_isa_primary() {
		return co_applicant_isa_primary;
	}



	public WebElement getCo_applicant_DOB() {
		return co_applicant_DOB;
	}



	public WebElement getCo_applicant_middle_name() {
		return co_applicant_middle_name;
	}



	public WebElement getCo_applicant_share_holding() {
		return co_applicant_share_holding;
	}



	public WebElement getCo_applicant_last_name() {
		return co_applicant_last_name;
	}



	public WebElement getCo_applicant_male() {
		return co_applicant_male;
	}



	public WebElement getCo_applicant_relationship() {
		return co_applicant_relationship;
	}



	public WebElement getCo_applicant_email() {
		return co_applicant_email;
	}



	public WebElement getCo_applicant_mobile_no() {
		return co_applicant_mobile_no;
	}



	public WebElement getCo_applicant_pincode() {
		return co_applicant_pincode;
	}



	public WebElement getCo_applicant_address1() {
		return co_applicant_address1;
	}



	public WebElement getCo_applicant_address2() {
		return co_applicant_address2;
	}



	public WebElement getCo_applicant_address3() {
		return co_applicant_address3;
	}



	public WebElement getCo_applicant_owned_button() {
		return co_applicant_owned_button;
	}



	public WebElement getCo_applicant_ispermanent() {
		return co_applicant_ispermanent;
	}



	public WebElement getCo_applicant_save_applicant() {
		return co_applicant_save_applicant;
	}



	public WebElement getAdd_karza_verification() {
		return add_karza_verification;
	}


	public WebElement getKarza_pan_textbox() {
		return karza_pan_textbox;
	}


	public WebElement getKarza_name() {
		return karza_name;
	}


	public WebElement getKarza_dob() {
		return karza_dob;
	}


	public WebElement getKarza_consent() {
		return karza_consent;
	}


	public WebElement getKarza_save_button() {
		return karza_save_button;
	}


	public WebElement getKarza_utility() {
		return karza_utility;
	}


	public WebElement getKarza_mockdataupload() {
		return karza_mockdataupload;
	}


	public WebElement getKarza_verification() {
		return karza_verification;
	}


	public WebElement getKarza_selectservice() {
		return karza_selectservice;
	}


	public WebElement getKarza_cibilpan() {
		return karza_cibilpan;
	}


	public WebElement getKarza_cibildata() {
		return karza_cibildata;
	}


	public WebElement getKarza_cibilhtml() {
		return karza_cibilhtml;
	}


	public WebElement getKarza_cibilxml() {
		return karza_cibilxml;
	}

	public WebElement getKarza_cibilsave() {
		return karza_cibilsave;
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

	public WebElement getSecured_loan() {
		return Secured_loan;
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
	
	
	//just login 
	
	
	public void Justlogin(String enter_usrname,String enter_pwd) throws InterruptedException
	{
		Thread.sleep(3000);
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
		
String bi = Secured_loan.getText();
		
		//String v = bi.getText();
		System.out.println(bi);
		Thread.sleep(3000);
		
		if(bi.equals("Secured Loans - LOS"))
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
			s.selectByVisibleText("Secured Loans - LOS");
			yes_button.click();
		}
		
	}
		

	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		username.sendKeys(RM_Badshah_neo);
		
		Thread.sleep(3000);
		login_button.click();
		
		pwdrbutton.click();
		
		pwd_textbox.sendKeys(Password);
		login.click();
		Thread.sleep(3000);
		//continue_login.click();
		sme_loans.click();
		Thread.sleep(3000);
		//String type="Business Loans - LOS";
		String bi = Secured_loan.getText();
		
		//String v = bi.getText();
		System.out.println(bi);
		Thread.sleep(3000);
		
		if(bi.equals("Secured Loans - LOS"))
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
			s.selectByVisibleText("Secured Loans - LOS");
			yes_button.click();
		}
		Thread.sleep(3000);
		
		Plus_button.click();
		new_case.click();
		Thread.sleep(5000);
		//PAN.click();
	}
		
		public void newCase() throws InterruptedException, EncryptedDocumentException, IOException, AWTException
		{
			Thread.sleep(5000);
			
            Robot r=new Robot();//exception
			
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			
			
			Flib f = new Flib();
			
			String pan = f.readDataW(excel_pathsl, "entity", 1, 0);
			
			enter_pan_manually.click();
			pan_number.sendKeys(pan);
			Thread.sleep(4000);
			verify_pan.click();
			
			
		}
		
		public void gstin() throws InterruptedException
		{
			String g = GSTN.getText();
			Thread.sleep(2000);
			System.out.println(g);
			
			if(g.equals("GST EXEMPT"))
			{
				System.out.println("already their");
			}
			else
			{
				GSTN.sendKeys("GST EXEMPT");
			}
		}
		
		
		public void checkEntity() throws InterruptedException, EncryptedDocumentException, IOException 
		{
			Flib f = new Flib();
			
			 double cin = f.readDataN(excel_pathsl, "entity", 1, 4 );
			 double phone = f.readDataN(excel_pathsl, "entity", 1, 7);
			 String company = f.readDataW(excel_pathsl, "entity", 1, 8);
			 double mobile = f.readDataN(excel_pathsl, "entity", 1, 9);
			 double loan = f.readDataN(excel_pathsl, "entity", 1, 10);
			 String email2 = f.readDataW(excel_pathsl, "entity", 1, 11);
			 Date date = f.date(excel_pathsl,"entity", 1, 12);
			 long date2 = (long) f.readDataN(excel_pathbl, "entity", 1, 12);
			 String l3 = f.readDataLONGString(excel_pathsl, "entity", 1, 10);
			System.out.println("check entity");
			Thread.sleep(2000);
			application_date.sendKeys(String.valueOf(date));
			Thread.sleep(2000);
			application_date.sendKeys(Keys.ENTER);
			
			//Thread.sleep(3000);
			//owned_button.click();
			Thread.sleep(3000);

			cin_number.sendKeys(String.valueOf(cin));
			Thread.sleep(2000);
			phone_no.sendKeys(String.valueOf(phone));
			Thread.sleep(2000);
			company_no.sendKeys(company);
			Thread.sleep(2000);
			mobile_no.sendKeys(String.valueOf(mobile));
			Thread.sleep(2000);
			loan_amount.sendKeys(String.valueOf(l3));
			Thread.sleep(2000);
			email_id.sendKeys(email2);
			Thread.sleep(2000);
			source.click();
			Thread.sleep(2000);
			source_direct.click();
			
			
			
		}
		public void entity() throws InterruptedException, EncryptedDocumentException, IOException
		{
			Flib f = new Flib();
			String bn = f.readDataW(excel_pathsl, "entity", 1, 1);
			 double pin = f.readDataN(excel_pathsl, "entity", 1, 2 );
			 String ba = f.readDataW(excel_pathsl, "entity", 1, 3);
			 double cin = f.readDataN(excel_pathsl, "entity", 1, 4 );
			 String email = f.readDataW(excel_pathsl, "entity", 1, 5);	
			 double hsn = f.readDataN(excel_pathsl, "entity", 1, 6);
			 double phone = f.readDataN(excel_pathsl, "entity", 1, 7);
			 String company = f.readDataW(excel_pathsl, "entity", 1, 8);
			 double mobile = f.readDataN(excel_pathsl, "entity", 1, 9);
			 double loan = f.readDataN(excel_pathsl, "entity", 1, 10);
			 String email2 = f.readDataW(excel_pathsl, "entity", 1, 11);
			 Date date = f.date(excel_pathsl,"entity", 1, 12);
			 String source1 = f.readDataW(excel_pathsl, "entity", 1, 19);
			 long loan2 = (long) f.readDataN(excel_pathsl, "entity", 1, 10);
			 long date2 = (long) f.readDataN(excel_pathsl, "entity", 1, 12);
			 String l3 = f.readDataLONGString(excel_pathsl, "entity", 1, 10);
			// owned_button.click();
		//	GSTN.sendKeys("GST EXEMPT");
			System.out.println("entity");
			
			Thread.sleep(2000);
			date_of_pan.sendKeys("01011990");
			Thread.sleep(2000);
			date_of_udyam.sendKeys("01011990");
			Thread.sleep(2000);
			name_of_business.sendKeys(bn);
			Thread.sleep(2000);
			pincode.sendKeys(String.valueOf(pin));
			Thread.sleep(2000);
			business_address.sendKeys(ba);
			Thread.sleep(2000);
			owned_button.click();
			Thread.sleep(3000);
			application_date.sendKeys(String.valueOf(date));
			Thread.sleep(2000);
			application_date.sendKeys(Keys.ENTER);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", same_as_business_address);
			//same_as_business_address.click();
			Thread.sleep(2000);
			cin_number.sendKeys(String.valueOf(cin));
			Thread.sleep(2000);
			regd_email.sendKeys(email);
			Thread.sleep(2000);
			hsn_code.sendKeys(String.valueOf(hsn));
			Thread.sleep(2000);
			phone_no.sendKeys(String.valueOf(phone));
			Thread.sleep(2000);
			company_no.sendKeys(company);
			Thread.sleep(2000);
			mobile_no.sendKeys(String.valueOf(mobile));
			Thread.sleep(2000);
			loan_amount.sendKeys(String.valueOf(loan2));
			Thread.sleep(2000);
			loan_amount.clear();
			loan_amount.sendKeys(String.valueOf(l3));
			email_id.sendKeys(email2);
			Thread.sleep(2000);
			source.click();
			Thread.sleep(2000);
			source_direct.click();
			
			
			//add_coapplicant.click();	
			
		}
		
		public void remaningEntity()
		{
			name_of_business.sendKeys("trade group");
		}
		
		public void karza() throws EncryptedDocumentException, IOException, InterruptedException
		{
			Flib f = new Flib();
			String p = f.readDataW(excel_pathsl, "entity", 1, 0);
			String fn = f.readDataW(excel_pathsl, "entity", 1, 13);
			//Date date = f.date(excel_path, "entity", 1, 14);

			String pan=p;
			add_karza_verification.click();
			Thread.sleep(2000);
			karza_pan_textbox.sendKeys(pan);
			Thread.sleep(2000);
			karza_name.sendKeys(fn);
			Thread.sleep(2000);
			karza_dob.sendKeys("01011990");
			Thread.sleep(2000);
			karza_consent.sendKeys("y");
			Thread.sleep(2000);
			karza_save_button.click();
		}
		
		public void addCoAppButton()
		{
			 
			add_coapplicant.click();
		}
		
		public void checkAddCoApp() throws InterruptedException, EncryptedDocumentException, IOException
		{

			Thread.sleep(2000);
			Flib f = new Flib();
			//String pan = f.readDataW(excel_pathsl, "co-applicant", 1, 0);
			String fn = f.readDataW(excel_pathsl, "co-applicant", 1, 1);
			String mn = f.readDataW(excel_pathsl, "co-applicant", 1, 2);
			String ln = f.readDataW(excel_pathsl, "co-applicant", 1, 3);
			int sh = f.readDataIN(excel_pathsl, "co-applicant", 1, 4);
			String email = f.readDataW(excel_pathsl, "co-applicant", 1, 5);
			double mobile = f.readDataN(excel_pathsl, "co-applicant", 1, 6);
			double pin = f.readDataN(excel_pathsl, "co-applicant", 1, 7);
			String a1 = f.readDataW(excel_pathsl, "co-applicant", 1, 8);
			String a2 = f.readDataW(excel_pathsl, "co-applicant", 1, 9);
			String a3 = f.readDataW(excel_pathsl, "co-applicant", 1, 10);
			String r= f.readDataW(excel_pathsl, "co-applicant", 1, 12);
			//long date = f.readDataLONG(excel_pathsl, "co-applicant", 1, 11);
			//co_applicant_pan.click();
			Thread.sleep(2000);
			//co_applicant_isa_primary.click();
			System.out.println("checkaddcoapp method");
			//co_applicant_male.click();
			Thread.sleep(2000);
			co_applicant_first_name.sendKeys(fn);
			Thread.sleep(2000);
			co_applicant_DOB.sendKeys("01011990");
			Thread.sleep(2000);
			co_applicant_middle_name.sendKeys(mn);
			Thread.sleep(2000);
			co_applicant_last_name.sendKeys(ln);
			Thread.sleep(2000);
			co_applicant_share_holding.sendKeys(String.valueOf(sh));
			Thread.sleep(2000);
			co_applicant_relationship.sendKeys(r);
			Thread.sleep(2000);
			//co_applicant_email.sendKeys(email);
			Thread.sleep(2000);
			//co_applicant_mobile_no.sendKeys(String.valueOf(mobile));
			Thread.sleep(2000);
			//co_applicant_pincode.sendKeys(String.valueOf(pin));
			Thread.sleep(2000);
			co_applicant_address1.sendKeys(a1);
			Thread.sleep(2000);
			co_applicant_address2.sendKeys(a2);
			Thread.sleep(2000);
			co_applicant_address3.sendKeys(a3);
			Thread.sleep(2000);
			co_applicant_owned_button.click();
			Thread.sleep(2000);
			//co_applicant_CKYC.click();
			//co_applicant_ispermanent.click();
			
			
		}
		public void coAppCKYC() throws InterruptedException
		{
			Thread.sleep(2000);
			co_applicant_CKYC.click();
			Thread.sleep(4000);
			String text = co_applicant_abouttext.getText();
			System.out.println(text);
			if(text.equals("About the Co-Applicant"))
			{
				System.out.println("coapp if block");
				co_applicant_save_applicant.click();
				Thread.sleep(4000);
				co_applicant_next_button.click();
			}
			else
			{
				System.out.println("coapp if block");
				Thread.sleep(3000);
			co_applicant_next_button.click();
			}
		}
		
		public void coAppCKYCjs() throws InterruptedException
		{
			Thread.sleep(2000);
			co_applicant_CKYC.click();
			Thread.sleep(4000);
			String text = co_applicant_abouttext.getText();
			System.out.println(text);
			if(text.equals("About the Co-Applicant"))
			{
				System.out.println("coapp if block");
				JavascriptExecutor js=(JavascriptExecutor) driver;
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			        // Wait for the page to load completely using the "presence of element located" expected condition
			        wait.until(ExpectedConditions.invisibilityOf( co_applicant_save_applicant));
			        System.out.println("coapp save");
				js.executeScript("arguments[0].click()", co_applicant_save_applicant);
				Thread.sleep(4000);
				System.out.println("coapp nxt");
				co_applicant_next_button.click();
			}
			else
			{
				System.out.println("coapp if block");
				Thread.sleep(3000);
			co_applicant_next_button.click();
			}
		}
		
		public void addCoApplicant() throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			Thread.sleep(2000);
			Flib f = new Flib();
			String pan = f.readDataW(excel_pathsl, "co-applicant", 1, 0);
			String fn = f.readDataW(excel_pathsl, "co-applicant", 1, 1);
			String mn = f.readDataW(excel_pathsl, "co-applicant", 1, 2);
			String ln = f.readDataW(excel_pathsl, "co-applicant", 1, 3);
			int sh = f.readDataIN(excel_pathsl, "co-applicant", 1, 4);
			String email = f.readDataW(excel_pathsl, "co-applicant", 1, 5);
			double mobile = f.readDataN(excel_pathsl, "co-applicant", 1, 6);
			double pin = f.readDataN(excel_pathsl, "co-applicant", 1, 7);
			String a1 = f.readDataW(excel_pathsl, "co-applicant", 1, 8);
			String a2 = f.readDataW(excel_pathsl, "co-applicant", 1, 9);
			String a3 = f.readDataW(excel_pathsl, "co-applicant", 1, 10);
			
			//co_applicant_pan.click();
			co_applicant_enterpanmanually.click();
			Thread.sleep(2000);
			co_applicant_panmumber.sendKeys(pan);
			Thread.sleep(2000);
			co_applicant_verifypan_button.click();
			Thread.sleep(2000);
			co_applicant_continue_button.click();
			Thread.sleep(2000);
			//co_applicant_isa_primary.click();
			co_applicant_male.click();
			Thread.sleep(2000);
			co_applicant_first_name.sendKeys(fn);
			Thread.sleep(2000);
			co_applicant_DOB.sendKeys("01011990");
			Thread.sleep(2000);
			co_applicant_middle_name.sendKeys(mn);
			Thread.sleep(2000);
			co_applicant_last_name.sendKeys(ln);
			Thread.sleep(2000);
			co_applicant_share_holding.sendKeys(String.valueOf(sh));
			Thread.sleep(2000);
			//co_applicant_relationship.sendKeys("CEO");
			Thread.sleep(2000);
			co_applicant_email.sendKeys(email);
			Thread.sleep(2000);
			co_applicant_mobile_no.sendKeys(String.valueOf(mobile));
			Thread.sleep(2000);
			co_applicant_pincode.sendKeys(String.valueOf(pin));
			Thread.sleep(2000);
			co_applicant_address1.sendKeys(a1);
			Thread.sleep(2000);
			co_applicant_address2.sendKeys(a2);
			Thread.sleep(2000);
			co_applicant_address3.sendKeys(a3);
			Thread.sleep(2000);
			co_applicant_owned_button.click();
			Thread.sleep(2000);
			
			//co_applicant_ispermanent.click();
				
		}
		
		public void addCoApplicantElse() throws EncryptedDocumentException, IOException, InterruptedException
		{
			Thread.sleep(2000);
			Flib f = new Flib();
			String pan = f.readDataW(excel_pathbl, "co-applicant", 1, 0);
			String fn = f.readDataW(excel_pathbl, "co-applicant", 1, 1);
			String mn = f.readDataW(excel_pathbl, "co-applicant", 1, 2);
			String ln = f.readDataW(excel_pathbl, "co-applicant", 1, 3);
			int sh = f.readDataIN(excel_pathbl, "co-applicant", 1, 4);
			String email = f.readDataW(excel_pathbl, "co-applicant", 1, 5);
			double mobile = f.readDataN(excel_pathbl, "co-applicant", 1, 6);
			double pin = f.readDataN(excel_pathbl, "co-applicant", 1, 7);
			String a1 = f.readDataW(excel_pathbl, "co-applicant", 1, 8);
			String a2 = f.readDataW(excel_pathbl, "co-applicant", 1, 9);
			String a3 = f.readDataW(excel_pathbl, "co-applicant", 1, 10);
			String relationship = f.readDataW(excel_pathbl, "co-applicant", 1, 12);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", co_applicantelse_primarytoggle);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()", co_applicantelse_male);
			//co_applicantelse_male.click();
			Thread.sleep(2000);
			co_applicantelse_firstname.sendKeys(fn);
			Thread.sleep(2000);
			co_applicantelse_dob.sendKeys("01011990");
			Thread.sleep(2000);
			co_applicantelse_middlename.sendKeys(mn);
			Thread.sleep(2000);
			co_applicantelse_lastname.sendKeys(ln);
			Thread.sleep(2000);
			if(co_applicantelse_shareholding.isEnabled())
			{
			js.executeScript("arguments[0].value = arguments[1];", co_applicantelse_shareholding, String.valueOf(sh));
			}
			else
			{
				System.out.println("co_applicantelse_shareholding is disabled");
			}
			//js.executeScript("arguments[0].value = 'String.valueOf(sh)';", co_applicantelse_shareholding);
			//co_applicantelse_shareholding.sendKeys(String.valueOf(sh));
			Thread.sleep(2000);
			//co_applicant_relationship.sendKeys("CEO");
			Thread.sleep(2000);
			//co_applicant_email.sendKeys(email);
			Thread.sleep(2000);
			//co_applicant_mobile_no.sendKeys(String.valueOf(mobile));
			Thread.sleep(2000);
			//co_applicant_pincode.sendKeys(String.valueOf(pin));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()", co_applicantelse_relationship);
			WebElement active = driver.switchTo().activeElement();
			active.sendKeys(relationship);
			active.sendKeys(Keys.ENTER);
			co_applicantelse_address1.sendKeys(a1);
			Thread.sleep(2000);
			co_applicantelse_address2.sendKeys(a2);
			Thread.sleep(2000);
			co_applicantelse_address3.sendKeys(a3);
			Thread.sleep(2000);
			co_applicantelse_owned.click();
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()", co_applicantelse_ispermanent);
			
		}
		
		
		
		public void coAppNextForCKYC() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(co_applicant_save_applicant));
			co_applicant_save_applicant.click();
			Thread.sleep(5000);
			co_applicant_forCKYC.click();
		}
		
		public void coAppDropdown()
		{
			co_applicant_forCKYC.click();
		}
		
		public void coAppNextButton() throws InterruptedException
		{
			co_applicant_save_applicant.click();
			Thread.sleep(3000);
			co_applicant_next_button.click();
			Thread.sleep(5000);
			
			
			String text = co_applicant_bureau.getText();
			
			System.out.println(text);
			
			if(text.equals("Bureau Check"))
			{
				System.out.println("bureau screen");
				
			}
			else
			{
				co_applicant_next_button2.click();
			}
			
		}
		
		public void karza1() throws EncryptedDocumentException, IOException, InterruptedException
		{
			Flib f = new Flib();
			String pan = f.readDataW(excel_pathsl, "co-applicant", 1, 0);
			String fn = f.readDataW(excel_pathsl, "co-applicant", 1, 1);
			//Date date = f.date(excel_path, "entity", 1, 14);

			
			add_karza_verification.click();
			Thread.sleep(2000);
			karza_pan_textbox.sendKeys(pan);
			Thread.sleep(2000);
			karza_name.sendKeys(fn);
			Thread.sleep(2000);
			karza_dob.sendKeys("01011990");
			Thread.sleep(2000);
			karza_consent.sendKeys("y");
			Thread.sleep(2000);
			karza_save_button.click();
		}
		
		
		public void bureau() throws InterruptedException, AWTException
		{
			
			Thread.sleep(4000);
			
			bureau_upload_form.click();
			Thread.sleep(4000);
			bureau_capture_button.click();
			Thread.sleep(2000);
			bureau_upload_button.click();
			Thread.sleep(2000);
			bureau_checkscore.click();
			Thread.sleep(2000);
			
		}
		
		public void bureaurepull() throws InterruptedException
		{
			System.out.println("repull cibil");
			Thread.sleep(3000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click()",bureau_repull);
			//bureau_repull.click();
			Thread.sleep(4000);
			js.executeScript("arguments[0].click()",bureau_repull_popup);
			//bureau_repull_popup.click();
			//Thread.sleep(4000);
			//bureau_continue.click();
		}
	
		
		public void karzaBureau() throws InterruptedException, IOException
		{
			karza_utility.click();
			Thread.sleep(2000);
			karza_mockdataupload.click();
			Thread.sleep(2000);
			WebElement ss=karza_selectservice;
			
			Select s=new Select(ss);
			s.selectByVisibleText("CIBIL");
			Thread.sleep(2000);
			
			karza_cibilpan.sendKeys("CHKPB8974M");
			Thread.sleep(2000);
			
			String fp="./data/json.txt";
			File f=new File(fp);
			FileReader fr=new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fr);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
			    karza_cibildata.sendKeys(line);;
			}
			Thread.sleep(3000);
			
			
			String fp1="./data/html.txt";
			File f1=new File(fp1);
			FileReader fr1=new FileReader(f1);
			BufferedReader br=new BufferedReader(fr1);
			
			String html;
			while ((html = br.readLine()) != null) {
			    karza_cibilhtml.sendKeys(html);;
			}
			Thread.sleep(3000);
			
			String fp2="./data/xml.txt";
			File f2=new File(fp2);
			FileReader fr2=new FileReader(f2);
			BufferedReader br1=new BufferedReader(fr2);
			
			String xml;
			while ((xml = br1.readLine()) != null) {
			    karza_cibilxml.sendKeys(xml);
			}
			Thread.sleep(3000);
			
			//karza_cibilsave.click();
			
		}
		
		public void poi() throws AWTException, InterruptedException
		{
			Thread.sleep(2000);
			document_poi.click();
			System.out.println("poi start");
			  Robot r=new Robot();//exception
				
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(3000);
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				System.out.println("end");
				
				
		}
		public void documentPOI() throws InterruptedException
		{
			
			document_poidocumentno.sendKeys("132131");
			Thread.sleep(3000);
			document_poicapture.click();
			Thread.sleep(3000);
			document_poisave.click();
		}
		
		public void poa() throws InterruptedException
		{
			Thread.sleep(3000);
			// Create a new WebDriverWait object that will wait for up to 30 seconds
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

						// Wait for the element to be clickable using the "elementToBeClickable" expected condition
						wait.until(ExpectedConditions.elementToBeClickable(document_poa));
			document_poa.click();
		}
		
		public void documentPOA() throws InterruptedException
		{
			
			document_POAdocumentno.sendKeys("132131");
			Thread.sleep(3000);
			document_POAdate.sendKeys("01012024");
			Thread.sleep(3000);
			document_POAcapture.click();
			Thread.sleep(3000);
			document_POAsave.click();
		}
		
		public void applicationForm() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_Appform));
			
			document_Appform.click();
			Thread.sleep(3000);
			document_Appformcapture.click();
			Thread.sleep(3000);
			document_Appformsave.click();
			System.out.println("Applicaton done");
		}
		
		public void partnership() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_partership));
			
			System.out.println("partnership");
			document_partership.click();
			Thread.sleep(3000);
			document_patershipcapture.click();
			Thread.sleep(3000);
			document_patershipsave.click();
		}
		
		public void pan() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_pan));
			
			document_pan.click();
			Thread.sleep(3000);
			document_pancapture.click();
			Thread.sleep(3000);
			document_pansave.click();
		}
		
		public void coAppPoi() throws InterruptedException
		{
			
			document_coappdropdown.click();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coappdroppoi));
			document_coappdroppoi.click();
		}
		
		public void coAppPoiDoc() throws InterruptedException
		{
			Thread.sleep(3000);
			document_coapp_poi_docno.sendKeys("212122");
			Thread.sleep(3000);
			document_POAdate.sendKeys("01012024");
			Thread.sleep(3000);
			document_coapp_poicapture.click();
			Thread.sleep(3000);
			document_coapp_poisave.click();
			
		}
		
		public void coAppPoa()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coapp_poa));
			document_coapp_poa.click();
		}
		
		public void coAppPoaDoc() throws InterruptedException
		{
			document_coapp_poa_docno.sendKeys("2132");
			Thread.sleep(3000);
			document_POAdate.sendKeys("01012024");
			document_coapp_poacapture.click();
			Thread.sleep(3000);
			document_coapp_poasave.click();
		}
		
		public void coAppPhoto() throws InterruptedException
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coapp_photo));
			document_coapp_photo.click();
			Thread.sleep(3000);
			document_coapp_photocapture.click();
			Thread.sleep(3000);
			document_coapp_photosave.click();
		}
		
		public void signature() throws InterruptedException
		{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coapp_sign));
			document_coapp_sign.click();
			Thread.sleep(3000);
			document_coapp_signcapture.click();
			Thread.sleep(3000);
			document_coapp_signsave.click();
		}
		
		public void coAppPan() throws InterruptedException
		{
			Thread.sleep(3000);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coapp_pan));
			document_coapp_pan.click();
			Thread.sleep(3000);
			document_coapp_pancapture.click();
			Thread.sleep(3000);
			document_coapp_pansave.click();
		}
		
		public void saveOvd() throws InterruptedException
		{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_coapp_saveovd));
			
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 
			 js.executeScript("arguments[0].click()", document_coapp_saveovd);
			
			Thread.sleep(3000);
			 js.executeScript("arguments[0].click()", document_banking);
		
		}
		
		public void banking()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClickable" expected condition
			wait.until(ExpectedConditions.elementToBeClickable(document_banking_bankstate));
			document_banking_bankstate.click();
		}
		
		public void bankSelectFile() throws InterruptedException
		{
			document_banking_selectfile.sendKeys(File_path);
			Thread.sleep(3000);
			document_banking_save.click();
		}
		
		public void bankingCoApp() throws InterruptedException
		{WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the element to be clickable using the "elementToBeClickable" expected condition
		wait.until(ExpectedConditions.elementToBeClickable(document_banking_coApp));
			document_banking_coApp.click();
			Thread.sleep(3000);
			document_banking_coAppselectdoc.click();
		}
		
		public void bankingCoAppSelectfile() throws InterruptedException
		{
			document_banking_coApp_iestatement.click();
			Thread.sleep(3000);
			document_banking_selectfile.sendKeys(File_path);
			Thread.sleep(3000);
			document_banking_save.click();
			
		}		
		public void property() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

						// Wait for the element to be clickable using the "elementToBeClickable" expected condition
						wait.until(ExpectedConditions.elementToBeClickable(property));
			property.click();
			Thread.sleep(3000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click()", property_registration_doc);
			WebElement activeElement3 = driver.switchTo().activeElement();
			activeElement3.sendKeys("property");
			activeElement3.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			property_registration_name.sendKeys("om");
			Thread.sleep(3000);
			property_capture.click();
			Thread.sleep(3000);
			property_save.click();
		}
		
		public void propertyTransfer() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClicka
			wait.until(ExpectedConditions.elementToBeClickable(property_transfer));
			property_transfer.click();
			
JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click()", property_registration_doc);
			WebElement activeElement3 = driver.switchTo().activeElement();
			activeElement3.sendKeys("property");
			activeElement3.sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			property_capture.click();
			Thread.sleep(3000);
			property_save.click();
		
		}
		
		public void propertyValuation() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClicka
			wait.until(ExpectedConditions.elementToBeClickable(property_valuation));
			property_valuation.click();
			Thread.sleep(3000);
			
JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click()", property_registration_doc);
			WebElement activeElement3 = driver.switchTo().activeElement();
			activeElement3.sendKeys("property");
			activeElement3.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			
			js.executeScript("arguments[0].click()", property_documenttype);
			WebElement activeElement4 = driver.switchTo().activeElement();
			activeElement4.sendKeys("oc");
			activeElement4.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			property_capture.click();
			Thread.sleep(3000);
			property_save.click();
			
		}
		
		public void propertyOwer() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClicka
			wait.until(ExpectedConditions.elementToBeClickable(property_owned));
			property_owned.click();
			Thread.sleep(3000);
			
            JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", property_registration_doc);
			WebElement activeElement3 = driver.switchTo().activeElement();
			activeElement3.sendKeys("property");
			activeElement3.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			property_capture.click();
			Thread.sleep(3000);
			property_save.click();
			
		}
		
		public void propertyOther() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

						// Wait for the element to be clickable using the "elementToBeClicka
						wait.until(ExpectedConditions.elementToBeClickable(property_otherdoc));
			
			property_otherdoc.click();

            JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", property_registration_doc);
			WebElement activeElement3 = driver.switchTo().activeElement();
			activeElement3.sendKeys("property");
			activeElement3.sendKeys(Keys.ENTER);
			
			property_capture.click();
			Thread.sleep(3000);
			property_save.click();

		}
		
		public void propertyLegal() throws InterruptedException
		{
			// Create a new WebDriverWait object that will wait for up to 30 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for the element to be clickable using the "elementToBeClicka
			wait.until(ExpectedConditions.elementToBeClickable(property_legal));
			
			property_legal.click();
			Thread.sleep(3000);
			
			 JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", property_registration_doc);
				WebElement activeElement3 = driver.switchTo().activeElement();
				activeElement3.sendKeys("property");
				activeElement3.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				js.executeScript("arguments[0].click()", property_documenttype);
				WebElement activeElement4 = driver.switchTo().activeElement();
				activeElement4.sendKeys("8A Extract");
				activeElement4.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				property_capture.click();
				Thread.sleep(3000);
				property_save.click();
				Thread.sleep(3000);
				js.executeScript("arguments[0].click()", document_banking_AssigntoCO);
				
		}
		
		
		
	}

