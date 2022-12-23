package com.company.game;

import com.company.game.Models.Figure;
import com.company.game.Models.GameField;
import com.company.game.Models.Generator;
import com.company.game.Models.Point;
import com.company.game.Views.GameView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GameController {
    Figure figure = Generator.newFigure();
    public KeyListener keyListener;
    Timer timer = new Timer();

    public GameController(GameView gameView, GameField gameField){
        gameView.setX(gameField.getX());
        gameView.setY(gameField.getY());

        gameView.setFigure(figure);

        gameView.revalidate();
        gameView.repaint();

        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = 0;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        x = 1;
                        break;
                    case KeyEvent.VK_LEFT:
                        x = -1;
                        break;
                }

                if(!gameField.Try(figure, x,0)) {
                    figure.Move(x, 0);
                    gameView.revalidate();
                    gameView.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        gameView.setArray(gameField.getArray());




        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                gameView.getScoreText().setText("счет: " + gameField.getScore());

                for (Point point : figure.getPoints()){
                    point.Down();
                }

                if(!gameField.isGet(figure)){
                    if(!gameField.Draw(figure)){
                        timer.cancel();
                        timer.purge();
                        timer = null;
                        Score.Add(gameField.getScore());
                        gameView.getFrame().dispatchEvent(new WindowEvent(gameView.getFrame(), WindowEvent.WINDOW_CLOSING));
                        return;
                    }
                    figure = Generator.newFigure();
                    gameView.setFigure(figure);
                    gameView.setArray(gameField.getArray());

                }

                gameView.revalidate();
                gameView.repaint();
            }
        }, 0, 500);
    }
}
