package ua.QALightCourse.AQALesson9.put;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson9.dto.CategoryDto;
import ua.QALightCourse.AQALesson9.dto.PetDto;
import ua.QALightCourse.AQALesson9.dto.TagsDto;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PutPetTest {

    @Test
    public void verifyPetCanBeModified() {

        int petIdToCreate = 155;
        int categoryId = 10;
        String categoryName = "Volkodav";
        CategoryDto category = new CategoryDto(categoryId, categoryName);
        String name = "Bobby";
        List<String> photoUrls = List.of(
                "https://images.example.com/gallery/poodle_84721.jpg",
                "https://cdn.pets-world.net/photos/dog_59384.png",
                "https://media.animals-cloud.org/images/pet_12876.jpeg"
        );
        List<TagsDto> tags = List.of(new TagsDto(32, "Text"));
        String status = "available";

        PetDto petToCreate = new PetDto(
                petIdToCreate,
                category,
                name,
                photoUrls,
                tags,
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
        Assert.assertEquals(previouslyCreatedPetDto.getId(), petIdToCreate);

        int newCategoryId = 11;
        String newCategoryName = "Volk";
        CategoryDto newCategory = new CategoryDto(newCategoryId, newCategoryName);
        String newName = "Bobby";
        List<String> newPhotoUrls = List.of(
                "https://picsum.photos/800/600",
                "https://picsum.photos/1200/800",
                "https://picsum.photos/640/480"
        );
        List<TagsDto> newTags = List.of(new TagsDto(30, "Test"));
        String newStatus = "sold";

        petToCreate.setCategory(newCategory);
        petToCreate.setName(newName);
        petToCreate.setPhotoUrls(newPhotoUrls);
        petToCreate.setTags(newTags);
        petToCreate.setStatus(newStatus);

        Response putPetResponse = given()
                .contentType(ContentType.JSON)
                .body(petToCreate)
                .put("https://petstore.swagger.io/v2/pet");

        Response newCreatedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        PetDto newCreatedPetDto = newCreatedPetResponse.as(PetDto.class);

        Assert.assertEquals(newCreatedPetDto.getName(), newName);
        Assert.assertEquals(newCreatedPetDto.getStatus(), newStatus);
        Assert.assertEquals(newCreatedPetDto.getCategory().getName(), newCategoryName);

    }
}
