package Adapter;

interface Duck {
    void quack();
}

interface Turkey {
    void gobble();
}

class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("turkey gobble");
    }
}

class TurkeyAdapter implements Duck {

    private Turkey turkey;

    TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}

public class Main {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();

        Duck duck = new TurkeyAdapter(turkey);

        duck.quack();
    }
}
