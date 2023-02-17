package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

WebDriver localDriver;
WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver remoteDriver) 
	{
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);  //ask why is it written in this way
		waitHelper = new WaitHelper(localDriver);
	}
	
	@FindBy(name = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name = "SearchFirstName")
	@CacheLookup
	WebElement txtFname;
	
	@FindBy(name = "SearchLastName")
	@CacheLookup
	WebElement txtLname;
	
	@FindBy(xpath = "//*[@id=\"search-customers\"]")
	@CacheLookup
	WebElement btnSearch;
	
	public void setEmail(String email) {

		waitHelper.WaitForElement(txtEmail, 10L);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFname(String fName) {

		waitHelper.WaitForElement(txtFname, 10L);
		txtFname.clear();
		txtFname.sendKeys(fName);
	}
	
	public void setLname(String lName) {

		waitHelper.WaitForElement(txtLname, 10L);
		txtLname.clear();
		txtLname.sendKeys(lName);
	}
	
	public void clickSearch() {
		
		waitHelper.WaitForElement(btnSearch, 10L);
		btnSearch.click();
	}
	
}
