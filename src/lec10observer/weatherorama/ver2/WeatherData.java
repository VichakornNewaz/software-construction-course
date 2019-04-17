package lec10observer.weatherorama.ver2;

import java.util.ArrayList;
import java.util.List;

public class WeatherData extends Subject {

    private double temperature;
    private double humidity;
    private double pressure;
    private String pollution;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public String getPollotion() { return pollution; }

    public void setMeasurement(double t, double h, double p, String pollution) {
        temperature = t;
        humidity = h;
        pressure = p;
        this.pollution = pollution;
        notifyObservers();
    }
}
