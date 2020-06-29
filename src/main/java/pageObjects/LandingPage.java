package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	private By logIn =By.cssSelector("a[href='https://sso.teachable.com/secure/4282/users/sign_in ']");
	private By title =By.cssSelector(".text-center>h2");
	
	private	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	public String getTitle() {
		 return driver.findElement(title).getText();
	}
	
	public void clickLoginButton() {
		driver.findElement(logIn).click();
	}
	public boolean displayNavigationBar() {
		return driver.findElement(navBar).isDisplayed();
	}
	
	

}
