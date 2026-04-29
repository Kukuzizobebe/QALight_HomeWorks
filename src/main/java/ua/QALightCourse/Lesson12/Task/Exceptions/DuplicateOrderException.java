package ua.QALightCourse.Lesson12.Task.Exceptions;

public class DuplicateOrderException extends Exception{

    public DuplicateOrderException() {
        super("This order number is exist!");
    }
}
