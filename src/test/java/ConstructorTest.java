import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("possible to select bun section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectBunSectionTest() {
        mainPage.openPage();
        mainPage.clickSauceSection();
        mainPage.clickBunSection();

        mainPage.waitUntilBunSectionIsSelected();
        boolean isSelected = mainPage.isBunSectionSelected();

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }

    @Test
    @DisplayName("possible to select sauce section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectSauceSectionTest() {
        mainPage.openPage();
        mainPage.clickSauceSection();

        boolean isSelected = mainPage.isSauceSectionSelected();

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }

    @Test
    @DisplayName("possible to select filling section test")
    @Description("selected section should have class 'tab_tab_type_current__2BEPc'")
    public void possibleToSelectFillingSectionTest() {
        mainPage.openPage();
        mainPage.clickFillingSection();

        boolean isSelected = mainPage.isFillingSectionSelected();

        assertTrue("Элемент должен иметь класс tab_tab_type_current__2BEPc", isSelected);
    }
}

