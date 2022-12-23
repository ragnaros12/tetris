package com.company.game.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {

    private static final List<Figure> pool;
    private static final Random random;

    static {
        pool = new ArrayList<>();
        pool.add(new Figure(List.of(new Point(0, -1))));
        pool.add(new Figure(Arrays.asList(new Point(0,-1), new Point(0,0), new Point(0,1))));
        pool.add(new Figure(Arrays.asList(new Point(0,-1), new Point(1,-1), new Point(2,-1))));
        random = new Random();
    }

    public static Figure newFigure(){
        return new Figure(pool.get(random.nextInt(pool.size())).getPoints().stream().map(u -> new Point(u.getX(), u.getY())).collect(Collectors.toList()));
    }
}
