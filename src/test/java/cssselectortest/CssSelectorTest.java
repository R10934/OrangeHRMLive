package cssselectortest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CssSelectorTest {
	
static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		
		driver = new FirefoxDriver();				
		driver.manage().window().maximize();
	
	}
	
	
	@AfterMethod
	@AfterTest
	public void tearDown() throws InterruptedException
	{		
	
		Thread.sleep(1000);
		driver.quit();
	}
	
	
		
	@Test(enabled = true)
	public void cssTest01()
	{
		
		
		driver.get("https://demoqa.com/text-box");
		
		
		
		//css=<HTML tag><#><Value of ID attribute>
		WebElement newEle = driver.findElement(By.cssSelector("input#userName"));
		newEle.sendKeys("Srikanth");
		
		
		//css=<HTML tag><.><Value of Class attribute>
		newEle = driver.findElement(By.cssSelector("textarea.form-control"));
		newEle.sendKeys("Fake Street, Fake Country , Fake Postcode 0000001");
		
		
		//css=<HTML tag><[attribute=Value of attribute]>
		newEle = driver.findElement(By.cssSelector("input[type=email]"));
		newEle.sendKeys("Srikanth01@gmail.com");
		
		//Inner String - syntax - css=<HTML tag><:><contains><(text)>
//		newEle = driver.findElement(By.cssSelector("textarea:'control'"));
//		newEle.sendKeys("----------------------------------------- ");
//		newEle.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ");
//		
		
		

//Sub-String - syntax -  
// -- Matching a prefix - css=<HTML tag><[attribute^=prefix of the string]>
// -- Matching a suffix - css=<HTML tag><[attribute$=suffix of the string]>
// -- Matching a substring - css=<HTML tag><[attribute*=sub string]>

		// -- Matching a prefix - css=<HTML tag><[attribute^=prefix of the string]>
		
		newEle = driver.findElement(By.cssSelector("textarea[id^='perm']"));
		newEle.sendKeys("Hello Srikanth I live here permamnet ");
		
		
		newEle = driver.findElement(By.cssSelector("textarea[id$='ress']"));
		newEle.sendKeys("New Addree entert here ");
		
		
		newEle = driver.findElement(By.cssSelector("textarea[id*='ntAdd']"));
		newEle.sendKeys("Anither Addree entert here - hello");

		
		
		
		
		
		
		
		
		
		
	}

}
