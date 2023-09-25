package Module1_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Adactin_Library.BaseClass;
import Adactin_Library.UtilityClass;
import Module1.Adactin_Home;
import Module1.Adactin_Login;

public class TestClass extends BaseClass
{
	
	Adactin_Login Login;
	Adactin_Home Home;
	//Adactin_LoginAgain Loginagain;
	String TestCaseID;
	
	
	@BeforeClass
	public void openBrowser()
	{
		initializeBrowser();
		
		Login=new Adactin_Login(driver);
		Home=new Adactin_Home(driver);
		
		//Loginagain=new Adactin_LoginAgain(driver);
		
	}
	@BeforeMethod
	public void loginToApp() throws IOException
	{
		Login.enterUsername(UtilityClass.getDataFromPropertyFile("Username"));
		
		Login.enterPassword(UtilityClass.getDataFromPropertyFile("Password"));
		
		Login.clickLoginBtn();
		
	}
	@Test(priority=1)
	public void verifyUser() throws EncryptedDocumentException, IOException
	{
		TestCaseID="TC100";
		
		String ExpectedUsername=UtilityClass.getDataFromExcel(0, 0);
		
		String ActualUsername=Home.getUsername();
		
		Assert.assertEquals(ActualUsername, ExpectedUsername);		
		
	}
	@Test(priority=2)
	public void verifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID="TC101";
		String ExpectedTitle=UtilityClass.getDataFromExcel(1, 0);
		
		String ActualTitle=driver.getTitle();
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
				
	}
	@AfterMethod
	public void logoutFromApp(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.CaptureScreenShot(driver, TestCaseID);
		}
		
		Home.clickLogoutBtn();
		Home.clickloginAgain();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
