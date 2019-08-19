package ru.job4j.array;

import java.util.Arrays;

/**
 * Обертка над строкой.
 */
public class ArrayChar {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();

        if (!word.startsWith(prefix)) {
            result = false;
        }
        return result;
    }
}
