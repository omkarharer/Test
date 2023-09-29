package automationproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest implements AutoI {
	
	static WebDriver driver ;
	
	public void openBrowser(String url)
	{
		System.setProperty(Edge_Key, Edge_Value);
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(url);
	}
	
	
	

}
