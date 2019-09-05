package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;
    // было StubInput, переименовал для checkstyle
    public String[] stubInput(String[] value) {
        this.value = value;
        return this.value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
//    @Override
//    public String ask(String question) {
//        return this.value[this.position++];
//    }

    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
//
//    @Test
//    public void updateItem() {
//        Tracker tracker = new Tracker();
//        //Напрямую добавляем заявку
//        Item item = tracker.add(new Item("test name", "desc"));
//        //создаём StubInput с последовательностью действий(производим замену заявки)
//        Input input =  new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
//        // создаём StartUI и вызываем метод init()
//        new StartUI(input).init();
//        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
//    }

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
        System.out.println(tracker.findByName("test name"));
        boolean result = tracker.delete(item.getId());

        // проверяем, что заявка удалилась.
        assertThat(result, is(true));
    }

//    @Test
//    public void findByName() {
//        Tracker tracker = new Tracker();
//        //Напрямую добавляем заявку
//        Item item = tracker.add(new Item("test name", "desc"));
//        //создаём StubInput с последовательностью действий(производим замену заявки)
//        Input input =  new StubInput(new String[]{"5", item.getName(), "6"});
//        // создаём StartUI и вызываем метод init()
//        new StartUI(input).init();
//        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        assertThat(tracker.findByName(item.getName()), is(item));
//    }

    @Test
    public void findByID() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input =  new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
