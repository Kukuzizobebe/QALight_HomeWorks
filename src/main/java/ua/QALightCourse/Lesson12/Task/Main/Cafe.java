package ua.QALightCourse.Lesson12.Task.Main;

import ua.QALightCourse.Lesson12.Task.Classes.*;
import ua.QALightCourse.Lesson12.Task.Enums.CofeeSize;
import ua.QALightCourse.Lesson12.Task.Enums.TypeOfDessert;
import ua.QALightCourse.Lesson12.Task.Enums.OrderStatus;
import ua.QALightCourse.Lesson12.Task.Enums.TypeOfTea;
import ua.QALightCourse.Lesson12.Task.Exceptions.DuplicateOrderException;
import ua.QALightCourse.Lesson12.Task.Exceptions.InvalidOrderStatusException;
import ua.QALightCourse.Lesson12.Task.Exceptions.NoOrdersException;
import ua.QALightCourse.Lesson12.Task.Exceptions.OrderNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cafe {

    static void main(String[] args) {

        List<Order> ordersList = new ArrayList<>(Arrays.asList(
                new CoffeeOrder(1, CofeeSize.SMALL),
                new CoffeeOrder(2, CofeeSize.MEDIUM),
                new TeaOrder(3, TypeOfTea.BLACK),
                new DessertOrder(4, TypeOfDessert.CAKE)
        ));

        for (Order order : ordersList) {
            order.printOrderInfo();
        }

    }
}
