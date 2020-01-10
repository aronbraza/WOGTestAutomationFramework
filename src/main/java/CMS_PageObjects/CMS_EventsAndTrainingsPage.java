package CMS_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class CMS_EventsAndTrainingsPage extends base {
	

	
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
		Events.click();
	}
	
	public void clickCreate_Event()
	{
		Create_Event.click();
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
