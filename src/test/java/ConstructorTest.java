import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу \"Булки\"")
    @Description("Проверяем, что переход к разделу \"Булки\" работает")
    public void tabBunTest() {
        orderPage.openOrderPage();
        orderPage.clickTabFilling();
        orderPage.clickTabBun();
        WebElement tabBunElement = orderPage.getTabBun();
        assertTrue(tabBunElement.isDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу \"Соусы\"")
    @Description("Проверяем, что переход к разделу \"Соусы\" работает")
    public void tabSauceTest() {
        orderPage.openOrderPage();
        orderPage.clickTabSauce();
        WebElement tabSauceElement = orderPage.getTabSauce();
        assertTrue(tabSauceElement.isDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу \"Начинки\"")
    @Description("Проверяем, что переход к разделу \"Начинки\" работает")
    public void tabFillingTest() {
        orderPage.openOrderPage();
        orderPage.clickTabFilling();
        WebElement tabFillingElement = orderPage.getTabFilling();
        assertTrue(tabFillingElement.isDisplayed());
    }
}
