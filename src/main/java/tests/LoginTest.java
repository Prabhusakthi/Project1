package tests;

import base.BaseClass;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class LoginTest extends BaseClass {
	    private LoginPage loginPage;

	    
	    @BeforeMethod
		@BeforeTest
	    public void setUp() {
	        setup("chrome");
	        loginPage = new LoginPage(driver);
	    }

	    @Test(priority = 1)
	    public void testSuccessfulLogin() {
	        loginPage = new LoginPage(driver);
	        loginPage.login("valid@example.com", "validPassword");
	        // Assert login success (e.g., check for a logout button)
	    }

	    @Test(priority = 2)
	    public void testLoginWithInvalidCredentials() {
	        loginPage.login("invalid@example.com", "wrongPassword");
	        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
	    }

	    @Test(priority = 3)
	    public void testLoginWithEmptyFields() {
	        loginPage.login("", "");
	        Assert.assertEquals(loginPage.getErrorMessage(), "Email and password cannot be empty");
	    }
	
	    @AfterMethod
			@AfterTest
		    public void tearDown() {
		        BaseClass baseClass = new BaseClass();
				baseClass.tearDown();
		    }
		}
	
	
	
	


