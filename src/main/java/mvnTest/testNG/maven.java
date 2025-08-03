package mvnTest.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class maven{
	WebDriver driver;
	@Test
	public void first() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\propFile.properties");
		prop.load(fil);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();}
		else if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browserName.contains("headless")){
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
        else if(browserName.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
		}
		
		
		driver.get("https://www.amazon.in/");
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\checking.png"));
		driver.quit();
		
		
	}
}

