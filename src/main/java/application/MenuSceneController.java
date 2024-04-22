package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label quadraticFunctionLabel;
    @FXML
    AnchorPane scenePane;


    public void displayABC(double a, double b, double c){
        String term1 = (a == 1)? "x²" : ((a == -1) ? "-x²" : Double.toString(a) + "x²");
        String term2 = "";
        String term3 = "";

        if (b == 1){
            term2 = (" + x");
        }
        else if (b == -1){
            term2 = (" - x");
        }
        else if (b > 0){
            term2 = (" + " + b + "x");
        }
        else if(b < 0) {
            term2 = (" - "  + Math.abs(b) + "x");
        }

        if (c > 0){
            term3 = (" + " + c);
        }
        if(c < 0){
            term3 = (" - "  + Math.abs(c));
        }
        quadraticFunctionLabel.setText("f(x) = " + term1 + term2 + term3);
    }

    public void close(MouseEvent event){
        Global.close(event);
    }

    public void goBack(MouseEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("view/BeginningScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/BeginningScene.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void goToXIntScene(ActionEvent event) throws IOException {
        //If there are no x-intercepts:
        try{
            double discriminant = ((Math.pow(Global.getBValue(),2)) - 4 * Global.getAValue() * Global.getCValue());
            if (discriminant < 0){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ShowXIntScene.fxml"));
                root = loader.load();
                ShowXIntController showXIntObject = loader.getController();
                showXIntObject.theXIntLabel.setText("");
                showXIntObject.XIntLabel.setText("There are no x-intercepts");

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("css/XIntAndVertex.css").toExternalForm());
                scene.setFill(Color.TRANSPARENT);

                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                return;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        //If there are intercepts:
        try {
            root = FXMLLoader.load((getClass().getResource("view/FindXIntScene.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/XIntAndVertex.css").toExternalForm());
            scene.setFill(Color.TRANSPARENT);

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public void goToVertexScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("view/VertexScene.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/XIntAndVertex.css").toExternalForm());
        stage.setScene(scene);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);

        stage.centerOnScreen();
        stage.show();
    }
    public void goToYScene(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load((getClass().getResource("view/YScene.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/YScene.css").toExternalForm());

            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);

            stage.centerOnScreen();
            stage.show();
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }
    public void goToGraphingScene(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/GraphingScene.fxml"));
            root = loader.load();
            GraphingSceneController graphingSceneController = loader.getController();
            graphingSceneController.displayTransformations(Global.getAValue(), Global.getBValue(), Global.getCValue());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/GraphingScene.css").toExternalForm());
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);

            stage.centerOnScreen();
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

