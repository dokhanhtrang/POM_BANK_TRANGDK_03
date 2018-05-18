package pages;

import commons.AbstractPage;

import org.openqa.selenium.WebDriver;

import bank.HomePageUI;

public class HomePagePO extends AbstractPage {
	WebDriver driver;

	public HomePagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitForControlVisible(driver, HomePageUI.WELCOM_MESSAGE);
		return controlDisplay(driver, HomePageUI.WELCOM_MESSAGE);
	}
}
