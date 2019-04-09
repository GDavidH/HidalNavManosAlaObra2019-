package File;

// Clase archivo ---- Crea mi archivo de empleado
import Company.Employee;
import java.io.File;
import java.io.IOException;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFile extends Employee {

    public EmployeeFile() {
        this.setName("");
        this.setLastName("");
        this.setiD("");
        this.setQuality(false);
        this.setEmployeeCode("");
    }

    public EmployeeFile(String name, String lastName, String employeeCode, String iD, double salary, boolean quality, String position) {
        super(name, lastName, employeeCode, iD, salary, quality);

    }

    // Declaracion de mi archivo y las variables 
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;
    private int regSize;
    private String path;

    // Constructores de la clase
    public EmployeeFile(File file) throws IOException {
        start(file);
    }

    private void start(File file) throws IOException {
        // Almacena la Ruta del Archivo
        path = file.getPath();

        // Tamaño maximo de los registros
        this.regSize = 81;

        //validacion basica
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + "is a invalid file ");
        } else {
            //nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");

            //Indicar cuantos registros tiene el archivo 
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) regSize);
        }
    }

    //cerrar el programa 
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //cantidad de registros actuales 
    public int fileSize() {
        return regsQuantity;
    }

    //inserta un nuevo registro pero en una posicion existente
    public boolean putValue(int position, Employee employee) throws IOException {
        //validaccion antes de insertar 
        System.out.println(employee);
        if (position >= 0 && position <= regsQuantity) {
            if (employee.Size() > regSize) {
                System.err.print("7001 record size is out of bounds");
                return false;
            } else {
                //escribir en el archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeUTF(employee.getName());
                randomAccessFile.writeUTF(employee.getLastName());
                randomAccessFile.writeUTF(employee.getiD());
                randomAccessFile.writeUTF(employee.getEmployeeCode());
                randomAccessFile.writeBoolean(employee.isQuality());

                return true;
            }
        } else {
            System.err.println("7002 position is "
                    + "out of bounds of this file");
            return false;
        }
    }

    //agrega un registro nuevo pero al final del archivo, por esa razon se incrementa la cantidad de registros
    public boolean addEndRecord(Employee employee) throws IOException {
        //Insertar al final del archivo
        boolean success = putValue(regsQuantity, employee);
        if (success) {
            ++regsQuantity;
        }
        return success;
    }

    //Metodo que obtiene un registro del vehiculo en la posicion indicada
    public Employee getEmployee(int position) throws IOException {
        //validacion de la posicion
        if (position >= 0 && position <= regsQuantity) {
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);

            //instancia del vehiculo
            //Employee myVehicle = new Employee();
            Employee myEmployee = new Employee() {
                @Override
                public void calculateSalary() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            //llevamos a cabo las lecturas 
            myEmployee.setName(randomAccessFile.readUTF());
            myEmployee.setLastName(randomAccessFile.readUTF());
            myEmployee.setiD(randomAccessFile.readUTF());
            myEmployee.setEmployeeCode(randomAccessFile.readUTF());
            myEmployee.setQuality(randomAccessFile.readBoolean());

            //si es = delete no retorno 
            if (myEmployee.getName().equalsIgnoreCase("delete")) {
                return null;
            } else {
                return myEmployee;
            }
        } else {
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }

    //consulta todos los registros de mi archivo y retorna una lista
    public List<Employee> getAllEmployees() throws IOException {

        //variables a retornar
        List<Employee> employee = new ArrayList();

        //recorro todos mis registros y los inserto en la lista
        for (int i = 0; i < regsQuantity; i++) {
            Employee EmployeeTemp = this.getEmployee(i);
            
            if (EmployeeTemp != null ) {
                employee.add(EmployeeTemp);
            }
        }
        return employee;
    }

    //buscar el registro por serie para eliminarlo
    public boolean deleteRecord(String name) throws IOException {
        Employee myEmployee;

        String temp;
        for (int i = 0; i < regsQuantity; i++) {
            myEmployee = this.getEmployee(i);
            if (myEmployee == null) {

            } else {
                temp = myEmployee.getName();
                if (temp.equals(name)) {
                    //marcar este vehiculo como eliminado
                    randomAccessFile.seek(i * regSize);
                    randomAccessFile.writeInt(0);
                    return true;
                }
            }
        }
        //si llega a este punto no encontro
        return false;
    }

    public Employee getEmploye(String name) throws IOException {
        //validacion de la posicion
        for (int position = 0; position <= regsQuantity; position++) {
            if (position >= 0 && position <= regsQuantity){
                System.out.println(regsQuantity);
            
                Employee myEmployee;
                myEmployee = this.getEmployee(position);
                if (myEmployee == null) {

                } else {
                    if (myEmployee.getName().equalsIgnoreCase(name)) {
                        //llevamos a cabo las lecturas 
                        //colocamos el puntero en el lugar 
                        return myEmployee;
                    }
                }
            } else {
                return null;
            }
        }
        System.err.println("6001 position is out of bounds");
        return null;
    }

  public void getModEmployee(String name, String employeeID, boolean Quality) throws IOException {//cambiar entradas para mmodificar
        //validacion de la posicion
        for (int position = 0; position <= regsQuantity; position++) {
            if (position >= 0 && position <= regsQuantity) {
                //instancia del vehiculo
                Employee myEmployee;
                myEmployee = this.getEmployee(position);
                if (myEmployee == null) {

                } else if (myEmployee.getName().equalsIgnoreCase(name)) {
                    //llevamos a cabo las lecturas 
                    //colocamos el puntero en el lugar 
                    randomAccessFile.seek(position * regSize);
                    //reemplazar
                    randomAccessFile.writeUTF(myEmployee.getName());
                    randomAccessFile.writeUTF(myEmployee.getLastName());
                    randomAccessFile.writeUTF(myEmployee.getiD());
                    randomAccessFile.writeUTF(employeeID);
                    randomAccessFile.writeBoolean(Quality);
                }
            }
        }
    }

    public boolean SerieExist(String name) throws IOException {

        Employee myEmployee;
        for (int i = 0; i <= regsQuantity; i++) {
            myEmployee = this.getEmployee(i);
            if (myEmployee == null) {

            } else {
                if (myEmployee.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        //si llega a este punto no encontro
        return false;
    }

    @Override
    public void calculateSalary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
