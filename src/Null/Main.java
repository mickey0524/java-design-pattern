package Null;

abstract class AbstractOperation {
    abstract void request();
}

class RealOperation extends AbstractOperation {

    @Override
    void request() {
        System.out.println("real operation");
    }
}

class NullOperation extends AbstractOperation {
    @Override
    void request() {

    }
}

public class Main {
    public static void main(String[] args) {

    }

    private static AbstractOperation func(int num) {
        if (num < 0) {
            return new NullOperation();
        }

        return new RealOperation();
    }
}
