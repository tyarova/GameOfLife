import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cell {
    private int row;
    private int col;

    private boolean isAlive = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean getIsAlive() {
        return this.isAlive;

    }

    public void setIsAlive(boolean isAlive) {
       this.isAlive = isAlive;
    }

}
