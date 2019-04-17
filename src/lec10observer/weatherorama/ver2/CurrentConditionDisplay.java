package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class CurrentConditionDisplay implements Observer {

    private JFrame frame;
    private JTextArea weatherArea, oceanArea, pollutionArea;

    public CurrentConditionDisplay() {
        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Current Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        weatherArea = new JTextArea(200, 200);
        weatherArea.setBackground(Color.PINK);
        weatherArea.setText("Current Weather:\n\n");

        oceanArea = new JTextArea(200, 200);
        oceanArea.setBackground(Color.CYAN);
        oceanArea.setText("Current Ocean:\n\n");

        pollutionArea = new JTextArea(100, 50);
        pollutionArea.setBackground(Color.ORANGE);
        pollutionArea.setText("Current Pollution:\n\n");

        frame.setLayout(new GridLayout(3, 1));
        frame.add(weatherArea);
        frame.add(oceanArea);
        frame.add(pollutionArea);
    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;
            weatherArea.setBackground(Color.PINK);
            weatherArea.setText("Current Weather:\n\n");
            weatherArea.append("Temperature = " + weatherData.getTemperature() + "\n");
            weatherArea.append("Humidity = " + weatherData.getHumidity() + "\n");
            weatherArea.append("Pressure = " + weatherData.getPressure() + "\n");
            pollutionArea.append("Pollution = " + weatherData.getPollotion() + "\n");
        }
        if (data instanceof OceanData) {
            OceanData oceanData = (OceanData) data;
            oceanArea.setBackground(Color.CYAN);
            oceanArea.setText("Current Ocean:\n\n");
            oceanArea.append("Wave Height = " + oceanData.getWaveHeight() + "\n");
            oceanArea.append("Wind = " + oceanData.getWindGust() + "\n");
        }



    }
}
