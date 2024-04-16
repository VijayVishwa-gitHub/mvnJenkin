package mvnTest.testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mvnTesting {
	WebDriver driver;
	@Test
	public void firstmvn() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream src = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//properties//propFile.properties");
		prop.load(src);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
}

driver.get("https://www.amazon.in/");
Thread.sleep(4000);
driver.quit();
}
		// master is here
		
	}


