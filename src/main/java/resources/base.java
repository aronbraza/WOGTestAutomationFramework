package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		 prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			
			//String browserName =  System.getProperty("browser");
			String browserName = prop.getProperty("browser");
			
			if(browserName.contains("Chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				//Run test in headless mode.
				//if(browserName.contains("Headless")) 
				//{
					options.addArguments("headless");
				//}
				driver = new ChromeDriver(options);
				
				
			}
			
			else if(browserName.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			
			else if(browserName.equals("Internet Explorer"))
			{
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
	}
	
	public void getScreenShot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshot\\"+result+" Screenshot.png"));
		
	}

}
