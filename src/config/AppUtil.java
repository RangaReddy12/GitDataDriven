package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static Properties conprop;
	public static WebDriver driver;
	@BeforeTest
	public static void setUp()throws Throwable
	{
		conprop = new Properties();
		conprop.load(new FileInputStream("D:\\MrngBatch_Selenium\\DDT_FrameWork\\PropertyFiles\\Environment.properties"));
		if(conprop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			
			
		}
		else if(conprop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();

		}
		else 
		{
			System.out.println("Browser  value is Not Matching");
		}
	}
	@AfterTest
	public static void tearDown()
	{
		driver.quit();
	}
}
