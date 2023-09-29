package test;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import datadriven.PomEdgeRm;

public class CheckCKYC {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		
		EdgeOptions options=new EdgeOptions(); 
				
				options.addArguments("--remote-allow-origins=*");
				
			   WebDriver driver=new EdgeDriver(options);
					driver.manage().window().maximize();
					
					driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					
					PomEdgeRm co = new PomEdgeRm(driver);
					
					co.Justlogin("felix.f@eclf.com", "123456");
						
					driver.findElement(By.xpath("//span[.='FIFA india trade group']")).click();
					Thread.sleep(5000);
					
					JavascriptExecutor js=(JavascriptExecutor) driver;
					
					WebElement c = driver.findElement(By.xpath("//span[.='Co-Applicant']"));
					js.executeScript("arguments[0].click()", c);
					
					PomEdgeRm rm = new PomEdgeRm(driver);
					
					rm.coAppDropdown();
					Thread.sleep(2000);
					rm.coAppCKYC();
					Thread.sleep(4000);
					//rm.coAppNextButton();
					System.out.println("bureau");
					Thread.sleep(2000);
					rm.bureau();
					Thread.sleep(2000);
					rm.bureaurepull();
					Thread.sleep(5000);
				

	}

}
