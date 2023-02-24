package view;

import java.awt.image.BufferedImage;

public class VehicleWrapper {
    String name;
    double x;
    double y;
    BufferedImage image;

    // Finns det en regel angående this.x = ... vs använda set metoder?
    public VehicleWrapper(String name, double x, double y, BufferedImage image) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
