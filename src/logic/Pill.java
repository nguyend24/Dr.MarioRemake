package logic;

import java.awt.*;

public class Pill {

//add return methods for row and col, a pill is one block on the grid instead of two, randomize the color and orientation in the constructor
    public enum Orientation {
        LEFT,
        RIGHT,
        UP,
        DOWN,
    }

    private Color myColor;
    private Shape myShape;
    private int row, col;

    public Pill(Color c, Orientation o) {
        if((int)Math.random()*3 == 0)
            myColor = Color.blue;
        else if((int)Math.random()*3 == 1)
            myColor = Color.red;
        else
            myColor = Color.yellow;
        row = 0;
        col = 7;
    }

    public Color getColor() {
        return myColor;
    }

    public Shape getShape() {
        return myShape;
    }

    public int getRow() {return row;}

    public int getCol() {return col;}



}
