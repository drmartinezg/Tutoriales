package es.duero4.headfirst.observer.weather;

/**
 *
 * @author ramon
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
