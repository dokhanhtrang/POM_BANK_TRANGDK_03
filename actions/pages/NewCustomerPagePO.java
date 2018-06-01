package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class NewCustomerPagePO extends AbstractPage{
	WebDriver driver;

	// contructor
	public NewCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
}
