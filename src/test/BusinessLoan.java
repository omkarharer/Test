package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import automationproject.BaseTest;
import pom.RM;

public class BusinessLoan {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		RM rm = new RM(driver);
		rm.login("jeevakani.d@eclf.com","jeevakani.d@eclf.com", "123456");
		Thread.sleep(3000);
		System.out.println("Create new case");
		 
		//rm.entity("AZDFA8934E");
		
		

	}

}
