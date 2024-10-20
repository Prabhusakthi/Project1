package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage {
    WebDriver driver;
    By originInput = By.id("origin-input-id");
    By destinationInput = By.id("destination-input-id");
    By searchButton = By.id("search-button-id");

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFlight(String origin, String destination) {
        driver.findElement(originInput).sendKeys(origin);
        driver.findElement(destinationInput).sendKeys(destination);
        driver.findElement(searchButton).click();
    }
}
