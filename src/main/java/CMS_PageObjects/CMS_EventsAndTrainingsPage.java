package CMS_PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class CMS_EventsAndTrainingsPage extends base {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	
	public CMS_EventsAndTrainingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Events")
	private WebElement Events;
	
	@FindBy(linkText="Create Event")
	private WebElement Create_Event;
	
	@FindBy(linkText="Trainings")
	private WebElement Trainings;
	
	@FindBy(linkText="Create Training")
	private WebElement Create_Training;
	
	@FindBy(linkText="Form Builder")
	private WebElement Form_Builder;
	
	@FindBy(linkText="Create Registration Form")
	private WebElement Create_Registration_Form;
	
	
	//Method
	
	public void clickEvents()
	{
		//Events.click();
		executor.executeScript("arguments[0].click();",Events);
	}
	
	
	public void clickCreate_Event()
	{
		Create_Event.click();
		//executor.executeScript("arguments[0].click();",Create_Event);
	}
	
	
	
	public void clickTrainings()
	{
		Trainings.click();
	}
	
	public void clickCreate_Training()
	{
		 Create_Training.click();
	}
	
	public void clickForm_Builder()
	{
		 Form_Builder.click();
	}
	
	public void clickCreate_Registration_Form()
	{
		 Create_Registration_Form.click();
	}
	
	
	
	
	

}
