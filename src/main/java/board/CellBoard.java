package board;

import java.awt.*;
import java.util.Random;

public class CellBoard {

    public static final int DEFAULT_SIZE = 10;
    public static final int DEFAULT_ROWS_QTY = 50;
    public static final int DEFAULT_COLS_QTY = 50;

    private Cell[][] cellsBoard = new Cell[DEFAULT_ROWS_QTY][DEFAULT_COLS_QTY];
    BoardGenerator b = new BoardGenerator();

    public void init(){
        //b.randomFilling(cellsBoard);
        b.testFilling(cellsBoard);
    }

    public void tick() {
        cellsBoard = b.nextGeneration(cellsBoard);

        //b.testFilling(cellsBoard);
    }

    public void render(Graphics g) {
        for (int i = 0; i < cellsBoard.length; i++) {
            for (int j = 0; j < cellsBoard[0].length; j++) {
                boolean isAlive = cellsBoard[i][j].getIsAlive();
                g.setColor(isAlive ? Color.WHITE : Color.GRAY);
                g.fillRect(i * DEFAULT_SIZE, j * DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SIZE);
            }
        }
    }

}

