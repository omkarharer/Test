package rpulse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Test implements Iauto {
	
	protected static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


		EdgeOptions options = new EdgeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new EdgeDriver(options);
		driver.manage().window().maximize();

		driver.get(ehlf_rpulse_url);
		RpulsePOM r = new RpulsePOM (driver);
		r.login();
		r.provisionalItCertificate();
		 r.rejectLetter();
		  
		  r.documentCustodyRecord();
		


	}

}
