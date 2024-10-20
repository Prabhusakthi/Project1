package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
    WebDriver driver;

    @FindBy(id = "origin")
    WebElement originField;

    @FindBy(id = "destination")
    WebElement destinationField;

    @FindBy(id = "flight-type")
    WebElement flightTypeField;

    @FindBy(xpath = "//button[@id='search-flights']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@id='select-flight']")
    WebElement selectFlightButton;

    @FindBy(xpath = "//button[@id='proceed-to-booking']")
    WebElement proceedToBookingButton;

    // Payment fields
    @FindBy(id = "payment-card-number")
    WebElement cardNumberField;

    @FindBy(id = "payment-expiry-date")
    WebElement expiryDateField;

    @FindBy(id = "payment-cvv")
    WebElement cvvField;

    @FindBy(id = "payment-amount")
    WebElement paymentAmountField;

    @FindBy(xpath = "//button[@id='pay-now']")
    WebElement payNowButton;

    @FindBy(id = "booking-confirmation-message")
    WebElement bookingConfirmationMessage;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFlight(String origin, String destination, String flightType) {
        originField.sendKeys(origin);
        destinationField.sendKeys(destination);
        flightTypeField.sendKeys(flightType);
        searchButton.click();
    }

    public void selectFlight(int flightIndex) {
        // Logic to select a flight based on flightIndex
        selectFlightButton.click();
    }

    public void proceedToBooking() {
        proceedToBookingButton.click();
    }

    public void enterDummyPaymentDetails() {
        cardNumberField.sendKeys("4111111111111111"); // Dummy Visa card number
        expiryDateField.sendKeys("12/24");
        cvvField.sendKeys("123");
    }

    public void validatePaymentAmountIsZero() {
        String amount = paymentAmountField.getText();
        if (!amount.equals("0")) {
            throw new AssertionError("Payment amount is not zero. It is: " + amount);
        }
    }

    public void confirmPayment() {
        payNowButton.click();
    }

    public String getBookingConfirmationMessage() {
        return bookingConfirmationMessage.getText();
    }
}
