package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties properties;
	public String browserUsed;
//	public WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) throws IOException {
		FileInputStream file = new FileInputStream(".//src//test//resources//config.properties");
		properties=new Properties();
		properties.load(file);
		logger=LogManager.getLogger(this.getClass());
		browserUsed=br;
		switch (br) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "edge":
			try {
		    	WebDriverManager.edgedriver().setup();
			} catch (Exception e) {
				WebDriverManager.edgedriver().driverVersion("138.0.3351.83").setup();
			}
			driver= new EdgeDriver();
			break;
		default:
			return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("projectUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
