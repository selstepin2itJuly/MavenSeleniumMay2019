package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver dr) 
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="RememberMe")
	WebElement rememberCheckbox;
	
	@FindBy(css="input[type='submit']")
	WebElement loginbutton;
	
	@FindBy(css="input[value='Register']")
	WebElement registerButton;
	
	@FindBy(xpath="//*[@id='Email-error']")
	WebElement emailError;
	
	@FindBy(css="form[method='post'] ul >li")
	WebElement passError;
	
	private void setUsername(String str) {
		username.sendKeys(str);
	}
	
	private void setPassword(String str) {
		password.sendKeys(str);
	}

	public void enableRemeberBox(){
		boolean b=rememberCheckbox.isSelected();
		if(b==false) {
			rememberCheckbox.click();
		}
	}
	public void disableRemeberBox(){
		boolean b=rememberCheckbox.isSelected();
		if(b==true) {
			rememberCheckbox.click();
		}
	}
	
	public void clickOnLogin() {
		loginbutton.click();
	}
	public void registerNewUser() {
		registerButton.click();
	}
	
	public void login(String user, String pass) {
		setUsername(user);
		setPassword(pass);
	}
	
	public String wrongEmail() {
		String s=emailError.getText();
		return s;
	}
	public String wrongPass() {
		String s=passError.getText();
		return s;
	}
}
