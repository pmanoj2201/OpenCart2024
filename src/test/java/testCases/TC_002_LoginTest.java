package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Regression", "Master"})
	public void verifyLogin()
	{
		try
		{
			logger.info("*** TC_002_LoginTest Started ***");
			
			HomePage homePage= new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.setEmailAddress(p.getProperty("email"));
			logger.info("entered email");
			loginPage.setPassword(p.getProperty("password"));
			logger.info("entered password");
			loginPage.clickLogin();
			logger.info("clicked login");
			
			MyAccountPage myAccountPage= new MyAccountPage(driver);
			boolean targetPage= myAccountPage.isMyAccountExist();
			Assert.assertEquals(targetPage, true, "Login Failed...");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** TC_002_LoginTest Finished ***");
	}

}
