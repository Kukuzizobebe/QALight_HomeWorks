package ua.QALightCourse.AQALesson9.post;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson9.dto.CategoryDto;
import ua.QALightCourse.AQALesson9.dto.PetDto;
import ua.QALightCourse.AQALesson9.dto.TagsDto;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreatePetTest {

    @Test
    public void verifyPetCanBeCreated() {
        int petIdToCreate = 151;
        int categoryId = 10;
        String categoryName = "Pudel";
        CategoryDto categoryDto = new CategoryDto(categoryId, categoryName);
        String petName = "Bobik";
        List<String> photoUrls = List.of(
                "https://images.example.com/poodle1.jpg",
                "https://images.example.com/poodle2.jpg",
                "https://images.example.com/poodle3.jpg"
        );
        List<TagsDto> tags = List.of(new TagsDto(32, "Text"));
        String status = "available";

        PetDto petToCreate = new PetDto(
                petIdToCreate,
                categoryDto,
                petName,
                photoUrls,
                tags,
                status
        );

        Response createdPetResponse = given()
                .contentType(ContentType.JSON)
                .body(petToCreate)
                .post("https://petstore.swagger.io/v2/pet");

        PetDto createdPetDto = createdPetResponse.as(PetDto.class);
        Assert.assertEquals(createdPetDto.getId(),petIdToCreate);

        Response previuoslyCreatedPetResponse = given().get("https://petstore.swagger.io/v2/pet/"+petIdToCreate);
        PetDto previuoslyCreatedPetDto = previuoslyCreatedPetResponse.as(PetDto.class);

        Assert.assertEquals(previuoslyCreatedPetDto.getId(),petIdToCreate);
        Assert.assertEquals(previuoslyCreatedPetDto.getCategory().getId(),categoryId);
        Assert.assertEquals(previuoslyCreatedPetDto.getCategory().getName(),categoryName);
        Assert.assertEquals(previuoslyCreatedPetDto.getName(),petName);
        Assert.assertEquals(previuoslyCreatedPetDto.getStatus(),status);


    }
}
