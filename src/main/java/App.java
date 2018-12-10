
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.Random;

public class App {

    private Cell cell;
    private int rows = 50;
    private int cols = 50;
    private Cell[][] cellsBoard = new Cell[rows][cols];
    private Timer timer;


    public void randomCellsBoardFilling(Canvas canvas) {
        Random r = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double cellW = canvas.getWidth() / cols;
        double cellH = canvas.getHeight() / rows;

        for (int i = 0; i < cellsBoard.length; i++) {
            for (int j = 0; j < cellsBoard[0].length; j++) {
                boolean isAlive = r.nextBoolean();
                cellsBoard[i][j] = new Cell(i, j);
                cellsBoard[i][j].setIsAlive(isAlive);

                gc.setFill(isAlive ? Color.WHITE : Color.DARKGREY);
                gc.fillRect(i * cellW, j * cellH, cellW, cellH);
            }
        }
    }

    public int isAlive(int xPoint, int yPoint) {
        boolean inGrid = xPoint >= 0 && xPoint < cellsBoard.length && yPoint >= 0 && yPoint < cellsBoard[0].length;
        return inGrid && (cellsBoard[xPoint][xPoint].getIsAlive())
                ? 1
                : 0;
    }

        public int countAliveNeighbors(int row, int col) {
            int count = 0;
            count += isAlive(row - 1, col - 1);
            count += isAlive(row - 1, col);
            count += isAlive(row - 1, col + 1);
            count += isAlive(row, col - 1);
            count += isAlive(row, col + 1);
            count += isAlive(row + 1, col + 1);
            count += isAlive(row + 1, col - 1);
            count += isAlive(row + 1, col);
            return count;
        }

        public void nextGeneration(Canvas canvas) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            double cellW = canvas.getWidth() / cols;
            double cellH = canvas.getHeight() / rows;

            Cell[][] nextGen = copyArr(cellsBoard);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Cell cell = cellsBoard[i][j];
                    int neighbors = countAliveNeighbors(i, j);
                    if ((cell.getIsAlive()==false && neighbors == 3) || (cell.getIsAlive() && neighbors == 2) || (cell.getIsAlive() && neighbors == 3)) {
                        nextGen[i][j].setIsAlive(true);
                    } else nextGen[i][j].setIsAlive(false);
                    gc.setFill(cellsBoard[i][j].getIsAlive() ? Color.WHITE : Color.RED);
                    gc.fillRect(i * cellW, j * cellH, cellW, cellH);
                }
            }
            cellsBoard = nextGen;
        }

        private Cell[][] copyArr(Cell[][] old) {
            Cell[][] current = new Cell[old.length][old[0].length];
            for(int i=0; i<old.length; i++)
                for(int j=0; j<old[i].length; j++)
                    current[i][j]=old[i][j];
            return current;
        }

        public void drawGame(Canvas canvas){
            GraphicsContext gc = canvas.getGraphicsContext2D();
            double cellW = canvas.getWidth() / cols;
            double cellH = canvas.getHeight() / rows;

        }

//        public static void print() {
//            System.out.println(Arrays.deepToString(cellsField)
//                    .replace("], ", "]\n")
//                    .replace("[[", "[")
//                    .replace("]]", "]")
//                    .replace(", ", "\t"));
//
//        }

}

