package org.example.homeworks.lesson16_homework.part2Last;

import org.example.homeworks.lesson16_homework.part1.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LastTask {
    // // Задача 15: Фильтрация и сортировка пользователей по возрасту.
    public static void main(String[] args) {
        User user1 = new User("Tom",25);
        User user2 = new User("Elizabeth",25);
        User user3 = new User("Toni",31);
        User user4 = new User("Ivan",19);
        User user5 = new User("Mira",23);
        User user6 = new User("Leandro",25);
        User user7 = new User("Sandra",27);
        User user8 = new User("Manuel",22);
        User user9 = new User("Jack",19);
        User user10 = new User("Angel",22);
        Set<User> users = Set.of(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);

        System.out.println(getUsersWithStudentsSubscription(users));
        System.out.println(getUsersWithDiscountedSubscription(users));
        System.out.println(getUsersWithNormalSubscription(users));
    }

    public static List<User> getUsersWithStudentsSubscription(Set<User> users) {
        return users.stream()
                .filter(user -> user.getAge() <= 23)
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }
    public static List<User> getUsersWithDiscountedSubscription(Set<User> users) {
        return users.stream()
                .filter(user -> user.getAge() > 23 && user.getAge() < 27)
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }
    public static Collection<User> getUsersWithNormalSubscription(Set<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 27)
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
 class User {
     private String name;
     private int age;


 public User(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

     @Override
     public String toString() {
         return "User{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }

