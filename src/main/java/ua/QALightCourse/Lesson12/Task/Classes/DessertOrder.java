package ua.QALightCourse.Lesson12.Task.Classes;

import ua.QALightCourse.Lesson12.Task.Enums.TypeOfDessert;

public class DessertOrder extends Order {

    private TypeOfDessert dessertName;

    public DessertOrder(int orderNumber, TypeOfDessert dessertName) {
        super(orderNumber);
        this.dessertName = dessertName;
    }

    @Override
    public double getPrice() {
        return switch (dessertName) {
            case dessertName.PANCAKES -> 25.0;
            case dessertName.CAKE -> 50.0;
            case dessertName.CANDIES -> 36.0;
            default -> throw new IllegalArgumentException(dessertName + " isn`t exist!");
        };
    }

    @Override
    public void printOrderInfo() {
        System.out.println("\nOCN-" + getOrderNumber() + "(" + getStatus() + "): \n[Dessert (" + dessertName + ") \nPrice: " + getPrice() + " UAH.]");
    }
}
