package org.fiazovsky.gridpainter;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

import static org.fiazovsky.gridpainter.Grid.*;

public class Cell {

    private boolean isPainted;
    private int row;
    private int col;
    Rectangle gridSquare;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        gridSquare = new Rectangle(row * cellSize + padding, col * cellSize + padding, cellSize, cellSize);
        gridSquare.draw();
    }

    public void paintSquare(){
        isPainted = true;
        gridSquare.fill();
    }

    public void deleteSquare(){
        isPainted = false;
        gridSquare.draw();
    }

}
