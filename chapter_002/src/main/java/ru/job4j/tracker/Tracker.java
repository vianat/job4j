package ru.job4j.tracker;

import java.util.*;
public class Tracker {

    private Item[] items = new Item[10];
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
    public boolean replace(String id, String name) {
        boolean result = false;
        for(int x = 0; x < items.length; x++) {
            if(items[x].getId().equals(id)){
                items[x].setName(name);
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
        // проверяем сколько элементов в массиве с таким именем
        System.out.println("items.length = "  + items.length);
        int count = 0;
        for (; count < this.items.length; count++) {
            if (items[count] == null) {
            }else {
                count++;
            }
        }
        // возвращает копию массива this.items без null элементов;
        Item[] newItem = new Item[count];
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
            } else {
                newItem[i] = items[i];
            }
        }
        // печатаем что внутри items;
        for (int i = 0; i < newItem.length; i++) {
            System.out.println("newItem[" + i + "] = " + newItem[i]);
        }
        this.items = newItem;
        return items;
    }
    public Item findByName(String key) {
        // проверяем сколько элементов в массиве с таким именем
//        int count = 0;
//        for ( ; count < this.items.length; count++) {
//            if (this.items[count].getName().equals(key)) {
//                count++;
//            }
//        }
        // проверяет в цикле все элементы массива this.items,
        // сравниваем name с аргументом метода String key.
        // Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
        // возвращает копию массива this.items без null элементов;
//        Item[] newItem = new Item[count];
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items[i].getName().equals(key)) {
//                newItem[i] = this.items[i];
//            }
//        }
//        return newItem;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
//                System.out.println(items[i].getId());
//                System.out.println(items[i].getName());
                return this.items[i];
            }
        }
        return null;
    }
    public Item findById(String id) {
        // проверяет в цикле все элементы массива this.items,
        // сравнивая id с аргументом String id и возвращает найденный Item.
        // Если Item не найден - возвращает null.
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
//                System.out.println(items[i].getId());
//                System.out.println(items[i].getName());
                return this.items[i];
            }
        }
        return null;
    }



    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        System.out.println(tracker.findAll() + " -=*^");

        int[] smallPrimes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] luckyNumbers = new int[smallPrimes.length - 1];
        System.out.println(Arrays.toString(smallPrimes) + "++++");
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
