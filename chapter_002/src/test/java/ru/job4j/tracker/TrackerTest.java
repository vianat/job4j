package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "simple desc");
        tracker.add(item);
        Item[] findItem = tracker.findByName(item.getName());
        assertThat(findItem[0].getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "simple desc");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "simple desc");
        tracker.add(next);
        System.out.println(tracker);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(next.getId(), next);
        // Проверяем, что заявка с таким id имеет новое имя test2.
        assertThat(tracker.findById(previous.getId()), is(true));
    }
    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item first = new Item("testFirst", "simple desc");
        Item second = new Item("testSecond", "simple desc");
        Item third = new Item("testThird", "simple desc");
        Item[] result = new Item[1];
        result[0] = second;

        tracker.add(first);
        tracker.add(second);
        tracker.add(third);

        System.out.println(Arrays.toString(tracker.findAll())); // до удаления
        tracker.delete(second.getId());
        System.out.println(Arrays.toString(tracker.findAll())); // после удаления

        //findByName возвращаем массив item, что написать в expected, ????
//        assertThat(tracker.findByName(second.getName()), result[0]);
    }
}
