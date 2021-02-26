package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HrmLoginPage {

	WebDriver driver;
	
	By txtUn = By.id("txtUsername");
	By txtPwd = By.id("txtPassword");
	By btnLg = By.id("btnLogin");
	
	
	public HrmLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	void setUn(String UserName)
	{
		driver.findElement(txtUn).sendKeys(UserName);
	}
	
	
	void setPwd(String Password)
	{
		driver.findElement(txtPwd).sendKeys(Password);
	}
	
	void clickOnBtn()
	{
		driver.findElement(btnLg).click();
	}
	
	
	public void LoginOnHRM(String UserName, String Password) {
		
		setUn(UserName);
		setPwd(Password);
		
		clickOnBtn();
		
	}
}
