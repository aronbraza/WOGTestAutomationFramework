package CMS_PageObjects;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class CMS_EventsPage extends base  {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	 public CMS_EventsPage(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(className="errMsg")
	 private WebElement messageHolder_Text;
	 
	 @FindBy(css="[class=\"rightColumnContentHolder\"] table")
	 private List<WebElement> All_Events_List;
	 
	 @FindBy(css="table tr td:nth-child(2)")
	 private List<WebElement> eventName;
	 
	 @FindBy(css="table tr td:nth-child(3)")
	 private List<WebElement> eventSchedule;
	 
	 @FindBy(css="table tr td:nth-child(4)")
	 private List<WebElement> eventLocation;
	 
	 @FindBy(css="table tr td:nth-child(5)")
	 private List<WebElement> eventRegistrationDeadline;
	 
	 @FindBy(linkText="Edit")
	 private List<WebElement> Edit_Linktext;
	 
	 @FindBy(linkText="View Attendees")
	 private List<WebElement> View_Attendees_Linktext;
	 
	 @FindBy(linkText="Survey")
	 private List<WebElement> Survey_Linktext;
	 
	 @FindBy(linkText="Deactivate")
	 private List<WebElement> Deactivate_Linktext;
	 
	 @FindBy(linkText="Activate")
	 private List<WebElement> Activate_Linktext;
	 
	 @FindBy(linkText="Trash")
	 private List<WebElement> Trash_Linktext;
	 
	 @FindBy(className="pagination")
	 private List<WebElement> Pagination;
	 
	 @FindBy(linkText="Next")
	 private WebElement Next_Linktext;
	 
	//Create Event  Form
	
		@FindBy(id="pagePrivacy")
		private WebElement Event_Privacy_Dropdown;
		
		@FindBy(name="access[]")
		private List<WebElement> Allow_Registration_Checkbox;
		
		
		@FindBy(name="eventName")
		private WebElement Event_Name_Textbox;
		
		@FindBy(name="eventLocation")
		private WebElement Event_Location_Textbox;
		
		@FindBy(css="iframe[class*='cke_wysiwyg_frame']")
		private WebElement Event_Description_Iframe;
		
		@FindBy(tagName = "body")
		private WebElement EventDescription_Body;
		
		@FindBy(id="eventFormTemplate")
		private WebElement Registration_Form_Template_Dropdown;
		
		@FindBy(id="eventStartDate")
		private WebElement Event_Start_Date_Textbox;
		
		@FindBy(id="eventEndDate")
		private WebElement Event_End_Date_Textbox;
		
		//Date Picker Web element
		@FindBy(id="ui-datepicker-div")
		private WebElement Date_Picker;
		
		@FindBy(className="ui-datepicker-month")
		private WebElement Date_Picker_Month;
		
		@FindBy(className="ui-datepicker-year")
		private WebElement Date_Picker_Year;
		
		@FindBy(css="[class=\"ui-datepicker-next ui-corner-all\"]")
		private WebElement Date_Picker_Next_Button;
		
		@FindBy(className="ui-state-default")
		private List<WebElement> Date_Picker_Days;
		
		@FindBy(css="[class=\"ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all\"]")
		private WebElement Date_Picker_Done_Button;
		
		@FindBy(css="[class=\"ui_tpicker_hour\"] [class=\"ui-timepicker-select ui-state-default ui-corner-all\"]")
		private WebElement Date_Picker_Hour_Dropdown;
		
		@FindBy(css="[class=\"ui_tpicker_minute\"] [class=\"ui-timepicker-select ui-state-default ui-corner-all\"]")
		private WebElement Date_Picker_Minute_Dropdown;
		//Date Picker Web element
		
		@FindBy(id="eventRegStartDate")
		private WebElement Registration_Start_Date_Textbox;
		
		@FindBy(id="eventRegEndDate")
		private WebElement Registration_End_Date_Textbox;
		
		@FindBy(css="[class*=\"pres_material presentation_file_field\"]")
		private WebElement Event_Presentation_File_Field;
		
		@FindBy(css="[class=\"form-group\"] span")
		private WebElement Add_File_Button;
		
		@FindBy(className="pres-availability")
		private List<WebElement> Presentation_Materials_Availability_Radiobutton;
		
		//Availability Start
		@FindBy(id="lifetimeStartDate")
		private WebElement Lifetime_Start_Date_Textbox;
		
		
		@FindBy(id="customStartDate")
		private WebElement Custom_Start_Date_Textbox;
		
		@FindBy(id="customEndDate")
		private WebElement Custom_End_Date_Textbox;
		
		@FindBy(name="eventFeaturedImage")
		private WebElement Event_Featured_Image_Choose_File_Field;
		
		@FindBy(name="eventSurveyForm")
		private WebElement PEMC_Transactional_Sruvey_Dropdown;
		
		@FindBy(name="survey_required")
		private WebElement Survey_Required_Dropdown;
		
		@FindBy(name="allow_invitation")
		private WebElement Allow_Invitation_Checkbox;
		
		@FindBy(name="invitation-number")
		private WebElement Number_Of_Slots_Textbox;
		
		@FindBy(id="eventActivation")
		private WebElement Activate_Dropdown;
		
		@FindBy(id="createEventButton")
		private WebElement Add_Event_Button;

		@FindBy(css="table tbody tr")
		private List<WebElement> eventRow;
		
		public String getMessage_Holder_Text()
		{
			return messageHolder_Text.getText();
		}
		
		public ArrayList<String> getAll_Events_List()
		{
			List<String> getEvents_List = new ArrayList<String>();
			for(WebElement item: All_Events_List)
			{
				getEvents_List.add(item.getText());
			}
			
			return (ArrayList<String>) getEvents_List;
			
			
		}
		
		public String getEventName(String Event_Name)
		{
			String name="";
			
			for(int i=0; i<eventName.size(); i++)
			{
				if(eventName.get(i).getText().contains(Event_Name))
				{
					name = eventName.get(i).getText();
					break;
				}
			}
			return name;
		}
		
		public String getEventSchedule(String Event_Schedule)
		{
			String schedule="";
			
			for(int i=0; i<eventSchedule.size(); i++)
			{
				if(eventSchedule.get(i).getText().contains(Event_Schedule))
				{
					schedule = eventSchedule.get(i).getText();
					break;
				}
			}
			return schedule;
		}
		
		public String getEventLocation(String Event_Location)
		{
			String location="";
			
			for(int i=0; i<eventLocation.size(); i++)
			{
				if(eventLocation.get(i).getText().contains(Event_Location))
				{
					location = eventLocation.get(i).getText();
					break;
				}
			}
			return location;
		}
		
		public String priv()
		{
			return Event_Privacy_Dropdown.getText();
		}
		
		public String getEventRegistrationDeadline(String Event_Reg_Deadline)
		{
			String deadline="";
			
			for(int i=0; i<eventRegistrationDeadline.size(); i++)
			{
				if(eventRegistrationDeadline.get(i).getText().contains(Event_Reg_Deadline))
				{
					deadline = eventRegistrationDeadline.get(i).getText();
					break;
				}
			}
			return deadline;
		}
		
		public String getEventInfo(String Event_Name)
		{
			while(!getAll_Events_List().toString().contains(Event_Name))
			{
				Next_Linktext.click();
			}
			
			List<String> getEvent = new ArrayList<String>();
			for(int i=0; i<eventRow.size(); i++)
			{
				
				if(eventRow.get(i).getText().contains(Event_Name))
				{
					getEvent.add(eventRow.get(i).getText());
					break;
				}
				
			}
			return  getEvent.toString();
		}
		
		
		
		
		public void setEvent_Privacy_Dropdown(String Event_Privacy)
		{
			Select privacy = new Select(Event_Privacy_Dropdown);
			privacy.selectByVisibleText(Event_Privacy);
			
		}
		
		public void clickWCO_Checkbox(String Event_Privacy)
		{
			if(Event_Privacy_Dropdown.getAttribute("value").equalsIgnoreCase(Event_Privacy))
			{
				Allow_Registration_Checkbox.get(0).click();
				
			}
		}
		
		public void clickAllow_Registration_Checkbox(String Allow_For)
		{
			for(int i=0; i<Allow_Registration_Checkbox.size(); i++)
			{
				if(Allow_Registration_Checkbox.get(i).getAttribute("value").equalsIgnoreCase(Allow_For))
				{
					Allow_Registration_Checkbox.get(i).click();
				}
			}
		}
		
		public void setEvent_Name_Textbox(String Event_Name)
		{
			Event_Name_Textbox.clear();
			Event_Name_Textbox.sendKeys(Event_Name);
		}
		
		public void setEvent_Location_Textbox(String Event_Location)
		{
			Event_Location_Textbox.clear();
			Event_Location_Textbox.sendKeys(Event_Location);
		}
		

		public void set_Event_Description_Textbox(String Event_Description)
		{
			driver.switchTo().frame(Event_Description_Iframe);
			//EventDescription_Body.clear();
			EventDescription_Body.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			EventDescription_Body.sendKeys(Event_Description);
			driver.switchTo().defaultContent();
		}
		
		public void setRegistration_Form_Template_Dropdown(String Registration_Form_Template)
		{
			Select Registration_Form = new Select(Registration_Form_Template_Dropdown);
			Registration_Form.selectByVisibleText(Registration_Form_Template);
		}
		
		public void setEvent_Start_Date_Textbox(String Event_StartDate)
		{
			Event_Start_Date_Textbox.clear();
			Event_Start_Date_Textbox.sendKeys(Event_StartDate);
		}
		
		public void setEvent_End_Date_Textbox(String Event_End_Date)
		{
			Event_End_Date_Textbox.clear();
			Event_End_Date_Textbox.sendKeys(Event_End_Date);
		}
		
		public void setRegistration_Start_Date_Textbox(String Registration_Start_Date)
		{
			Registration_Start_Date_Textbox.clear();
			Registration_Start_Date_Textbox.sendKeys(Registration_Start_Date);
		}
		
		public void setRegistration_End_Date_Textbox(String Registration_End_Date)
		{
			Registration_End_Date_Textbox.clear();
			Registration_End_Date_Textbox.sendKeys(Registration_End_Date);
		}
		
		public void setDate_On_Presentation_Materials(String Lifetime_Start_Date, String Custom_Start_Date, String Custom_End_Date)
		{
			if(Presentation_Materials_Availability_Radiobutton.get(0).isSelected())
			{
				Lifetime_Start_Date_Textbox.clear();
				Lifetime_Start_Date_Textbox.sendKeys(Lifetime_Start_Date);
				Date_Picker_Done_Button.click();
			}
			else if(Presentation_Materials_Availability_Radiobutton.get(1).isSelected())
			{
				Custom_Start_Date_Textbox.clear();
				Custom_Start_Date_Textbox.sendKeys(Custom_Start_Date);
				
				Custom_End_Date_Textbox.clear();
				Custom_End_Date_Textbox.sendKeys(Custom_End_Date);
				Date_Picker_Done_Button.click();
			}
		}
			
		
		
		//Code for selecting date on datepicker.
		/*
		public void selectEvent_Start_Date(String Month, String Day, String Hour, String Minute)
		{
			Event_Start_Date_Textbox.click();
			while(!Date_Picker_Month.getText().contains(Month))
			{
				executor.executeScript("arguments[0].click();", Date_Picker_Next_Button);
			}
			
			for(int i=0; i<Date_Picker_Days.size(); i++)
			{
				String day = Date_Picker_Days.get(i).getText();
				if(day.equals(Day))
				{
					Date_Picker_Days.get(i).click();
					break;
				}
			}
			
			Select hour = new Select(Date_Picker_Hour_Dropdown);
			hour.selectByVisibleText(Hour);
			Select minute = new Select(Date_Picker_Minute_Dropdown);
			minute.selectByVisibleText(Minute);
			Date_Picker_Done_Button.click();
		}
		*/

		
		public void clickPresentation_Materials_Radiobutton(String Availability)
		{
			for(int i=0; i<Presentation_Materials_Availability_Radiobutton.size(); i++)
			{
				if(Presentation_Materials_Availability_Radiobutton.get(i).getAttribute("value").equalsIgnoreCase(Availability))
				{
					Presentation_Materials_Availability_Radiobutton.get(i).click();
					break;
				}
			}
		}
		
		public void uploadPresentation_Materials(String FilePath) throws InterruptedException, IOException
		{
			Event_Presentation_File_Field.sendKeys(FilePath);

		}
		
		
		public void uploadFeatured_Image(String ImagePath)
		{
			Event_Featured_Image_Choose_File_Field.sendKeys(ImagePath);
		}
		
		public void setPEMC_Transactional_Survey(String Survey)
		{
			Select survey = new Select(PEMC_Transactional_Sruvey_Dropdown);
			survey.selectByVisibleText(Survey);
		}
		
		public void setSurvey_Required_Dropdown(String SurveyReq)
		{
			try 
			{
				Select value = new Select(Survey_Required_Dropdown);
				value.selectByVisibleText(SurveyReq);
			} catch (ElementNotInteractableException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public void clickAllow_Invitation()
		{
			
			Allow_Invitation_Checkbox.click();
			//executor.executeScript("arguments[0].click();", Allow_Invitation_Checkbox);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		public void setNumber_Of_Slots_Textbox(String Slots)
		{
			if(Allow_Invitation_Checkbox.isSelected())
			{
				wait.until(ExpectedConditions.visibilityOf(Number_Of_Slots_Textbox)).clear();
				//Number_Of_Slots_Textbox.clear();
				Number_Of_Slots_Textbox.sendKeys(Slots);
			}
		}
		
		public void setActivate_Dropdown(String Activate)
		{
			Select value = new Select(Activate_Dropdown);
			value.selectByVisibleText(Activate);
		}
		
		public void clickAdd_Event_Button()
		{
			Add_Event_Button.click();
			//executor.executeScript("arguments[0].click();", Add_Event_Button);
		}
		
		
		
		
		


}
