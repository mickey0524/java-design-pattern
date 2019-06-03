package Facade;

class SubSystem {

    void chooseMovie() {
        System.out.println("choose movie");
    }

    void setCD() {
        System.out.println("set cd");
    }

    void watchMovie() {
        System.out.println("watch movie");
    }
}

class Facade {
    private SubSystem subSystem = new SubSystem();

    void watchMovie() {
        subSystem.chooseMovie();
        subSystem.setCD();
        subSystem.watchMovie();
    }
}

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.watchMovie();
    }
}
