package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;
    private int countTem;
    private int countWave;

    private JFrame frame;
    private JTextArea weatherArea, oceanArea, pollutionArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Average Condition");
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

            if (prevTemp == 0) {
                prevTemp = weatherData.getTemperature();
            }
            else {
                double avg = (prevTemp + weatherData.getTemperature()) / 2;
                prevTemp = avg;
            }
            weatherArea.setText("Average Condition:\n");
            weatherArea.append("Temperature = " + prevTemp+"\n");
            pollutionArea.append("Pollution = " + weatherData.getPollotion() + "\n");
        }
        else if (data instanceof OceanData) {
            OceanData oceanData = (OceanData) data;
            if (prevWave == 0) {
                prevWave = oceanData.getWaveHeight();
            }
            else {
                double avg = (prevWave + oceanData.getWaveHeight()) / 2;
                prevWave = avg;
            }
            oceanArea.setText("Average Condition:\n");
            oceanArea.append("Wave Height = " + prevWave+"\n");
        }

    }
}
