package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchCustomerPage;
import utility.Data;
import utility.Reusable;

public class SearchCustomer extends BaseTest {
	
	@Test(dataProvider = "smokeTestData", dataProviderClass = Data.class)
	public void searchCustomerbyEmail(String url, String username, String password, String customerEmail1, String customerEmail2) throws Exception {
		lp = new LoginPage(driver);
		searchCust = new SearchCustomerPage(driver);
		reuse = new Reusable(driver);
		logger.info("************* Launching Browser *****************");
		logger.info("************* Opeining URL *****************");
		driver.get(url);
		logger.info("************* Entering username *****************");
		lp.enterUserName(username);
		logger.info("************* Entering password *****************");
		lp.enterPassword(password);
		lp.clickLogin();
		logger.info("************* Login successful *****************");
		searchCust.clickCustomerMenu();
		Thread.sleep(3000);
		searchCust.clickCustomerMenuItem();
		logger.info("************* Entering email to search *****************");
		searchCust.setEmail(customerEmail1);
		searchCust.clickSearch();
		Thread.sleep(3000);
		logger.info("************* Search result received *****************");
		boolean status=searchCust.searchCustomerByEmail(customerEmail2);
		Assert.assertEquals(true, status);
		logger.info("************* Search successful *****************");
		reuse.getScreenshot("test");
		logger.info("************* Screenshot captured *****************");
		lp.clickLogout();
		logger.info("************* Logout successful *****************");

	}


}
