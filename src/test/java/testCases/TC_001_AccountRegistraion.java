package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistraion extends BaseClass
{
	
	@Test(groups= {"Sanity", "Master"})
	public void test_account_registration()
	{
		logger.info("***TC_001_AccountRegistraion started***");
		try
		{
			HomePage homePage=new HomePage(driver);
			
			homePage.clickMyAccount();
			logger.info("Clicked on MyAccount...");
			homePage.clickRegister();
			logger.info("Clicked on Register...");
			
			AccountRegistrationPage accRegPage= new AccountRegistrationPage(driver);
			
			accRegPage.setFirstName("Thea");
			logger.info("Entered First Name...");
			accRegPage.setLastName("Queen");
			logger.info("Entered Last Name...");
			accRegPage.setEmail(randomString()+"@gmail.com");
			logger.info("Entered emailID...");
			accRegPage.setTelephone("1234567890");
			accRegPage.setPassword("123456");
			accRegPage.setConfPassword("123456");
			accRegPage.setNewsletetrYes();
			logger.info("Selected Newsletter...");
			accRegPage.setPrivacyPolicy();
			accRegPage.clickContinue();
			logger.info("Clicked on Continue...");
			
			
			String confirmMsg= accRegPage.getConfirmationMsg();
			if(confirmMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("test failed!!!");
				logger.debug("debug logs...");
				Assert.fail();
			}
			//Assert.assertEquals(confirmMsg, "Your Account Has Been Created!!");
		}
		
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***TC_001_AccountRegistraion finished***");
	}
	
}	
	
	

