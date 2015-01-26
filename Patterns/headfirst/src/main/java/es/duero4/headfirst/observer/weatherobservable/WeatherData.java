package es.duero4.headfirst.observer.weatherobservable;

import java.util.Observable;

/**
 *
 * @author ramon
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressute;

    public WeatherData() {
    }

    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressute = pressure;
        measurementChanged();
    }
    
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressute() {
        return pressute;
    }
    
    
}
