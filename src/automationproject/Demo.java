package automationproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo extends BaseTest {
	

	public static void main(String[] args) throws InterruptedException {
		
		BaseTest bt=new BaseTest();
		//bt.openBrowser();
		driver.get("https://dlp-qa.edelweisscredit.com/DLP/Login");
		driver.findElement(By.xpath("//*[@id='Input_CommonUsername']")).sendKeys("felix.f@eclf.com");  
		driver.findElement(By.xpath("//*[@id='b29-Button']/button")).click();
		driver.findElement(By.xpath("//*[@id=\'RadioButton2-input\']")).click();
		driver.findElement(By.xpath("//input[@id='Input_CommonPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='b38-Button']/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b3-Content']/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b14-Button']/i")).click();
		driver.findElement(By.xpath("//*[@id='b15-Label']")).click();
	}
}
