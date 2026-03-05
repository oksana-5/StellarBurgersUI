package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    //поле ввода Email
    private final By emailField = By.name("name");
    //поле ввода Пароль
    private final By passwordField = By.name("Пароль");
    //кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open Login page")
    public void openPage() {
        driver.get(URL);
    }

    @Step("set email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("set password")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}