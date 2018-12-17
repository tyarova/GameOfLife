
import board.CellBoard;

import java.awt.*;

public class GameState extends State {

    private CellBoard cellBoard;

    int i = 0;

    public GameState(GameBoard game) {
        super(game);
        cellBoard = new CellBoard();
        cellBoard.init();
    }

    @Override
    public void tick() {
        i++;

        if (i % 30 == 0){
            cellBoard.tick();
        }


    }

    @Override
    public void render(Graphics g) {
        cellBoard.render(g);
    }
}
