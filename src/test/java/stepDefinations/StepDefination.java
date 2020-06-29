package stepDefinations;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Resources.Base;

@RunWith(Cucumber.class)
public class StepDefination extends Base {

	@Given("^Initialize the chrome browser$")
	public void initialize_the_chrome_browser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}
    	
    
	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		   driver.get(arg1);
	

    
    }
	@Given("^Click on Login to land on Home Page$")
	public void click_on_Login_to_land_on_Home_Page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage landingPage = new LandingPage(driver);
    	landingPage.clickLoginButton();
	}
    	

	
	 @When("^User enter (.+) and (.+)$")
	    public void user_enter_and(String username, String password) throws Throwable {
	      
		 LoginPage loginPage = new LoginPage(driver);
    	loginPage.enterEmail(username);
    	loginPage.enterPassword(password);
    	//System.out.println(text);
    	loginPage.clickSignIn();
	}



    @Then("^Verify that user successfully logged In.$")
    public void verify_that_user_successfully_logged_in() throws Throwable {
    
        System.out.println("Welcome User");
    	driver.close();
    }

   

  

}