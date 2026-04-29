package ua.QALightCourse.Lesson12.Task.Exceptions;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException() {
        super("Order`s not found!");
    }
}
