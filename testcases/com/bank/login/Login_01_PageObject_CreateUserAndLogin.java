package com.bank.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import commons.AbstractTest;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.RegisterPagePO;

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String loginUrl;
	String username, password, userID, mail;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMultibrowser(browser); //sai cho này
		// loginPage
		loginPage = new LoginPagePO(driver);
		mail = "khanhtrang" + randomData() + "@gmail.com";
	}

	@Test
	public void TC_Login_01_CreateUser() {
		loginUrl = loginPage.getLoginUrl();
		loginPage.clickToHereLink();
		// RegisterPage
		registerPage = new RegisterPagePO(driver);
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
		loginPage.clickToLoginButton();
		// homePage
		homePage = new HomePagePO(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		// userID = driver.findElement(By.xpath("//td[contains(@style,'color:
		// green')]")).getText();

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
