package com.company.game.Models;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GameField {

    private int Score;
    private final boolean[][] array;
    public GameField(int x, int y) {
        this.array = new boolean[x][y];
    }


    public boolean[][] getArray() {
        return array;
    }

    public int getScore() {
        return Score;
    }

    public int getX(){
        return array.length;
    }

    public int getY(){
        return array[0].length;
    }

    public boolean isGet(Figure figure){
        for (Point point : figure.getPoints()){
            if(point.getX() == array.length || point.getY() + 1 == array[0].length)
                return false;
            if(array[point.getX()][point.getY() + 1])
                return false;
        }
        return true;
    }

    public boolean Try(Figure figure, int x, int y){
        for (Point point : figure.getPoints()){
            if(point.getX() + x >= array.length || point.getY() + y >= array[0].length || point.getX() + x == -1 || point.getY() + y == 0)
                return true;
        }
        return false;
    }

    public boolean Draw(Figure figure){
        for (Point point : figure.getPoints()){
            if(point.getY() == 1)
                return false;
            array[point.getX()][point.getY()] = true;
        }

        Score++;

        Remove();

        return true;

    }

    public void Remove(){
        for (int i = 0; i < array[0].length; i++){
            boolean isEnd = false;
            for (boolean[] booleans : array) {
                if (!booleans[i]) {
                    isEnd = true;
                    break;
                }
            }
            if(!isEnd){
                for (int i1 = 0; i1 < array.length; i1++){
                    array[i1][i] = false;
                }
                Score += 20;
                Down(i);
                Remove();
                return;
            }
        }
    }


    public void Down(int index){
        for (int i = index; i > 1; i--){
            for (int i1 = 0; i1 < array.length; i1++){
                array[i1][i] = array[i1][i - 1];
            }
        }
    }
}
