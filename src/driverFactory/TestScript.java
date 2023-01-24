package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import config.AppUtil1;
import utilites.ExcelFileUtil;

public class TestScript extends AppUtil1 {

String inputpath ="D:\\MrngBatch_Selenium\\DDT_FrameWork\\FileInput\\EmplyeData.xlsx";
String outputpath ="D:\\MrngBatch_Selenium\\DDT_FrameWork\\FileOutput\\PomResults.xlsx";
@Test
public void startTest()throws Throwable
{
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc =xl.rowCount("EmpData");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		String Fname =xl.getCellData("EmpData", i, 0);
		String Mname = xl.getCellData("EmpData", i, 1);
		String Lname =xl.getCellData("EmpData", i, 2);
		AddEmpPage emp = PageFactory.initElements(driver, AddEmpPage.class);
		boolean res = emp.addEmp(Fname, Mname, Lname);
		if(res)
		{
			xl.setCellData("EmpData", i, 3, "Pass", outputpath);
		}
		else
		{
			xl.setCellData("EmpData", i, 3, "Fail", outputpath);
		}
	}
}

}
