
package Interface;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class InterfaceCredits {
    //Interface Creditos
    public VBox getInterfaceCredits(){
        VBox vBCredits =new VBox();
        
        TextArea tA_Creditos=new TextArea();
        tA_Creditos.setEditable(false);
        tA_Creditos.setText("        Realizado por: \nKevin Navarro Navarro \nGuillermo David Hidalgo Segura\n\n        Version 1.1");
        tA_Creditos.setFont(new Font("Times new roman",22));
        
        Button bTN_Cerrar=new Button("Cerrar");
 
        bTN_Cerrar.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 15px;");
        bTN_Cerrar.setTranslateX(600);
        bTN_Cerrar.setOnAction(((event) -> {
        vBCredits.getChildren().clear();
        }));
        
        
        vBCredits.getChildren().addAll(tA_Creditos,bTN_Cerrar);
        return vBCredits;
    }
    
}
