package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.linkText("Log in"));

        // This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        // Validate actual and expected message
        Assert.assertEquals("Not Navigat to Login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //find login & click
        clickOnElement(By.linkText("Log in"));
        // Enter the email
        sendTextToElement(By.id("Email"), "patel0011@yahoo.com");

        // Enter the password
        sendTextToElement(By.name("Password"), "Dipak&12345");

        // Find the login button and click
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String expectedMassage = "Log Out";
        String actualMessage = getTextFromElement(By.xpath("//a[@class='ico-logout']"));
    }

    @Test
    public void verifyErrorMessage() {
        clickOnElement(By.linkText("Log in"));

        // Enter the Invalid email
        sendTextToElement(By.id("Email"), "patel0001@yahoo.com");

        // Enter the Invalid password
        sendTextToElement(By.name("Password"), "dipak&1234");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String expectedMassage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        String ErrorMessage = getTextFromElement(By.xpath("//div[contains(@class,'message-error')]"));

    }

}
