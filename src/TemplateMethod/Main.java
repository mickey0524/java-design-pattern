package TemplateMethod;

abstract class Template {
    void template() {
        a();
        b();
    }

    void a() {
        System.out.println("a");
    }

    abstract void b();
}

class A extends Template {

    @Override
    void b() {
        System.out.println("A.b");
    }
}

class B extends Template {

    @Override
    void b() {
        System.out.println("B.b");
    }
}

public class Main {
    public static void main(String[] args) {
        Template a = new A();
        Template b = new B();

        a.template();
        b.template();
    }
}
