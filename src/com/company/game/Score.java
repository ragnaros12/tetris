package com.company.game;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private static final List<Integer> scores = new ArrayList<>();

    public static void Add(Integer score){
        scores.add(score);
        System.out.println("aa");
    }

    public static List<Integer> getScores() {
        return scores;
    }
}
