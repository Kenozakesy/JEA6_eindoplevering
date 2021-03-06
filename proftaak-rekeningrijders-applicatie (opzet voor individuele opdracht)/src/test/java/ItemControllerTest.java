import com.google.gson.Gson;
import domain.Item;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
/*
TDD: Get items and add/delete items
 */
public class ItemControllerTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost/1";
        RestAssured.port = 8080;
    }
    @Test
    public void testCreateItemSuccess() {
        Gson gson = new Gson();
        Item item = new Item();
        item.setPrice(29.99);
        item.setName("Whiskey");
        Response response = given().
                contentType(ContentType.JSON)
                .body(gson.toJson(item))
                .when()
                .post( "/api/item/save");
        System.out.println("POST Response\n" + response.asString());
        response.then().body("name", Matchers.is("Whiskey"));
    }

}
