package ua.QALightCourse.Lesson12.Task.Classes;

import ua.QALightCourse.Lesson12.Task.Enums.CofeeSize;

public class CoffeeOrder extends Order {

    private CofeeSize size;

    public CoffeeOrder(int orderNumber, CofeeSize size) {
        super(orderNumber);
        this.size = size;
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case size.SMALL -> 20.0;
            case size.MEDIUM -> 35.0;
            case size.LARGE -> 50.0;
            default -> throw new IllegalArgumentException(size + " isn`t exist!");
        };
    }

    @Override
    public void printOrderInfo() {
        System.out.println("\nOCN-" + getOrderNumber() + "(" + getStatus() + "): \n[Coffee (size: " + size + ") \nPrice: " + getPrice() + " UAH.]");
    }
}
