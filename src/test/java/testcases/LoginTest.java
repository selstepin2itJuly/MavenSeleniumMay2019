package testcases;

import org.testng.annotations.Test;

import config.TestBase;
import pages.Dashboard;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver dr;
	LoginPage lp;
	Dashboard db;
	String user;
	String pass;
  @Test(priority=11, description="Successfull login")
  public void LoginTestPositive() {  
	  lp.login(user, pass);
	  lp.enableRemeberBox();
	  lp.clickOnLogin();
	  Assert.assertEquals(db.logOutOption(), "Logout");
	  WebDriverWait wait = new WebDriverWait(dr,10);
	  wait.until(ExpectedConditions.visibilityOf(db.logOut));
	  db.clickOnLogout();
  }
  @Test(priority=12,description="Wrong user login")
  public void LoginTestNegativeUser() {
	  lp.login("Anything", pass);
	  lp.disableRemeberBox();
	  lp.clickOnLogin();
	  System.out.println(lp.wrongEmail());
	  Assert.assertEquals(lp.wrongEmail(), "Wrong email");
  }
  @Test(priority=13,description="Wrong password login")
  public void LoginTestNegativePass() {
	  lp.login(user, "pass");
	  lp.disableRemeberBox();
	  lp.clickOnLogin();
	  System.out.println(lp.wrongPass());
	  Assert.assertTrue(lp.wrongPass().contains("incorrect"));
  }
  @Test(priority=14,description="Failing login")
  public void FailDelibrately() {
	  lp.login(user, "pass");
	  lp.disableRemeberBox();
	  lp.clickOnLogin();
	  System.out.println(lp.wrongPass());
	  Assert.assertTrue(lp.wrongPass().contains("incorrect90"));
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr=TestBase.init();
	  lp= new LoginPage(dr);
	  db=new Dashboard(dr);
	  user=TestBase.prop.getProperty("user");
	  pass=TestBase.prop.getProperty("pass");
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
