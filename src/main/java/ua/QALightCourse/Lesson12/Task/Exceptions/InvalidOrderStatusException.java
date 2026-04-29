package ua.QALightCourse.Lesson12.Task.Exceptions;

public class InvalidOrderStatusException extends Exception{

    public InvalidOrderStatusException() {
        super("Status`s not valid!");
    }
}
