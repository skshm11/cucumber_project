package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException 
	{
		//Reading properties from property file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("Config.properties");
		configProp.load(configPropFile);
		
		logger = Logger.getLogger("cucumber_project");        // added logger
		PropertyConfigurator.configure("log4j.properties");
		
		String browser = configProp.getProperty("browser");  // to read from config.properties and determine on which type of browser the action should be performed 
		
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));  // use getProperty whenever you need to read the property from config.properties file
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));  // use getProperty whenever you need to read the property from config.properties file
			driver = new FirefoxDriver();
		}	
	}
	
	// Steps definition related to login feature

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);
		
		customerPage = new AddCustomerPage(driver);
		searchCustomer = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		logger.info("Launching Browser");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters emails as {string} and password as {string}")
	public void user_enters_emails_as_and_password_as(String email, String password) {

		logger.info("Providing login details");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {

		logger.info("Started login");
		lp.clickLogin();
		Thread.sleep(1000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String pageTitle) {

		// if the login is unsuccessful then it won't check the title
		// getPageSource() returns the resource of the last reloaded page and return the
		// modified data if any

		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(pageTitle, driver.getTitle());
		}
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {

		logger.info("Click on logout link");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {

		logger.info("Logout successful. Closing the browser");
		driver.quit();
	}

	// Steps related to adding a new customer

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		Assert.assertEquals("Dashboard / nopCommerce administration", customerPage.getPageTitle());
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(1000);
		customerPage.clickOnCustomerMenu();
	}

	@When("click on customers Menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(1000);
		customerPage.clickOnCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		
		logger.info("Add new customer");
		logger.info("Providing customer details");
		Thread.sleep(1000);
		customerPage.clickOnAddNew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", customerPage.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com"; // to randomly Generate an email
		// By default role is 'Registered'
		// The customer cannot be in both 'Guest' and 'Registered' customer role
		// Assign either 'Guest' or 'Registered' role to the customer

		customerPage.setEmail(email);
		customerPage.setPassword("test123");

		customerPage.setCustomerRoles("Administrators");
		Thread.sleep(2000);

		customerPage.setGender("Male");
		customerPage.setFirstName("Saksham");
		customerPage.setLastName("Nasa");
		customerPage.DOB("05/10/98");
		customerPage.setCompanyName("QA");
		customerPage.setAdminContent("This is for testing purpose");
		customerPage.setManagerofVendor("Not a vendor");
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {

		logger.info("Saving customer data");
		customerPage.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

	// Steps related to searching a customer

	@When("Enter customer email id")
	public void enter_customer_email_id() {

		logger.info("Searching customer by email id");
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {

		searchCustomer.clickSearch();
		Thread.sleep(3000); // it will take some time to fetch data from DB
	}

	@When("Enter customer first name")
	public void enter_customer_first_name() {

		logger.info("Searching customer by name");
		searchCustomer.setFname("Victoria");
	}

	@When("Enter customer last name")
	public void enter_customer_last_name() {

		searchCustomer.setLname("Terces");
	}
}
