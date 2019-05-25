package Singleton;

public enum Singleton5 {
    INSTANCE;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
