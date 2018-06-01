package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class EditCustomerPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public EditCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
}
