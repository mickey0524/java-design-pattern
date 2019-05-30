package Visitor;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.ArrayList;

interface Element {
    void accept(Visitor visitor);
}

class ConsumerGroup implements Element {
    private ArrayList<Consumer> consumers;

    public ConsumerGroup() {
        this.consumers = new ArrayList<Consumer>();
    }

    public void addConsumer(Consumer consumer) {
        this.consumers.add(consumer);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Consumer consumer : consumers) {
            consumer.accept(visitor);
        }
    }
}

class Consumer implements Element {

    private ArrayList<Order> orders;

    public Consumer() {
        this.orders = new ArrayList<Order>();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Order order : orders) {
            order.accept(visitor);
        }
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

}

class Order implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Consumer consumer);
    void visit(Order order);
}

class ConcreteVisitor implements Visitor {

    private int consumerNum;
    private int orderNum;

    @Override
    public void visit(Consumer consumer) {
        this.consumerNum++;
    }

    @Override
    public void visit(Order order) {
        this.orderNum++;
    }

    public void display() {
        System.out.println("consumerNum: " + consumerNum);
        System.out.println("orderNum: " + orderNum);
    }
}


public class Main {
    public static void main(String[] args) {
        ConsumerGroup consumerGroup = new ConsumerGroup();

        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();

        consumerGroup.addConsumer(consumer1);
        consumerGroup.addConsumer(consumer2);

        Order order1 = new Order();
        Order order2 = new Order();

        consumer1.addOrder(order1);
        consumer2.addOrder(order2);
        consumer2.addOrder(order1);

        ConcreteVisitor visitor = new ConcreteVisitor();
        consumerGroup.accept(visitor);
        visitor.display();
    }
}
