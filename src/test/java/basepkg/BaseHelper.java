package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseHelper {

	protected WebDriver driver;
	
	public BaseHelper() {
		
		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		
		driver = new FirefoxDriver();				
		driver.manage().window().maximize();
	}	
	
	
//	@AfterMethod
//	@AfterTest
//	public void tearDown()
//	{		
//		driver.quit();
//	}
	
	
}
