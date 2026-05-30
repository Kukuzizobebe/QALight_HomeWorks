package ua.QALightCourse.AQALesson9.delete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson9.dto.CategoryDto;
import ua.QALightCourse.AQALesson9.dto.NotFoundPetDto;
import ua.QALightCourse.AQALesson9.dto.PetDto;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    @Test
    public void verifyPetCanBeDeleted() {
        int petIdToCreate = 152;
        CategoryDto categoryDto = new CategoryDto(10, "Pudel");
        String petName = "Bobik";
        String status = "available";

        PetDto petToCreate = new PetDto(
                petIdToCreate,
                categoryDto,
                petName,
                status
        );

        Response createdPetResponse = given()
                .contentType(ContentType.JSON)
                .body(petToCreate)
                .post("https://petstore.swagger.io/v2/pet");

        PetDto createdPetDto = createdPetResponse.as(PetDto.class);
        Assert.assertEquals(createdPetDto.getId(), petIdToCreate);

        Response previouslyCreatedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        PetDto previouslyCreatedPetDto = previouslyCreatedPetResponse.as(PetDto.class);
        Assert.assertEquals(previouslyCreatedPetDto.getId(),petIdToCreate);

        given().delete("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        Response deletedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + petIdToCreate);
        NotFoundPetDto notFoundPetDto = deletedPetResponse.as(NotFoundPetDto.class);

        Assert.assertEquals(deletedPetResponse.getStatusCode(),404);
        Assert.assertEquals(notFoundPetDto.getType(),"error");
        Assert.assertEquals(notFoundPetDto.getMessage(),"Pet not found");




    }
}
