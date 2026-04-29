package ua.QALightCourse.Lesson12.Task.Enums;

public enum OrderStatus {
    NEW("NEW"), CANCELED("CANCELED"), COMPLETED("COMPLETED"), NULL("NULL");

    private final String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
