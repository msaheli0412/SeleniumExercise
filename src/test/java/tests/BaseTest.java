package tests;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SearchCustomerPage;
import utility.Reusable;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage lp;
	public SearchCustomerPage searchCust;
	public Reusable reuse;
	public static Logger logger;
	
	@BeforeTest
	public void launchApp() throws Exception {
		//Logging
		logger=Logger.getLogger("nopCommerceDemoRun");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		System.out.println("launching application");		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		System.out.println("closing application");
		Thread.sleep(5000);
		driver.close();
		
	}

}
