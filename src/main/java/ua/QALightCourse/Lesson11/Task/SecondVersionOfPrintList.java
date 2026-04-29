package ua.QALightCourse.Lesson11.Task;

import java.util.List;

public class SecondVersionOfPrintList {
    static void main(String[] args) {

        List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5);
        for (Integer listOfInteger : listOfIntegers) {
            System.out.println(listOfInteger);
        }
    }

}
