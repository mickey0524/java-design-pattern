package SimpleFactory;

interface Product {}

class ConcreteProduct1 implements Product{}

class ConcreteProduct2 implements Product{}

class ConcreteProduct3 implements Product{}

public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct3();
    }
}


