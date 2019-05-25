package Singleton;

public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    public Singleton1 getInstance() {
        return Singleton1.instance;
    }
}
