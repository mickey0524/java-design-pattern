package Singleton;

public class Singleton2 {
    private static Singleton2 instance;

    public synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }

        return instance;
    }
}
