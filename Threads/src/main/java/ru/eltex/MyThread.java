package ru.eltex;

public class MyThread implements Runnable{
    static Integer number = 0;

    @Override
    public void run() {
        number++;
        System.out.println(number);
    }
}
