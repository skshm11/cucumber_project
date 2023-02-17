package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// this method waits for the element until it is visible on the page.
	public void WaitForElement(WebElement element, Long waitTime) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(waitTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
