package org.automation.generic_utilities;

import java.time.Duration;

import org.automation.element_repository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConstants{
	public static WebDriver driver;
	public LoginPage loginPage;
	public WebDriverWait explicitWait;
	@Parameters("bname")
	@BeforeClass
	public void launchAndMaximizeBrower(@Optional("chrome")String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
   	    else if(browserName.equalsIgnoreCase("edge")) 
   	    	driver=new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
	    explicitWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
   	    driver.get(FLib.readDataFromProperties("url"));
	}
	@AfterClass
	public void tearDownBrowser()
	{
		driver.close();
		driver.quit();
	}	
	@BeforeMethod
	public void login() {
		loginPage = new LoginPage(driver);
		String email= FLib.readDataFromProperties("email");
		String password = FLib.readDataFromProperties("password");
		loginPage.login(email,password);
	}
	@AfterMethod
	public void logout()
	{
		loginPage.logout();
	}	
}
