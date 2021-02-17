package smapletest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest {
	
	static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		
		driver = new FirefoxDriver();				
		driver.manage().window().maximize();
		
		//driver.navigate().to(URL VAlue);
		
	
		
	}
	
	
	
	@AfterTest
	public void tearDown()
	{		
		driver.quit();
	}
	
	
	public boolean validLogin()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		WebElement ele = driver.findElement(By.id("txtUsername"));		
		ele.sendKeys("Admin");
		
		
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");		
		driver.findElement(By.id("btnLogin")).click();
		
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		return true;
	}
	
	
	@Test(enabled = false)
	public void loginTest01()
	{
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		
		
		
		
	}
	
	
	@Test(enabled = false) 
	public void loginTest02()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard01");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	
	
	
	@Test(enabled = false)
	public void loginTest03()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123pkjbjb");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");
		
		//Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	
	
	
	@Test(enabled = false)
	public void loginTest04()
	{
		
		if(validLogin())
		{
			WebElement mainmenu = driver.findElement(By.id("mainMenu"));
			
			System.out.println(mainmenu.getText());
		}	
		
		
	}
	
	
	@Test
	public void loginTest05()
	{		
		
		if(validLogin())
		{
			WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
			admin.click();
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
			
			driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");;
			
			driver.findElement(By.id("searchBtn")).click();
			
			
			
			
			WebElement resultTable = driver.findElement(By.id("resultTable"));
			
			
			List<WebElement> headerRows = resultTable.findElements(By.xpath(".//thead/tr/th"));
			
			for (WebElement webElement : headerRows) {
				
				System.out.println(webElement.getText());
				
			}
			
			Assert.assertEquals(headerRows.size(), 5);
			
			Assert.assertEquals(headerRows.get(1).getText(), "Username1");
			
			//System.out.println(headerRows.get(1).getText());
			
			
			
			
			
		
			
			
		}	
		
			
		
		
	}
	
	
	

}
