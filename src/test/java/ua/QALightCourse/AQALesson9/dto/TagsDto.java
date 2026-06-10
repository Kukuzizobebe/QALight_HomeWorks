package ua.QALightCourse.AQALesson9.dto;

import io.qameta.allure.testng.Tag;

public class TagsDto {

    private int id;
    private String name;

    public TagsDto(){}
    public TagsDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
