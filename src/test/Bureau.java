package test;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import datadriven.PomEdgeRm;

public class Bureau {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
EdgeOptions options=new EdgeOptions(); 
		
		options.addArguments("--remote-allow-origins=*");
		
	   WebDriver driver=new EdgeDriver(options);
					driver.manage().window().maximize();
					
					driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					
					PomEdgeRm co = new PomEdgeRm(driver);
					
					co.Justlogin("felix.f@eclf.com", "123456");
					
					driver.findElement(By.xpath("//span[.='RANGEROVER PVTtrade group']")).click();
					Thread.sleep(5000);
					
					JavascriptExecutor js=(JavascriptExecutor) driver;
					
					WebElement c = driver.findElement(By.xpath("//span[.='Bureau']"));
					js.executeScript("arguments[0].click()", c);
					Thread.sleep(5000);
					//WebElement n = driver.findElement(By.xpath("//button[@class='btn btn-primary btnwidth100per ThemeGrid_Width4']"));
					//js.executeScript("arguments[0].click()", n);
					co.bureaurepull();
					
					String parentw=driver.getWindowHandle();
					Thread.sleep(2000);
					
					((JavascriptExecutor) driver).executeScript("window.open()");
					
					// Switch to the new tab
					for (String handle : driver.getWindowHandles()) {
					    if (!handle.equals(parentw)) {
					        driver.switchTo().window(handle);
					    }
					}
					
					driver.get("https://dlp-qa.edelweisscredit.com/DLP_UTILS/KarzaVerifications");
					String handle=driver.getWindowHandle();
					Thread.sleep(2000);
					co.karzaBureau();
					
					
				

	}
	
}
