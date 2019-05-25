package FactoryMethod;

interface Product {}

class ConcreteProduct1 implements Product {}

class ConcreteProduct2 implements Product {}

class ConcreteProduct3 implements Product {}

public abstract class FactoryMethod {
    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
    }
}

class FactoryMethod1 extends FactoryMethod {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

class FactoryMethod2 extends FactoryMethod {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}

class FactoryMethod3 extends FactoryMethod {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct3();
    }
}


