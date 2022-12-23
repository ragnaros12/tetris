package com.company.game.Views;

import com.company.game.GameController;
import com.company.game.Models.GameField;
import com.company.game.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class GameSetupWindow extends JFrame {
    public GameSetupWindow(){
        GameField gameField = new GameField(7,15);
        setBounds(new Rectangle(0,0,(gameField.getX() + 1) * 40, (gameField.getY() + 4) * 40));


        JLabel label = new JLabel("счет");
        label.setBounds(getWidth() / 2 - 60,(gameField.getY() + 2) * 40,100,30);


        GameView gameView = new GameView(this, label);


        setLayout(null);
        add(gameView);
        add(label);


        JButton exit = new JButton("Выйти");

        JFrame frame = this;

        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Score.Add(gameField.getScore());
                dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        GameController gameController = new GameController(gameView, gameField);
        exit.setBounds(getWidth() / 2 - 60,(gameField.getY() + 1) * 40,100,30);
        add(exit);

        gameView.setBounds(new Rectangle(10,10,gameField.getX() * 40, gameField.getY() * 40));



        setFocusable(true);
        requestFocusInWindow();


        addKeyListener(gameController.keyListener);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setVisible(true);
    }
}
