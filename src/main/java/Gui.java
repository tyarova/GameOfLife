import javax.swing.*;
import java.awt.*;

public class Gui {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Gui(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
