package org.automation.element_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	private WebElement genderMaleRadioButton; 
	
	@FindBy(id = "gender-female")
	private WebElement genderFemaleRadioButton; 
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox; 
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextBox; 
	
	@FindBy(id = "Email")
	private WebElement emailTextBox; 
	
	public WebElement getGenderMaleRadioButton() {
		return genderMaleRadioButton;
	}

	public WebElement getGenderFemaleRadioButton() {
		return genderFemaleRadioButton;
	}

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	@FindBy(id = "Password")
	private WebElement passwordTextBox; 
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextBox; 
	
	@FindBy(id = "register-button")
	private WebElement registerButton; 
	
	public void register(String gender, String firstName, String lastName, String email, String password) {
		getRegisterLink().click();
		if(gender.equalsIgnoreCase("male"))
			getGenderMaleRadioButton().click();
		else
			getFirstNameTextBox().click();
		getFirstNameTextBox().sendKeys(firstName);
		getLastNameTextBox().sendKeys(lastName);
		getEmailTextBox().sendKeys(email);
		getPasswordTextBox().sendKeys(password);
		getConfirmPasswordTextBox().sendKeys(password);
		getRegisterButton().click();		
	}
}
