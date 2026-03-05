import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static data.TestData.*;
import static org.junit.Assert.assertTrue;

public class SignUpTest extends BaseTest {

    @Test
    @DisplayName("sign up success test")
    @Description("if sign up success then makeOrder button should be displayed")
    public void SignUpSuccessTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        signUpPage.openPage();
        signUpPage.setName(NAME);
        signUpPage.setEmail(EMAIL);
        signUpPage.setPassword(PASSWORD);
        signUpPage.clickSignUpButton();
        loginPage.openPage();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement makeOrderButton = mainPage.getMakeOrderButton();
        assertTrue("Регистрация не прошла", makeOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("sign up with invalid password test")
    @Description("if password is invalid then invalid password message should be displayed")
    public void SignUpWithInvalidPasswordTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        signUpPage.openPage();
        signUpPage.setName(NAME);
        signUpPage.setEmail(EMAIL);
        signUpPage.setPassword("1");
        signUpPage.clickSignUpButton();
        WebElement invalidPasswordMessage = signUpPage.getInvalidPasswordMessage();
        assertTrue("Регистрация не прошла", invalidPasswordMessage.isDisplayed());
    }

}
