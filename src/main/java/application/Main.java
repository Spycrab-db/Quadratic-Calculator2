package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/BeginningScene.fxml"));
        Image icon = new Image("application/images/Quadratic Symbol.png"); //Getting icon

        primaryStage.setTitle("Quadratic Calculator"); //Setting title
        primaryStage.getIcons().add(icon); //Setting the icon
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Scene beginningScene = new Scene(root); //Create scene object with parent root
        beginningScene.getStylesheets().add(getClass().getResource("css/BeginningScene.css").toExternalForm());
        beginningScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(beginningScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
