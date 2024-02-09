package org.example.lesson7_homework;


import java.util.Arrays;

public class DynamicIntArray {
    // У вас есть класс DynamicintArray. Внутри него есть 3 характеристики:
    //- int lenght(реальный размер хранимых данных),
    //- int capacity(размер массива),
    //- массив int размером capacity (arr[capacity]),
    //константы:
    //- начальный размер массива по умолчанию (DEFAULT_CAPACITY),
    //- % изменения размера массива при автоматическом увеличениию (PROCENT_CHANGE).
    //Реализуйте 2 конструктора:
    //- по умолчанию (создается массив arr размером DEFAULT_CAPACITY)
    //- с параметром capacity (создается массив arr размер которого передается параметром  capacity).
    //Реализуйте методы:
    //- add(int element) - добавление элемента в конец (не забывайте про ограничения размера массива).
    //- add(int[] elements) - добавление массива элементов в конец нашего массива(не забывайте про ограничения размера массива).
    //- insert (int index, int element) - вставка элемента в место с нужным индексом (не забывайте про ограничения размера массива
    //и смещение элементов вправо)
    //- delete (int index) - удаление элемента (не забывайте про смещение элементов влево при операции).
    //- get(int index) - вернуть значение элемента по index

    private int length;
    private int capacity;
    private int[] arr;
    private final int DEFAULT_CAPACITY = 5;
    private final int PERCENT_CHANGE = 50;
    public DynamicIntArray() {
        this.arr = new int[DEFAULT_CAPACITY];
    }

    public DynamicIntArray(int capacity) {
        if(capacity >= 0) {
            this.capacity = capacity;
            arr = new int[this.capacity];
        }  else {
            throw new IllegalArgumentException("wrong value");
        }
    }

    private int[] grow(int minCapacity) throws Exception {
        return arr = Arrays.copyOf(arr, minCapacity);
    }

    private void add(int[] arr,int element,int index) throws Exception {
        if(index == this.capacity) {
            this.capacity = this.capacity + (this.capacity * PERCENT_CHANGE/100);
            arr = grow(this.capacity);
        }
        arr[index] = element;
        this.length = index + 1;
    }

    public boolean add(int element) throws Exception {
        add(arr, element, length);
        return true;
    }

    private void add(int arr[], int[] elements,int index) throws Exception {
        for (int element : elements) {
            if (index == this.capacity) {
                this.capacity = this.capacity + (this.capacity * PERCENT_CHANGE / 100);
                arr = grow(this.capacity);
            }
            arr[index++] = element;

        }
        this.length = index;
    }

    public boolean add(int[] elements) throws Exception {
        add(arr, elements, length);
        return true;
    }
    

    private void insert(int index, int element,int[] arr) throws Exception {
         if(index < this.capacity  && index >= 0) {
             if(index == this.capacity - 1) {
                 this.capacity = this.capacity + 1;
                 arr = grow(this.capacity);
                 int temp = arr[index];
                 arr[index] = element;
                 arr[index+1] = temp;
             } else {
                 for (int i = this.capacity - 1; i >= index; i--) {
                     arr[i] = arr[i - 1];
                     if (i == index) {
                         arr[index] = element;
                     }
                 }
             }
             this.length++;
         } else if(index == this.capacity) {
             this.capacity = this.capacity + (this.capacity * PERCENT_CHANGE / 100);
             arr = grow(this.capacity);
             arr[index] = element;
             this.length = index + 1;
         } else {
             throw new Exception("wrong value");
         }
    }

    public boolean insert(int index,int element) throws Exception {
        insert(index,element,arr);
        return true;
    }


    public void delete(int element) {
        for (int i = 0; i < this.capacity; i++) {
            if(arr[i] == element) {
                if (arr[this.capacity - 1] != element) {
                    for (int j = i; j < this.capacity - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                }
                arr[this.capacity - 1] = 0;
                length--;
            }
        }
    }

    public int get(int index) {
        if(index <= length)
            return arr[index];
        else
            throw new ArrayIndexOutOfBoundsException("out of bounds");
    }

    public int length() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr,length));
    }
}
