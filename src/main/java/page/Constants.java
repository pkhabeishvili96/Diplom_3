package page;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class Constants {

    private WebDriver driver;

    public Constants(WebDriver driver) {
        this.driver = driver;
    }

    private static Faker faker = new Faker();

    public static final String BASE_URI  = "https://stellarburgers.nomoreparties.site/";
    public static final String EMAIL = faker.internet().emailAddress();
    public static final String PASSWORD = faker.internet().password();
    public static final String NAME = faker.internet().password(6, 10, true, false, false);
    public static final String DELETE_USER = "/api/auth/user/%s";
    public static final String LOGIN_USER = "/api/auth/login";
    public static final String CREATE_USER = "/api/auth/register";
}