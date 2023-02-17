package pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
WebDriver localDriver;
	
	public AddCustomerPage(WebDriver remoteDriver) 
	{
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);  //ask why is it written in this way
	}
	
	By customers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By customers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	By btnAddnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");  
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	By fname = By.xpath("//*[@id=\"FirstName\"]");
	By lname = By.xpath("//*[@id=\"LastName\"]");
	By male = By.xpath("//*[@id=\"Gender_Male\"]");
	By female = By.xpath("//*[@id=\"Gender_Female\"]");
	By txtDOB = By.xpath("//*[@id=\"DateOfBirth\"]");
	By txtCompanyName = By.xpath("//*[@id=\"Company\"]");
	
	By drpManagerOfVendor = By.xpath("//*[@id=\"VendorId\"]");
	
	By defaultRoleRemove = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");
	By txtCustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
		
	By lstItemAdministrators = By.xpath("//li[contains(.,'Administrators')]");
	By lstItemRegistered = By.xpath("//li[contains(.,'Registered')]");
	By lstItemGuests = By.xpath("//li[contains(.,'Guests')]");
	By lstItemVendors = By.xpath("//li[contains(.,'Vendors')]");

	By txtAdminContent = By.xpath("//*[@id=\"AdminComment\"]");
	By btnSave = By.name("save");
	
	// Method created to validate the page title
	public String getPageTitle() 
	{	
		return localDriver.getTitle();
	}
	
	public void clickOnCustomerMenu() 
	{
		localDriver.findElement(customers_menu).click();
	}
	
	public void clickOnCustomerMenuItem() 
	{
		localDriver.findElement(customers_menuitem).click();
	}
	
	public void clickOnAddNew() 
	{
		localDriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) 
	{
		localDriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) 
	{
		localDriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstName(String firstName) 
	{
		localDriver.findElement(fname).sendKeys(firstName);		
	}
	
	public void setLastName(String lastName) 
	{
		localDriver.findElement(lname).sendKeys(lastName);		
	}
	
	public void DOB(String dob) 
	{
		localDriver.findElement(txtDOB).sendKeys(dob);
	}
	
	public void setCompanyName(String compName) 
	{
		localDriver.findElement(txtCompanyName).sendKeys(compName);		
	}
	
	public void setAdminContent(String content) 
	{
		localDriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException 
	{	
		//if(!role.equals("Vendors"))
		//{
			//localDriver.findElement(By.xpath());
		//}
		
		localDriver.findElement(txtCustomerRoles).click();
		//localDriver.findElement(defaultRoleRemove).click();
		
		WebElement listItem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) 
		{
			listItem = localDriver.findElement(lstItemAdministrators);
		}
		else if(role.equals("Guests"))
		{
			listItem = localDriver.findElement(lstItemGuests);
		}
		else if(role.equals("Registered"))
		{
			listItem = localDriver.findElement(lstItemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listItem = localDriver.findElement(lstItemVendors);
		}
		else 
		{
			listItem = localDriver.findElement(lstItemGuests);
		}
		
		listItem.click(); // if this does not work then use the below mentioned js code 
		
		//JavascriptExecutor js = (JavascriptExecutor)localDriver;
		//js.executeScript("arguments[0].click();", listItem);
	}
	
	public void setManagerofVendor(String value)
	{
		Select drp = new Select(localDriver.findElement(drpManagerOfVendor));
		drp.selectByVisibleText(value);   //selectByVisibleText : Select all options that display text matching the argument.
	}
	
	public void setGender(String gender) 
	{
		if(gender.equals("Male")) 
		{
			localDriver.findElement(male).click();				
		}
		else if(gender.equals("Female")) 
		{
			localDriver.findElement(female).click();
		}
		else 
		{
			localDriver.findElement(male).click(); // by default select male
		}
	}
	
	public void clickOnSave() 
	{
		localDriver.findElement(btnSave).click();
	}
	
}
