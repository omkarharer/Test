package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import pom.EdgeRm;

public class EdgeBL  {

	WebDriver  driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		
		EdgeOptions options = new EdgeOptions();

		//Add argument to options to disable Edge's protected mode security
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		
	    WebDriver driver=new EdgeDriver(options);
	    
	   //Add desired capabilities for the Edge driver to allow permissions
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("ms:inPrivate", true);
	    capabilities.setCapability("ms:extensionOptions", "{\"enableAutomation\": true}");
		driver.manage().window().maximize();
		
		driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		EdgeRm rm = new EdgeRm(driver);
		rm.login("felix.f@eclf.com", "123456");
		Thread.sleep(3000);
		System.out.println("Create new case");
		Thread.sleep(4000);
		//driver.switchTo().alert().accept();
		//WebElement pan = driver.findElement(By.xpath("//div[@id='b5-b59-b1-Column1']"));
		
        JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement pan = driver.findElement(By.xpath("//div[@id='b5-b59-b1-Column1']"));
		
		js.executeScript("arguments[0].click()", pan);
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

		
		rm.entity();
		
		
		
	
		Thread.sleep(4000);
		
		
		Thread.sleep(9000);
		
		
       
		
		WebElement t = driver.findElement(By.xpath("//input[@id='b5-Switch3']"));
		//WebElement bi2 = driver.findElement(By.id("choices--b5-b17-DropdownSelect-item-choice-1"));
		WebElement bi=driver.findElement(By.xpath("//select[@id='b5-b18-DropdownSelect']")); 
		WebElement doi=driver.findElement(By.xpath("//select[@id='b5-b8-DropdownSelect']"));//Date of incorporation
		WebElement bs=driver.findElement(By.xpath("//select[@id='b5-b29-DropdownSelect']"));// business sturture
		WebElement it=driver.findElement(By.xpath("//select[@id='b5-b33-DropdownSelect']"));//industry type
		WebElement st=driver.findElement(By.xpath("//select[@id='b5-b41-DropdownSelect']"));//segment type
		WebElement np=driver.findElement(By.xpath("//select[@id='b5-b51-DropdownSelect']"));//negative profile
		WebElement p=driver.findElement(By.xpath("//select[@id='b5-b44-DropdownSelect']"));//product
		WebElement sch=driver.findElement(By.xpath("//select[@id='b5-b53-DropdownSelect']"));//scheme
		WebElement b=driver.findElement(By.xpath("//select[@id='b5-b54-DropdownSelect']"));//branch
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", bi);
		Thread.sleep(3000);
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys("Trade Name");
		activeElement.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", doi);
		WebElement activeElement1 = driver.switchTo().activeElement();
		activeElement1.sendKeys("date");
		activeElement1.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", bs);
		WebElement activeElement2 = driver.switchTo().activeElement();
		activeElement2.sendKeys("firm");
		activeElement2.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", it);
		WebElement activeElement3 = driver.switchTo().activeElement();
		activeElement3.sendKeys("Animation");
		activeElement3.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", st);
		WebElement activeElement4 = driver.switchTo().activeElement();
		activeElement4.sendKeys("service");
		activeElement4.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", np);
		WebElement activeElement5 = driver.switchTo().activeElement();
		activeElement5.sendKeys("not a");
		activeElement5.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", p);
		WebElement activeElement6 = driver.switchTo().activeElement();
		activeElement6.sendKeys("finrise");
		activeElement6.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", sch);
		WebElement activeElement7 = driver.switchTo().activeElement();
		activeElement7.sendKeys("fin");
		activeElement7.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click()", b);
		WebElement activeElement8 = driver.switchTo().activeElement();
		activeElement8.sendKeys("Indore");
		activeElement8.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		rm.entity();
		
		js.executeScript("arguments[0].click()", t);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", sch);
		WebElement activeElement9 = driver.switchTo().activeElement();
		activeElement9.sendKeys("fin");
		activeElement9.sendKeys(Keys.ENTER);
		System.out.println("entity done");

	    //js.executeScript("arguments[0].value=arguments[1]", bi1,"Legal Name");
		
		
		
		//driver.quit();
		

	}

}
