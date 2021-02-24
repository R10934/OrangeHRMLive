package smapletest;
//package basepkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import basepkg.BaseHelper;

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
	//WebDriver driver;
	
	public loginTest() {
		//super();		
	}
		
	public boolean validLogin()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		WebElement ele = driver.findElement(By.id("txtUsername"));		
		ele.sendKeys("Admin");
		
		
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");		
		driver.findElement(By.id("btnLogin")).click();
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
		
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
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
		
		
		
		
		
	}
	
	
	@Test(enabled = false) 
	public void loginTest02()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard01");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
			
		
	}
	
	
	
	@Test(enabled = false)
	public void loginTest03()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123pkjbjb");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		AssertJUnit.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");
		
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
	
	
	@Test(enabled = false)
	public void loginTest05()
	{		
		
		if(validLogin())
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
		
		
		@Test
		public void loginTest06()
		{		
			
			if(validLogin())
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
