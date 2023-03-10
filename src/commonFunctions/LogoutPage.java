package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
@FindBy(id="welcome")
WebElement clickWelcome;
@FindBy(linkText = "Logout")
WebElement clickLogout;
public void verifyLogout()
{
	clickWelcome.click();
	clickLogout.click();
}
}
