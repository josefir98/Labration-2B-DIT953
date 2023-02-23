package view;

import model.VehicleWrapper;
import model.interfaces.IVehicle;
import structure.observer.IViewObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IViewObserver {
    private ArrayList<VehicleWrapper> wCars;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.wCars = new ArrayList<>();
    }

    @Override
    public void update(ArrayList<IVehicle> cars) {
        wCars.clear();
        for (IVehicle car : cars) {
            String name = car.getModelName();
            double x = car.getX();
            double y = car.getY();
            BufferedImage image = null;
            try {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("/assets/pics/" + name + ".jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            wCars.add(new VehicleWrapper(name, x, y, image));
        }
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehicleWrapper car : wCars) {
            String name = car.getName();
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());
            BufferedImage image = car.getImage();
            g.drawImage(image, x, y, null);
        }
    }
}