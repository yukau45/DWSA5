package org.sample_testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Titan {
	    @Test
		public void tc() {
	    	 WebDriver driver = new ChromeDriver();
	    	 driver.manage().window().maximize();
	    	 driver.get("https://www.titan.co.in/");
	    	 driver.quit();
	  }
}
