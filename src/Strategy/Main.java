/**
 * 策略模式和状态模式有些类似
 * 都是可以在运行的时候改变类的内部状态
 * 但是状态模式是状态自行发生转移
 * 策略模式需要手动去修改
 */

package Strategy;

interface Behavior {
    void behave();
}

class Fly implements Behavior {

    @Override
    public void behave() {
        System.out.println("fly");
    }
}

class Swim implements Behavior {

    @Override
    public void behave() {
        System.out.println("swim");
    }
}

class Person {
    private Behavior behavior;

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public void behavior() {
        if (this.behavior != null) {
            this.behavior.behave();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        Fly fly = new Fly();
        Swim swim = new Swim();

        person.setBehavior(fly);
        person.behavior();

        person.setBehavior(swim);
        person.behavior();
    }
}
