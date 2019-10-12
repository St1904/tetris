package first;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Hi from new Main");
        text.setLayoutX(80);
        text.setLayoutY(100);

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }
}
