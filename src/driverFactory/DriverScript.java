package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibray;
import config.AppUtil;
import utilites.ExcelFileUtil;

public class DriverScript extends AppUtil {
String inputpath ="D:\\MrngBatch_Selenium\\DDT_FrameWork\\FileInput\\LoginData.xlsx";
String outputpath ="D:\\MrngBatch_Selenium\\DDT_FrameWork\\FileOutput\\DataDrivenResults.xlsx";
@Test
public void startTest()throws Throwable
{
	//create object for excelfile util
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows in login sheet
	int rc= xl.rowCount("Login");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		String 	user =xl.getCellData("Login", i, 0);
		String pass =xl.getCellData("Login", i, 1);
	//call login method from function library
	boolean res =FunctionLibray.verify_Login(user, pass);
	if(res)
	{
		xl.setCellData("Login", i, 2, "Login Success", outputpath);
		xl.setCellData("Login", i, 3, "Pass", outputpath);
	}
	else
	{
		//take screen shot
		File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./Screenshot/Iteration/"+i+"_"+"Loginpage.png"));
		xl.setCellData("Login", i, 2, "Login Fail", outputpath);
		xl.setCellData("Login", i, 3, "Fail", outputpath);
	}
	}
}
}











