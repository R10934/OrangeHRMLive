package smapletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import basepkg.BaseHelper;
import pageObject.HrmLoginPage;
import pageObject.HrmLoginPagePageFactoryExample;

import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest extends BaseHelper {
	
	HrmLoginPage login;
	HrmLoginPagePageFactoryExample loginFactoryPage;
	
	String validUserName = "Admin";
	String invalidUserName = "Admin01";
	
	String validPwd = "admin123";
	String invalidPwd = "Admin01mkjnhghhjjb";
	
	
	
	
	
	public loginTest() {
		super();
		login = new HrmLoginPage(driver);
		loginFactoryPage =  new HrmLoginPagePageFactoryExample(driver);
	}
	
	
	//@AfterMethod
	@AfterTest
	public void tearDown()
	{		
		driver.close();
	}
	
	
		
	public boolean isLoginSuccessful()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		login.LoginOnHRM(validUserName, validPwd);	
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
		
		return true;
	}
	
	
	@Test(enabled = true)
	public void loginTest01()
	{		
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		login.LoginOnHRM(validUserName, validPwd);	
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");		
		
	}
	
	
	@Test(enabled = true) 
	public void loginTest02()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		loginFactoryPage.LoginOnHRM(validUserName, validPwd);	
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	
	
	
	@Test(enabled = false)
	public void loginTest03()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		login.LoginOnHRM(validUserName, invalidPwd);	
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		AssertJUnit.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");
		
		//Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	
	
	
	@Test(enabled = false)
	public void loginTest04()
	{
		
		if(isLoginSuccessful())
		{
			WebElement mainmenu = driver.findElement(By.id("mainMenu"));
			
			System.out.println(mainmenu.getText());
		}	
		
		
	}
	
	
	@Test(enabled = false)
	public void loginTest05()
	{		
		
		if(isLoginSuccessful())
		{
			WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
			admin.click();
			
			AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
			
			driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");;
			
			driver.findElement(By.id("searchBtn")).click();
			
			
			
			
			WebElement resultTable = driver.findElement(By.id("resultTable"));
			
			
			List<WebElement> headerRows = resultTable.findElements(By.xpath(".//thead/tr/th"));
			
			for (WebElement webElement : headerRows) {
				
				System.out.println(webElement.getText());
				
			}
			
			AssertJUnit.assertEquals(headerRows.size(), 5);
			
			AssertJUnit.assertEquals(headerRows.get(1).getText(), "Username"); // 1. User Name  2. UserName 3. UN 4. username 5. UserN@me
			
			//System.out.println(headerRows.get(1).getText());
			AssertJUnit.assertNotNull(headerRows.get(1).getText(), "User Name can't ne empty");
			
			Assert.assertNotEquals(headerRows.get(1).getText(), "User Name");
		}
		
			
			
		}	
		
		
		@Test(enabled = false)
		public void loginTest06()
		{		
			
			if(isLoginSuccessful())
			{
				
				driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b")).click();
				
				WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
				admin.click();
				
				AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
				
				driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");
				
				Select dropdown = new Select(driver.findElement(By.id("searchSystemUser_status")));
				
				List<WebElement>  dropdownOptions = dropdown.getOptions();
				
				for (WebElement webElement : dropdownOptions) {
					System.out.println(webElement.getText());
				}
				
				
				
				
				
				driver.findElement(By.id("searchBtn")).click();
				
				
				
				
				WebElement resultTable = driver.findElement(By.id("resultTable"));
				
				
				List<WebElement> headerRows = resultTable.findElements(By.xpath(".//thead/tr/th"));
				
				for (WebElement webElement : headerRows) {
					
					System.out.println(webElement.getText());
					
				}
				
				AssertJUnit.assertEquals(headerRows.size(), 5);
				
				AssertJUnit.assertEquals(headerRows.get(1).getText(), "Username"); // 1. User Name  2. UserName 3. UN 4. username 5. UserN@me
				
				//System.out.println(headerRows.get(1).getText());
				AssertJUnit.assertNotNull(headerRows.get(1).getText(), "User Name can't ne empty");
				
				Assert.assertNotEquals(headerRows.get(1).getText(), "User Name");
				
				
				
				
			
				
				
			}	
			
			
		
		
	}
	
	
	

}
