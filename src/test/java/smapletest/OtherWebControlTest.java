package smapletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OtherWebControlTest {

	
	static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		
		driver = new FirefoxDriver();				
		driver.manage().window().maximize();
		
		//driver.navigate().to(URL VAlue);
		
	
		}
	
	
	
	@AfterMethod
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
		
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
		
		return true;
	}
	
	
	@Test
	public void OtherControlTest01()
	{
		
		if(validLogin())
		{
		
		
		driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule > b")).click();
	   
		driver.findElement(By.id("menu_leave_viewLeaveList")).click();
	    driver.findElement(By.id("leaveList_chkSearchFilter_-1")).click();
	    driver.findElement(By.id("leaveList_cmbSubunit")).click();
	    
	    
	    
	    {
	      WebElement dropdown = driver.findElement(By.id("leaveList_cmbSubunit"));
	      //dropdown.findElement(By.xpath("//option[. = 'regexp:\\s+Technical Support']")).click();
	      
	      
	      Select dd = new Select(dropdown);
	      
	      
	      for (WebElement iterable_element : dd.getOptions()) {
	    	  
	    	  System.out.println(iterable_element.getText() + "---" + iterable_element.getAttribute("value"));			
		}
	      
	      dd.selectByIndex(0);
	      
	      dd.selectByVisibleText("Finance");
	      
	      
	      System.out.println(dd.isMultiple());
	      
	      
	      
	      
	      
	    }
	    driver.findElement(By.id("leaveList_cmbSubunit")).click();
	    driver.findElement(By.id("btnSearch")).click();
	}
	}
	
	
	@Test
	public void OtherControlTest02()
	{
		
		if(validLogin())
		{
		
		
		driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule > b")).click();
	    driver.findElement(By.id("menu_leave_viewLeaveList")).click();
	    driver.findElement(By.id("leaveList_chkSearchFilter_-1")).click();
	    driver.findElement(By.id("leaveList_cmbSubunit")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("leaveList_cmbSubunit"));
	      //dropdown.findElement(By.xpath("//option[. = 'regexp:\\s+Technical Support']")).click();
	      
	      
	      Select dd = new Select(dropdown);
	      
	      
	      for (WebElement iterable_element : dd.getOptions()) {
	    	  
	    	  System.out.println(iterable_element.getText() + "---" + iterable_element.getAttribute("value"));			
		}
	      
	      dd.selectByValue("2");    
	      
	      
	      
	      
	      
	    }
	    driver.findElement(By.id("leaveList_cmbSubunit")).click();
	    driver.findElement(By.id("btnSearch")).click();
	}
	}
	
}
