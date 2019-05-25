package Builder;

class Person {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

abstract public class Builder {
    protected Person person = new Person();

    abstract public void setName();
    abstract public void setAge();

    public Person getPerson() {
        return person;
    }
}

class ConcreteBuilder1 extends Builder {

    @Override
    public void setName() {
        person.setName("1");
    }

    @Override
    public void setAge() {
        person.setAge(1);
    }
}

class ConcreteBuilder2 extends Builder {

    @Override
    public void setName() {
        person.setName("2");
    }

    @Override
    public void setAge() {
        person.setAge(2);
    }
}
