package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;
    private int count;
    private double humid;
    private double avgHumidity;

    public HumidityAverageDisplay() {
        count = 0;
        humid = 0;
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Humidity AVG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.LIGHT_GRAY);
        area.setText("Humidity AVG:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        count ++;
        this.humid += humid;
        avgHumidity = this.humid/count;
        area.setText("Humidity AVG:\n\n");
        area.append("AVG = "+avgHumidity+"\n");
    }
}
