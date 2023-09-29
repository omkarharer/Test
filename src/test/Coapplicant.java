package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import datadriven.PomEdgeRm;

public class Coapplicant {

	public static void main(String[] args) throws EncryptedDocumentException, InterruptedException, IOException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		
EdgeOptions options=new EdgeOptions(); 
		
		options.addArguments("--remote-allow-origins=*");
		
	   WebDriver driver=new EdgeDriver(options);
			driver.manage().window().maximize();
			
			driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			PomEdgeRm co = new PomEdgeRm(driver);
			
			co.Justlogin("felix.f@eclf.com", "123456");
				
			driver.findElement(By.xpath("//span[.='J. S. D. ENGINEERING PRODUCTS']")).click();
			Thread.sleep(5000);
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			WebElement c = driver.findElement(By.xpath("//span[.='Co-Applicant']"));
			js.executeScript("arguments[0].click()", c);
			
			List<WebElement> cop1 = driver.findElements(By.xpath("//label[.='PAN']"));
			if (cop1.size() > 0) {
			    // If the WebElement is present, execute this block of code
			    System.out.println("Element is present on the webpage");
			    System.out.println("Coapp if block ");
				js.executeScript("arguments[0].click()", cop1);
				Thread.sleep(3000);

				co.addCoApplicant();

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

				//driver.switchTo().window(handle);
				Thread.sleep(2000);
				co.karza1();
				Thread.sleep(2000);
			//	driver.switchTo().window(parentw);
				Thread.sleep(2000);
				co.coAppNextForCKYC();
				Thread.sleep(2000);
				co.coAppCKYCjs();
				Thread.sleep(2000);
				//rm.coAppNextButton();
				
				Thread.sleep(2000);

			} else {
			    // If the WebElement is not present, execute this block of code
			    System.out.println("Element is not present on the webpage");
			    WebElement ecoapp = driver.findElement(By.xpath("//span[.='(Co-Applicant)']"));
				System.out.println("Coapp else block ");
				//WebElement ecoapp = driver.findElement(By.xpath("//span[.='(Co-Applicant)']"));
				Thread.sleep(2000);
				js.executeScript("arguments[0].click()", ecoapp);
				Thread.sleep(2000);
				co.addCoApplicantElse();

				//driver.switchTo().window(handle);
				Thread.sleep(2000);
				co.karza1();
				Thread.sleep(2000);
				//driver.switchTo().window(parentw);
				Thread.sleep(2000);
				co.coAppNextForCKYC();
				Thread.sleep(2000);
				co.coAppCKYC();
				Thread.sleep(2000);
				//rm.coAppNextButton();
				
				Thread.sleep(2000);


			}
			

	}

}
