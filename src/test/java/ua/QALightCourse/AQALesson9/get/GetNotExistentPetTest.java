package ua.QALightCourse.AQALesson9.get;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson9.dto.NotFoundPetDto;
import ua.QALightCourse.AQALesson9.dto.PetDto;

import static io.restassured.RestAssured.given;

public class GetNotExistentPetTest {

    @Test
    public void verifyPetEntityCannotBeObtained() {
        int petIdToGet = 10000;

        Response response = given().get("https://petstore.swagger.io/v2/pet/" + petIdToGet);

        NotFoundPetDto notObtainedPet = response.as(NotFoundPetDto.class);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(notObtainedPet.getCode(), 1);
        Assert.assertEquals(notObtainedPet.getType(), "error");
        Assert.assertEquals(notObtainedPet.getMessage(), "Pet not found");
    }
}

