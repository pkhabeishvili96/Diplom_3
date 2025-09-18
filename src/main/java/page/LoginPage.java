package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Зарегистрироваться"
    private By buttonRegistration = By.xpath(".//a[text()='Зарегистрироваться']");
    //Кнопка "Восстановить пароль"
    private By buttonRecoveredPassword = By.xpath(".//a[text()='Восстановить пароль']");
    //Заголовок "Вход"
    private By heading = By.xpath(".//h2[text()='Вход']");
    //Кнопка "Войти"
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    //Поле Email
    private By fieldsEmail = By.xpath(".//input[@type='text']");
    //Поле Пароль
    private By fieldsPassword = By.xpath(".//input[@type='password']");
    //Кнопка "Войти" формы восстановления пароля
    private By buttonLoginRecoveryForm = By.xpath(".//a[text()='Войти']");

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Клик по кнопке Войти в форме восстановления пароля")
    public void clickButtonLoginRecoveryForm() {
        driver.findElement(buttonLoginRecoveryForm).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickButtonRecoveredPassword() {
        driver.findElement(buttonRecoveredPassword).click();
    }

    @Step("Ожидание появления заголовка Вход")
    public WebElement getHeading() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    @Step("Введение значения в поле Email")
    public void clickFieldsEmail(String email) {
        driver.findElement(fieldsEmail).click();
        driver.findElement(fieldsEmail).sendKeys(email);
    }

    @Step("Введение значения в поле Пароль")
    public void clickFieldsPassword(String password) {
        driver.findElement(fieldsPassword).click();
        driver.findElement(fieldsPassword).sendKeys(password);
    }
}