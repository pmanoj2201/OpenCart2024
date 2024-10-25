package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass 
{
	
	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class, groups= {"DataDriven"})
	public void verifyLoginDDT(String email, String pswd, String exp)
	{
		logger.info("*** TC_003_LoginDDT Started ***");
		try
		{
			//HomePage
			HomePage homePage= new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();
			
			//LoginPage
			LoginPage loginPage=new LoginPage(driver);
			loginPage.setEmailAddress(email);	
			loginPage.setPassword(pswd);	
			loginPage.clickLogin();
			
			//MyAccountPage
			MyAccountPage myAccountPage= new MyAccountPage(driver);
			boolean targetPage= myAccountPage.isMyAccountExist();
			
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetPage==true)
				{
					myAccountPage.clickLogout();
					Assert.assertTrue(true);				
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			else if(exp.equalsIgnoreCase("invalid"))
			{
				if(targetPage==true)
				{
					myAccountPage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** TC_003_LoginDDT Finished ***");
	}
	

}
