package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillMandatoryFields(String email, String password) {
        driver.findElement(By.id("signupEmail")).sendKeys(email);
        driver.findElement(By.id("signupPassword")).sendKeys(password);
    }

    public void fillOptionalFields(String optionalField) {
        driver.findElement(By.id("optionalField")).sendKeys(optionalField);
    }

    public void submitSignup() {
        driver.findElement(By.id("signupButton")).click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("error")).getText();
    }

	public void signup(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		
	}
}

