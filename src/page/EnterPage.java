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
	@FindBy(xpath="//tr[2]//div[4]")
	private WebElement help;
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutAT;
	@FindBy(xpath="//span[@class='productVersion']")
	private WebElement version;
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closePopup;
	
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
		Reporter.log("Actual and Expected versions are same",true);
		closePopup.click();
	}
	public void verifyHomePageDisplayed(WebDriver driver, String eTitle)
	{
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle, eTitle);
		Reporter.log("Actual tiltle is matching with the Expected tiltle",true);
		
		
	}
}
