package com.company.game.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartWindow extends JFrame {

    public StartWindow(){
        setBounds(new Rectangle(0,0,200,400));

        setLayout(new GridLayout(0,1, 10, 60));

        Button about = new Button("О игре"), newGame = new Button("Новая игра"), recs = new Button("Таблица счетов");

        about.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About about1 = new About();
                about1.setVisible(true);
            }
        });

        newGame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameSetupWindow gameSetupWindow = new GameSetupWindow();
            }
        });
        recs.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreView scoreView = new ScoreView();
                scoreView.setVisible(true);
            }
        });
        add(about);
        add(newGame);
        add(recs);

    }
}
