package ua.QALightCourse.AQALesson9.get;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson9.dto.PetDto;

import static io.restassured.RestAssured.given;

public class GetPetTest {

    @Test
    public void verifyPetEntityCanBeObtained() {
        int petIdToGet = 150;

        Response response = given().get("https://petstore.swagger.io/v2/pet/" + petIdToGet);

        PetDto obtainedPet = response.as(PetDto.class);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(obtainedPet.getId(),petIdToGet);
    }
}
