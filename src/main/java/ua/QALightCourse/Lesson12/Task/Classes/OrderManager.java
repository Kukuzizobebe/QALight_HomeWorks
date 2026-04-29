package ua.QALightCourse.Lesson12.Task.Classes;

import ua.QALightCourse.Lesson12.Task.Enums.OrderStatus;
import ua.QALightCourse.Lesson12.Task.Exceptions.DuplicateOrderException;
import ua.QALightCourse.Lesson12.Task.Exceptions.NoOrdersException;
import ua.QALightCourse.Lesson12.Task.Exceptions.OrderNotFoundException;
import ua.QALightCourse.Lesson12.Task.Interface.Priceable;

import java.util.*;

public class OrderManager {

    private final List<Order> ordersList;

    public OrderManager(List<Order> orders) {
        this.ordersList = orders;
    }

    public void addOrder(Order order) throws DuplicateOrderException {
        boolean isDuplicated = ordersList.stream()
                .anyMatch(o -> o.getOrderNumber() == order.getOrderNumber());
        if (!isDuplicated) {
            ordersList.add(order);
        } else throw new DuplicateOrderException();
    }

    public void removeOrderByNumber(int orderNumber) throws OrderNotFoundException {
        ordersList.stream().
                filter(o -> o.getOrderNumber() == orderNumber)
                .findFirst()
                .orElseThrow(OrderNotFoundException::new);
        ordersList.removeIf(o -> o.getOrderNumber() == orderNumber);
    }

    public Order findOrderByNumber(int orderNumber) throws OrderNotFoundException {
        return ordersList.stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .findFirst()
                .orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        List<Order> orderStatusList = new ArrayList<>();
        ordersList.stream()
                .filter(o -> Objects.equals(o.getStatus().getStatusName(), status.getStatusName()))
                .forEach(orderStatusList::add);
        return orderStatusList;
    }

    public Map<String, Integer> getOrderTypeCounts() {
        Map<String, Integer> mapOfOrderTypeCounts = new HashMap<>();
        for (int i = 0; i < ordersList.size(); i++) {
            switch (ordersList.get(i)) {
                case CoffeeOrder coffeeOrder -> mapOfOrderTypeCounts.merge("Coffee", 1, Integer::sum);
                case TeaOrder teaOrder -> mapOfOrderTypeCounts.merge("Tea", 1, Integer::sum);
                case DessertOrder dessertOrder -> mapOfOrderTypeCounts.merge("Dessert", 1, Integer::sum);
                default -> throw new IllegalArgumentException(ordersList.getClass() + " isn`t used in our project!");
            }
        }
        return mapOfOrderTypeCounts;
    }

    public double calculateTotalOrder() throws NoOrdersException {
        if (ordersList.isEmpty()) {
            throw new NoOrdersException();
        }
        return ordersList.stream()
                .filter(o -> o.getStatus() == OrderStatus.NEW).mapToDouble(Priceable::getPrice).sum();
    }

}
