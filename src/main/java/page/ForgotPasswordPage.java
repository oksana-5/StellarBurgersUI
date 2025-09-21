package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    // кнопка Войти
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open Forgot Password page")
    public void openPage() {
        driver.get(URL);
    }

    @Step("click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
