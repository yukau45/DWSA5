package org.automation.generic_utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * JavaScriptUtil class contains some non-static methods which will help
 * Automation Engineers to perform some tasks like scrolling, click, passing data etc.
 * 
 * @author my
 */
public class JavaScriptUtil {
  
	public JavascriptExecutor jse;
	/**
	 * JavaScriptUtil constructor accepts driver reference in WebDriver type and
	 * converts that reference into JavascriptExecutor type and assigns it.
	 * @param driver [WebDriver]
	 */
    public JavaScriptUtil(WebDriver driver) {
	    this.jse = (JavascriptExecutor)driver;
    }
    /**
     * This method is used to perform click action on the given element through js
     * @param element [WebElement]
     * @return void
     */
    public void jsClick(WebElement element) {
    	jse.executeScript("arguments[0].click()", element);
    }
    /**
     * This method is used to pass the data to the given element through js
     * @param element [WebElement]
     * @param data [String]
     * @return void
     */
    public void jsSendKeys(WebElement element,String data) {
    	jse.executeScript("arguments[0].value='"+data+"'", element);
    }
    /**
     * This method is used to scroll the webPage based on offset values through js
     * @param xOffset [int]
     * @param yOffset [int]
     * @return void
     */
    public void jsScrollBy(int xOffset,int yOffset) {
    	jse.executeScript("window.scrollBy("+xOffset+","+yOffset+")");
    }
    /**
     * This method is used to scroll the webPage based on co-ordinate values through js
     * @param xCoordinate [int]
     * @param yCoordinate [int]
     * @return void
     */
    public void jsScrollTo(int xCoordinate,int yCoordinate) {
    	jse.executeScript("window.scrollBy("+xCoordinate+","+yCoordinate+")");
    }
   /**
    * This method is used to scroll the webPage based on element through js
    * and we can decide that element should be their in top or bottom of the webPage
    * if element to be present in top pass true, otherwise pass false
    * @param topView [boolean]
    * @param element [WebElement]
    * @return void
    */
    public void jsScrollIntoView(boolean topView,WebElement element) {
    	jse.executeScript("arguments[0].scrollIntoView("+topView+")",element);
    }
}
