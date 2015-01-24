package es.duero4.headfirst.observer.weather;

/**
 *
 * @author ramon
 */
public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
