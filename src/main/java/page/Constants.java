package page;
import org.openqa.selenium.WebDriver;

public class Constants {

    private WebDriver driver;

    public Constants(WebDriver driver) {
        this.driver = driver;
    }

    public static final String BASE_URI  = "https://stellarburgers.nomoreparties.site/";
    public static final String EMAIL = "iva@ya.ru" + System.currentTimeMillis();
    public static final String PASSWORD = "1234" + System.currentTimeMillis();
    public static final String NAME = "iva" + System.currentTimeMillis();
    public static final String DELETE_USER = "/api/auth/user/%s";
    public static final String LOGIN_USER = "/api/auth/login";
    public static final String CREATE_USER = "/api/auth/register";
}