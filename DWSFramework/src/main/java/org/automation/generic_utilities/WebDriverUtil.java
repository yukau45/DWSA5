package org.automation.generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
/**
 * WebDriverUtil class provides some static and non static methods
 * which are helping an automation engineer to perform some task easily
 * 
 * @author my
 */
public class WebDriverUtil  {
/**
 * This is a method which is used to capture the screenshot of a webPage
 * This method accepts driver reference in WebDriver type
 * @param driver [WebDriver]
 * 
 * @return void
 */
	public static void captureScreenshot(WebDriver driver){
		LocalDateTime ltd = LocalDateTime.now();
		String timeStamp = ltd.toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorShots/screenshot "+timeStamp+".png");
		try {
			FileHandler.copy(screenshot, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This is a method which is used to switch to a tab or a window based on title
	 * This method accepts driver reference in WebDriver type, title in string type
	 * @param driver [webDriver]
	 * @param title [String]
	 * 
	 * @return void
	 */
	public void switchToATabOrWindowUsingTitle(WebDriver driver, String title) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().equals(title)) {
				break;
			}
		}
	}
	
	/**
	 * This is a method which is used to switch to a tab or a window based on url
	 * This method accepts driver reference in WebDriver, url in string type
	 * @param driver [webDriver]
	 * @param url [String]
	 * 
	 * @return void
	 */
	public void switchToATabOrWindowUsingURL(WebDriver driver, String url) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().equals(url)) {
				break;
			}
		}
	}
	/**
	 * This method is used to switch to an alert and accept it
	 * This method accepts driver reference in WebDriver type
	 * @param driver [webDriver]
	 * 
	 * @return void
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to switch to an alert and dismiss it
	 * This method accepts driver reference in WebDriver type
	 * @param driver [webDriver]
	 * 
	 * @return void
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to switch to an alert and pass data to the textBox present in the prompt alert
	 * This method accepts driver reference in WebDriver type, dataToBePassed in string type
	 * @param driver [webDriver]
	 * @param dataToBePassed [String]
	 * 
	 * @return void
	 */
	public void passDataToAnAlert(WebDriver driver, String dataToBePassed) {
		driver.switchTo().alert().sendKeys(dataToBePassed);
	}
	/**
	 * This method is used to switch to an alert and return the text present in alert
	 * This method accepts driver reference in WebDriver type
	 * @param driver [WebDriver]
	 * @return text[String]
	 */
	public String getDataFromAlert(WebDriver driver) {
		String data = driver.switchTo().alert().getText();
		return data;
	}
	/**
	 * This method is used to switch to frame using index
	 * This method accepts driver reference in WebDriver type, index in int type
	 * @param driver [webDriver]
	 * @param index  [int]
	 * 
	 * @return void
	 */
	public void switchToFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame using name or id attribute value
	 * This method accepts driver reference in WebDriver type, nameOrId in string type
	 * @param driver [webDriver]
	 * @param nameOrId [String]
	 * 
	 * @return void
	 */
	public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch to frame using webElement
	 * This method accepts driver reference in WebDriver type, element in WebElement type
	 * @param driver [webDriver]
	 * @param element [webElement]
	 * 
	 * @return void
	 */
	public void switchToFrameUsingWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
}
