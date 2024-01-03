package org.fiazovsky.gridpainter;

public class Grid {
    public static int cellSize = 20;
    public static int padding = 10;
    private int rows;
    private int cols;
    private Cell[][] grid;
    private int gridWidth;
    private int gridHeight;

    public Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        gridWidth = rows * cellSize;
        gridHeight = cols * cellSize;
        grid = new Cell[rows][cols];
        drawGrid(rows, cols);
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPadding() {
        return padding;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void drawGrid(int rows, int cols){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell getCurrentCell(int row, int col){
        return grid[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
