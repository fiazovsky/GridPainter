package org.fiazovsky.gridpainter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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

    public void paintCell(){
        isPainted = true;
        gridSquare.setColor(Color.BLACK);
        gridSquare.fill();
    }

    public void deleteCell(){
        isPainted = false;
        gridSquare.setColor(Color.BLACK);
        gridSquare.draw();
    }

    public boolean isPainted() {
        return isPainted;
    }

}
