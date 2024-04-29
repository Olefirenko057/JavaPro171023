package org.example.homeworks.lesson24_homework.task2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private static Set<Mentor> mentors;
    private static Set<Student> students = new HashSet<>();
    private static AtomicInteger moneyEarned = new AtomicInteger(0);
    private static AtomicBoolean enrollmentIsOpen = new AtomicBoolean(true);

    //2*. Одна компания решила заработать миллион. Для этого они решили создать курсы, где за 1000
    //можно обучиться чему-то очень интересному и полезному:
    //они наняли преподавателей, которые получают 10% от суммы оплаты каждого студента.
    //Напишите программу, которая даст возможность набирать студентов на курс до тех пор,
    //пока компания не заработает миллион :) Используйте AtomicInteger для накопления.

    public static void main(String[] args) throws InterruptedException {
        Mentor mentor1 = new Mentor("Alex");
        Mentor mentor2 = new Mentor("Ivan");
        Mentor mentor3 = new Mentor("Leo");
        mentors = Set.of(mentor1,mentor2,mentor3);
        while (Company.moneyEarned.get() < 1_000_000) {
                Thread thread = new Thread(new Student());
                thread.start();
//                System.out.println(Company.moneyEarned.get() + " has been raised");
        }
        Thread.sleep(1500);
        System.out.print("Group enrollment is closed. The goal to earn 1 million has been reached.");
        System.out.println(" The balance of the school: " + Company.moneyEarned);
        System.out.println("There are " + Company.students.size() + " students in our school");
        System.out.println("Each mentor earned " + Company.mentors.stream().findFirst().get().moneyEarned);
    }
    public static class Mentor {
        private String name;
        private volatile double moneyEarned;

        public Mentor(String name) {
            this.name = name;
        }
    }
    public static class Student implements Runnable {
        private final int coursePayment = 1000;
        private int balance;
        private int id;

        public Student() {
            Random random = new Random();
            this.balance = random.nextInt(12_000);
            this.id = random.nextInt(10_000_000);
        }

        @Override
        public void run() {
            if(payForStudying()) {
                balance -= coursePayment;
                int revenueForCompany = coursePayment - coursePayment * 10 / 100;
                int mentorsRemainder = coursePayment - revenueForCompany;
                synchronized (Company.class) {
                    if(Company.enrollmentIsOpen.get()) {
                        Company.moneyEarned.addAndGet(revenueForCompany);
                        double feePerMentor = mentorsRemainder / Company.mentors.size();
                        for (Mentor mentor : Company.mentors) {
                            mentor.moneyEarned += feePerMentor;
                        }
                        Company.students.add(this);
                    }
                }
                System.out.println("student " + id + " started studying");
            } else {
                System.out.println("Failed to pay for studying");
            }
        }

        public boolean payForStudying() {
            if(balance >= coursePayment) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student student)) return false;

            if (coursePayment != student.coursePayment) return false;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            int result = coursePayment;
            result = 31 * result + id;
            return result;
        }
    }
}
