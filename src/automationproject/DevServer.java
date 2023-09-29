package automationproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DevServer {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://dlp-dev.edelweisscredit.com/DLP/Login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//*[@id='Input_CommonUsername']")).sendKeys("badshah.khan@edelweissfin.com");
		driver.findElement(By.xpath("//*[@id='b29-Button']/button")).click();
		driver.findElement(By.xpath("//*[@id=\'RadioButton2-input\']")).click();
		driver.findElement(By.xpath("//input[@id='Input_CommonPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='b38-Button']/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='b3-Content']/div[2]")).click();
		Thread.sleep(3000);
		
		//String type="Business";
		Thread.sleep(3000);
		WebElement v = driver.findElement(By.xpath(" //div[@id='b3-b1-Menu']"));
		
		String loan = v.getText();
		
		System.out.println(loan);
		Thread.sleep(3000);
		if(loan=="Business")
		{
			System.out.println("done");
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='submenu-icon']")).click();
			WebElement selectloan = driver.findElement(By.xpath("//select[@id='b3-Dropdown1']"));
			
			Select s = new Select(selectloan);
			s.selectByVisibleText("Business Loans - LOS");
			driver.findElement(By.xpath("//button[@id='b3-YesButton']")).click();
		}
		
	}

}
