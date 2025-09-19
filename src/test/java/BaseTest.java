import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.LoginUserModel;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

import static java.net.HttpURLConnection.*;
import static page.Constants.*;
import static steps.UserSteps.deleteUser;
import static steps.UserSteps.loginUser;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    OrderPage orderPage;
    Constants constants;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:/Users/sslla/Downloads/yandexdriver-25.8.0.1872-win64/yandexdriver.exe");
        driver = new ChromeDriver();
        orderPage = new OrderPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        constants = new Constants(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        RestAssured.baseURI = BASE_URI;
        LoginUserModel loginUser = new LoginUserModel(EMAIL, PASSWORD);
        Response response = loginUser(loginUser);
        if (response.statusCode() == HTTP_OK) {
            String userToken = response.jsonPath().getString("accessToken");
            deleteUser(userToken);
        }
    }
}