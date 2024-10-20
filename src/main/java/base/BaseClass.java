package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

	public class BaseClass {
	    public static WebDriver driver;

	    public static void setup(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kaleeswari\\eclipse-workspace\\Project1\\src\\main\\java\\base\\chromedriver.exe");
	            driver = new ChromeDriver();
	       
	        }
	        else if (browser.equalsIgnoreCase("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kaleeswari\\eclipse-workspace\\Project1\\src\\main\\java\\base\\geckodriver.exe");
	            driver = new FirefoxDriver();
	        }
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("http://www.spicejet.com");
	    }
	    
	     public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



