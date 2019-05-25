package Prototype;

abstract public class Prototype {
    abstract public Prototype myClone();
}

class ConcretePrototype extends Prototype {

    private String name;
    private int age;

    public ConcretePrototype(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Prototype myClone() {
        return new ConcretePrototype(name, age);
    }
}
