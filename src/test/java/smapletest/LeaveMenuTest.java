package smapletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LeaveMenuTest {
	
	  private WebDriver driver;
	
	
	  @BeforeTest
	  public void setUp() {
		  
		System.setProperty("webdriver.gecko.driver.driver", "./geckodriver.exe");		
		driver = new FirefoxDriver();		
			
		driver.manage().window().maximize();
		  
		  
	    //driver = new ChromeDriver();
	    //js = (JavascriptExecutor) driver;
	    //vars = new HashMap<String, Object>();
	  }
	  
	  @AfterTest
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  
	  @Test
	  public void myTest() {
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	    
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    
	    driver.findElement(By.id("btnLogin")).click();
	    
	    
	    ////
	    
	    driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule > b")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
	    
	    
	    driver.findElement(By.xpath("//input[@id=\"calFromDate\"]")).sendKeys("1990-01-01");
	    driver.findElement(By.xpath("//input[@id=\"calToDate\"]")).sendKeys("2022-12-01");
	    
	    
	    WebElement ele =  driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
	    
	    
	  if(ele.isSelected())
	  {
		  ele.click();
		  
		  
	  }
	  
	  
	    
	  driver.findElement(By.name("btnSearch"));
	    
	    
	  }


}
