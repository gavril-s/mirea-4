package task8.opt6;
import java.util.ArrayList;
import java.util.List;

// Интерфейс подписки, который реализуется всеми наблюдателями, которые хотят получать обновления от наблюдаемого объекта
interface Observer {
    void update(String event);
}

// Конкретный наблюдатель, который реагирует на уведомления от наблюдаемого объекта
class ConcreteObserver implements Observer {
    private String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(String event) {
        System.out.println(observerName + " received notification: " + event);
    }
}

// Интерфейс наблюдаемого объекта
interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event);
}

// Наблюдаемый объект, который отправляет уведомления своим наблюдателям
class ConcreteObservable implements Observable {
    private List<Observer> observers;

    public ConcreteObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    // Пример метода, который может запускать уведомление наблюдателей
    public void doSomething() {
        // Некоторый код...
        notifyObservers("Event from ConcreteObservable");
    }
}

// Клиентский код, который создает наблюдателей и наблюдаемый объект, затем запускает процесс, который ведет к уведомлениям
class ObserverClient {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.doSomething(); // Оба наблюдателя получат уведомление

        observable.removeObserver(observer1); // Удаляем наблюдателя 1

        observable.doSomething(); // Только наблюдатель 2 получит уведомление
    }
}
