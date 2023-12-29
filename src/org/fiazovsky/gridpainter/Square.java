package org.fiazovsky.gridpainter;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Square extends Cell {
    public Square(){
        super(0, 0);
        gridSquare.setColor(Color.BLACK);
        paintSquare();
    }
}
