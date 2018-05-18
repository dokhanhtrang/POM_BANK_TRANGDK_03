package pages;

import org.openqa.selenium.WebDriver;

import bank.LoginPageUI;
import commons.AbstractPage;

public class LoginPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	public String getLoginUrl() {
		return getCurrentUrl(driver);
	}

	public void inputToUserIDTextbox(String username) {
		waitForControlVisible(driver, LoginPageUI.USERNAME_TXT);
		sendkeysToElement(driver, LoginPageUI.USERNAME_TXT, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public void clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.SUBMIT_BTN);
		clickToElement(driver, LoginPageUI.SUBMIT_BTN);
	}

	public void clickToResetButton() {
		waitForControlVisible(driver, LoginPageUI.RESET_BTN);
		clickToElement(driver, LoginPageUI.RESET_BTN);
	}

	public void clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

}
