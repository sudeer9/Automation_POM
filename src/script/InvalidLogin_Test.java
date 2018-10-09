package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel_Data;
import page.LoginPage;

public class InvalidLogin_Test extends BaseTest
{
	@Test(priority=2,groups= {"login"})
	public void testInvalidLogin() throws InterruptedException
	{
		int rc=Excel_Data.getRowCount(EXCEL_PATH, "Invalid Login");
		for(int i=1;i<=rc;i++)
		{
			String un=Excel_Data.getValue(EXCEL_PATH, "Invalid Login", i, 0);
			String pw=Excel_Data.getValue(EXCEL_PATH, "Invalid Login", i, 1);
			String expectedMsg=Excel_Data.getValue(EXCEL_PATH, "Invalid Login", i, 2);
			LoginPage l=new LoginPage(driver);
			//Enter User Name
			l.setuserName(un);
			l.setPassword(pw);
			l.clickLogin();
			Thread.sleep(2000);
			l.verifyErrorMSG(expectedMsg);
			Thread.sleep(2000);
		}
	}
}
