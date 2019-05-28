/**
 * 中介者模式
 * 如果在某个事件到来的时候，一些对象之间存在相互调用
 * 可以用一个中介者集中管理
 */
package Mediator;

abstract class Colleague {
    public abstract void onEvent(Mediator mediator);
}

class Alarm extends Colleague {

    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("alarm");
    }

    public void doEvent() {
        System.out.println("do alarm");
    }
}

class Watch extends Colleague {

    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("watch");
    }

    public void doEvent() {
        System.out.println("do watch");
    }
}

abstract class Mediator {
    public abstract void doEvent(String eventType);
}

class ConcreteMediator extends Mediator {
    private Alarm alarm;
    private Watch watch;

    public ConcreteMediator(Alarm alarm, Watch watch) {
        this.alarm = alarm;
        this.watch = watch;
    }

    @Override
    public void doEvent(String eventType) {
        if (eventType.equals("alarm")) {
            doAlarm();
        } else {
            doWatch();
        }
    }

    private void doAlarm() {
        alarm.doEvent();
        watch.doEvent();
    }

    private void doWatch() {
        watch.doEvent();
        alarm.doEvent();
    }
}

public class Main {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Watch watch = new Watch();

        Mediator mediator = new ConcreteMediator(alarm, watch);

        alarm.onEvent(mediator);
    }
}
