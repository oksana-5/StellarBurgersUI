package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    // поле Имя
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input[@name='name']");
    // поле Email
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input[@name='name']");
    // поле Пароль
    private final By passwordField = By.name("Пароль");
    // кнопка Зарегистрироваться
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // кнопка Войти
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    // сообщение о некорректном пароле
    private final By invalidPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open SignUp page")
    public void openPage() {
        driver.get(URL);
    }

    @Step("set name")
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("set email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("set password")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("click signUp button")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    @Step("click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("get invalid password message")
    public WebElement getInvalidPasswordMessage() {
        return driver.findElement(invalidPasswordMessage);
    }

}
