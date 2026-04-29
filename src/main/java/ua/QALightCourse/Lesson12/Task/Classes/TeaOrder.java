package ua.QALightCourse.Lesson12.Task.Classes;

import ua.QALightCourse.Lesson12.Task.Enums.TypeOfTea;

public class TeaOrder extends Order {

    private TypeOfTea type;

    public TeaOrder(int orderNumber, TypeOfTea type) {
        super(orderNumber);
        this.type = type;
    }

    @Override
    public double getPrice() {
        return switch (type) {
            case type.BLACK -> 15.0;
            case type.GREEN -> 20.0;
            case type.HERBAL-> 21.0;
            default -> throw new IllegalArgumentException(type + " isn`t exist!");
        };
    }

    public void printOrderInfo() {
        System.out.println("\nOCN-" + getOrderNumber() + "(" + getStatus() + "): \n[Tea (type: " + type + ") \nPrice: " + getPrice() + " UAH.]");
    }
}
