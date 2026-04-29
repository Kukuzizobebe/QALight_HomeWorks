package ua.QALightCourse.Lesson12.Task.Classes;

import ua.QALightCourse.Lesson12.Task.Enums.OrderStatus;
import ua.QALightCourse.Lesson12.Task.Exceptions.InvalidOrderStatusException;
import ua.QALightCourse.Lesson12.Task.Interface.Priceable;
import ua.QALightCourse.Lesson12.Task.Interface.Printable;

import java.util.EnumSet;
import java.util.Set;

public abstract class Order implements Priceable, Printable {

    private final int orderNumber;

    private OrderStatus status;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.status = OrderStatus.NEW;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) throws InvalidOrderStatusException {

        Set<OrderStatus> setOfAllowedStatuses = EnumSet.of(OrderStatus.NEW, OrderStatus.CANCELED, OrderStatus.COMPLETED);
        setOfAllowedStatuses.stream()
                .filter(s -> s.equals(status))
                .findFirst()
                .orElseThrow(InvalidOrderStatusException::new);
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "orderNumber=" + orderNumber +
                ", status=" + status +
                '}';
    }
}
