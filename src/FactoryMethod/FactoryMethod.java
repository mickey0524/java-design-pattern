/**
 * 工厂方法与简单工厂有所不同，工厂方法存在一个抽象的工厂函数
 * 工厂函数中有一个返回 Product 的抽象工厂方法
 * 不同的工厂函数子类实现抽象工厂方法，返回不同的 Product 子类
 */

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


