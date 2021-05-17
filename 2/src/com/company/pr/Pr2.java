package com.company.pr;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.Random;

/*
 1) класс Human (int age, String firstName, String lastName, LocalDate birthDate, int weight);
 2) приложение, которое создает список из объектов класса Human,
    а затем производит действия в соответствии с вариантом индивидуального задания
    (список после каждого этапа должен выводиться в консоль).
 Все действия должны производиться только с использованием Stream API.
 Индивидуальное задание должно быть оформлено в отдельном проекте.
 Для проверки работоспособности выполненного индивидуального задания следует
 использовать отдельный класс с методом main.

 7) Выбор первых 5 элементов списка, сортировка по дате рождения от старых к новым,
 фильтрация по весу меньше, чем 60,
 вывод имени и фамилии через пробел.
 */
public class Pr2 {

    public static void test(ArrayList<Human> humans){
        /*
        Stream<Human> hs = humans.stream();
        hs.limit(5)
          .sorted(
                Comparator.comparing(Human::getBirthDate)
          )
          .filter(
                (h) -> h.getWeight() < 60
          )
          .forEach(
                (h) -> System.out.println(h.getFirstName() + " " + h.getLastName())
          );
        */
        Stream<Human> hs = humans.stream();
        hs.limit(5).forEach(
                (h) -> System.out.println(h.toString())
        );

        System.out.println("---");
        hs = humans.stream();
        hs.limit(5)
          .sorted(
                Comparator.comparing(Human::getBirthDate)
          )
          .forEach(
                  System.out::println
          );

        System.out.println("---");
        hs = humans.stream();
        hs.limit(5)
            .sorted(
                    Comparator.comparing(Human::getBirthDate)
            )
            .filter(
                    (h) -> h.getWeight() < 60
            ).forEach(
                System.out::println
            );

        System.out.println("---");
        hs = humans.stream();
        hs.limit(5)
            .sorted(
                    Comparator.comparing(Human::getBirthDate)
            )
            .filter(
                    (h) -> h.getWeight() < 60
            )
            .forEach(
                    (h) -> System.out.println(h.getFirstName() + " " + h.getLastName())
            );

    }

    public static Human getHuman(){
        Random r = new Random();
        String[] names = new String[]{"Боб", "Иван", "Петя", "Дункан"};
        String[] surNames = new String[]{"Кузнецов", "Белый", "МакКлауд", "Огурцов"};

        return new Human(r.nextInt(100),
                names[r.nextInt(names.length)],
                surNames[r.nextInt(surNames.length)],
                LocalDate.of(r.nextInt(2020)+1, r.nextInt(11)+1, r.nextInt(28)+1),
                r.nextInt(100));
    }

    public static void main(String[] args) {
        ArrayList<Human> hal = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            hal.add(getHuman());
        test(hal);
    }
}
