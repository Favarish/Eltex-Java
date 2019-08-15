package ru.eltex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // автоконфигурирование, обозначение точки входа
public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class);
    }

    @Bean // компонент контекста Spring
    public CommandLineRunner demo(UserRepository crudRepository) {
        return (args) -> {
            crudRepository.save(new User("Ivan", "900"));
            crudRepository.save(new User("Boris", "800"));
            for (User user : crudRepository.findAll()) {
                System.out.println(user.getFio());
            }
            crudRepository.save(new User(1, "Barby", "111"));
            for (User user : crudRepository.findAll()) {
                System.out.println(user.getFio());
            }
        };
    }

    @Bean
    public CommandLineRunner demo1(CatRepository mongoRepository) {
        return (args) -> {
            Cat cat1 = new Cat(1, "Barsik", 15);
            mongoRepository.insert(cat1);
            for (Cat cat : mongoRepository.findAll()) {
                System.out.println(cat.getName());
            }
        };
    }
}