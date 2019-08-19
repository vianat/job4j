package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        if (!word.endsWith(post)) {
            result = false;
        }
        return result;
    }
}