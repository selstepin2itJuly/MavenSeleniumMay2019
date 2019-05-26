package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	private WebDriver driver;
	
	public Dashboard(WebDriver dr) 
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logOut;
	
	public String logOutOption() {
		String s=logOut.getText();
		return s;
	}
	public void clickOnLogout() {
		logOut.click();
	}
}
