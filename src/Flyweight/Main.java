package Flyweight;
import java.util.HashMap;
import java.util.Map;

interface Flyweight {
    void execute(String s);
}

class ConcreteFlyweight implements Flyweight {
    private String name;

    ConcreteFlyweight(String name) {
        this.name = name;
    }

    @Override
    public void execute(String s) {
        System.out.println(System.identityHashCode(this));
        System.out.println(name);
        System.out.println(s);
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> map = new HashMap<>();

    Flyweight getFlyweight(String name) {
        if (!map.containsKey(name)) {
            Flyweight flyweight = new ConcreteFlyweight(name);
            map.put(name, flyweight);
        }

        return map.get(name);
    }
}

public class Main {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight a = flyweightFactory.getFlyweight("A");
        Flyweight b = flyweightFactory.getFlyweight("A");
        a.execute("a");
        b.execute("b");
    }
}
