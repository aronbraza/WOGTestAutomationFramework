package WOG;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.values.StringEnumValue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CMS_PageObjects.CMS_LoginPage;
import TestData.ExcelConfig;
import TestData.LoginTestData;
import resources.base;

public class CMS_LoginTest extends base {
	
	public static Logger log = LogManager.getLogger(CMS_LoginTest.class.getName());
	 
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Initialized driver.");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to "+prop.getProperty("URL"));
	}
	
	
	@Test(dataProvider="L_00", dataProviderClass=LoginTestData.class)
	public void loginToCMS(String Username, String Password, String Results) throws InterruptedException
	{
		CMS_LoginPage cmsLogin_Page = new CMS_LoginPage(driver);
		cmsLogin_Page.setUsername_Textbox(Username);
		cmsLogin_Page.setPassword_Textbox(Password);
		cmsLogin_Page.clickLogin_Button();
		Assert.assertEquals(cmsLogin_Page.getError_Message_Text(), Results);
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver = null;
	}

}
