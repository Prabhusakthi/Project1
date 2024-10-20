package utils;


	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.apache.commons.io.FileUtils;
	import utils.TestUtils;

	import java.io.File;
	import java.io.IOException;

	public class TestUtils {
	    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(srcFile, new File(filePath));
	        TestUtils.takeScreenshot(driver, "path/to/screenshot.png");
	    }
	}



