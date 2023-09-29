package datadriven;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.EdgeRm;

public class EdgeBL implements IAuto {

	

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		
		EdgeOptions options=new EdgeOptions(); 
		
		options.addArguments("--remote-allow-origins=*");
		
	   WebDriver driver=new EdgeDriver(options);
		driver.manage().window().maximize();
		//ENTER LINK 
		driver.get(QA_link);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		PomEdgeRm rm = new PomEdgeRm(driver);
		
		rm.login();
		Thread.sleep(3000);
		System.out.println("Create new case");
		Thread.sleep(4000);
		//driver.switchTo().alert().accept();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement pan = driver.findElement(By.xpath("//div[@id='b5-b59-b1-Column1']"));
		
		js.executeScript("arguments[0].click()", pan);
		
		rm.newCase();
		Thread.sleep(4000);
		
		Thread.sleep(9000);
		//rm.gstin();
        
		
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
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Wait for the page to load completely using the "presence of element located" expected condition
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", bi);
		Thread.sleep(5000);
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
		activeElement6.sendKeys("fingrow");
		activeElement6.sendKeys(Keys.ENTER);
		
		js.executeScript("arguments[0].click()", sch);
		WebElement activeElement7 = driver.switchTo().activeElement();
		//activeElement7.sendKeys();
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
		
		js.executeScript("arguments[0].click()", p);
		WebElement activeElement10 = driver.switchTo().activeElement();
		activeElement10.sendKeys("finrise");
		activeElement10.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click()", sch);
		WebElement activeElement11 = driver.switchTo().activeElement();
		activeElement11.sendKeys("fin");
		activeElement11.sendKeys(Keys.ENTER);
		
		System.out.println("entity done");

		//driver.quit();s
		String parentw=driver.getWindowHandle();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("window.open()");
		
		// Switch to the new tab
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(parentw)) {
		        driver.switchTo().window(handle);
		    }
		}
		
		//ENTER KARZA LINK
		driver.get(QA_karza);
		String handle=driver.getWindowHandle();
		
		rm.karza();
		
		driver.switchTo().window(parentw);
		Thread.sleep(2000);
		rm.remaningEntity();
		Thread.sleep(2000);
		rm.addCoAppButton();
		Thread.sleep(2000);
		
		WebElement cop = driver.findElement(By.xpath("//div[@id='b5-b2-b1-Column1']"));
		js.executeScript("arguments[0].click()", cop);
		Thread.sleep(2000);

		rm.addCoApplicant();

		WebElement r = driver.findElement(By.xpath("//select[@id='b5-b35-DropdownSelect']"));
		WebElement pt=driver.findElement(By.xpath("//input[@id='b5-TierALinkage']"));
		WebElement pas=driver.findElement(By.xpath("//input[@id='b5-Switch1']"));
		Thread.sleep(2000);
					js.executeScript("arguments[0].click()", pt);
					Thread.sleep(2000);
					js.executeScript("arguments[0].click()", pas);
					Thread.sleep(2000);
					js.executeScript("arguments[0].click()", r);
					WebElement active = driver.switchTo().activeElement();
					active.sendKeys("CEO");
					active.sendKeys(Keys.ENTER);

		driver.switchTo().window(handle);
		Thread.sleep(2000);
		rm.karza1();
		Thread.sleep(2000);
		driver.switchTo().window(parentw);
		Thread.sleep(2000);
		rm.coAppNextButton();
		Thread.sleep(2000);
		System.out.println("bureau");
		Thread.sleep(2000);
		rm.bureau();
		Thread.sleep(2000);
		rm.bureaurepull();
		Thread.sleep(5000);
		
		WebElement con=driver.findElement(By.xpath("//*[@id='b5-btn_Continue']"));
		js.executeScript("arguments[0].click()", con);
		
		
	}

}
