package smapletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {
	
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
	public void tearDown()
	{		
		driver.quit();
	}
	
	
	@Test(enabled = false)
	public void alertTest01()
	{
		driver.get("https://demoqa.com/alerts");
		
		
		driver.findElement(By.id("alertButton")).click();
		
		
		Alert simpleAlert = driver.switchTo().alert();
		
		System.out.println(simpleAlert.getText());
		
		simpleAlert.accept();
		
	}
	
	
	
	@Test(enabled = false)
	public void alertTest02()
	{
		driver.get("https://demoqa.com/alerts");
		
		
		WebElement element = 	driver.findElement(By.id("promtButton"));		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		
		
		Alert simpleAlert = driver.switchTo().alert();
		
		simpleAlert.sendKeys("Hello I am Here to learn");
		
		//System.out.println(simpleAlert.getText());
		
		simpleAlert.accept();
		
	}
	
	
	@Test
	public void radioBtnTest01()
	{
		driver.get("https://demoqa.com/radio-button");
		
		
	//	WebElement element = 	driver.findElement(By.xpath("//input[@type=\"radio\" and @name= \"like\"]"));		
	
		WebElement element = 	driver.findElement(By.xpath("//input[contains(@name,\"lik\")]"));	
		
		System.out.println(element.getText());
		
		System.out.println(element.getSize());
		
			
	}
	
	
	

}
