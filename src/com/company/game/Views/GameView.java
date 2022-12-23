package com.company.game.Views;

import com.company.game.Models.Figure;
import com.company.game.Models.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class GameView extends JPanel {

    JLabel ScoreText;
    JFrame frame;
    int x = 5, y = 10;
    Figure figure;
    boolean[][] array;
    public JFrame getFrame() {
        return frame;
    }

    public JLabel getScoreText() {
        return ScoreText;
    }

    public void setArray(boolean[][] array) {
        this.array = array;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public GameView(JFrame frame, JLabel scoreText){
        this.frame = frame;
        this.ScoreText = scoreText;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.clearRect(0,0, x * 40, y * 40);

        for (int i = 0; i < x; i++){
            for (int i1 = 0; i1 < y; i1++){
                if(!array[i][i1]){
                    g2.setPaint(Color.black);
                    g2.drawRect(i * 40, i1 * 40, 40, 40);
                }
            }
        }
        for (int i = 0; i < x; i++){
            for (int i1 = 0; i1 < y; i1++){
                if(array[i][i1]){
                    g2.setPaint(Color.red);
                    g2.fill(new Rectangle2D.Double(i * 40, i1 * 40, 40, 40) );
                }
            }
        }


        if(figure != null) {
            for (Point point : figure.getPoints()) {
                g2.setPaint(Color.red);
                g2.fill(new Rectangle2D.Double(point.getX() * 40, point.getY() * 40, 40, 40) );
            }
        }
    }

}
