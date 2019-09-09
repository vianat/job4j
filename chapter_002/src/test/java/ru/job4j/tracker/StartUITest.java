package ru.job4j.tracker;

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
        System.out.println(new String(out.toByteArray()));
        assertThat(tracker.findAll(), is(tracker.findByName(item.getName())));
    }

    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void updateItem() {
        Tracker tracker = new Tracker();
        // Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        // создаём StubInput с последовательностью действий(производим замену заявки)
        Input input =  new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(tracker, input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        System.out.println("start " + tracker.findAll());
        // добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(удаляем заявку)
        Input input =  new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        System.out.println("test " + item.getId());
        new StartUI(input).init();

        boolean result = tracker.delete(item.getId());

        // проверяем, что заявка удалилась.
        assertThat(result, is(true));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        // Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input =  new StubInput(new String[]{"5", item.getName(), "6"});
        // создаём StartUI и вызываем метод init()
        // new StartUI(input).init();
        new StartUI(tracker, input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item result = tracker.findByName(item.getName())[0];
        assertThat(result, is(item));
    }

    @Test
    public void findByID() {
        Tracker tracker = new Tracker();
        // Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        // создаём StubInput с последовательностью действий(производим замену заявки)
        Input input =  new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
