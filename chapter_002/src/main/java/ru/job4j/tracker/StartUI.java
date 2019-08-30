package ru.job4j.tracker;

public class StartUI {

    private static final String ADD = "0";       // Константа меню для добавления новой заявки.
    private static final String SHOWALL = "1";   // Отобразить все заявки.
    private static final String EDIT = "2";      // Изменить заявку.
    private static final String DELETE = "3";    // Удалить заявку.
    private static final String FINDBYID = "4";  // Найти заявку по ID.
    private static final String FINDBYNAME = "5"; // Найти заявку по имени.
    private static final String EXIT = "6";      // Выход

    private final Input input;                   // Получение данных от пользователя.
    private final Tracker tracker;               // Хранилище заявок.
    /** Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }








    // Метод реализует добавление новой заявки в хранилище.
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
    }

    // Метод реализует отображение всех заявок в хранилище.
    private void showAll() {
        System.out.println("Показать все заявки.");
        Item[] items = this.tracker.findAll();
        if (items.length == 0) {
            System.out.println("Заявок нет");
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println("items[" + i + "] = " + items[i]);
            }
        }
    }

    // Метод изменяет заявку.
    private void edit() {
        System.out.println("Изменить заявку :");
        String id = this.input.ask("Введите id заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");

        Item newItem = new Item(name, desc);

        boolean flag = this.tracker.replace(newItem);

        if (flag) {
            System.out.println("Заявка " + id + " была изменена");
        }
    }

    // Метод поиска по имени.
    private void findById() {
        System.out.println("Поиск заявки по id:");
        String id = this.input.ask("Введите id заявки :");

        if (this.tracker.findById(id)) {
            System.out.println("Заявка с id > " + id + " < найдена !");
        }
    }

    // Метод поиска по имени.
    private void findName() {
        System.out.println("Поиск по имени заявки :");
        String name = this.input.ask("Введите имя заявки :");

        if (this.tracker.findByName(name) != null) {
            System.out.println("Заявка с именем > " + name + " < найдена !");
        } else {
            System.out.println("Заявка с именем > " + name + " < НЕ найдена !");
        }
    }

    private void delete() {
        System.out.println("Удаление заявки по id :");
        String id = this.input.ask("Введите id :");

        boolean flag = this.tracker.delete(id);

        if (flag) {
            System.out.println("Заявка " + id + " была удалена !");
        }
    }








    private void showMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Меню :");
        System.out.println("Добавить заявку - 0");
        System.out.println("Показать все заявки - 1");
        System.out.println("Изменить заявку - 2");
        System.out.println("Удалить заявку - 3");
        System.out.println("Найти заявку по ID - 4");
        System.out.println("Найти заявку по имени - 5");
        System.out.println("Выйти из программы - 6");
        System.out.println("--------------------------------------------------");
    }
    /**Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}