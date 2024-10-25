package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	//WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txt_firstName;
	
	@FindBy(name="lastname")
	WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath= "//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confPassword;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement btn_newsletterYes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement btn_newsletterNo;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btn_agreePrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMsg;
	
	public void setFirstName(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txt_telephone.sendKeys(telephone);
	}
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void setConfPassword(String confPassword)
	{
		txt_confPassword.sendKeys(confPassword);
	}
	public void setNewsletetrYes()
	{
		btn_newsletterYes.click();
	}
	
	public void setPrivacyPolicy()
	{
		btn_agreePrivacyPolicy.click();
	}
	
	public void clickContinue()
	{
		btn_continue.click();
	}
	
	public String getConfirmationMsg()
	{
		try 
		{
			return confirmationMsg.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	
	
	

}
