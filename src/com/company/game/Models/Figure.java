package com.company.game.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Figure implements Cloneable {
    private final List<Point> points;

    public void Move(int x, int y) {
        for (Point point : points) {
            point.setX(point.getX() + x);
            point.setY(point.getY() + y);
        }
    }

    public Figure(List<Point> points){
        this.points = points;
    }


    public List<Point> getPoints() {
        return points;
    }

    @Override
    public Figure clone() {
        try {
            return (Figure) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
