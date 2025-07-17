package org.sample_testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.automation.generic_utilities.IAutoConstants.*;

public class LaunchAndSearch_Test {
	
	@Test
	public void testCase() {
		WebDriver driver = new ChromeDriver();
   	    driver.manage().window().maximize();
   	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
   	    String URL=System.getProperty("url");
   	    driver.get(URL);
   	    String TESTDATA = System.getProperty("data");
   	    driver.findElement(By.name("q")).sendKeys(TESTDATA,Keys.ENTER);
	}

}
