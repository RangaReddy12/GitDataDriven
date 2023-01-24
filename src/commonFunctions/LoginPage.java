package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define Repository
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement User;
	@FindBy(name="txtPassword")
	WebElement pass;
	@FindBy(id ="btnLogin")
	WebElement loginbtn;
	//define method
	public void verify_Login(String username,String password)
	{
		User.sendKeys(username);
		pass.sendKeys(password);
		loginbtn.click();
	}
}
