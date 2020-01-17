package WOG;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import CMS_PageObjects.CMS_EventsAndTrainingsPage;
import CMS_PageObjects.CMS_EventsPage;
import CMS_PageObjects.CMS_HomePage;
import CMS_PageObjects.CMS_LoginPage;
import TestData.DataProviderTestData;
import TestData.ExcelUtil;
import Utilities.Utilities;
import resources.base;

public class CMS_EventsAndTrainingsTest extends base {
	
	public static Logger log = LogManager.getLogger(CMS_EventsAndTrainingsTest.class.getName());

	

	@BeforeTest()
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Initialized driver");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to "+System.getProperty("URL"));
	}
	
	@Test(priority=1, dataProvider="CMSLoginTestData1", dataProviderClass=DataProviderTestData.class)
	public void login(String Username, String Password)
	{
		CMS_LoginPage cmsLogin_Page = new CMS_LoginPage(driver);
		cmsLogin_Page.setUsername_Textbox(Username);
		cmsLogin_Page.setPassword_Textbox(Password);
		cmsLogin_Page.clickLogin_Button();
	}
	
	/*
	@Test(dataProvider="CreateEventTestData1", dataProviderClass=DataProviderTestData.class)
	public void verifyCreateEvents(String Event_Privacy, String Event_Name, String Event_Location, String Event_Description, String Registration_Form_Template, String Event_StartDate, String Event_End_Date, String Registration_Start_Date, String Registration_End_Date, String FilePath, String Availability,  String Lifetime_Start_Date, String Custom_Start_Date, String Custom_End_Date,  String ImagePath, String Survey, String SurveyReq, String Slots, String Activate, String Message) throws ParseException
	{
		Utilities utilities = new Utilities();
		CMS_HomePage cmsHome_Page = new CMS_HomePage(driver);
		CMS_EventsAndTrainingsPage cmsEvents_And_TrainingsPage = new CMS_EventsAndTrainingsPage(driver);
		CMS_EventsPage cmsEvents_Page = new CMS_EventsPage(driver);
		cmsHome_Page.clickEvents_And_Trainings();
		cmsEvents_And_TrainingsPage.clickEvents();
		
		System.out.println(cmsEvents_Page.getEventName(Event_Name));
		System.out.println(cmsEvents_Page.getEventSchedule(utilities.ConvertDate(Event_StartDate)+" - "+utilities.ConvertDate(Event_End_Date)));
		System.out.println(cmsEvents_Page.getEventLocation(Event_Location));
		System.out.println(cmsEvents_Page.getEventRegistrationDeadline(utilities.ConvertDate(Registration_Start_Date)+" - "+utilities.ConvertDate(Registration_End_Date)));
		Assert.assertTrue(cmsEvents_Page.getEventName(Event_Name).contains(Event_Name));
		Assert.assertEquals(cmsEvents_Page.getEventSchedule(utilities.ConvertDate(Event_StartDate)+" - "+utilities.ConvertDate(Event_End_Date)), utilities.ConvertDate(Event_StartDate)+" - "+utilities.ConvertDate(Event_End_Date));
		Assert.assertEquals(cmsEvents_Page.getEventLocation(Event_Location), Event_Location);
		Assert.assertEquals(cmsEvents_Page.getEventRegistrationDeadline(utilities.ConvertDate(Registration_Start_Date)+" - "+ utilities.ConvertDate(Registration_End_Date)) , utilities.ConvertDate(Registration_Start_Date)+" - "+utilities.ConvertDate(Registration_End_Date));
	}
	*/
	
	
	@Test(priority=2,dataProvider="CreateEventTestData", dataProviderClass=DataProviderTestData.class)
	public void CreateEvent(String Event_Privacy, String Event_Name, String Event_Location, String Event_Description, String Registration_Form_Template, String Event_StartDate, String Event_End_Date, String Registration_Start_Date, String Registration_End_Date, String FilePath, String Availability,  String Lifetime_Start_Date, String Custom_Start_Date, String Custom_End_Date,  String ImagePath, String Survey, String SurveyReq, String Slots, String Activate, String Message ) throws InterruptedException, IOException
	{
		driver.get(prop.getProperty("URL"));
		CMS_HomePage cmsHome_Page = new CMS_HomePage(driver);
		CMS_EventsAndTrainingsPage cmsEvents_And_TrainingsPage = new CMS_EventsAndTrainingsPage(driver);
		CMS_EventsPage cmsEvents_Page = new CMS_EventsPage(driver);
		cmsHome_Page.clickEvents_And_Trainings();
		cmsEvents_And_TrainingsPage.clickEvents();
		cmsEvents_And_TrainingsPage.clickCreate_Event();
		cmsEvents_Page.setEvent_Privacy_Dropdown(Event_Privacy);
		cmsEvents_Page.clickWCO_Checkbox(Event_Privacy);
		cmsEvents_Page.setEvent_Name_Textbox(Event_Name);
		cmsEvents_Page.setEvent_Location_Textbox(Event_Location);
		cmsEvents_Page.set_Event_Description_Textbox(Event_Description);
		cmsEvents_Page.setRegistration_Form_Template_Dropdown(Registration_Form_Template);
		cmsEvents_Page.setEvent_Start_Date_Textbox(Event_StartDate);
		cmsEvents_Page.setEvent_End_Date_Textbox(Event_End_Date);
		cmsEvents_Page.setRegistration_Start_Date_Textbox(Registration_Start_Date);
		cmsEvents_Page.setRegistration_End_Date_Textbox(Registration_End_Date);
		cmsEvents_Page.uploadPresentation_Materials(FilePath);
		cmsEvents_Page.clickPresentation_Materials_Radiobutton(Availability);
		cmsEvents_Page.setDate_On_Presentation_Materials(Lifetime_Start_Date, Custom_Start_Date, Custom_End_Date);
		cmsEvents_Page.setPEMC_Transactional_Survey(Survey);
		cmsEvents_Page.setSurvey_Required_Dropdown(SurveyReq);
		cmsEvents_Page.clickAllow_Invitation();
		cmsEvents_Page.setNumber_Of_Slots_Textbox(Slots);
		cmsEvents_Page.setActivate_Dropdown(Activate);
		cmsEvents_Page.clickAdd_Event_Button();
		assertEquals(cmsEvents_Page.getMessage_Holder_Text(), Message);
		//Thread.sleep(3000);

	}
	
	
	
	
	/*
	@Test(priority=3)
	public void Edit_Event() throws InterruptedException, IOException
	{
		CMS_HomePage cmsHome_Page = new CMS_HomePage(driver);
		CMS_EventsAndTrainingsPage cmsEvents_And_TrainingsPage = new CMS_EventsAndTrainingsPage(driver);
		CMS_EventsPage cmsEvents_Page = new CMS_EventsPage(driver);
		
		cmsHome_Page.clickEvents_And_Trainings();
		cmsEvents_And_TrainingsPage.clickEvents();
		cmsEvents_Page.clickEdit_Linktext("WOG Sample Event");
		cmsEvents_Page.setEvent_Privacy_Dropdown("Public");
		cmsEvents_Page.setEvent_Name_Textbox("PEMC Event 2020");
		cmsEvents_Page.setEvent_Location_Textbox("Ortigas");
		cmsEvents_Page.set_Event_Description_Textbox("lorem ipsum");
		cmsEvents_Page.setRegistration_Form_Template_Dropdown("PEMC Event");
		cmsEvents_Page.selectEvent_Start_Date("May", "28", "12", "40");
		cmsEvents_Page.selectEvent_End_Date("May", "31", "05", "30");
		cmsEvents_Page.selectRegistration_Start_Date("January", "20", "07", "00");
		cmsEvents_Page.selectRegistration_End_Date("May", "27", "11", "59");
		cmsEvents_Page.uploadPresentation_Materials("C:\\Users\\OJT - Project Sec1\\eclipse-workspace\\WOGTestAutomationFramework\\sample files\\Dummy PDF.pdf");
		cmsEvents_Page.clickPresentation_Materials_Radiobutton("Custom");
		cmsEvents_Page.selectCustom_Start_Date("June", "1", "07", "00");
		cmsEvents_Page.selectCustom_End_Date("July", "2", "11", "30");
		cmsEvents_Page.uploadFeatured_Image("C:\\Users\\OJT - Project Sec1\\eclipse-workspace\\WOGTestAutomationFramework\\sample files\\1.jpg");
		cmsEvents_Page.setPEMC_Transactional_Survey("PEMC Survey Form");
		cmsEvents_Page.setSurvey_Required_Dropdown("Required");
		cmsEvents_Page.clickAllow_Invitation();
		cmsEvents_Page.setNumber_Of_Slots_Textbox("2");
		cmsEvents_Page.setActivate_Dropdown("Yes");
		
	
		//Thread.sleep(3000);
	}
	*/
	
	@AfterTest()
	public void tearDown() throws IOException
	{
		//driver.close();
		driver.quit();
		driver = null;
	}
}
