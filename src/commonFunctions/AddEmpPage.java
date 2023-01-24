package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class AddEmpPage {
WebDriver driver;
public AddEmpPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath = "//b[normalize-space()='PIM']")
WebElement clickPim;
@FindBy(name = "btnAdd")
WebElement clickAdd;
@FindBy(xpath = "//input[@id='firstName']")
WebElement fname;
@FindBy(xpath = "//input[@id='middleName']")
WebElement mname;
@FindBy(xpath = "(//input[@id='lastName'])[1]")
WebElement lname;
@FindBy(xpath = "//input[@id='employeeId']")
WebElement BeforeEid;
@FindBy(id="btnSave")
WebElement clickSave;
@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
WebElement AfterEid;
public boolean addEmp(String FirstName,String Middlename,String LastName)
{
Actions ac = new Actions(driver);
ac.moveToElement(clickPim).click().perform();
ac.moveToElement(clickAdd).click().perform();
this.fname.sendKeys(FirstName);
this.mname.sendKeys(Middlename);
this.lname.sendKeys(LastName);
String expectedEID =this.BeforeEid.getAttribute("value");
ac.moveToElement(this.clickSave).click().perform();
String ActualEID =this.AfterEid.getAttribute("value");
System.out.println(expectedEID+"        "+ActualEID);
if(expectedEID.equals(ActualEID))
{
	Reporter.log("Add Employee Success",true);
	return true;
}
else
{
	Reporter.log("Add Employee Fail",true);
	return false;
}

}

}











