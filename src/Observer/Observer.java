package Observer;

import java.util.ArrayList;

abstract class Subject {

    ArrayList<Observer> observerList;

    Subject() {
        this.observerList = new ArrayList<>();
    }

    void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    void removeObserver(Observer observer) {
        int idx = observerList.indexOf(observer);
        if (idx >= 0) {
            observerList.remove(idx);
        }
    }

    abstract void notityObserver();
}

class WeatherData extends Subject {

    private int weather;

    public WeatherData(int weather) {
        this.weather = weather;
        notityObserver();
    }

    public void setWeather(int weather) {
        this.weather = weather;
        notityObserver();
    }

    @Override
    void notityObserver() {
        for (Observer observer : this.observerList) {
            observer.update(this.weather);
        }
    }
}

interface Observer {
    void update(int weather);
}

class WeatherObserver implements Observer {

    @Override
    public void update(int weather) {
        System.out.println("update " + weather);
    }
}
