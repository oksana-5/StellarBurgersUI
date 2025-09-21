import builder.UserBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static data.TestData.*;
import static org.junit.Assert.assertTrue;
import static steps.UserSteps.createUser;

public class LoginTest extends BaseTest {

    @Before
    public void createUserSuccess() {
        UserBuilder userBuilder = new UserBuilder.Builder()
                .withEmail(EMAIL)
                .withPassword(PASSWORD)
                .withName(NAME)
                .build();

        createUser(userBuilder);
    }

    @Test
    @DisplayName("login with login button on main page test")
    @Description("if login success then makeOrder button should be displayed")
    public void loginWithLoginButtonOnMainPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.openPage();
        mainPage.clickLoginButton();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement makeOrderButton = mainPage.getMakeOrderButton();
        assertTrue("Регистрация не прошла", makeOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login with account button test")
    @Description("if login success then makeOrder button should be displayed")
    public void loginWithAccountButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.openPage();
        mainPage.clickAccountButton();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement makeOrderButton = mainPage.getMakeOrderButton();
        assertTrue("Регистрация не прошла", makeOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login with login button on SignUp page test")
    @Description("if login success then makeOrder button should be displayed")
    public void loginWithLoginButtonOnSignUpPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        signUpPage.openPage();
        signUpPage.clickLoginButton();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement makeOrderButton = mainPage.getMakeOrderButton();
        assertTrue("Регистрация не прошла", makeOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login with login button on Forgot Password page test")
    @Description("if login success then makeOrder button should be displayed")
    public void loginWithLoginButtonOnForgotPasswordPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        forgotPasswordPage.openPage();
        forgotPasswordPage.clickLoginButton();
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement makeOrderButton = mainPage.getMakeOrderButton();
        assertTrue("Регистрация не прошла", makeOrderButton.isDisplayed());
    }

}
