package Interface;

import Company.CarDriver;
import Company.Employee;
import Company.HeavyMachineryDrivers;
import Company.Janitor;
import Company.Manager;
import Company.Vehicle;
import File.EmployeeFile;
import File.MyFile;
import com.sun.media.jfxmediaimpl.platform.Platform;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class InterfaceEmployee {

    //Interface Añadir Empleado
    public VBox getAddInterface() {

        VBox vB_AddIF = new VBox();
        GridPane gPAdd = new GridPane();
        gPAdd.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPAdd.setVgap(14);
        gPAdd.setHgap(10);

        gPAdd.setTranslateY(100);
        gPAdd.setTranslateX(45);
        // Caracteristicas del Label lBADDEMployee
        Label lBAddEmployee = new Label("Añadir Empleado");
        lBAddEmployee.setStyle("-fx-text-fill: Red");
        lBAddEmployee.setFont(new Font("Broadway", 24));
        gPAdd.add(lBAddEmployee, 0, 0);
        lBAddEmployee.setTranslateY(15);
        lBAddEmployee.setTranslateX(195);

        //NOMBRE Label y Text Field
        Label lBName = new Label("  Nombre");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Garamond", 22));
        gPAdd.add(lBName, 0, 3);
        TextField tF_Name = new TextField();
        tF_Name.setMaxSize(350, 30);
        tF_Name.setMinSize(350, 30);
        tF_Name.setPromptText("Ingrese el nombre del empleado");
        gPAdd.add(tF_Name, 1, 3);

        //Apellido Label y Text Field
        Label lBLastName = new Label("  Apellido");
        lBLastName.setStyle("-fx-text-fill: white");
        lBLastName.setFont(new Font("Garamond", 22));
        gPAdd.add(lBLastName, 0, 4);

        TextField tF_LastName = new TextField();
        tF_LastName.setMaxSize(350, 30);
        tF_LastName.setMinSize(350, 30);
        tF_LastName.setPromptText("Ingrese el apellido del empleado");
        gPAdd.add(tF_LastName, 1, 4);

        //Cédula Label y Text Field
        Label lBID = new Label("  Cédula");
        lBID.setStyle("-fx-text-fill: white");
        lBID.setFont(new Font("Garamond", 22));
        gPAdd.add(lBID, 0, 5);

        TextField tF_ID = new TextField();
        tF_ID.setMaxSize(350, 30);
        tF_ID.setMinSize(350, 30);
        tF_ID.setPromptText("Ingrese el Id de la persona");
        gPAdd.add(tF_ID, 1, 5);

        //Numero de empleado Label y Text Field
        Label lbEmployeeID = new Label("  Número de empleado");
        lbEmployeeID.setStyle("-fx-text-fill: white");
        lbEmployeeID.setFont(new Font("Garamond", 22));
        gPAdd.add(lbEmployeeID, 0, 6);

        TextField tF_EmployeeID = new TextField();
        tF_EmployeeID.setMaxSize(350, 30);
        tF_EmployeeID.setMinSize(350, 30);
        tF_EmployeeID.setPromptText("Ingrese el ID de empleado");
        gPAdd.add(tF_EmployeeID, 1, 6);

        //Esta calificado para el puesto Label 
        Label lBQualified = new Label("¿Está calificado(a) \npara el puesto?");
        lBQualified.setStyle("-fx-text-fill: white");
        lBQualified.setFont(new Font("Garamond", 22));
        gPAdd.add(lBQualified, 0, 7);

        //Combo box Quality
        ComboBox cBQuality = new ComboBox();
        cBQuality.getItems().addAll("Si", "No");
        gPAdd.add(cBQuality, 0, 9);
        cBQuality.setMaxSize(150, 27);
        cBQuality.setPromptText("¿Esta calificado?");

        //Label Empleado insertado con exito
        Label lBAdd = new Label("Empleado añadido con éxito");
        lBAdd.setFont(new Font("Broadway", 22));
        gPAdd.add(lBAdd, 1, 12);
        lBAdd.setVisible(false);
        lBAdd.setStyle("-fx-text-fill: Red");

        PauseTransition visibleLabel = new PauseTransition(Duration.seconds(3));
        visibleLabel.setOnFinished(event -> lBAdd.setVisible(false));

        //Boton Insertar
        Button btNAdd = new Button("Añadir");//Insertar imagen 
        btNAdd.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPAdd.add(btNAdd, 1, 11);
        btNAdd.setMaxSize(120, 50);
        btNAdd.setMinSize(120, 50);

        //Label para comboBox
        Label lBPosition = new Label("Cargo");
        lBPosition.setStyle("-fx-text-fill: white");
        lBPosition.setFont(new Font("Garamond", 22));
        gPAdd.add(lBPosition, 0, 10);

        ComboBox cBPosition = new ComboBox();
        cBPosition.getItems().addAll("Conductor", "Administrador", "Conserje");
        gPAdd.add(cBPosition, 0, 11);
        gPAdd.setTranslateY(7);
        cBPosition.setMaxSize(150, 27);
        cBPosition.setPromptText("Escoja el Cargo");

        //Funcion de add
        btNAdd.setOnAction(((event) -> {

            String name = tF_Name.getText();
            String lastName = tF_LastName.getText();
            String employeeCode = tF_EmployeeID.getText();
            String iD = tF_ID.getText();
            int salary = 0;

            String quality = (String) cBQuality.getValue();
            boolean quality1;
            quality1 = quality.equalsIgnoreCase("Si");

            try {
                if (cBPosition.getValue().equals("Administrador")) {
                    File fileVehicle = new File("./Files/Manager.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    Employee employee = new Employee(name, lastName, iD, employeeCode, salary, quality1) {
                        @Override
                        public void calculateSalary() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    my.addEndRecord(employee);
                    lBAdd.setVisible(true);
                    visibleLabel.play();
                    tF_EmployeeID.setText("");
                    tF_ID.setText("");
                    tF_LastName.setText("");
                    tF_Name.setText("");
                    cBQuality.setValue("");
                }
                if (cBPosition.getValue().equals("Conserje")) {
                    File fileVehicle = new File("./Files/Janitor.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    Employee employee = new Employee(name, lastName, employeeCode, iD, salary, quality1) {
                        @Override
                        public void calculateSalary() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    my.addEndRecord(employee);
                    lBAdd.setVisible(true);
                    visibleLabel.play();
                    tF_EmployeeID.setText("");
                    tF_ID.setText("");
                    tF_Name.setText("");
                    tF_LastName.setText("");
                    cBQuality.setValue("");
                }

                if (cBPosition.getValue().equals("Conductor")) {
                    File fileVehicle = new File("./Files/Driver.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    Employee employee = new Employee(name, lastName, employeeCode, iD, salary, quality1) {
                        @Override
                        public void calculateSalary() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    my.addEndRecord(employee);
                    lBAdd.setVisible(true);
                    visibleLabel.play();
                    tF_EmployeeID.setText("");
                    tF_ID.setText("");
                    tF_LastName.setText("");
                    tF_Name.setText("");
                    cBPosition.setValue("");
                    cBQuality.setValue("");
                }
                cBPosition.getSelectionModel().selectFirst();
                cBQuality.getSelectionModel().selectFirst();
            } catch (IOException ioe) {

            }
        }));

        // Funcion de Close
        Button bTN_Close = new Button("Cerrar");
        bTN_Close.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPAdd.add(bTN_Close, 1, 11);
        bTN_Close.setTranslateX(150);
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

    // Busca Empleado
    public VBox SearchEmployee() {

        VBox vB_Search = new VBox();
        GridPane gPSearch = new GridPane();
        gPSearch.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPSearch.setVgap(10);
        gPSearch.setHgap(10);

        gPSearch.setTranslateY(100);
        gPSearch.setTranslateX(45);

        Label lBAddVehicle = new Label("Buscar empleado por nombre");
        lBAddVehicle.setStyle("-fx-text-fill: white");
        lBAddVehicle.setFont(new Font("Broadway", 26));
        gPSearch.add(lBAddVehicle, 0, 0);

        TextField tF_Name = new TextField();
        gPSearch.add(tF_Name, 0, 1);
        tF_Name.setMinSize(500, 50);
        tF_Name.setMaxSize(500, 50);

        //Boton Insertar
        Button btNAdd = new Button("Buscar");
        btNAdd.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPSearch.add(btNAdd, 1, 4);
        btNAdd.setMaxSize(120, 50);
        btNAdd.setMinSize(120, 50);

        TextArea tAEmployee = new TextArea();
        tAEmployee.setTranslateY(7);
        tAEmployee.setMaxSize(300, 100);
        tAEmployee.setMinSize(300, 100);
        gPSearch.add(tAEmployee, 0, 5);

        ComboBox cBPosition = new ComboBox();
        cBPosition.getItems().addAll("Conductor", "Administrador", "Conserje");
        gPSearch.add(cBPosition, 0, 4);
        gPSearch.setTranslateY(7);
        cBPosition.setMaxSize(150, 27);
        cBPosition.setPromptText("Escoja el Cargo");

        //Funcion de add
        btNAdd.setOnAction(((event) -> {
            String employee = tF_Name.getText();
            tAEmployee.setText("");

            try {
                if (cBPosition.getValue().equals("Administrador")) {
                    File fileVehicle = new File("./Files/Manager.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    tAEmployee.setText(my.getEmploye(employee).toString());

                }

                if (cBPosition.getValue().equals("Conserje")) {
                    File fileVehicle = new File("./Files/Janitor.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);

                    tAEmployee.setText(my.getEmploye(employee).toString());
                }

                if (cBPosition.getValue().equals("Conductor")) {
                    File fileVehicle = new File("./Files/Driver.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    tAEmployee.setText(my.getEmploye(employee).toString());

                }
                tF_Name.setText("");
                cBPosition.setValue("");
                cBPosition.getSelectionModel().selectFirst();

            } catch (IOException ioe) {

            }
            //String info = "No existe un empleado con ese nombre";

        }));

        // Funcion de Close
        Button bTN_Close = new Button("Cerrar");
        bTN_Close.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPSearch.add(bTN_Close, 1, 13);
        bTN_Close.setTranslateX(150);
        bTN_Close.setMaxSize(120, 50);
        bTN_Close.setMinSize(120, 50);

        bTN_Close.setOnAction(((event) -> {

            gPSearch.getChildren().clear();
            gPSearch.setStyle("");
            vB_Search.getChildren().clear();
        }));

        vB_Search.getChildren().addAll(gPSearch);

        return vB_Search;
    }

    public VBox getEmployeeTipe() {

        VBox vB_getEmployeeTipe = new VBox();
        GridPane gPSearch = new GridPane();
        gPSearch.setMinSize(700, 700);

        gPSearch.setHgap(25);
        gPSearch.setHgap(25);
        //determina el espacio entre columnas (vertical y orizontal)
        gPSearch.setTranslateY(40);
        gPSearch.setTranslateX(50);

        Label lBAddVehicle = new Label("Mostrar los empleados");
        lBAddVehicle.setStyle("-fx-text-fill: Red");
        lBAddVehicle.setFont(new Font("Broadway", 28));
        lBAddVehicle.setTranslateX(210);
        lBAddVehicle.setTranslateY(30);

        //Boton Insertar
        Button btNAdd = new Button("Buscar");
        btNAdd.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPSearch.add(btNAdd, 0, 3);
        btNAdd.setMaxSize(120, 50);
        btNAdd.setMinSize(120, 50);
        btNAdd.setTranslateY(10);

        //Caracteristicas del cBPosition
        ComboBox cBPosition = new ComboBox();
        cBPosition.getItems().addAll("Conductor", "Administrador", "Conserje");
        gPSearch.add(cBPosition, 0, 2);
        cBPosition.setMinSize(200, 40);
        cBPosition.setMaxSize(200, 40);
        cBPosition.setMaxSize(150, 27);
        cBPosition.setPromptText("Escoja el Cargo");

        //Funcion de add
        btNAdd.setOnAction(((event) -> {

            try {
                if (cBPosition.getValue().equals("Administrador")) {
                    File fileVehicle = new File("./Files/Manager.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    TableView tvList = tBView();
                    gPSearch.add(tvList, 0, 4);
                    ObservableList<Employee> data;
                    data = getEmployeeManager();
                    tvList.setItems(data);

                }

                if (cBPosition.getValue().equals("Conserje")) {
                    File fileVehicle = new File("./Files/Janitor.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    TableView tvList = tBView();
                    gPSearch.add(tvList, 0, 4);
                    ObservableList<Employee> data;
                    data = getEmployeeJanitor();
                    tvList.setItems(data);

                }

                if (cBPosition.getValue().equals("Conductor")) {
                    File fileVehicle = new File("./Files/Driver.dat");
                    EmployeeFile my = new EmployeeFile(fileVehicle);
                    TableView tvList = tBView();
                    gPSearch.add(tvList, 0, 4);
                    ObservableList<Employee> data;
                    data = getEmployeeDriver();
                    tvList.setItems(data);

                }
                cBPosition.setValue("");

            } catch (IOException ioe) {

            }
            //String info = "No existe un empleado con ese nombre";

        }));

        // Funcion de Close
        Button bTNClose = new Button("Cerrar");
        bTNClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");
        gPSearch.add(bTNClose, 0, 3);
        bTNClose.setTranslateX(150);
        bTNClose.setMaxSize(120, 50);
        bTNClose.setMinSize(120, 50);
        bTNClose.setTranslateY(10);

        bTNClose.setOnAction(((event) -> {

            gPSearch.getChildren().clear();
            gPSearch.setStyle("");
            vB_getEmployeeTipe.getChildren().clear();
        }));

        vB_getEmployeeTipe.getChildren().addAll(lBAddVehicle, gPSearch);

        return vB_getEmployeeTipe;
    }

    public VBox getInterfaceCalSalary() {

        VBox vBCalSalary = new VBox();
        GridPane gPCalSal = new GridPane();
        gPCalSal.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPCalSal.setVgap(10);
        gPCalSal.setHgap(10);
        //determina alineacion del GridPane
        gPCalSal.setTranslateX(50);
        gPCalSal.setTranslateY(50);

        //Caracteristicas del lBEmployee
        Label lBEmployee = new Label("Escoja el cargo del empleado");
        lBEmployee.setStyle("-fx-text-fill: white");
        lBEmployee.setFont(new Font("Garamond", 22));
        gPCalSal.add(lBEmployee, 0, 0);

        //Caracteristicas de cBPositionEmployee
        ComboBox cBPositionEmploye = new ComboBox();
        cBPositionEmploye.getItems().addAll("Conductor", "Conserje", "Administrativo");
        gPCalSal.add(cBPositionEmploye, 0, 2);

        Button btnSearch = new Button("Buscar");
        gPCalSal.add(btnSearch, 0, 4);

        btnSearch.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 18px;");

        btnSearch.setOnAction((event) -> {
            String name = (String) cBPositionEmploye.getValue();
            //se ingresa metodo para ver el cargo
            if (name.equalsIgnoreCase("Conductor")) {
                vBCalSalary.getChildren().clear();
                vBCalSalary.getChildren().addAll(getInterfaceCalSalaryDriver());
            }
            if (name.equalsIgnoreCase("Conserje")) {
                vBCalSalary.getChildren().clear();
                vBCalSalary.getChildren().addAll(getInterfaceCalSalaryJanitor());
            }
            if (name.equalsIgnoreCase("Administrativo")) {
                vBCalSalary.getChildren().clear();
                vBCalSalary.getChildren().addAll(getInterfaceCalSalaryManager());
            }
        });

        Button btnClose = new Button("Cerrar");
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPCalSal.add(btnClose, 0, 4);
        btnClose.setTranslateX(150);

        btnClose.setOnAction(((event) -> {

            gPCalSal.getChildren().clear();
            vBCalSalary.getChildren().clear();
        }));

        vBCalSalary.getChildren().addAll(gPCalSal);
        return vBCalSalary;
    }

    //retorna la interfaz para calcular salario del conductor
    public VBox getInterfaceCalSalaryDriver() {
        VBox vBCalSalary = new VBox();
        GridPane gPCalSal = new GridPane();
        gPCalSal.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPCalSal.setVgap(15);
        gPCalSal.setHgap(20);

        //determina alineacion del GridPane
        gPCalSal.setTranslateX(100);
        gPCalSal.setTranslateY(50);

        Label lBName = new Label("Ingrese nombre del empleado");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBName, 0, 0);
        TextField tfName = new TextField();
        gPCalSal.add(tfName, 0, 1);

        Label lBHours = new Label("Ingrese horas laboradas");
        lBHours.setStyle("-fx-text-fill: white");
        lBHours.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBHours, 0, 2);
        TextField tfHours = new TextField();
        gPCalSal.add(tfHours, 0, 3);

        Label lBKindVeh = new Label("Tipo de vehículo");
        lBKindVeh.setStyle("-fx-text-fill: white");
        lBKindVeh.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBKindVeh, 0, 4);
        ComboBox cB_kind = new ComboBox();
        cB_kind.getItems().addAll("Carro", "Grua", "Vagoneta", "Monta cargas");
        gPCalSal.add(cB_kind, 0, 5);

        Label lBScheduleVeh = new Label("Horario");
        lBScheduleVeh.setStyle("-fx-text-fill: white");
        lBScheduleVeh.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBScheduleVeh, 0, 6);

        // Caracteristicas ComboBox 
        ComboBox cB_day = new ComboBox();
        cB_day.getItems().addAll("Día", "Noche");
        gPCalSal.add(cB_day, 0, 7);

        TextField tfCal = new TextField();
        gPCalSal.add(tfCal, 0, 10);

        Button btnCal = new Button("Calcular Salario");
        gPCalSal.add(btnCal, 0, 9);

        btnCal.setOnAction((event) -> {

            try {
                CarDriver cd = new CarDriver();
                String name = tfName.getText();
                int hours = Integer.parseInt(tfHours.getText());
                String schedule = (String) cB_day.getValue();
                String vehicle = (String) cB_kind.getValue();

                int sal = cd.calculateSalary(name, hours, schedule, vehicle);
                tfCal.setText("$" + sal);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnClose = new Button("Cerrar");
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPCalSal.add(btnClose, 0, 11);
        btnClose.setOnAction(((event) -> {

            gPCalSal.getChildren().clear();
            vBCalSalary.getChildren().clear();
        }));

        vBCalSalary.getChildren().addAll(gPCalSal);
        return vBCalSalary;

    }

    //retorna la interfaz para calcular salario del conserje
    public VBox getInterfaceCalSalaryJanitor() {
        VBox vBCalSalary = new VBox();
        GridPane gPCalSal = new GridPane();
        gPCalSal.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPCalSal.setVgap(20);
        gPCalSal.setHgap(20);
        //determina alineacion del GridPane
        gPCalSal.setTranslateX(100);
        gPCalSal.setTranslateY(100);

        // Caracteristicas del lBName y tfName
        Label lBName = new Label("Ingrese nombre del empleado");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBName, 0, 0);
        TextField tfName = new TextField();
        gPCalSal.add(tfName, 0, 1);

        // Caracteristicas del lBHours y tfHours
        Label lBHours = new Label("Ingrese horas extra laboradas");
        lBHours.setStyle("-fx-text-fill: white");
        lBHours.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBHours, 0, 2);
        TextField tfHours = new TextField();
        gPCalSal.add(tfHours, 0, 3);
        // Caracteristicas del tfCal
        TextField tfCal = new TextField();
        gPCalSal.add(tfCal, 0, 5);

        Button btnCal = new Button("Calcular Salario");
        gPCalSal.add(btnCal, 0, 4);
        btnCal.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");

        btnCal.setOnAction((event) -> {
            try {
                Janitor j = new Janitor();
                String name = tfName.getText();
                int hours = Integer.parseInt(tfHours.getText());

                int sal = j.calculateSalary(name, hours);
                tfCal.setText("$" + sal);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnClose = new Button("Cerrar");
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPCalSal.add(btnClose, 0, 6);
        btnClose.setOnAction(((event) -> {

            gPCalSal.getChildren().clear();
            vBCalSalary.getChildren().clear();
        }));

        vBCalSalary.getChildren().addAll(gPCalSal);
        return vBCalSalary;

    }

    //retorna la interfaz para calcular salario del administrativo
    public VBox getInterfaceCalSalaryManager() {
        VBox vBCalSalary = new VBox();
        GridPane gPCalSal = new GridPane();
        gPCalSal.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPCalSal.setVgap(20);
        gPCalSal.setHgap(20);
        //determina alineacion del GridPane
        gPCalSal.setTranslateX(100);
        gPCalSal.setTranslateY(100);

        // Caracteristicas del lBName y tfName
        Label lBName = new Label("Ingrese nombre del empleado");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBName, 0, 0);
        TextField tfName = new TextField();
        gPCalSal.add(tfName, 0, 1);

        // Caracteristicas del lBClass 
        Label lBClass = new Label("Categoría de administrativo");
        lBClass.setStyle("-fx-text-fill: white");
        lBClass.setFont(new Font("Garamond", 20));
        gPCalSal.add(lBClass, 0, 2);

        //Caracteristicas del ComboBox
        ComboBox cB_Category = new ComboBox();
        cB_Category.getItems().addAll("Categoría 1", "Categoría 2");
        gPCalSal.add(cB_Category, 0, 3);

        TextField tfCal = new TextField();
        gPCalSal.add(tfCal, 0, 5);

        Button btnCal = new Button("Calcular Salario");
        gPCalSal.add(btnCal, 0, 4);
        btnCal.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");

        btnCal.setOnAction((event) -> {
            try {
                Manager m = new Manager();
                String name = tfName.getText();
                String category = (String) cB_Category.getValue();
                int sal = m.calculateSalary(name, category);
                tfCal.setText("$" + sal);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnClose = new Button("Cerrar");
        btnClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPCalSal.add(btnClose, 0, 6);
        btnClose.setOnAction(((event) -> {

            gPCalSal.getChildren().clear();
            vBCalSalary.getChildren().clear();
        }));

        vBCalSalary.getChildren().addAll(gPCalSal);
        return vBCalSalary;
    }

    public ObservableList<Employee> getEmployeeDriver() throws IOException {

        File fileEmployee = new File("./Files/Driver.dat");
        EmployeeFile mf = new EmployeeFile(fileEmployee);
        ObservableList<Employee> ol_ListadoContactos;

        ol_ListadoContactos = FXCollections.observableArrayList(mf.getAllEmployees());

        return ol_ListadoContactos;
    }

    public ObservableList<Employee> getEmployeeManager() throws IOException {

        File fileEmployee = new File("./Files/Manager.dat");
        EmployeeFile mf = new EmployeeFile(fileEmployee);
        ObservableList<Employee> ol_ListadoContactos;

        ol_ListadoContactos = FXCollections.observableArrayList(mf.getAllEmployees());

        return ol_ListadoContactos;
    }

    public ObservableList<Employee> getEmployeeJanitor() throws IOException {

        File fileEmployee = new File("./Files/Janitor.dat");
        EmployeeFile mf = new EmployeeFile(fileEmployee);
        ObservableList<Employee> ol_ListadoContactos;

        ol_ListadoContactos = FXCollections.observableArrayList(mf.getAllEmployees());

        return ol_ListadoContactos;
    }

    public TableView tBView() throws IOException {

        TableView<Employee> tvList = new TableView();

        //Propiedades de Table view
        tvList.setTranslateX(15);
        tvList.setTranslateY(25);
        tvList.setMinSize(510, 300);
        tvList.setMaxSize(510, 300);

        //Crea columnas
        TableColumn tcName = new TableColumn("Nombre");
        TableColumn tcLastName = new TableColumn("Apellido");
        TableColumn tcIdEmployee = new TableColumn("Id Empleado");
        TableColumn tcQuality = new TableColumn("Calificado");

        //Caracteristicas de los TableColumn
        tcName.setMaxWidth(130);
        tcName.setMinWidth(130);
        tcLastName.setMaxWidth(130);
        tcLastName.setMinWidth(130);
        tcIdEmployee.setMaxWidth(130);
        tcIdEmployee.setMinWidth(130);
        tcQuality.setMaxWidth(116);
        tcQuality.setMinWidth(116);

        //Columnas con su respectiva informacion
        tcName.setCellValueFactory(new PropertyValueFactory("Name"));
        tcLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        tcIdEmployee.setCellValueFactory(new PropertyValueFactory("employeeCode"));
        tcQuality.setCellValueFactory(new PropertyValueFactory("quality"));

        tvList.getColumns().addAll(tcName, tcLastName, tcIdEmployee, tcQuality);

        return tvList;
    }

    //Interface de Modificar Empleado
    public VBox getModEmployeeInterface() {

        VBox vB_AddIF = new VBox();
        GridPane gPAdd = new GridPane();
        gPAdd.setMinSize(700, 700);

        //determina el espacio entre columnas (vertical y orizontal)
        gPAdd.setVgap(22);
        gPAdd.setHgap(10);

        gPAdd.setTranslateY(100);
        gPAdd.setTranslateX(100);

        Label lbTitle = new Label("Modificar Empleado");
        lbTitle.setStyle("-fx-text-fill: Red");
        lbTitle.setFont(new Font("Broadway", 26));
        lbTitle.setTranslateX(210);
        lbTitle.setTranslateY(20);

        //label nombre
        Label lBName = new Label("  Ingrese el nombre");
        lBName.setStyle("-fx-text-fill: white");
        lBName.setFont(new Font("Garamond", 20));
        gPAdd.add(lBName, 0, 1);

        TextField tF_Name = new TextField();
        tF_Name.setPromptText("Ingrese el nombre");
        gPAdd.add(tF_Name, 1, 1);
        // Caractesiticas del comboBx
        ComboBox cBPosition = new ComboBox();
        cBPosition.getItems().addAll("Conductor", "Administrador", "Conserje");
        gPAdd.add(cBPosition, 0, 2);
        gPAdd.setTranslateY(5);
        cBPosition.setMaxSize(200, 22);
        cBPosition.setPromptText("Cargo del empleado");

        //EmployeeID 
        Label lBEmployeeID = new Label(" Número de empleado");
        lBEmployeeID.setStyle("-fx-text-fill: white");
        lBEmployeeID.setFont(new Font("Garamond", 20));
        gPAdd.add(lBEmployeeID, 0, 4);

        TextField tF_EmployeeID = new TextField();
        tF_EmployeeID.setPromptText("Codigo del empleado");
        gPAdd.add(tF_EmployeeID, 1, 4);

        //Qualified
        Label lBQualified = new Label("  Está calificado");
        lBQualified.setStyle("-fx-text-fill: white");
        lBQualified.setFont(new Font("Garamond", 20));
        gPAdd.add(lBQualified, 0, 5);

        ComboBox cBQualified = new ComboBox();
        cBQualified.getItems().addAll("Si", "No");
        gPAdd.add(cBQualified, 0, 6);
        cBQualified.setMaxSize(125, 22);

        //boton buscar
        Button btSearch = new Button("Buscar");//Insertar imagen 
        btSearch.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(btSearch, 0, 3);
        btSearch.setMaxSize(120, 50);
        btSearch.setMinSize(120, 50);

        btSearch.setOnAction((event) -> {

            //Datos actuales
            try {
                if (cBPosition.getValue().equals("Administrador")) {
                    File fileEmployee = new File("./Files/Manager.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    //valores actuales
                    String name = tF_Name.getText();

                    tF_EmployeeID.setText(my.getEmploye(name).getEmployeeCode() + "");
                    String s;
                    if (my.getEmploye(name).isQuality()) {
                        s = "Si";
                    } else {
                        s = "No";
                    }
                    cBQualified.setValue(s);

                }

                if (cBPosition.getValue().equals("Conserje")) {
                    File fileEmployee = new File("./Files/Janitor.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    //valores actuales
                    String name = tF_Name.getText();

                    tF_EmployeeID.setText(my.getEmploye(name).getEmployeeCode() + "");
                    String s;
                    if (my.getEmploye(name).isQuality()) {
                        s = "Si";
                    } else {
                        s = "No";
                    }
                    cBQualified.setValue(s);
                }

                if (cBPosition.getValue().equals("Conductor")) {
                    File fileEmployee = new File("./Files/Driver.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    //valores actuales
                    String name = tF_Name.getText();

                    tF_EmployeeID.setText(my.getEmploye(name).getEmployeeCode() + "");
                    cBQualified.setValue(my.getEmploye(name).isQuality() + "");
                }
            } catch (IOException ex) {
                Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

            // tF_Serie.setText("");
        });

        //Label vehiculo modificado con exito
        Label lBModify = new Label("Vehículo modificado con éxito");
        lBModify.setFont(new Font("Garamond", 20));
        gPAdd.add(lBModify, 1, 7);
        lBModify.setVisible(false);
        lBModify.setStyle("-fx-text-fill: Red");

        PauseTransition visibleLabel = new PauseTransition(Duration.seconds(3));
        visibleLabel.setOnFinished(event -> lBModify.setVisible(false));

        //Boton modifficar
        Button btModify = new Button("Modificar");//Insertar imagen 
        btModify.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(btModify, 0, 8);
        btModify.setMaxSize(120, 50);
        btModify.setMinSize(120, 50);

        //Funcion de modificar
        btModify.setOnAction(((event) -> {

            try {
                if (cBPosition.getValue().equals("Administrador")) {
                    File fileEmployee = new File("./Files/Manager.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    String name = tF_Name.getText();
                    String EmployeeID = tF_EmployeeID.getText();
                    String Qualified = (String) cBQualified.getValue();

                    boolean Qualified1;
                    Qualified1 = cBQualified.getValue().equals("Si");
                    my.getModEmployee(name, EmployeeID, Qualified1);
                }

                if (cBPosition.getValue().equals("Conserje")) {
                    File fileEmployee = new File("./Files/Janitor.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    String name = tF_Name.getText();

                    String EmployeeID = tF_EmployeeID.getText();
                    boolean Qualified;

                    Qualified = cBQualified.getValue().equals("Si");

                    my.getModEmployee(name, EmployeeID, Qualified);
                }

                if (cBPosition.getValue().equals("Conductor")) {
                    File fileEmployee = new File("./Files/Driver.dat");
                    EmployeeFile my = new EmployeeFile(fileEmployee);

                    String name = tF_Name.getText();

                    String EmployeeID = tF_EmployeeID.getText();
                    String Qualified = (String) cBQualified.getValue();

                    boolean Qualified1;

                    Qualified1 = cBQualified.getValue().equals("Si");

                    my.getModEmployee(name, EmployeeID, Qualified1);
                }

            } catch (IOException ex) {
                //Logger.getLogger(InterfaceVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

            tF_Name.setText("");
            tF_EmployeeID.setText("");
            cBQualified.setValue("");
            cBPosition.setValue("");

            // visibleLabel.play(); 
        }));

        // Funcion de Close
        Button bTNClose = new Button("Cerrar");
        bTNClose.setStyle("-fx-text-fill: White; -fx-background-color: #082d44; -fx-font-size: 16px;");
        gPAdd.add(bTNClose, 0, 8);
        bTNClose.setTranslateX(200);
        bTNClose.setMaxSize(120, 50);
        bTNClose.setMinSize(120, 50);

        bTNClose.setOnAction(((event) -> {

            gPAdd.getChildren().clear();
            gPAdd.setStyle("");
            vB_AddIF.getChildren().clear();
        }));

        vB_AddIF.getChildren().addAll(lbTitle, gPAdd);

        return vB_AddIF;
    }

}
