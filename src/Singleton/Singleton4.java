package Singleton;

public class Singleton4 {
    public static class Singleton {
        private static final Singleton4 instance = new Singleton4();
    }

    public Singleton4 getInstance() {
        return Singleton.instance;
    }
}
