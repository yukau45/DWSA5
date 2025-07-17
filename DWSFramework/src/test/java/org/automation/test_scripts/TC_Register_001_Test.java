package org.automation.test_scripts;

import java.time.Duration;

import org.automation.element_repository.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Register_001_Test {
   @Test
   public void verify_user_is_able_to_register_or_not(){
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   driver.get("https://demowebshop.tricentis.com/");
	   RegisterPage registerPage = new RegisterPage(driver);
	   registerPage.register("female", "shivani", "jadhav", "shivanijadhav01@gmail.com", "shivani347");
	   driver.quit();
   }
}
