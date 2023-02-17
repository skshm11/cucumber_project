package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp; // creating an object of loginPage(pageObjects) to access its method
	public AddCustomerPage customerPage; // creating an object of AddCustomerPage(pageObjects) to access its method
	public SearchCustomerPage searchCustomer; // creating an object of SearchCustomerPages
	public static Logger logger;
	public Properties configProp;

	// Created for generating random string for Unique email id
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
}
