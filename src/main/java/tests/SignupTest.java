package tests;


	import org.testng.annotations.AfterMethod;
    import org.testng.annotations.Test;
    import org.testng.annotations.BeforeMethod;
	import base.BaseClass;
	import pages.SignupPage;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;


	public class SignupTest extends BaseClass {
	    SignupPage signupPage;

	    @BeforeMethod
		@BeforeTest
	    public void setUp() {
	        setup("chrome");
	        signupPage = new SignupPage(driver);
	    }

	    @Test(priority = 1)
	    public void testSuccessfulSignup() {
	        signupPage = new SignupPage(driver);
	        signupPage.fillMandatoryFields("prabhakaran2631994@gmail.com", "Prabhu03!");
	        signupPage.fillOptionalFields("Optional Info");
	        signupPage.submitSignup();
	        // Assert successful signup (modify according to the actual success message)
	        // Assert.assertEquals(signupPage.getSuccessMessage(), "Signup successful");
	    }

	    @Test(priority = 2)
	    public void testSignupWithInvalidEmail() {
	        signupPage.fillMandatoryFields("prabhakaran26031994@gmail.com", "Prabhu94!");
	        signupPage.submitSignup();
	        Assert.assertEquals(signupPage.getErrorMessage(), "Invalid email format");
	    }

	    @Test(priority = 3)
	    public void testSignupWithoutMandatoryFields() {
	        signupPage.submitSignup();
	        Assert.assertEquals(signupPage.getErrorMessage(), "Mandatory fields are missing");
	    }

	    @AfterMethod
		@AfterTest
	    public void tearDown() {
	        BaseClass baseClass = new BaseClass();
			baseClass.tearDown();
	    }
	}


