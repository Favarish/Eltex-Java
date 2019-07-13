package ru.eltex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempStr;

        System.out.println("Введите текущий день недели");
        while (true) {
             tempStr = reader.readLine();

            try {
                DayOfWeek.valueOf(tempStr);
                break;

            } catch(Exception ex) {
                System.out.println("Попробуйте ввести еще раз в формате \"TUESDAY\"");
            }
        }

        switch(DayOfWeek.valueOf(tempStr)){
            case MONDAY:
                System.out.println("Осталось 5 дней до субботы");
                break;
            case TUESDAY:
                System.out.println("Осталось 4 дня до субботы");
                break;
            case WEDNESDAY:
                System.out.println("Осталось 3 дня до субботы");
                break;
            case THURSDAY:
                System.out.println("Осталось 2 дня до субботы");
                break;
            case FRIDAY:
                System.out.println("Остался 1 день до субботы");
                break;
            case SUNDAY:
                System.out.println("Ничего не осталось.. до субботы (0 дней)");
                break;
            case SATURDAY:
                System.out.println("До субботы осталась вся неделя (6 дней)");
                break;

            default:
                System.out.println("Error");
                break;

        }
    }
}

