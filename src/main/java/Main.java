import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        primaryStage.setTitle("Game of Life");
        Button startGame = new Button("Start Game");
        Button clearBoard = new Button("Clear Board");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        App app = new App();
        app.drawGame(canvas);
        root.getChildren().add(canvas);
//        root.getChildren().add(startGame);
//        root.getChildren().add(clearBoard);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}


//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Scene scene = new Scene(root, 600, 600);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Game Of Life");
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//
//}
