package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public String sound() {
        String voice = "meow-meow";
        return voice;
    }
    public void giveNick(String nick) {
        this.name = nick;
    }
    public void show() {
        System.out.println("There are " + this.name + "s " + this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();

        Cat black  = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
