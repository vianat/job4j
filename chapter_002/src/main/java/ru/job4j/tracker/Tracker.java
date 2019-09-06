package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;
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

    public boolean replace(String id, Item item) {
        for (int x = 0; x < this.items.length; x++) {
            if (items[x].getId().equals(id)) {
                items[x].setName(item.getName());
                items[x].setDesc(item.getDesc());
                items[x].setId(id);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        boolean result = false;
//        System.out.println("from delete " + id);
//        for (int y = 0; y < this.items.length; y++) {
//            System.out.println();
//        }

        for (int x = 0; x < position; x++) {
//            System.out.println("check " + this.items[x].getId());
            if (this.items[x].getId().equals(id)) {
                System.arraycopy(this.items, x + 1, this.items, x, position - 1 - x);
                items[--position] = null;
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

    // метод возвращает item, если найдёт по id.
    public Item findById(String id) {
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                return this.items[i];
            }
        }
        return null;
    }

}