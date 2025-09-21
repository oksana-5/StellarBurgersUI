import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("possible to select bun section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectBunSectionTest() {
        mainPage.openPage();
        mainPage.clickSauceSection();
        mainPage.clickBunSection();
        WebElement bunSection = mainPage.getBunSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(mainPage.getBunSection(), "class", "tab_tab_type_current__2BEPc"));
        String classAttribute = bunSection.getAttribute("class");
        Assert.assertNotNull(classAttribute);
        boolean isSelected = classAttribute.contains("tab_tab_type_current__2BEPc");

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }

    @Test
    @DisplayName("possible to select sauce section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectSauceSectionTest() {
        mainPage.openPage();
        mainPage.clickSauceSection();
        WebElement sauceSection = mainPage.getSauceSection();
        String classAttribute = sauceSection.getAttribute("class");
        Assert.assertNotNull(classAttribute);
        boolean isSelected = classAttribute.contains("tab_tab_type_current__2BEPc");

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }

    @Test
    @DisplayName("possible to select filling section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectFillingSectionTest() {
        mainPage.openPage();
        mainPage.clickFillingSection();
        WebElement fillingSection = mainPage.getFillingSection();
        String classAttribute = fillingSection.getAttribute("class");
        Assert.assertNotNull(classAttribute);
        boolean isSelected = classAttribute.contains("tab_tab_type_current__2BEPc");

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }
}

