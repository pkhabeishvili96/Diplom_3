package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CreateUserModel;
import model.LoginUserModel;

import static io.restassured.RestAssured.given;
import static page.Constants.*;

public class UserSteps {

    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .when()
                .delete(String.format(DELETE_USER, accessToken));
    }

    @Step("Авторизация пользователя в системе")
    public static Response loginUser(LoginUserModel loginUser) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginUser)
                .when()
                .post(LOGIN_USER)
                .then()
                .log().all()
                .extract().response();
    }

    @Step("Создание пользователя")
    public static Response createUser(CreateUserModel user) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(CREATE_USER)
                .then()
                .log().all()
                .extract().response();
    }
}
