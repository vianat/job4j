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
        for (int p = pst.length - 1, w = wrd.length - 1; p > 0; p--, w--) {
            if (pst[p] != wrd[w]) {
                result = false;
                break;
            }
        }
        return result;
    }
}