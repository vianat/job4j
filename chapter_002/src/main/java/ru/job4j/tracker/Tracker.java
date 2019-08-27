package ru.job4j.tracker;

import java.util.*;
public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    private String generateId() {
        Random rand = new Random();
        return String.valueOf(rand.nextLong() + System.currentTimeMillis());
    }
    public boolean replace(String id, Item item) {
        boolean result = false;
        for(int x = 0; x < items.length; x++) {
            if(items[x].getId().equals(id)){
                items[x].setName(item.getName());
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        boolean result = false;
        for(int x = 0; x < this.items.length; x++) {
            if(this.items[x].getId().equals(id)){
                //создать новый массив - 1
                Item[] newItems = new Item[this.items.length - 1];
                //скопировать в новый, начало старого массива и конец, исключая искомый элемент
                System.arraycopy(this.items, 0, newItems, 0, x);
                System.arraycopy(this.items, x + 1, newItems, x, this.items.length - 1 - x);
                //перезаписать в старый массив, новый
                this.items = newItems;
                result = true;
                break;
            }
        }
        return result;
    }
    public Item[] findAll() {
     //возвращает копию массива this.items без null элементов;

        Item[] newItem = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                newItem[i] = items[i];
            }
        }
        return newItem;
    }
    public Item[] findByName(String key) {
        // проверяем сколько элементов в массиве с таким именем
        int count = 0;
        for (; count < this.items.length; count++) {
            if (this.items[count].getName().equals(key)) {
                count++;
            }
        }
        // проверяет в цикле все элементы массива this.items,
        // сравнивая name (используя метод getName класса Item)
        // с аргументом метода String key.
        // Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
        // возвращает копию массива this.items без null элементов;
        Item[] newItem = new Item[count];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                newItem[i] = this.items[i];
            }
        }
        return newItem;
    }
    public Item findById(String id) {
        // проверяет в цикле все элементы массива this.items,
        // сравнивая id с аргументом String id и возвращает найденный Item.
        // Если Item не найден - возвращает null.
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                return this.items[i];
            }
        }
        return null;
    }



    public static void main(String[] args) {
        int[] smallPrimes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] luckyNumbers = new int[smallPrimes.length - 1];
        System.out.println(Arrays.toString(smallPrimes));
        System.out.println(smallPrimes.length);
        System.out.println(Arrays.toString(luckyNumbers));

        for (int x = 0; x < smallPrimes.length; x++) {
            if (smallPrimes[x] == 5) {
                System.arraycopy(smallPrimes, 0, luckyNumbers, 0, x);
                System.arraycopy(smallPrimes, x + 1, luckyNumbers, x, smallPrimes.length - 1 - x);
            }
        }
        System.out.println(Arrays.toString(luckyNumbers));
        smallPrimes = luckyNumbers;
        System.out.println(Arrays.toString(smallPrimes));
        System.out.println(smallPrimes.length);
    }
}
