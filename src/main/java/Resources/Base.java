package Resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties property ;
	public WebDriver initializeDriver() throws IOException {
		 property = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Selenium_Workspace\\EToEProject\\src\\main\\java\\Resources\\data.properties");
	property.load(fis);
	String browserName =property.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		 //ChromeOptions options = new ChromeOptions();
		 //options.addArguments("headless");
		driver = new ChromeDriver();
		System.out.println("Chrome");
		
	}else if(browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
		 driver = new FirefoxDriver();
		
		
	}else if(browserName.equals("IE")) {
		System.setProperty("webdriver.ie.driver", "C:\\Work\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		System.out.println("Test");
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}
}
