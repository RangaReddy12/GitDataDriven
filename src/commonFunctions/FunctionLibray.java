package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibray extends AppUtil{
public static boolean verify_Login(String username,String password)
{
	driver.get(conprop.getProperty("Url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector(conprop.getProperty("ObjUser"))).sendKeys(username);
	driver.findElement(By.cssSelector(conprop.getProperty("Objpass"))).sendKeys(password);
	driver.findElement(By.cssSelector(conprop.getProperty("ObjLogin"))).click();
	String expected="dashboard";
	String actual = driver.getCurrentUrl();
	if(actual.contains(expected))
	{
		Reporter.log("Login success   "+expected+"     "+actual,true);
		return true;
	}
	else
	{
	String error =driver.findElement(By.cssSelector(conprop.getProperty("Objerrormessage"))).getText();
	Reporter.log(error+"   "+expected+"       "+actual,true);
	return false;
	}
	
	
}
}
