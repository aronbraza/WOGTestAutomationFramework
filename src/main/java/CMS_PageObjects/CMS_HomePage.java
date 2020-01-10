package CMS_PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CMS_HomePage   {
	
	public CMS_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class=\"userHolder\"] span")
	private WebElement Username;
	
	@FindBy(xpath="//a[@href=\"profile.php?myid=1\"]")
	private WebElement My_Profile;
	
	@FindBy(linkText="Logout")
	private WebElement Logout;
	
	@FindBy(linkText="Dashboard")
	private WebElement Dashboard;
	
	@FindBy(linkText="Users")
	private WebElement Users;
	
	@FindBy(linkText="Members")
	private WebElement Members;
	
	@FindBy(linkText="Sections")
	private WebElement Sections;
	
	@FindBy(linkText="Pages")
	private WebElement Pages;
	
	@FindBy(linkText="Market Graphs")
	private WebElement Market_Graphs;
	
	@FindBy(linkText="Market Downloads")
	private WebElement Market_Downloads;
	
	@FindBy(linkText="Events & Trainings")
	private WebElement Events_And_Trainings;
	
	@FindBy(linkText="Jobs")
	private WebElement Jobs;
	
	@FindBy(linkText="News & Updates")
	private WebElement News_And_Updates;
	
	@FindBy(linkText="Extras")
	private WebElement Extras;
	
	//Methods
	
	public WebElement getUsername()
	{
		return Username;
	}
	
	public void clickMy_Profile()
	{
		My_Profile.click();
	}
	
	public void clickLogout()
	{
		Logout.click();
	}
	
	
	
	public void clickDashboard()
	{
		Dashboard.click();
	}
	
	public void clickUsers()
	{
		Users.click();
	}
	
	public void clickMembers()
	{
		Members.click();
	}
	
	public void clickSections()
	{
		Sections.click();
	}
	
	public void clickPages()
	{
		Pages.click();
	}
	
	public void clickMarket_Graphs()
	{
		Market_Graphs.click();
	}
	
	public void clickMarket_Downloads()
	{
		Market_Downloads.click();
	}
	
	public void clickEvents_And_Trainings()
	{
		Events_And_Trainings.click();
	}
	
	public void clickJobs()
	{
		Jobs.click();
	}
	
	public void clickNews_And_Updates()
	{
		News_And_Updates.click();
	}
	
	public void clickExtras()
	{
		Extras.click();
	}
	
	
	
	
	
}
