package ru.job4j.tracker;

import java.util.*;
public class Tracker {

    private Item[] items = new Item[20];
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

    public boolean replace(Item item) {
        System.out.println(item.getId());
        for (int x = 0; x < this.items.length; x++) {
            System.out.println(items[x].getId() + " and "+ item.getId());

            if (items[x].getId().equals(item.getId())) {
                items[x].setId(item.getId());
                items[x].setName(item.getName());
                items[x].setDesc(item.getDesc());
                return true;
            }
        }
        return false;
    }
    public boolean delete(String id) {
        boolean result = false;
        for (int x = 0; x < position; x++) {
            if (this.items[x].getId().equals(id)) {
                //создать новый массив - 1
                Item[] newItems = new Item[this.items.length - 1];
                //скопировать в новый, начало старого массива и конец, исключая искомый элемент
                System.arraycopy(this.items, 0, newItems, 0, x);
                System.arraycopy(this.items, x + 1, newItems, x, position - 1 - x);
                //перезаписать в старый массив, новый
                this.items = newItems;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        // возвращает массив со всеми элементами.
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        // считаем совпадения по кеу.
        int match = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                match++;
            }
        }
        // создаём новый массив длинной match.
        Item[] matchArr = new Item[match];
        // копируем в него совпадения.
        for (int i = 0, m = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                matchArr[m] = this.items[i];
                m++;
            }
        }
        return matchArr;
    }

    public Item findById(String id) {
        // возвращает item, если найдёт по id.
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                return this.items[i];
            }
        }
        return null;
    }

}