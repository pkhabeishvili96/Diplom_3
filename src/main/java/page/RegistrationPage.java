package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле Имя
    private By fieldsNameRegistration = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //Поле Email
    private By fieldsEmailRegistration = By.xpath(".//label[text()='Email']/following-sibling::input");
    //Поле Пароль
    private By fieldsPasswordRegistration = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    //Кнопка "Зарегистрироваться"
    private By buttonRegistrationInForm = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Кнопка "Войти"
    private By buttonLoginInForm = By.xpath(".//a[text()='Войти']");
    //Сообщение об ошибке: "Некорректный пароль"
    private By messageIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    //Сообщение об ошибке: "Такой пользователь уже существует"
    private By messageUserAlreadyExists = By.xpath(".//p[text()='Такой пользователь уже существует']");

    @Step("Введение значения в поле Имя")
    public void clickFieldsNameRegistration(String name) {
        driver.findElement(fieldsNameRegistration).click();
        driver.findElement(fieldsNameRegistration).sendKeys(name);
    }

    @Step("Введение значения в поле Email")
    public void clickFieldsEmailRegistration(String email) {
        driver.findElement(fieldsEmailRegistration).click();
        driver.findElement(fieldsEmailRegistration).sendKeys(email);
    }

    @Step("Введение значения в поле Пароль")
    public void clickFieldsPasswordRegistration(String password) {
        driver.findElement(fieldsPasswordRegistration).click();
        driver.findElement(fieldsPasswordRegistration).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickButtonRegistrationInForm() {
        driver.findElement(buttonRegistrationInForm).click();
    }

    @Step("Получение сообщения о некорректном пароле")
    public WebElement getMessageIncorrectPassword() {
        return driver.findElement(messageIncorrectPassword);
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonLoginInForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonLogin1Element = wait.until(ExpectedConditions.elementToBeClickable(buttonLoginInForm));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonLogin1Element);
        driver.findElement(buttonLoginInForm).click();
    }

    @Step("Получение сообщения о том, что пользователь уже существует")
    public WebElement getMessageUserAlreadyExists() {
        return driver.findElement(messageUserAlreadyExists);
    }
}