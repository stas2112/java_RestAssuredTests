package ApiTests.Tests;

import ApiTests.PojoClasses.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL ="https://reqres.in";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        Assert.assertTrue(users.stream().allMatch(item-> item.getEmail().endsWith("@reqres.in")));
    }
}
