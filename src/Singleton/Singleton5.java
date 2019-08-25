package Singleton;

public enum Singleton5 {
    INSTANCE("singleton");

    private String name;

    private Singleton5(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Singleton5 s1 = Singleton5.INSTANCE;
        Singleton5 s2 = Singleton5.INSTANCE;

        System.out.print(s1 == s2);
    }
}
