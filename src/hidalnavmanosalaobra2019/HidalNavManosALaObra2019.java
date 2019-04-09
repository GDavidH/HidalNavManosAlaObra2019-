package hidalnavmanosalaobra2019;

import Company.Manager;
import Interface.Interface;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HidalNavManosALaObra2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
        Interface i = new Interface();
        primaryStage.getIcons().add(new Image("Company1.png"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("HidalNavApp");
        primaryStage.setScene(i.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
