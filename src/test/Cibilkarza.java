package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import datadriven.IAuto;
import datadriven.PomEdgeRm;

public class Cibilkarza implements IAuto {
	protected static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
EdgeOptions options=new EdgeOptions(); 
		
		options.addArguments("--remote-allow-origins=*");
		
	   driver=new EdgeDriver(options);
					driver.manage().window().maximize();
					
			driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					PomEdgeRm co = new PomEdgeRm(driver);
					
					co.Justlogin("felix.f@eclf.com", "123456");
					
					String parentw=driver.getWindowHandle();
					Thread.sleep(2000);
					

					

				      // Open a new tab
				      ((JavascriptExecutor) driver).executeScript("window.open();");
				      
				      // Switch to the newly opened tab
				      ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				      driver.switchTo().window(tabs.get(1));
				      
				      // Open the second URL in the second tab
				      driver.get("https://dlp-qa.edelweisscredit.com/DLP_UTILS/KarzaVerifications");

						String karza=driver.getWindowHandle();
				      // Open a new tab
				      ((JavascriptExecutor) driver).executeScript("window.open();");
				      
				      // Switch to the newly opened tab
				      tabs = new ArrayList<String>(driver.getWindowHandles());
				      driver.switchTo().window(tabs.get(2));
				      
				      // Open the third URL in the third tab
				      driver.get("file:///C:/Users/omkar.harer/Documents/cibil/cibil.html");

						String html=driver.getWindowHandle();
				      // Close the last tab
				    //  driver.close();
				      
				      // Switch back to the second tab
				      driver.switchTo().window(karza);
				      Thread.sleep(4000);
				      co.cibilUpload();
				     
				      
				      // Switch back to the first tab
				      driver.switchTo().window(html);
				      Robot r1=new Robot();
				      Actions a = new Actions(driver);
				      
				      WebElement jd = driver.findElement(By.xpath("(//textarea[@class='form-control OSFillParent'])[1]"));
				    //  WebElement ht = driver.findElement(By.xpath("//textarea[@id='TextArea_Html']"));
				     // WebElement xm = driver.findElement(By.xpath("//textarea[@id='TextArea_Xml']"));
				      
				     
				     // WebElement ht2 = driver.findElement(By.xpath("//textarea[@id='TextArea_Html']"));
				      //WebElement xm2 = driver.findElement(By.xpath("//textarea[@id='TextArea_Xml']"));
				      Thread.sleep(4000);
				      System.out.println("copy action");
				    a.moveToElement(jd).click(); //keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
				    Thread.sleep(4000);
				   // a.keyDown(Keys.CONTROL).sendKeys("a");
				    //a.sendKeys("c");
				    
				    r1.keyPress(KeyEvent.VK_CONTROL);
				    r1.keyPress(KeyEvent.VK_A);
				  
				    driver.switchTo().window(karza);
				    Actions a1 = new Actions(driver);
				  
				   // co.cibilUpload();
				    WebElement jd2 = driver.findElement(By.xpath("//*[@id='TextArea_JsonData']"));
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

					// Wait for the element to be clickable using the "elementToBeClickable" expected condition
					wait.until(ExpectedConditions.elementToBeClickable(jd2));
					
					 a1.moveToElement(jd).click().keyDown(Keys.CONTROL).sendKeys("v");
					
					// JavascriptExecutor js=(JavascriptExecutor) driver;
						//js.executeScript("arguments[0].click()", jd2);

					
				  //  a.keyDown(Keys.CONTROL).sendKeys("v");
				    //a.keyUp(Keys.CONTROL).build().perform();
				      
				      
				      
				      
				   }
				

	}

