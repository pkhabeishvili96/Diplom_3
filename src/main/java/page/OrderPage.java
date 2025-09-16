package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static page.Constants.*;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Войти в аккаунт"
    private By buttonAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный Кабинет"
    private By buttonPersonal = By.xpath(".//p[text()='Личный Кабинет']");
    //Вкладка "Булки" активна
    private By tabBunActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Вкладка "Булки" неактивна
    private By tabBunInactive = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Вкладка "Соусы" активна
    private By tabSauceActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Вкладка "Соусы" неактивна
    private By tabSauceInactive = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Вкладка "Начинки" активна
    private By tabFillingActive = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Вкладка "Начинки" неактивна
    private By tabFillingInactive = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Кнопка "Оформить заказ"
    private By buttonOrder = By.xpath(".//button[text()='Оформить заказ']");

    public void openOrderPage() {
        driver.get(BASE_URI);
    }

    public void clickButtonAccount() {
        driver.findElement(buttonAccount).click();
    }

    public void clickButtonPersonal() {
        driver.findElement(buttonPersonal).click();
    }

    public WebElement getButtonOrder() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(buttonOrder));
    }

    public void clickTabFilling() {
        driver.findElement(tabFillingInactive).click();
    }

    public WebElement getTabFilling() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(tabFillingActive));
    }

    public void clickTabSauce() {
        driver.findElement(tabSauceInactive).click();
    }

    public WebElement getTabSauce() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(tabSauceActive));
    }

    public void clickTabBun() {
        driver.findElement(tabBunInactive).click();
    }

    public WebElement getTabBun() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(tabBunActive));
    }
}