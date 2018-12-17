package board;

import java.util.Random;

public class BoardGenerator {

    private int rows = 50;
    private int cols = 50;
    private Cell[][] cellsBoard = new Cell[rows][cols];

    public void randomFilling(Cell[][] cellsBoard) {
        Random r = new Random();

        for (int i = 0; i < cellsBoard.length; i++) {
            for (int j = 0; j < cellsBoard[0].length; j++) {
                boolean isAlive = r.nextBoolean();
                cellsBoard[i][j] = new Cell(i, j, 10, 10);
                cellsBoard[i][j].setIsAlive(isAlive);
            }
        }
    }

    public static void testFilling(Cell[][] cellsBoard) {
        for (int i = 0; i < cellsBoard.length; i++) {
            for (int j = 0; j < cellsBoard[0].length; j++) {
                cellsBoard[i][j] = new Cell(i, j, 10, 10);
                cellsBoard[i][j].setIsAlive(false);
            }
        }
        cellsBoard[0][0] = new Cell(0, 0, 10, 10);
        cellsBoard[0][0].setIsAlive(true);

        cellsBoard[1][0] = new Cell(1, 0, 10, 10);
        cellsBoard[1][0].setIsAlive(true);

        cellsBoard[2][0] = new Cell(2, 0, 10, 10);
        cellsBoard[2][0].setIsAlive(true);

        cellsBoard[2][1] = new Cell(2, 1, 10, 10);
        cellsBoard[2][1].setIsAlive(true);

        cellsBoard[3][1] = new Cell(3, 1, 10, 10);
        cellsBoard[3][1].setIsAlive(true);

        cellsBoard[3][2] = new Cell(3, 2, 10, 10);
        cellsBoard[3][2].setIsAlive(true);

        cellsBoard[4][1] = new Cell(4, 1, 10, 10);
        cellsBoard[4][1].setIsAlive(true);

        cellsBoard[4][2] = new Cell(4, 2, 10, 10);
        cellsBoard[4][2].setIsAlive(true);

    }

    public int isAlive(Cell[][] cellsBoard, int xPoint, int yPoint) {
        boolean inGrid = xPoint >= 0 && xPoint < cellsBoard.length && yPoint >= 0 && yPoint < cellsBoard[0].length;
        return inGrid && (cellsBoard[xPoint][xPoint].getIsAlive())
                ? 1
                : 0;
    }

    public int countAliveNeighbors(Cell[][] cellsBoard, int row, int col) {
        int count = 0;
        count += isAlive(cellsBoard, row - 1, col - 1);
        count += isAlive(cellsBoard, row - 1, col);
        count += isAlive(cellsBoard, row - 1, col + 1);
        count += isAlive(cellsBoard, row, col - 1);
        count += isAlive(cellsBoard, row, col + 1);
        count += isAlive(cellsBoard, row + 1, col + 1);
        count += isAlive(cellsBoard, row + 1, col - 1);
        count += isAlive(cellsBoard, row + 1, col);
        return count;
    }

    public Cell[][] nextGeneration(Cell[][] cellsBoard) {
        Cell[][] nextGen = copyArr(cellsBoard);

        for (int i = 0; i < cellsBoard.length; i++) {
            for (int j = 0; j < cellsBoard[0].length; j++) {
                Cell cell = cellsBoard[i][j];
                int neighbors = countAliveNeighbors(cellsBoard, i, j);
                if ((!cell.getIsAlive() && neighbors == 3) || (cell.getIsAlive() && neighbors == 2) || (cell.getIsAlive() && neighbors == 3)) {
                    nextGen[i][j].setIsAlive(true);
                } else nextGen[i][j].setIsAlive(false);
            }
        }
        return nextGen;
    }

    private static Cell[][] copyArr(Cell[][] old) {
        Cell[][] current = new Cell[old.length][old[0].length];
        for (int i = 0; i < old.length; i++)
            for (int j = 0; j < old[i].length; j++)
                current[i][j] = old[i][j];
        return current;
    }
}

