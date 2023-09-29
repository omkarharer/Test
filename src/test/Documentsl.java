package test;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import datadriven.PomEdgeRm;
import datadriven.SLPom;

public class Documentsl {
	
	protected static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
EdgeOptions options=new EdgeOptions(); 
		
		options.addArguments("--remote-allow-origins=*");
		
	   driver=new EdgeDriver(options);
					driver.manage().window().maximize();
					
					driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					
					SLPom co = new SLPom(driver);
					
					co.Justlogin("felix.f@eclf.com", "123456");
					
					driver.findElement(By.xpath("//span[.='akash PVTtrade group']")).click();
					Thread.sleep(5000);
					System.out.println("click on document");
	    JavascriptExecutor js=(JavascriptExecutor) driver;
					
					WebElement d = driver.findElement(By.xpath("(//div[@class='wizard-item-label ph'])[4]"));
					Thread.sleep(3000);
					js.executeScript("arguments[0].click()", d);
					Thread.sleep(3000);
					System.out.println("document page");
					Thread.sleep(5000);
				
					co.poi();
					Thread.sleep(2000);
					
					WebElement poid = driver.findElement(By.xpath("(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]"));
					
					Thread.sleep(5000);
					js.executeScript("arguments[0].click()", poid);
					WebElement ae= driver.switchTo().activeElement();
					ae.sendKeys("cer");
					ae.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					co.documentPOI();
					Thread.sleep(4000);
					
					co.poa();
					Thread.sleep(2000);
					WebElement poad = driver.findElement(By.xpath("(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]"));
					Thread.sleep(3000);
					js.executeScript("arguments[0].click()", poad);
					WebElement ae1= driver.switchTo().activeElement();
					ae1.sendKeys("bank");
					ae1.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					co.documentPOA();
					
					Thread.sleep(3000);
					co.applicationForm();
					Thread.sleep(3000);
					co.partnership();
					Thread.sleep(4000);
					co.pan();
					Thread.sleep(2000);
					co.coAppPoi();
					
					Thread.sleep(4000);
                    WebElement coApppoid = driver.findElement(By.xpath("(//div[@class='choices__list choices__list--single'])[1]"));
                    Thread.sleep(4000);
					js.executeScript("arguments[0].click()", coApppoid);
					WebElement ae2= driver.switchTo().activeElement();
					ae2.sendKeys("ra");
					ae2.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					co.coAppPoiDoc();
					Thread.sleep(3000);
					
					co.coAppPoa();
					Thread.sleep(3000);
					
					//(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]
					 WebElement coApppoad = driver.findElement(By.xpath("(//div[@class='choices__item needsclick choices__item--selectable choices__placeholder'])[1]"));
					 Thread.sleep(3000);
						js.executeScript("arguments[0].click()", coApppoad);
						WebElement ae3= driver.switchTo().activeElement();
						ae3.sendKeys("oth");
						ae3.sendKeys(Keys.ENTER);
						Thread.sleep(3000);
						
						co.coAppPoaDoc();
						Thread.sleep(3000);
						co.coAppPhoto();
						Thread.sleep(4000);
						co.signature();
						Thread.sleep(3000);
						co.coAppPan();
						Thread.sleep(3000);
						co.saveOvd();
						Thread.sleep(3000);
						
						co.banking();
						 WebElement bank = driver.findElement(By.xpath("//select[@class='dropdown-search-select choices__input is-hidden']"));
						 Thread.sleep(3000);
							js.executeScript("arguments[0].click()",bank);
							WebElement ae4= driver.switchTo().activeElement();
							ae4.sendKeys("sbi");
							ae4.sendKeys(Keys.ENTER);
							Thread.sleep(3000);
							co.bankSelectFile();
							Thread.sleep(3000);
							
							co.bankingCoApp();
							 WebElement cobank = driver.findElement(By.xpath("//select[@class='dropdown-search-select choices__input is-hidden']"));
								
								js.executeScript("arguments[0].click()",cobank);
								WebElement ae5= driver.switchTo().activeElement();
								ae5.sendKeys("sbi");
								ae5.sendKeys(Keys.ENTER);
								Thread.sleep(3000);
								
								co.bankingCoAppSelectfile();
								Thread.sleep(3000);
								co.property();
								Thread.sleep(3000);
								co.propertyTransfer();
								Thread.sleep(3000);
								co.propertyValuation();
								Thread.sleep(3000);
								co.propertyOwer();
								Thread.sleep(3000);
								co.propertyOther();
								Thread.sleep(3000);
								co.propertyLegal();
								
								
								
	
	}

}
