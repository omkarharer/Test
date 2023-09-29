package rpulse;




import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RpulsePOM extends Rpulse implements Iauto {
	public static Logger log;
	
	
	@FindBy(xpath ="//*[@id='txtUserName']") private WebElement Username;
	@FindBy(xpath ="//*[@id='txtPassword']") private WebElement Password;
	@FindBy(xpath ="//*[@id='btnLogin']") private WebElement Login_button;
	@FindBy(xpath ="//*[@id='pnlMenu']/div/div/nav/ul/li[3]/a") private WebElement Letters;
	@FindBy(xpath ="//*[@id='pnlMenu']/div/div/nav/ul/li[3]/ul/li[1]/a") private WebElement Letters_ops;
	@FindBy(xpath ="//*[@id='pnlMenu']/div/div/nav/ul/li[3]/ul/li[2]/a") private WebElement Letters_credit;
	@FindBy(xpath ="//*[@id='MainContent_ddlLetterType']") private WebElement Letter_type; //select letter type
	@FindBy(xpath ="//*[@id='MainContent_txtFromDate']") private WebElement From_date; //select letter type
	@FindBy(xpath ="//*[@id='MainContent_txtToDate']") private WebElement To_type; //select letter type
	@FindBy(xpath ="//*[@id='MainContent_txtAgreementNo']") private WebElement Agreement_No; //select letter type
	@FindBy(xpath ="//*[@id='MainContent_btnSearch']") private WebElement Search_button;
	@FindBy(xpath ="//*[@id='chkSelect_0']") private WebElement checkbox;
	@FindBy(xpath ="//*[@id='MainContent_btnGenerate']") private WebElement Generate_button;
	@FindBy(xpath ="(//a[.='Download'])[1]") private WebElement Download_link;
	@FindBy(xpath ="//*[@id='MainContent_dvResponseGrid']/table/tbody/tr[1]/td[2]") private WebElement App_id;
	
	 public RpulsePOM(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

	 
	 
	public WebElement getApp_id() {
		return App_id;
	}



	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin_button() {
		return Login_button;
	}

	public WebElement getLetters() {
		return Letters;
	}

	public WebElement getLetters_ops() {
		return Letters_ops;
	}

	public WebElement getLetters_credit() {
		return Letters_credit;
	}

	public WebElement getLetter_type() {
		return Letter_type;
	}

	public WebElement getFrom_date() {
		return From_date;
	}

	public WebElement getTo_type() {
		return To_type;
	}

	public WebElement getAgreement_No() {
		return Agreement_No;
	}

	public WebElement getSearch_button() {
		return Search_button;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getGenerate_button() {
		return Generate_button;
	}

	public WebElement getDownload_link() {
		return Download_link;
	}
	 
	 //Operational methods
	
	public void login() throws InterruptedException
	{
		Username.sendKeys(username_name);
		Thread.sleep(2000);
		Password.sendKeys(password);
		Thread.sleep(2000);
		Login_button.click();
		
	}
	
	public void welcomeLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Welcome letter");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("WELCOME LETTER");
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Welcome letter is filtered");
					String text = App_id.getText();
					log.info("Welcome letter App Id:-"+ text);
					checkbox.click();	
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					/*
					 * try { // Attempt to switch to the alert Alert alert =
					 * driver.switchTo().alert();
					 * 
					 * // If an alert is present, handle it String alertText = alert.getText();
					 * System.out.println("Alert text: " + alertText);
					 * 
					 * // Perform actions like accepting or dismissing the alert alert.accept(); }
					 * catch (NoAlertPresentException e) { // Handle the case when no alert is
					 * present System.out.println("No alert present on the screen."); }
					 */
					
						
						   //Switch to the alert 
						   Alert alert = driver.switchTo().alert();
						  
						  // Get the text of the alert 
						  String alertText = alert.getText();
						  System.out.println(alertText);
						  
						  // Accept the alert (click OK) 
						  alert.accept();
						 
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Welcome letter is Generated");
					}
					else
					{
						log.info("Welcome letter is not Generated");
					}
					
				}
				else
				{
					log.info("Welcome letter is not Filtered");
				}
		
		
	}
	
	public void provisionalItCertificate() throws InterruptedException
	{
		System.out.println("PROVISIONAL IT CERTIFICATE");
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("PROVISIONAL IT CERTIFICATE");
		log.info("PROVISIONAL IT CERTIFICATE");
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("PROVISIONAL IT CERTIFICATE is Filtered");
					String text = App_id.getText();
					log.info("PROVISIONAL IT CERTIFICATE App Id:-"+ text);
					
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("PROVISIONAL IT CERTIFICATE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("PROVISIONAL IT CERTIFICATE is not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("PROVISIONAL IT CERTIFICATE is Not Filtered");
				}
		
		
	}
	
	public void voucherAccountingInvoiceGeneration() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Voucher Accounting Invoice Generation");
		
		From_date.sendKeys("05-Dec-2018");
		Thread.sleep(3000);
		To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Voucher Accounting Invoice Generation is  Filtered");
					String text = App_id.getText();
					log.info("Voucher Accounting Invoice Generation App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Voucher Accounting Invoice Generation is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Voucher Accounting Invoice Generation is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Voucher Accounting Invoice Generation is Not Filtered");
				}
				
				From_date.clear();
				Thread.sleep(2000);
				To_type.clear();
			
	}
	
	public void listOfDocument() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("LIST OF DOCUMENTS");
		log.info("LIST OF DOCUMENTS");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("LIST OF DOCUMENTS is Filtered");
					String text = App_id.getText();
					log.info("LIST OF DOCUMENTS App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("LIST OF DOCUMENTS is  Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("LIST OF DOCUMENTS is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("LIST OF DOCUMENTS is Not Filtered");
				}
			
	}
	
	public void partPrePayment() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("PART PRE-PAYMENT");
		log.info("PART PRE-PAYMENT");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("PART PRE-PAYMENT is Filtered");
					String text = App_id.getText();
					log.info("PART PRE-PAYMENT  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("PART PRE-PAYMENT is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("PART PRE-PAYMENT is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("PART PRE-PAYMENT is Not Filtered");
				}
			
	}

	public void disbursalLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("DISBURSAL LETTER");
		log.info("DISBURSAL LETTER");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("DISBURSAL LETTER is Filtered");
					String text = App_id.getText();
					log.info("DISBURSAL LETTER   App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("DISBURSAL LETTER is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("DISBURSAL LETTER is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("DISBURSAL LETTER is Not Filtered");
				}
			
	}
	
	public void finalItCertificate() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("FINAL IT CERTIFICATE");
		log.info("FINAL IT CERTIFICATE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("FINAL IT CERTIFICATE is filtered");
					String text = App_id.getText();
					log.info("FINAL IT CERTIFICATE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("FINAL IT CERTIFICATE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("FINAL IT CERTIFICATE is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("FINAL IT CERTIFICATE is Not Filtered");
				}
			
	}

	public void debursementMemo() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("DISBURSEMENT MEMO");
		log.info("DISBURSEMENT MEMO");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("DISBURSEMENT MEMO is Filtered");
					String text = App_id.getText();
					log.info("DISBURSEMENT MEMO App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("DISBURSEMENT MEMO is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("DISBURSEMENT MEMO is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("DISBURSEMENT MEMO is Not Filtered");
					
				}
			
	}
	
	public void finalItCertificateNonHl() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("FINAL IT CERTIFICATE NONHL");
		log.info("FINAL IT CERTIFICATE NONHL");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("FINAL IT CERTIFICATE NONHL is Filtered");
					String text = App_id.getText();
					log.info("FINAL IT CERTIFICATE NONHL App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("FINAL IT CERTIFICATE NONHL is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("FINAL IT CERTIFICATE NONHL Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("FINAL IT CERTIFICATE NONHL Not Filtered");
				}
			
	}
	
	public void provisionalItCertificateNonhl() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("PROVISIONAL IT CERTIFICATE NONHL");
		log.info("PROVISIONAL IT CERTIFICATE NONHL");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("PROVISIONAL IT CERTIFICATE NONHL is Filtered");
					String text = App_id.getText();
					log.info("PROVISIONAL IT CERTIFICATE NONHL App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("PROVISIONAL IT CERTIFICATE NONHL is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("PROVISIONAL IT CERTIFICATE NONHL is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("PROVISIONAL IT CERTIFICATE NONHL is Not Filtered");
				}
			
	}

	public void finalItCertificateForClosed() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("FINAL IT CERTIFICATE FOR CLOSED");
		log.info("FINAL IT CERTIFICATE FOR CLOSED");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("FINAL IT CERTIFICATE FOR CLOSED Is Filtered");
					String text = App_id.getText();
					log.info("FINAL IT CERTIFICATE FOR CLOSED App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("FINAL IT CERTIFICATE FOR CLOSED is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("FINAL IT CERTIFICATE FOR CLOSED is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("FINAL IT CERTIFICATE FOR CLOSED is Not Filtered");
				}
			
	}

	public void soa() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("SOA");
		log.info("SOA");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("SOA is Filtered");
					String text = App_id.getText();
					log.info("SOA App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("SOA is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("SOA is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("SOA is Not Filtered");
				}
			
	}

	public void dunningNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("DUNNING NOTICE");
		log.info("DUNNING NOTICE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("DUNNING NOTICE is Filtered");
					String text = App_id.getText();
					log.info("DUNNING NOTICE  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("DUNNING NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("DUNNING NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("DUNNING NOTICE Not Filtered");
				}
			
	}

	public void dunningLetter2() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Dunning letter 2");
		log.info("Dunning letter 2");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Dunning letter 2 Is Filtered");
					String text = App_id.getText();
					log.info("Dunning letter 2  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Dunning letter 2 is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Dunning letter 2 is Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Dunning letter 2 is Not Filtered");
				}
			
	}

	public void repaymentSchedule() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("REPAYMENT SCHEDULE");
		log.info("REPAYMENT SCHEDULE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("REPAYMENT SCHEDULE is Filtered");
					String text = App_id.getText();
					log.info("REPAYMENT SCHEDULE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("REPAYMENT SCHEDULE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("REPAYMENT SCHEDULE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("REPAYMENT SCHEDULE is Not Filtered");
					
				}
			
	}

	public void rejectLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Reject Letter");
		log.info("Reject Letter");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Reject Letter is  filtered");
					String text = App_id.getText();
					log.info("Reject Letter App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Reject Letter is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Reject Letter Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Reject Letter Not Filtered");
				}
			
	}

	public void documentCustodyRecord() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Document Custody Record");
		log.info("Document Custody Record");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Document Custody Record is Filtered");
					String text = App_id.getText();
					log.info("Document Custody Record App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Document Custody Record is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Document Custody Record Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Document Custody Record Not Filtered");
				}
			
	}

	public void welcomeKit() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("WELCOME KIT");
		log.info("WELCOME KIT");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("WELCOME KIT is  Filtered");
					String text = App_id.getText();
					log.info("WELCOME KIT App Id:-"+ text);
					Thread.sleep(3000);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					/*
					 * Alert alert = driver.switchTo().alert();
					 * 
					 * // Get the text of the alert String alertText = alert.getText();
					 * System.out.println(alertText);
					 * 
					 * // Accept the alert (click OK) alert.accept();
					 */
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("WELCOME KIT is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("WELCOME KIT Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("WELCOME KIT Not Filtered");
				}
			
	}

	public void miniMillion() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Mini Million");
		log.info("Mini Million");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Mini Million is filtered");
					String text = App_id.getText();
					log.info("Mini Million App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Mini Million is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Mini Million Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Mini Million Not Filtered");
				}
			
	}

	public void smeRejectLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("SME Reject Letter");
		log.info("SME Reject Letter");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("SME Reject Letter is filtered");
					String text = App_id.getText();
					log.info("SME Reject Letter App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("SME Reject Letter is generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("SME Reject Letter Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("SME Reject Letter Not Filtered");
				}
			
	}

	public void dsaOracleEntryInvoiceGeneration() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("DSA ORACLE ENTRY INVOICE GENERATION");
		log.info("DSA ORACLE ENTRY INVOICE GENERATION");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("DSA ORACLE ENTRY INVOICE GENERATION is Filtered");
					String text = App_id.getText();
					log.info("DSA ORACLE ENTRY INVOICE GENERATION App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("DSA ORACLE ENTRY INVOICE GENERATION is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("DSA ORACLE ENTRY INVOICE GENERATION Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("DSA ORACLE ENTRY INVOICE GENERATION Not Filtered");
				}
			
	}

	public void vendorOracleEntryInvoiceGeneration() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("VENDOR ORACLE ENTRY INVOICE GENERATION");
		log.info("VENDOR ORACLE ENTRY INVOICE GENERATION");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("VENDOR ORACLE ENTRY INVOICE GENERATION is Filtered");
					String text = App_id.getText();
					log.info("VENDOR ORACLE ENTRY INVOICE GENERATION App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("VENDOR ORACLE ENTRY INVOICE GENERATION is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("VENDOR ORACLE ENTRY INVOICE GENERATION Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("VENDOR ORACLE ENTRY INVOICE GENERATION Not Filtered ");
				}
			
	}
	
	//line break

	public void cancelLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_credit.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Cancel Letter");
		log.info("Cancel Letter");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Cancel Letter is Filtered");
					String text = App_id.getText();
					log.info("Cancel Letter App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Cancel Letter is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Cancel Letter Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Cancel Letter Not Filtered");
				}
			
	}

	public void panNumberRequired() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		Letters.click();
		Thread.sleep(2000);
		Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("PAN Number Required");
		log.info("PAN Number Required");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("PAN Number Required is Filtered");
					String text = App_id.getText();
					log.info("PAN Number Required App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("PAN Number Required is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("PAN Number Required Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("PAN Number Required Not Filtered");
				}
			
	}

	public void mortgageLoanClosure() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("MORTGAGE LOAN CLOSURE");
		log.info("MORTGAGE LOAN CLOSURE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("MORTGAGE LOAN CLOSURE is Filtered");
					String text = App_id.getText();
					log.info("MORTGAGE LOAN CLOSURE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("MORTGAGE LOAN CLOSURE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("MORTGAGE LOAN CLOSURE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("MORTGAGE LOAN CLOSURE Not Filtered");
				}
			
	}
	
	public void nonmortgageLoanClosure() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("NON MORTGAGE LOAN CLOSURE");
		log.info("NON MORTGAGE LOAN CLOSURE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("NON MORTGAGE LOAN CLOSURE is Filtered");
					String text = App_id.getText();
					log.info("NON MORTGAGE LOAN CLOSURE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("NON MORTGAGE LOAN CLOSURE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("NON MORTGAGE LOAN CLOSURE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("NON MORTGAGE LOAN CLOSURE Not Filtered");
				}
			
	}

	public void fcLod() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("FC LOD");
		log.info("FC LOD");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("FC LOD is Filtered");
					String text = App_id.getText();
					log.info("FC LOD App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("FC LOD is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("FC LOD Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("FC LOD Not Filtered");
				}
			
	}

	public void dunningLetter1() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Dunning letter 1");
		log.info("Dunning letter 1");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Dunning letter 1 is Filtered");
					String text = App_id.getText();
					log.info("Dunning letter 1 App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Dunning letter 1 is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Dunning letter 1 Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Dunning letter 1 Not Filtered");
				}
			
	}

	public void softNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("SOFT NOTICE");
		log.info("SOFT NOTICE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("SOFT NOTICE is Filtered");
					String text = App_id.getText();
					log.info("SOFT NOTICE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("SOFT NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("SOFT NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("SOFT NOTICE Not Filtered");
				}
			
	}

	public void noticeWithMoratorium() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("NOTICE WITH MORATORIUM");
		log.info("NOTICE WITH MORATORIUM");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("NOTICE WITH MORATORIUM is Filterd");
					String text = App_id.getText();
					log.info("NOTICE WITH MORATORIUM App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("NOTICE WITH MORATORIUM is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("NOTICE WITH MORATORIUM  Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("NOTICE WITH MORATORIUM Not Filtered");
				}
			
	}

	public void repricingLetter() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("REPRICING LETTER");
		log.info("REPRICING LETTER");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("REPRICING LETTER is Filtered");
					String text = App_id.getText();
					log.info("REPRICING LETTER App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("REPRICING LETTER is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("REPRICING LETTER Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("REPRICING LETTER Not Filtered");
				}
			
	}

	public void preSarfeasiNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("PRE-SARFEASI NOTICE");
		log.info("PRE-SARFEASI NOTICE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("PRE-SARFEASI NOTICE is Filtered");
					String text = App_id.getText();
					log.info("PRE-SARFEASI NOTICE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("PRE-SARFEASI NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("PRE-SARFEASI NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("PRE-SARFEASI NOTICE Not Filtered");
				}
			
	}

	public void reminderDunningNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Reminder DUNNING NOTICE");
		log.info("Reminder DUNNING NOTICE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Reminder DUNNING NOTICE is Filtered");
					String text = App_id.getText();
					log.info("Reminder DUNNING NOTICE  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Reminder DUNNING NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Reminder DUNNING NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Reminder DUNNING NOTICE Not Filtered");
				}
			
	}

	public void reminderSoftNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Reminder SOFT NOTICE");
		log.info("Reminder SOFT NOTICE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Reminder SOFT NOTICE is Filtered");
					String text = App_id.getText();
					log.info("Reminder SOFT NOTICE  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Reminder SOFT NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Reminder SOFT NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Reminder SOFT NOTICE Not Filtered");
				}
			
	}

	public void reminderPreSarfeasiNotice() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("Reminder PRE-SARFEASI NOTICE");
		log.info("Reminder PRE-SARFEASI NOTICE");
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("Reminder PRE-SARFEASI NOTICE is Filtered");
					String text = App_id.getText();
					log.info("Reminder PRE-SARFEASI NOTICE  App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("Reminder PRE-SARFEASI NOTICE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("Reminder PRE-SARFEASI NOTICE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("Reminder PRE-SARFEASI NOTICE Not Filtered");
				}
			
	}

	public void nonMortgageSettlementLoanClosure() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("NON MORTGAGE SETTLEMENT LOAN CLOSURE");
		log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE is Filtered");
					String text = App_id.getText();
					log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("NON MORTGAGE SETTLEMENT LOAN CLOSURE Not Filtered");
				}
			
	}

	public void mortgageSettlementLoanClosure() throws InterruptedException
	{
		log = Logger.getLogger(RpulsePOM.class);
		PropertyConfigurator.configure("log4j.properties");
		//Letters.click();
		Thread.sleep(2000);
		//Letters_ops.click();
		
		WebElement selectp = Letter_type;
		Thread.sleep(3000);
		
		Select s = new Select(selectp);
		s.selectByVisibleText("MORTGAGE SETTLEMENT LOAN CLOSURE");
		log.info("MORTGAGE SETTLEMENT LOAN CLOSURE");
		
		//From_date.sendKeys("05-Dec-2018");
		//Thread.sleep(3000);
		//To_type.sendKeys("05-Dec-2018");
		
		
		//Agreement_No.sendKeys("");
		Search_button.click();
		
		
		// Locating the WebElement
		
				List<WebElement> cop1 =driver.findElements(By.xpath("//*[@id='chkSelect_0']"));
				if (cop1.size() > 0) 
				{
					log.info("MORTGAGE SETTLEMENT LOAN CLOSURE is Filtered");
					String text = App_id.getText();
					log.info("MORTGAGE SETTLEMENT LOAN CLOSURE App Id:-"+ text);
					checkbox.click();
					Thread.sleep(3000);
					Generate_button.click();
					Thread.sleep(3000);
					
					// Switch to the alert
					Alert alert = driver.switchTo().alert();

					// Get the text of the alert
					String alertText = alert.getText();
					System.out.println(alertText);

					// Accept the alert (click OK)
					alert.accept();
					
					List<WebElement> cop2 =driver.findElements(By.xpath("(//a[.='Download'])[1]"));
					if (cop2.size() > 0) { 
					Thread.sleep(3000);
					Download_link.click();
					Thread.sleep(2000);
					Download_link.click();
					log.info("MORTGAGE SETTLEMENT LOAN CLOSURE is Generated");
					}
					else
					{
						System.out.println("Not Generated");
						log.info("MORTGAGE SETTLEMENT LOAN CLOSURE Not Generated");
					}
					
				}
				else
				{
					System.out.println("Not Filtered");
					log.info("MORTGAGE SETTLEMENT LOAN CLOSURE Not Filtered");
				}
			
	}

}

