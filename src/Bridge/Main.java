package Bridge;

abstract class TV {
    abstract void on();

    abstract void off();

    abstract void tuneChannel();
}

class Sony extends TV {

    @Override
    void on() {
        System.out.println("sony on");
    }

    @Override
    void off() {
        System.out.println("sony off");
    }

    @Override
    void tuneChannel() {
        System.out.println("sony tuneChannel");
    }
}

class TCL extends TV {

    @Override
    void on() {
        System.out.println("TCL on");
    }

    @Override
    void off() {
        System.out.println("TCL off");
    }

    @Override
    void tuneChannel() {
        System.out.println("TCL tuneChannel");
    }
}

abstract class Control {
    protected TV tv;

    public Control(TV tv) {
        this.tv = tv;
    }

    abstract void on();

    abstract void off();

    abstract void tuneChannel();
}

class ConcreteControl extends Control {

    ConcreteControl(TV tv) {
        super(tv);
    }

    @Override
    void on() {
        tv.on();
    }

    @Override
    void off() {
        tv.off();
    }

    @Override
    void tuneChannel() {
        tv.tuneChannel();
    }
}

public class Main {
    public static void main(String[] args) {
        TV sony = new Sony();

        Control control = new ConcreteControl(sony);

        control.off();
    }
}
