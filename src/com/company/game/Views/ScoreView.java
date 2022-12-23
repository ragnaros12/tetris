package com.company.game.Views;

import com.company.game.Score;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreView extends JFrame {

    public ScoreView(){
        List<Integer> score = Score.getScores().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).toList();
        setBounds(0,0,400,200);
        JLabel jLabel = new JLabel("", SwingConstants.CENTER);

        StringBuilder text = new StringBuilder("<html>");

        for (int i = 0; i < score.size(); i++){
            text.append("<br>").append(i).append(" место: ").append(score.get(score.size() - i - 1));
        }

        text.append("</html>");

        jLabel.setText(text.toString());


        add(jLabel);
    }
}
