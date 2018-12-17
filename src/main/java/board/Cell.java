package board;

public class Cell {

    private int row, col;
    private int width, height;

    private boolean isAlive = false;

    public Cell(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
    }


    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}

