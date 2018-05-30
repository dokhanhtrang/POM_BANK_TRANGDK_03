package com.bank.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.PageFactoryManger;
import pages.DeleteCustomerPagePO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewCustomerPagePO;
import pages.RegisterPagePO;
import commons.AbstractPage;

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String loginUrl;
	String username, password, userID, mail;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPagePO newCustomerPage;
	private EditCustomerPagePO editCustomerPage;


	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMultibrowser(browser);
		loginPage = PageFactoryManger.getLoginPage(driver);
		// loginPage
		// loginPage = new LoginPagePO(driver);
		mail = "khanhtrang" + randomData() + "@gmail.com";
	}

	@Test (enabled = true)
	public void TC_Login_01_CreateUser() {
		loginUrl = loginPage.getLoginUrl();
		registerPage = loginPage.clickToHereLink();
		// RegisterPage
		// registerPage = new RegisterPagePO(driver);
		registerPage.inputToEmailIDTextbox(mail);
		registerPage.clickToSubmitButton();
		username = registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfo();
		System.out.println("UserName: " + username + "/n Password: " + password);
	}

	@Test
	public void TC_Login_02_LoginApp() {
		driver.get(loginUrl);
		// loginPage
		loginPage = new LoginPagePO(driver);
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage=loginPage.clickToLoginButton();
		// homePage
		// homePage = new HomePagePO(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		// userID = driver.findElement(By.xpath("//td[contains(@style,'color:
		// green')]")).getText();
		//Switch
		newCustomerPage = homePage.openNewCustomerPage(driver);
//		newCustomerPage = openEditCustomerPage(driver);
		


	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
