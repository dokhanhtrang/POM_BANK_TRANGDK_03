package com.bank.login;

import org.openqa.selenium.WebDriver;
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

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String loginUrl;
	String username, password, userID, mail;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPagePO newCustomerPage;
	private EditCustomerPagePO editCustomerPage;
	private DeleteCustomerPagePO deleteCustomerPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMultibrowser(browser);
		loginPage = PageFactoryManger.getLoginPage(driver);
		// loginPage
		mail = "khanhtrang" + randomData() + "@gmail.com";
	}

	@Test(enabled = true)
	public void TC_Login_01_CreateUser() {
		loginUrl = loginPage.getLoginUrl();
		registerPage = loginPage.clickToHereLink();
		// RegisterPage
		registerPage.inputToEmailIDTextbox(mail);
		registerPage.clickToSubmitButton();
		username = registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfo();
		System.out.println("UserName: " + username + "/n Password: " + password);
	}

	@Test
	public void TC_Login_02_LoginApp() {
		driver.get(loginUrl);
		loginPage = new LoginPagePO(driver);
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		//verify
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		// Switch
		// openNewCustomerPage
		newCustomerPage = homePage.openNewCustomerPage(driver);
		// openEditCustomerPage
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		// openHomePage
		homePage = editCustomerPage.openHomePage(driver);
		// openDeleteCustomerPage
		deleteCustomerPage = editCustomerPage.openDeleteCustomerPage(driver);
		// openLogout
		loginPage = deleteCustomerPage.openLogOutPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
