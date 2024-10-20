package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SelectFlightPage {
    WebDriver driver;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFlight() {
        driver.findElement(By.cssSelector("selectFlightButton")).click();
        driver.findElement(By.id("proceedToBookingButton")).click();
    }
}

