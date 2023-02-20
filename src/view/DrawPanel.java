package view;

import model.Wrapper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private HashMap<String,BufferedImage> pics;
    private ArrayList<Wrapper> cars;

    private void getImages() {
        pics = new HashMap<>();
        // Print an error message in case file is not found with a try/catch block
        try {
            pics.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("/assets/pics/Volvo240.jpg")));
            pics.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("/assets/pics/Saab95.jpg")));
            pics.put("Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("/assets/pics/Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateWrappers(ArrayList<Wrapper> cars) {
        this.cars = cars;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        getImages();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Wrapper car : cars) {
            String name = car.getName();
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());
            BufferedImage image = pics.get(name);
            g.drawImage(image, x, y, null);
        }
    }
}