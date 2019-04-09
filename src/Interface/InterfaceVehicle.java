package Interface;

import Company.Vehicle;
import File.MyFile;
import Util.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class InterfaceVehicle {

    Utilities ut = new Utilities();
    File fileVehicle = new File("./Files/Vehicles.dat");
    int n;

    //Interface Añadir Vehículo
    public VBox getAddVehicleInterface() {
        VBox vBVehiclecIF = new VBox();

        Label lbName = new Label("Ingrese la marca del auto");
        Label lbCar = new Label("Ingreso de Vehiculos");
        TextField tfName = new TextField();
        Label lbAmerican = new Label("Ingrese la procedencia del auto");
        ComboBox cbAmerican = new ComboBox();
        Label lbYear = new Label("Ingrese el año del auto");
        TextField tfYear = new TextField();
        Label lbMilage = new Label("Ingrese el kilometraje del auto");
        TextField tfMilage = new TextField();
        Label lbSeries = new Label("Ingrese la placa del auto");
        TextField tfSeries = new TextField();
        Label lb_mensaje = new Label("Se debe ingresar información en los campos de marca, año, y serie del auto");
        Label lbAlert = new Label("La serie actualmente esta en funcionamiento");
        GridPane gPAdd = new GridPane();
        gPAdd.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPAdd.setVgap(25);
        gPAdd.setHgap(20);

        // Determina la alineacion del gridpane
        gPAdd.setTranslateX(30);
        gPAdd.setTranslateY(35);

        // Caracteristicas de lbCar
        lbCar.setStyle("-fx-text-fill: Red;");
        lbCar.setTranslateX(210);
        lbCar.setTranslateY(20);
        lbCar.setFont(new Font("Broadway", 24));

        // Caracteristicas de lbName y tfName
        lbName.setStyle("-fx-text-fill: white");
        lbName.setFont(ut.getGaramond());
        gPAdd.add(lbName, 0, 0);
        tfName.setPromptText("Ingrese la marca del auto");
        tfName.setMaxSize(300, 35);
        tfName.setMinSize(300, 35);
        gPAdd.add(tfName, 1, 0);

        //// Caracteristicas de lbYear y tfYear
        lbYear.setStyle("-fx-text-fill: white");
        lbYear.setFont(ut.getGaramond());
        gPAdd.add(lbYear, 0, 1);
        tfYear.setPromptText("Ingrese el año del auto");
        tfYear.setMaxSize(300, 35);
        tfYear.setMinSize(300, 35);
        gPAdd.add(tfYear, 1, 1);

        // Caracteristicas de lbSerires y tfSeries 
        lbSeries.setStyle("-fx-text-fill: white");
        lbSeries.setFont(ut.getGaramond());
        gPAdd.add(lbSeries, 0, 2);
        tfSeries.setPromptText("Ingrese el año del auto");
        tfSeries.setMaxSize(300, 35);
        tfSeries.setMinSize(300, 35);
        gPAdd.add(tfSeries, 1, 2);

        // Caracteristicas de lbAmerican y cbAmerican
        lbAmerican.setStyle("-fx-text-fill: white");
        lbAmerican.setFont(ut.getGaramond());
        gPAdd.add(lbAmerican, 0, 3);
        cbAmerican.getItems().addAll("Americano", "Otro");
        cbAmerican.setPromptText("Procedencia de auto");
        cbAmerican.setMaxSize(200, 35);
        cbAmerican.setMinSize(200, 35);
        gPAdd.add(cbAmerican, 1, 3);

        // Caracteristicas de lbMilage y tfMilage
        lbMilage.setStyle("-fx-text-fill: white");
        lbMilage.setFont(ut.getGaramond());
        gPAdd.add(lbMilage, 0, 4);
        tfMilage.setPromptText("Ingrese las millas del vehiculo");
        tfMilage.setMaxSize(300, 35);
        tfMilage.setMinSize(300, 35);
        gPAdd.add(tfMilage, 1, 4);

        //Imagen vehiculo añadido con exito
        Label lBAdd = new Label("Vehículo añadido con éxito");
        lBAdd.setStyle("-fx-text-fill: RED");

        PauseTransition visibleLabel = new PauseTransition(Duration.seconds(2));
        visibleLabel.setOnFinished(event -> lBAdd.setVisible(false));
        PauseTransition visibleLabe2 = new PauseTransition(Duration.seconds(2));
        visibleLabe2.setOnFinished(event -> lbAlert.setVisible(false));

        //Caracteristicas de LbAdd 
        lBAdd.setFont(ut.getGaramond());
        gPAdd.add(lBAdd, 1, 6);
        lBAdd.setVisible(false);

        //Caracteristicas de lbAlert
        lbAlert.setFont(ut.getGaramond());
        gPAdd.add(lbAlert, 1, 6);
        lbAlert.setVisible(false);
        lbAlert.setFont(ut.getGaramond());
        lbAlert.setStyle("-fx-text-fill: Red");
        // Caracteristicas y funciones Boton Insertar
        Button btNAdd = new Button("Añadir");//Insertar imagen 
        btNAdd.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        btNAdd.setMinSize(120, 50);
        btNAdd.setMaxSize(120, 50);
        gPAdd.add(btNAdd, 1, 7);

        btNAdd.setOnAction(((event) -> {
            boolean american = false;

            if (cbAmerican.getValue().equals("Americano")) {
                american = true;
            }

            Vehicle vehicle = new Vehicle(Integer.parseInt(tfSeries.getText()), tfName.getText(), Integer.parseInt(tfYear.getText()), american, Float.parseFloat(tfMilage.getText()));
            if (tfName.getLength() == 0 || tfSeries.getLength() == 0 || tfYear.getLength() == 0) {
                lb_mensaje.setVisible(true);
            } else {
                try {
                    MyFile mf = new MyFile(fileVehicle);
                    if (mf.SerieExist(Integer.parseInt(tfSeries.getText()))) {
                        lbAlert.setVisible(true);
                        visibleLabe2.play();
                        tfSeries.setText("");
                    } else {
                        mf.addEndRecord(vehicle);
                        lBAdd.setVisible(true);
                        visibleLabel.play();
                        tfSeries.setText("");
                        tfMilage.setText("");
                        tfName.setText("");
                        tfYear.setText("");
                        cbAmerican.setValue("Procedencia de auto");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }));

        // Caracteristicas y funciones Boton Cerrar
        Button btnClose = new Button("Cerrar");
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPAdd.add(btnClose, 1, 7);
        btnClose.setMinSize(120, 50);
        btnClose.setMaxSize(120, 50);
        btnClose.setTranslateX(150);
        btnClose.setOnAction(((event) -> {

            gPAdd.getChildren().clear();
            vBVehiclecIF.getChildren().clear();

        }));

        vBVehiclecIF.getChildren().addAll(lbCar, gPAdd);

        return vBVehiclecIF;
    }

    public VBox getViewVehicule() throws IOException {

        VBox vBVehiclecIF = new VBox();
        MyFile mf = new MyFile(fileVehicle);
        vBVehiclecIF.setMinSize(700, 600);
        vBVehiclecIF.setMaxSize(700, 600);
        Label lbViewCars = new Label("Información de los vehiculos");
        Button btnClose = new Button("Cerrar");

        btnClose.setTranslateX(25);
        btnClose.setTranslateY(40);

        // Caracteristicas de lbCar
        lbViewCars.setStyle("-fx-text-fill: Red;");
        lbViewCars.setTranslateX(25);
        lbViewCars.setFont(new Font("Garamond", 26));
        lbViewCars.setTranslateX(25);
        lbViewCars.setTranslateY(15);

        TableView<Vehicle> tvList = new TableView();

        //Propiedades de Table view
        tvList.setTranslateX(25);
        tvList.setTranslateY(30);
        tvList.setMinSize(630, 395);
        tvList.setMaxSize(630, 395);

        //Crea columnas
        TableColumn tcSeries = new TableColumn("Series");
        TableColumn tcName = new TableColumn("Marca");
        TableColumn tcYear = new TableColumn("Años");
        TableColumn tcAmerican = new TableColumn("Americano");
        TableColumn tcMilage = new TableColumn("Millas");

        //Caracteristicas de los TableColumn
        tcSeries.setMaxWidth(125);
        tcSeries.setMinWidth(125);
        tcName.setMaxWidth(125);
        tcName.setMinWidth(125);
        tcYear.setMaxWidth(125);
        tcYear.setMinWidth(125);
        tcAmerican.setMaxWidth(125);
        tcAmerican.setMinWidth(125);
        tcMilage.setMaxWidth(128);
        tcMilage.setMinWidth(128);

        //Columnas con su respectiva informacion
        tcSeries.setCellValueFactory(new PropertyValueFactory("series"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcYear.setCellValueFactory(new PropertyValueFactory("year"));
        tcAmerican.setCellValueFactory(new PropertyValueFactory("american"));
        tcMilage.setCellValueFactory(new PropertyValueFactory("milage"));

        tvList.getColumns().addAll(tcSeries, tcName, tcYear, tcAmerican, tcMilage);
        ObservableList<Vehicle> data;
        try {
            data = getVehicle();
            tvList.setItems(data);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Caracteristicas y funciones Boton Cerrar
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        btnClose.setMinSize(120, 50);
        btnClose.setMaxSize(120, 50);
        btnClose.setTranslateX(150);

        btnClose.setOnAction(((event) -> {
            vBVehiclecIF.getChildren().clear();
        }));

        vBVehiclecIF.getChildren().addAll(lbViewCars, tvList, btnClose);

        return vBVehiclecIF;
    }

    public VBox getDelete() throws IOException {
        VBox vBVehiclecIF = new VBox();

        Label lbViewCars = new Label("Información de los vehiculos");
        Button btnSearch = new Button("Eliminar");
        Button btnClose = new Button("Cerrar");
        GridPane gpButton = new GridPane();
        Label lbDelete = new Label("Busque el vehiculo que desea eliminar");
        TextField tfDelete = new TextField();

        gpButton.add(btnSearch, 0, 0);
        gpButton.add(btnClose, 1, 0);
        gpButton.setMinSize(700, 700);
        gpButton.setTranslateX(20);
        gpButton.setTranslateY(80);

        //Caracteristicas del lbDelete
        lbDelete.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        lbDelete.setFont(ut.getGaramond());
        lbDelete.setTranslateX(20);
        lbDelete.setTranslateY(45);

        // Caracteristicas del tfDelete
        tfDelete.setMinSize(300, 30);
        tfDelete.setMaxSize(300, 30);
        tfDelete.setTranslateX(20);
        tfDelete.setTranslateY(60);

        // Caracteristicas de lbCar
        lbViewCars.setStyle("-fx-text-fill: Green; -fx-background-color: gray");
        lbViewCars.setTranslateX(25);
        lbViewCars.setFont(new Font("Garamond", 28));
        lbViewCars.setTranslateX(20);
        lbViewCars.setTranslateY(40);

        btnSearch.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        btnSearch.setMinSize(120, 50);
        btnSearch.setMaxSize(120, 50);

        btnSearch.setOnAction(((event) -> {

            try {
                MyFile mf = new MyFile(fileVehicle);
                mf.deleteRecord(Integer.parseInt(tfDelete.getText()));
                tfDelete.setText("");
            } catch (IOException ex) {
                Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }));

        // Caracteristicas y funciones Boton Cerrar
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        btnClose.setMinSize(120, 50);
        btnClose.setMaxSize(120, 50);
        btnClose.setTranslateX(110);

        btnClose.setOnAction(((event) -> {

            gpButton.getChildren().clear();
            vBVehiclecIF.getChildren().clear();
        }));

        vBVehiclecIF.getChildren().addAll(lbViewCars, lbDelete, tfDelete, gpButton);

        return vBVehiclecIF;
    }

    public VBox getModVehInterface() {

        VBox vB_AddIF = new VBox();
        GridPane gPAdd = new GridPane();
        gPAdd.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPAdd.setVgap(15);
        gPAdd.setHgap(15);

        gPAdd.setTranslateY(100);
        gPAdd.setTranslateX(45);

        Label lbTitle = new Label("Modificar vehículo");
        lbTitle.setStyle("-fx-text-fill: Red");
        lbTitle.setFont(new Font("Broadway", 26));
        gPAdd.add(lbTitle, 0, 0);
        lbTitle.setTranslateX(200);

        //label serie
        Label lBSerie = new Label("  Ingrese serie del Vehículo");
        lBSerie.setStyle("-fx-text-fill: white");
        lBSerie.setFont(new Font("Broadway", 18));
        gPAdd.add(lBSerie, 0, 3);

        TextField tF_Serie = new TextField();
        gPAdd.add(tF_Serie, 1, 3);

        //Nombre 
        Label lBName = new Label("  Nombre");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Broadway", 18));
        gPAdd.add(lBName, 0, 5);

        TextField tF_Name = new TextField();
        gPAdd.add(tF_Name, 1, 5);

        //Anno
        Label lBYear = new Label("  Año");
        lBYear.setStyle("-fx-text-fill: white");
        lBYear.setFont(new Font("Broadway", 18));
        gPAdd.add(lBYear, 0, 6);

        TextField tF_Year = new TextField();
        gPAdd.add(tF_Year, 1, 6);

        //Americano
        Label lBAmerican = new Label("Procedencia del auto");
        lBAmerican.setStyle("-fx-text-fill: white");
        lBAmerican.setFont(new Font("Broadway", 18));
        gPAdd.add(lBAmerican, 0, 7);

        //Combox American
        ComboBox cBAmerican = new ComboBox();
        cBAmerican.getItems().addAll("Americano", "Otros");
        gPAdd.add(cBAmerican, 0, 8);
        cBAmerican.setMaxSize(120, 50);

        //boton buscar
        Button btSearch = new Button("Buscar");//Insertar imagen 
        btSearch.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(btSearch, 1, 4);
        btSearch.setMaxSize(120, 50);
        btSearch.setMinSize(120, 50);

        btSearch.setOnAction((event) -> {

            //Datos actuales
            try {
                MyFile mf = new MyFile(fileVehicle);
                // mf.getVehicl(Integer.parseInt(tF_Serie.getText()));

                int serie = Integer.parseInt(tF_Serie.getText());

                tF_Name.setText(mf.getVehicl(serie).getName() + "");
                tF_Year.setText(mf.getVehicl(serie).getYear() + "");

                if (mf.getVehicl(serie).isAmerican()) {
                    cBAmerican.setValue("Americano");
                } else {
                    cBAmerican.setValue("Otro");
                }

            } catch (IOException ex) {
                Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

            // tF_Serie.setText("");
        });

        //Label vehiculo modificado con exito
        Label lBModify = new Label("Vehículo modificado con éxito");
        lBModify.setFont(new Font("Broadway", 22));
        gPAdd.add(lBModify, 1, 7);
        lBModify.setVisible(false);
        lBModify.setStyle("-fx-text-fill: Red");

        PauseTransition visibleLabel = new PauseTransition(Duration.seconds(3));
        visibleLabel.setOnFinished(event -> lBModify.setVisible(false));

        //Boton modifficar
        Button btModify = new Button("Modificar");//Insertar imagen 
        btModify.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(btModify, 1, 8);
        btModify.setMaxSize(120, 50);
        btModify.setMinSize(120, 50);

        //Funcion de modificar
        btModify.setOnAction(((event) -> {

            try {
                MyFile mf = new MyFile(fileVehicle);

                int serie = Integer.parseInt(tF_Serie.getText());
                String name = tF_Name.getText();
                int year = Integer.parseInt(tF_Year.getText());
                boolean isAmerican;
                if (cBAmerican.getValue().equals("Americano")) {
                    isAmerican = true;
                } else {
                    isAmerican = false;
                }

                mf.getModVehicl(serie, name, year, isAmerican);
               
                tF_Name.setText("");
                tF_Year.setText("");
                cBAmerican.setValue("");

            } catch (IOException ex) {
                //Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

            // visibleLabel.play(); 
        }));

        // Funcion de Close
        Button bTN_Close = new Button("Cerrar");
        bTN_Close.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(bTN_Close, 1, 8);
        bTN_Close.setTranslateX(200);
        bTN_Close.setMaxSize(120, 50);
        bTN_Close.setMinSize(120, 50);

        bTN_Close.setOnAction(((event) -> {

            gPAdd.getChildren().clear();
            gPAdd.setStyle("");
            vB_AddIF.getChildren().clear();
        }));

        vB_AddIF.getChildren().addAll(gPAdd);

        return vB_AddIF;
    }

    public ObservableList<Vehicle> getVehicle() throws IOException {

        MyFile mf = new MyFile(fileVehicle);
        ArrayList array = new ArrayList();
        ObservableList<Vehicle> ol_ListadoContactos = null;

        ol_ListadoContactos = FXCollections.observableArrayList(mf.getAllVehicle());

        return ol_ListadoContactos;
    }
}
