package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    // кнопка Личный кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    // кнопка Войти в аккаунт
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // кнопка Оформить заказ
    private final By makeOrderButton = By.xpath("//button[contains(@class, 'button_button_type_primary__1O7Bx') and text()='Оформить заказ']");
    // раздел Булки
    private final By bunSection = By.xpath(".//div[./span[text()='Булки']]");
    // раздел Соусы
    private final By sauceSection = By.xpath(".//div[./span[text()='Соусы']]");
    // раздел Начинки
    private final By fillingSection = By.xpath(".//div[./span[text()='Начинки']]");
    // класс выделенного раздела
    private final String selectedSectionClass = "tab_tab_type_current__2BEPc";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open Main page")
    public void openPage() {
        driver.get(URL);
    }

    @Step("click account button")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("click bun section")
    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }

    @Step("click sauce section")
    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    @Step("click filling section")
    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }

    @Step("get makeOrder button")
    public WebElement getMakeOrderButton() {
        return driver.findElement(makeOrderButton);
    }

    @Step("get bun section")
    public WebElement getBunSection() {
        return driver.findElement(bunSection);
    }

    @Step("get sauce section")
    public WebElement getSauceSection() {
        return driver.findElement(sauceSection);
    }

    @Step("get filling section")
    public WebElement getFillingSection() {
        return driver.findElement(fillingSection);
    }

    @Step("wait until bun section is selected")
    public void waitUntilBunSectionIsSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(bunSection, "class", selectedSectionClass));
    }

    @Step("check if bun section is selected")
    public boolean isBunSectionSelected() {
        String classAttribute = getBunSection().getAttribute("class");
        return classAttribute != null && classAttribute.contains(selectedSectionClass);
    }

    @Step("check if sauce section is selected")
    public boolean isSauceSectionSelected() {
        String classAttribute = getSauceSection().getAttribute("class");
        return classAttribute != null && classAttribute.contains(selectedSectionClass);
    }

    @Step("check if filling section is selected")
    public boolean isFillingSectionSelected() {
        String classAttribute = getFillingSection().getAttribute("class");
        return classAttribute != null && classAttribute.contains(selectedSectionClass);
    }

}
