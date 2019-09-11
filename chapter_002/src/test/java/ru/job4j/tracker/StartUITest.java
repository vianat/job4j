package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private StartUITest tracker;

    @Before
    public void beforeTests() {
        System.out.println("@before method");
        System.setOut(new PrintStream(this.out));

    }

    @After
    public void afterTests() {
        System.out.println("@after method");
        System.setOut(this.stdout);
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        // Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        // создаём StubInput с последовательностью действий(производим замену заявки)
        Input input =  new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        // проверяем, что введённое при эмуляции.
        // System.out.println(new String(out.toByteArray()));
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("Заявок нет")
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("---- Добавление новой заявки ----")
                                .append(System.lineSeparator())
                                .append("---- Новая заявка с Id :  добавлена")
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void updateItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        // создаём StubInput с последовательностью действий (производим замену заявки)
        Input input =  new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(tracker, input).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("Изменить заявку :")
                                .append(System.lineSeparator())
                                .append("Заявка с id: " + tracker.findById(item.getId()).getId() + " была изменена !")
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        // добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий (удаляем заявку)
        Input input =  new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input).init();

        boolean result = tracker.delete(item.getId());

        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("Удаление заявки по id :")
                                .append(System.lineSeparator())
                                .append("Заявка с id: " + tracker.findById(item.getId()).getId() + " НЕ была удалена !")
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input =  new StubInput(new String[]{"5", item.getName(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(tracker, input).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("Поиск по имени заявки :")
                                .append(System.lineSeparator())
                                .append("Заявка с именем > test name < найдена !")
                                .append(System.lineSeparator())
                                .append(tracker.findByName("test name"))
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void findByID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input =  new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .append("Поиск заявки по id:")
                                .append(System.lineSeparator())
                                .append("Заявка с id > " + tracker.findById(item.getId()).getId() + " < НЕ найдена !")
                                .append(System.lineSeparator())
                                .append("Меню :")
                                .append(System.lineSeparator())
                                .append("0 - Добавить заявку")
                                .append(System.lineSeparator())
                                .append("1 - Показать все заявки")
                                .append(System.lineSeparator())
                                .append("2 - Изменить заявку")
                                .append(System.lineSeparator())
                                .append("3 - Удалить заявку")
                                .append(System.lineSeparator())
                                .append("4 - Найти заявку по ID")
                                .append(System.lineSeparator())
                                .append("5 - Найти заявку по имени")
                                .append(System.lineSeparator())
                                .append("6 - Выйти из программы")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
