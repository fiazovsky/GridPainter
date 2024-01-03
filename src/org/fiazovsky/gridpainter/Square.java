package org.fiazovsky.gridpainter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.fiazovsky.gridpainter.Grid.cellSize;
import static org.fiazovsky.gridpainter.Grid.padding;

public class Square implements KeyboardHandler {
    private boolean isPainting;

    private Rectangle square;
    private Grid grid;
    private Cell currentCell;
    private int currentRow;
    private int currentCol;

    public Square(Grid grid) {
        this.grid = grid;
        this.square = new Rectangle(padding + currentRow, padding + currentCol, cellSize, cellSize);
        this.currentRow = 0;
        this.currentCol = 0;
        square.setColor(Color.GRAY);
        square.fill();
        keyboardInit();
    }

    private void updateCurrentCell() {
        currentCell = grid.getCurrentCell(currentRow, currentCol);
    }

    public void paintCurrentCell() {
        updateCurrentCell();
        currentCell.paintCell();
    }

    public void deleteCurrentCell() {
        updateCurrentCell();
        currentCell.deleteCell();
    }

    public void move() {
        if (isPainting) {
            paint();
        }
    }

    public void paint() {
        if (!grid.getCurrentCell(currentRow, currentCol).isPainted()) {
            paintCurrentCell();
            System.out.println(currentRow + ", " + currentCol);
        } else {
            deleteCurrentCell();
        }
    }

    public void clearGrid(){
        for (int row = 0; row < grid.getRows(); row++){
            for (int col = 0; col < grid.getCols(); col++){
                grid.getCurrentCell(row, col).deleteCell();
            }
        }
    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightKeyPressed);

        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftKeyPressed);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(upKeyPressed);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(downKeyPressed);

        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spaceKeyPressed);

        KeyboardEvent spaceKeyReleased = new KeyboardEvent();
        spaceKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spaceKeyReleased.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spaceKeyReleased);

        KeyboardEvent cKeyPressed = new KeyboardEvent();
        cKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        cKeyPressed.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(cKeyPressed);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if ((square.getX() + square.getWidth()) < grid.getGridHeight()) {
                    square.translate(cellSize, 0);
                    move();
                    currentRow++;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (square.getX() > padding) {
                    square.translate(-cellSize, 0);
                    move();
                    currentRow--;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (square.getY() > padding) {
                    square.translate(0, -cellSize);
                    move();
                    currentCol--;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if ((square.getY() + square.getWidth()) < grid.getGridWidth()) {
                    square.translate(0, cellSize);
                    move();
                    currentCol++;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                isPainting = true;
                paint();
                break;
            case KeyboardEvent.KEY_C:
                clearGrid();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        isPainting = false;
    }
}



