package ru.eltex;

public enum DayOfWeek {
    SUNDAY ("воскресенье"),
    MONDAY ("понедельник"),
    TUESDAY ("вторник"),
    WEDNESDAY ("среда"),
    THURSDAY ("четверг"),
    FRIDAY ("пятница"),
    SATURDAY ("суббота");

    private String title;

    DayOfWeek(String title) {
        this.title = title;
    }
}
