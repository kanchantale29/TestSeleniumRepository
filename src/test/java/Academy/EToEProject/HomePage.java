package Academy.EToEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(property.getProperty("url"));
		log.info("Navigated to Home Page");
		
		
		
	}
@Test(dataProvider ="getData")
	public void basePageNavigation(String userName,String password,String text) throws IOException {
	
	LandingPage landingPage = new LandingPage(driver);
	landingPage.getTitle();
	LoginPage loginPage = new LoginPage(driver);
	
	landingPage.clickLoginButton();
	loginPage.enterEmail(userName);
	loginPage.enterPassword(password);
	System.out.println(text);
	loginPage.clickSignIn();
	//log.info(text);
	

		
	}
@DataProvider
public Object[][] getData() {
	Object[][] data = new Object[2][3];
	data[0][0]="nonrestricteduser@gmail.com";
	data[0][1]="Test@1234";
	data[0][2]="Restricted User";
	
	
	 data[1][0]="restricteduser@gmail.com";
	 data[1][1]="Test2@1234";
	 data[1][2]="Nonrestricted User";
	 	return data;
	
	
	
}

  @AfterTest
  public void tearDown() { 
	  driver.close(); }


}
