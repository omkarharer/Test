package rpulse;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class RpulseDec implements Iauto {

	protected static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		// System.setProperty("webdriver.msedge.driver", "./drivers/msedgedriver.exe");

		EdgeOptions options = new EdgeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new EdgeDriver(options);
		driver.manage().window().maximize();

		driver.get(ehlf_rpulse_url);
		RpulsePOMDec r = new RpulsePOMDec(driver);
		r.login();
		r.provisionalItCertificate();

		  r.welcomeLetter(); r.voucherAccountingInvoiceGeneration();
		  r.partPrePayment(); r.disbursalLetter(); r.finalItCertificate();
		  r.disbursalLetter(); r.finalItCertificateNonHl();
		  r.provisionalItCertificateNonhl(); r.finalItCertificateForClosed(); r.soa();
		  r.dunningNotice(); r.dunningLetter2(); r.repaymentSchedule();
		  
		  r.rejectLetter();
		  
		  r.documentCustodyRecord();
		  r.welcomeKit();
		  r.miniMillion();
		//r.smeRejectLetter();

		r.dsaOracleEntryInvoiceGeneration(); r.vendorOracleEntryInvoiceGeneration();
		r.cancelLetter(); r.panNumberRequired(); r.mortgageLoanClosure();
		r.nonmortgageLoanClosure(); r.fcLod(); r.dunningLetter1(); r.softNotice();
		r.noticeWithMoratorium(); r.repricingLetter(); r.preSarfeasiNotice();
		r.reminderDunningNotice(); r.reminderSoftNotice();
		r.reminderPreSarfeasiNotice(); r.nonMortgageSettlementLoanClosure();
		r.mortgageSettlementLoanClosure();
	}
}
