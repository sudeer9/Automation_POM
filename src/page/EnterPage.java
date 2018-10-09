package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AutoUtils;
import generic.IAutoConstants;

public class EnterPage 
{
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutAT;
	@FindBy(xpath="//span[@class='productVersion']")
	private WebElement version;
	
	public EnterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Methods
	public void clickHelp()
	{
		help.click();
	}
	public void clickAboutActiTIME()
	{
		aboutAT.click();
	}
	public void verifyProductVersion(String ExpectedVersion)
	{
		String ActualVersion = version.getText();
		Assert.assertEquals(ActualVersion, ExpectedVersion);
	}
	public void verifyHomePageDisplayed(WebDriver driver, String eTitle)
	{
	String strETO=AutoUtils.getProperty(IAutoConstants.CONFIG_PATH,"ETO");
		long ETO=Long.parseLong(strETO);
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Home page is Displayed",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Home Page Not displayed",true);
			Assert.fail();
		}
	}
}
