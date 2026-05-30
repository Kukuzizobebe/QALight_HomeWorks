package ua.QALightCourse.AQALesson9.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteNonExistentPetTest {

    @Test
    public void verifyPetCannotBeDeleted() {
        int petNotExistId = 100000;
        Response deletePetWithId = given()
                .delete("https://petstore.swagger.io/v2/pet/" + petNotExistId);
        Assert.assertEquals(deletePetWithId.getStatusCode(), 404);
    }
}

