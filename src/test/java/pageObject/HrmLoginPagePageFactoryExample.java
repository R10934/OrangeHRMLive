package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrmLoginPagePageFactoryExample {
	
	WebDriver driver;
	
	@FindBy(id="txtUsername")
	WebElement txtUserName;
	
	
	@FindBy(id="txtPassword")
	WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	
	public HrmLoginPagePageFactoryExample(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	void setUn(String UserName)
	{
		txtUserName.sendKeys(UserName);
	}
	
	
	void setPwd(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	
	void clickOnBtn()
	{
		btnLogin.click();
	}
	
	
	public void LoginOnHRM(String UserName, String Password) {
		
		setUn(UserName);
		setPwd(Password);
		
		clickOnBtn();
		
	}

	
	
	
	
	
	
}
