import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.CreateUserModel;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static page.Constants.*;
import static steps.UserSteps.createUser;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        CreateUserModel user = new CreateUserModel(EMAIL, PASSWORD, NAME);
        createUser(user);
    }

    @Test
    @DisplayName("Вход по кнопке \"Войти в аккаунт\"")
    @Description("Проверяем, что можно войти через кнопку \"Войти в аккаунт\"")
    public void loginButtonAccountTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonAccount();
        loginPage.clickFieldsEmail(EMAIL);
        loginPage.clickFieldsPassword(PASSWORD);
        loginPage.clickButtonLogin();
        WebElement buttonOrderElement = orderPage.getButtonOrder();
        assertTrue(buttonOrderElement.isDisplayed());
    }

    @Test
    @DisplayName("Вход по кнопке \"Личный кабинет\"")
    @Description("Проверяем, что можно войти через кнопку \"Личнй кабинет\"")
    public void loginButtonPersonalTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonPersonal();
        loginPage.clickFieldsEmail(EMAIL);
        loginPage.clickFieldsPassword(PASSWORD);
        loginPage.clickButtonLogin();
        WebElement buttonOrderElement = orderPage.getButtonOrder();
        assertTrue(buttonOrderElement.isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяем, что можно войти через кнопку в форме регистрации")
    public void loginButtonRegistrationFormTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonPersonal();
        loginPage.clickButtonRegistration();
        registrationPage.clickButtonLogin1();
        loginPage.clickFieldsEmail(EMAIL);
        loginPage.clickFieldsPassword(PASSWORD);
        loginPage.clickButtonLogin();
        WebElement buttonOrderElement = orderPage.getButtonOrder();
        assertTrue(buttonOrderElement.isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяем, что можно войти через кнопку в форме восстановления пароля")
    public void loginButtonPasswordRecoveryFormTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonPersonal();
        loginPage.clickButtonRecoveredPassword();
        loginPage.clickButtonLogin2();
        loginPage.clickFieldsEmail(EMAIL);
        loginPage.clickFieldsPassword(PASSWORD);
        loginPage.clickButtonLogin();
        WebElement buttonOrderElement = orderPage.getButtonOrder();
        assertTrue(buttonOrderElement.isDisplayed());
    }
}
