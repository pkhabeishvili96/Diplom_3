package page;

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
    private By buttonLogin2 = By.xpath(".//a[text()='Войти']");

    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    public void clickButtonLogin2() {
        driver.findElement(buttonLogin2).click();
    }

    public void clickButtonRecoveredPassword() {
        driver.findElement(buttonRecoveredPassword).click();
    }

    public WebElement getHeading() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(heading));
    }

    public void clickFieldsEmail(String email) {
        driver.findElement(fieldsEmail).click();
        driver.findElement(fieldsEmail).sendKeys(email);
    }

    public void clickFieldsPassword(String password) {
        driver.findElement(fieldsPassword).click();
        driver.findElement(fieldsPassword).sendKeys(password);
    }
}