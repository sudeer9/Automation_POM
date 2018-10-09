package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@BeforeMethod(alwaysRun=true)
	public void openApp()
	{
		String appURL=AutoUtils.getProperty(CONFIG_PATH, "URL");
		String strITO=AutoUtils.getProperty(CONFIG_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		driver=new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult testResult)
	{
		String testName=testResult.getName();
		int status=testResult.getStatus();
		if(status==1)
		{
			Reporter.log(testName+" is PASSED", true);
		}
		else
		{
			Reporter.log(testName+" is FAILED", true);
			AutoUtils.getPhoto(driver, IMAGE_PATH, testName);
		}
		driver.quit();
	}
}
