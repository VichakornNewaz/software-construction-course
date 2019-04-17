package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;
    private double forecastTemparaturePredicts;


    public ForecastDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("ForecastDisplay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.LIGHT_GRAY);
        area.setText("ForecastDisplay:\n\n");
    }


    @Override
    public void update(double temp, double humid, double pressure) {

        area.append("predicts next forecast temperature = "+ forecastTemparaturePredicts +"\n");
    }

}
