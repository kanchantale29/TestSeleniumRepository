package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	By email = By.cssSelector("input[type='email']");
	By password = By.cssSelector("input[type='password']");
	By signIn = By.cssSelector("input[value='Log In']");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	
	public void enterEmail(String userName) {
		driver.findElement(email).sendKeys(userName);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}

}
