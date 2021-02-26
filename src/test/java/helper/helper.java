package helper;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import pageObject.HrmLoginPagePageFactoryExample;

public class helper {
	
	
	public static boolean isLoginSuccessful( WebDriver driver,  String siteURL, String UserName, String Password, String ExpectedURL)
	{
		boolean returnValue = true;
		
		driver.get(siteURL);
		
		new HrmLoginPagePageFactoryExample(driver).LoginOnHRM(UserName, Password);
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), ExpectedURL);
		
//		if()
//		{
//			returnValue = true;
//		}
//		else
//		{
//			returnValue = false;
//		}
//		
		return returnValue;
		
		
//		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//		login.LoginOnHRM(validUserName, validPwd);	
//		
//		
//		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
//		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
//		
//		return true;
	}

}
