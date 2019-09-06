package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;

    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
}
