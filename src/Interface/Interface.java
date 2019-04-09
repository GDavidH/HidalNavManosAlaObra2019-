package Interface;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Interface {

    InterfaceCredits InFC = new InterfaceCredits();
    InterfaceEmployee InFE = new InterfaceEmployee();
    InterfaceVehicle InFV = new InterfaceVehicle();

    public Scene getScene() {
        VBox vB_principal = new VBox();
        vB_principal.setStyle("-fx-background-image:url(Empresa.jpg);"
                + "-fx-background-repeat:no-repeat;"
                + "-fx-background-position: center;"
                + "-fx-background-size:cover, auto;");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #013c60");

        Scene scene = new Scene(vB_principal, 700, 550);

        MenuBar menuBar = new MenuBar();

        //Inicio
        Menu menuStart = new Menu("Inicio");

        MenuItem mIStar = new MenuItem("Pantalla Principal", new ImageView(new Image("MainMenu.jpg")));
        mIStar.setOnAction(((event) -> {
            vbox.getChildren().clear();
            //vB_principal.getChildren().clear();
        }));

        menuStart.getItems().addAll(mIStar);

        //sistema
        //Menu de sistema
        Menu menuSystem = new Menu("Sistema");

        //creditos del Programa
        MenuItem mICredits = new MenuItem("Créditos", new ImageView(new Image("About.png")));
        mICredits.setOnAction((event) -> {

            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFC.getInterfaceCredits());

        });

        //salir
        MenuItem mIExit = new RadioMenuItem("Salir", new ImageView(new Image("Exit.png")));
        mIExit.setOnAction((event) -> Platform.exit()
        );

        menuSystem.getItems().addAll(mICredits, mIExit);

        //employee
        Menu menuEmployee = new Menu("Empleados");
        //menuItem

        MenuItem mIAdd = new MenuItem("Añadir", new ImageView(new Image("add.png")));
        mIAdd.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFE.getAddInterface());

        });
        
        Menu mIViewAll = new Menu("Mostrar Empleados", new ImageView(new Image("show.png")));
        mIViewAll.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFE.getEmployeeTipe());
        });
        
        MenuItem mIMod = new MenuItem("Modificar", new ImageView(new Image("change.png")));
        mIMod.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFE.getModEmployeeInterface());

        });
        //menu Item calular salario
        MenuItem mICalSalary = new MenuItem("Calcular Salario", new ImageView(new Image("Dollar.png")));
        mICalSalary.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFE.getInterfaceCalSalary());
        });

        //Vehiculos
        Menu menuVehicle = new Menu("Vehículos");

        //menuItem
        MenuItem mIAddVehicle = new MenuItem("Añadir", new ImageView(new Image("CarAdd.png")));
        mIAddVehicle.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFV.getAddVehicleInterface());

        });

        MenuItem mIViewVehicle = new MenuItem("Registro Total", new ImageView(new Image("SearchVehicle.png")));
        mIViewVehicle.setOnAction((event) -> {
            vbox.getChildren().clear();
            try {
                vbox.getChildren().addAll(InFV.getViewVehicule());
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        MenuItem mIDeleteVehicle = new MenuItem("Eliminar", new ImageView(new Image("Delete.png")));
        mIDeleteVehicle.setOnAction((event) -> {
            vbox.getChildren().clear();
            try {
                vbox.getChildren().addAll(InFV.getDelete());
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        MenuItem mIModifyVeh = new MenuItem("Modificar", new ImageView(new Image("Update.png")));
        mIModifyVeh.setOnAction((event) -> {
            vbox.getChildren().clear();
            vbox.getChildren().addAll(InFV.getModVehInterface());

        });

        menuVehicle.getItems().addAll(mIAddVehicle, mIModifyVeh, mIDeleteVehicle, mIViewVehicle);

        menuEmployee.getItems().addAll(mIAdd,mIViewAll, mICalSalary,mIMod);

        menuBar.getMenus().addAll(menuStart, menuEmployee, menuVehicle, menuSystem);

        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, vbox);

        return scene;
    }
}
