package testBase;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass (groups={"Sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setup(@Optional("Windows") String os, @Optional("chrome")String br) throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		
		//loading config.properties file...
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver(); break;
		case "firefox" : driver= new FirefoxDriver(); break;
		default: System.out.println("invalid browser name..."); return;
		
		}
		
		//WebDriverManager.chromedriver().setup();
		//driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL")); // getting URL from properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups={"Sanity", "Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	/*public RandomStringUtils randomString()
	{
		RandomStringUtils generatedString= RandomStringUtils.secure();
		return (generatedString);
	}*/
	
	public String randomNumber()
	{
		String generatedNumber= RandomStringUtils.randomNumeric(5);
		return (generatedNumber);
	}

	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
