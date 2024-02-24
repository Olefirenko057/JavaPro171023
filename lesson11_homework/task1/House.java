package org.example.lesson11_homework.task1;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class House implements Comparable<House>{
    // 1 уровень сложности: 1. Вы автоматизируете бизнес риелторов. у вас есть класс:
    //public class House {
    //    int area; //площадь дома
    //    int price; // цена
    //    String city; // город
    //    boolean hasFurniture; //продается с мебелью
    //}
    //
    //
    //По умолчанию в вашем информационном хранилище дома сортируются по цене.
    //
    //Но иногда клиент хочет видеть информацию о домах в конкретном городе и осортированную по цене.
    //Реализуйте компаратор, который вы можете применить для показа клиенту в требуемом им формате.
    //
    //А если клиенту неожиданно захочет увидеть информацию, отсортированную в формате:
    //"город - площадь дома", что вы будете делать?
    private int area;
    private int price;
    private String city;
    private boolean hasFurniture;

    public House(int area, int price, String city, boolean hasFurniture) {
        this.area = area;
        this.price = price;
        this.city = city;
        this.hasFurniture = hasFurniture;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;

        if (getArea() != house.getArea()) return false;
        if (getPrice() != house.getPrice()) return false;
        if (isHasFurniture() != house.isHasFurniture()) return false;
        return getCity().equals(house.getCity());
    }

    @Override
    public int hashCode() {
        int result = getArea();
        result = 31 * result + getPrice();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + (isHasFurniture() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "area=" + area +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", hasFurniture=" + hasFurniture +
                '}';
    }

    @Override
    public int compareTo(House o) {
        int result = Integer.compare(this.price,o.price);
        if(result == 0) {
            result = Integer.compare(this.area,o.area);
            if(result == 0) {
                return this.city.compareTo(o.city);
            }
            return result;
        }
        return result;
    }

}
