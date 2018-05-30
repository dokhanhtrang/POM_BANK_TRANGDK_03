package commons;

import org.openqa.selenium.WebDriver;

import pages.DeleteCustomerPagePO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewCustomerPagePO;
import pages.RegisterPagePO;

public class PageFactoryManger {
	private static HomePagePO homePage;
	private static RegisterPagePO registerPage;
	private static LoginPagePO loginPage;
	private static NewCustomerPagePO newCustomerPage;
	private static EditCustomerPagePO editCustomerPage;
	private static DeleteCustomerPagePO deleteCustomerPage;

	public static HomePagePO getHomePage(WebDriver driver_) {
		if (homePage == null) {
			return new HomePagePO(driver_);
		}
		return homePage;
	}
	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}
	public static RegisterPagePO getRegisterPage(WebDriver driver_) {
		if (registerPage == null) {
			return new RegisterPagePO(driver_);
		}
		return registerPage;
	}
	public static NewCustomerPagePO getNewCustomerPage(WebDriver driver_) {
		if (newCustomerPage == null) {
			return new NewCustomerPagePO(driver_);
		}
		return newCustomerPage;
	}
	public static EditCustomerPagePO getEditCustomerPage(WebDriver driver_) {
		if (editCustomerPage == null) {
			return new EditCustomerPagePO(driver_);
		}
		return editCustomerPage;
	}
	public static DeleteCustomerPagePO getDeleteCustomerPage(WebDriver driver_) {
		if (deleteCustomerPage == null) {
			return new DeleteCustomerPagePO(driver_);
		}
		return deleteCustomerPage;
	}
}
