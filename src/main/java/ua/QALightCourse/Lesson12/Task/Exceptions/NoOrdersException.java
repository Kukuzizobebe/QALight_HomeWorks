package ua.QALightCourse.Lesson12.Task.Exceptions;

public class NoOrdersException extends Exception{
    public NoOrdersException() {
        super("The list of orders is empty!");
    }
}
