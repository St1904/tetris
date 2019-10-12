package first;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Text text = new Text("Ыыы съешь ещё этих мягких французских булок да выпей чаю");
        Text text = new Text("Hi");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        text.setRotate(12);
        text.setLayoutX(130);
        text.setLayoutY(100);

        Group group = new Group(text);

        Scene scene = new Scene(group, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.setWidth(300);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.show();
    }
}
