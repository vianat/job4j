package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
//        tracker.add(next);
        System.out.println(tracker);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item first = new Item("testFirst");
        Item second = new Item("testSecond");
        Item third = new Item("testThird");
        Item[] result = new Item[1];
        result[0] = second;

        tracker.add(first);
        tracker.add(second);
        tracker.add(third);

        System.out.println(Arrays.toString(tracker.findAll()));// до удаления
        tracker.delete(second.getId());
        System.out.println(Arrays.toString(tracker.findAll()));// после удаления

        //findByName возвращаем массив item, что написать в expected, ????
//        assertThat(tracker.findByName(second.getName()), result[0]);
    }
}