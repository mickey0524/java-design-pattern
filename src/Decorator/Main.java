package Decorator;

interface Function {
    void execute();
}

class Execution implements Function {

    @Override
    public void execute() {
        System.out.println("xixi");
    }
}

abstract class Decorator implements Function {
    protected Function function;
}

class PrintToSys extends Decorator {

    public PrintToSys(Function function) {
        this.function = function;
    }

    @Override
    public void execute() {
        this.function.execute();
        System.out.println("print to sys out");
    }
}

class PrintToErr extends Decorator {

    public PrintToErr(Function function) {
        this.function = function;
    }

    @Override
    public void execute() {
        this.function.execute();
        System.err.println("print to err out");
    }
}


public class Main {
    public static void main(String[] args) {
        Function a = new Execution();
        Function b = new PrintToSys(a);
        b.execute();
    }
}
