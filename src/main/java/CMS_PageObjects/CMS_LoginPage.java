package CMS_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMS_LoginPage {
	
	
	
	public CMS_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement Username_Textbox;
	
	@FindBy(name="password")
	private WebElement Password_Textbox;
	
	@FindBy(name="login")
	private WebElement Login_Button;
	

	public void setUsername_Textbox(String Username)
	{
		Username_Textbox.sendKeys(Username);
	}
	
	public void setPassword_Textbox(String Password)
	{
		
		 Password_Textbox.sendKeys(Password);
	}
	
	public void clickLogin_Button()
	{
		Login_Button.click();
	}
	
	
	

}
