package ua.nure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle implements Drawable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        log.info("Drawing Circle");
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
