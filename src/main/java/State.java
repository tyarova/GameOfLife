import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    protected GameBoard game;

    public State(GameBoard game){
        this.game = game;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
