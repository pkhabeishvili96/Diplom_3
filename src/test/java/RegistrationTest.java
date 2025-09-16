import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static page.Constants.*;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверяем, что можно успешно зарегистрироваться")
    public void registrationTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonAccount();
        loginPage.clickButtonRegistration();
        registrationPage.clickFieldsNameRegistration(NAME);
        registrationPage.clickFieldsEmailRegistration(EMAIL);
        registrationPage.clickFieldsPasswordRegistration(PASSWORD);
        registrationPage.clickButtonRegistration1();
        try {
            loginPage.getHeading();
        } catch (Exception e) {
            WebElement messageUserElement = registrationPage.getMessageUserAlreadyExists();
            assertTrue(messageUserElement.isDisplayed());
        }
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Проверяем, что при некорректном пароле появляется ошибка")
    public void registrationIncorrectPasswordTest() {
        orderPage.openOrderPage();
        orderPage.clickButtonAccount();
        loginPage.clickButtonRegistration();
        registrationPage.clickFieldsNameRegistration(NAME);
        registrationPage.clickFieldsEmailRegistration(EMAIL);
        registrationPage.clickFieldsPasswordRegistration("12345");
        registrationPage.clickButtonRegistration1();
        WebElement messageElement = registrationPage.getMessageIncorrectPassword();
        assertTrue(messageElement.isDisplayed());
    }
}

