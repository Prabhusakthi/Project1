package tests;


import base.BaseClass;
import pages.BookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends BaseClass {
    private BookingPage bookingPage;

    @Test(priority = 1)
    public void testSuccessfulFlightSearch() {
        bookingPage = new BookingPage(driver);
        bookingPage.searchFlight("Delhi", "Mumbai", "oneway");
        // Validate that the flight results are displayed
    }

    @Test(priority = 2)
    public void testSearchFlightWithInvalidOrigin() {
        bookingPage.searchFlight("", "Mumbai", "oneway");
        // Assert error message or that no results are displayed
    }

    @Test(priority = 3)
    public void testBookingWithEmptyFlightSelection() {
        bookingPage.searchFlight("Delhi", "Mumbai", "oneway");
        bookingPage.selectFlight(0);
        bookingPage.proceedToBooking();
        // Validate that booking page is reached
    }

    @Test(priority = 4)
    public void testDummyPaymentWithZeroAmount() {
        bookingPage = new BookingPage(driver);
        bookingPage.searchFlight("Delhi", "Mumbai", "oneway");
        bookingPage.selectFlight(0);
        bookingPage.proceedToBooking();

        // Enter dummy payment details
        bookingPage.enterDummyPaymentDetails();

        // Validate that the payment amount is zero
        bookingPage.validatePaymentAmountIsZero();

        // Confirm payment
        bookingPage.confirmPayment();

        // Validate that booking is successful
        String confirmationMessage = bookingPage.getBookingConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Booking successful", "Booking confirmation message is incorrect");
    }
}
