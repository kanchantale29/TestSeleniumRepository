package Academy.EToEProject;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateTest extends Base{
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(property.getProperty("url"));
		log.info("Navigated to Home Page");
		
		
	}
@Test
	public void basePageNavigation() throws IOException {
	
	LandingPage landingPage = new LandingPage(driver);
Assert.assertEquals(landingPage.getTitle(), "FEATURED COURSES");
log.info("Navigation Bar is displayed ");
Assert.assertTrue(landingPage.displayNavigationBar());


	
	
}

 @AfterTest public void tearDown() { 
	 driver.close(); }
 

}
