package ru.eltex;

public class MyThread implements Runnable{

    @Override
    public void run() {
        Printer.ink();
    }
}
