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
	String username, password, userID, mail, customerName, dob, add, city, state, pin, mobile, customerID;
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
		customerName = "Khanh Trang";
		dob ="06/28/1995";
		add = city = state = "Ha Noi";
		pin = "12345689";
		mobile = "123" + randomData();
		
	}

	@Test(enabled = true)
	public void TC_01_CreateUser() {
		loginUrl = loginPage.getLoginUrl();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(mail);
		registerPage.clickToSubmitButton();
		username = registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfo();
	}

	@Test
	public void TC_02_LoginApp() {
		driver.get(loginUrl);
		loginPage = new LoginPagePO(driver);
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		homePage = editCustomerPage.openHomePage(driver);
		deleteCustomerPage = editCustomerPage.openDeleteCustomerPage(driver);
		homePage = editCustomerPage.openHomePage(driver);
		loginPage = deleteCustomerPage.openLogOutPage(driver);
	}

	@Test
	public void TC_03_CreateCustomer() throws Exception{
		newCustomerPage = homePage.openNewCustomerPage(driver);
		newCustomerPage.inputCustomerName(customerName);
		newCustomerPage.checkGender();
		newCustomerPage.inputDob(dob);
		newCustomerPage.inputAdd(add);
		newCustomerPage.inputCity(city);
		newCustomerPage.inputState(state);
		newCustomerPage.inputPIN(pin);
		newCustomerPage.inputMobile(mobile);
		newCustomerPage.inputMail(mail);
		newCustomerPage.inputPassword(password);
		newCustomerPage.clickToSubmit();
		Thread.sleep(5000);
		customerID = newCustomerPage.getCustomerID();
	}
	@Test
	public void TC_04_EditCustomer() {
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		editCustomerPage.inputCustomerid(customerID);
		editCustomerPage.clickToSubmitAcc();
		editCustomerPage.clickToSubmit();
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
