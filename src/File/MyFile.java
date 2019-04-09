package File;

// Clase archivo ---- Crea mi archivo
import Company.Vehicle;
import java.io.File;
import java.io.IOException;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

    // Declaracion de mi archivo y las variables 
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;
    private int regSize;
    private String path;

    // Constructores de la clase
    public MyFile(File file) throws IOException {
        start(file);
    }

    private void start(File file) throws IOException {
        // Almacena la Ruta del Archivo
        path = file.getPath();

        // Tamaño maximo de los registros
        this.regSize = 53;

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
    public boolean putValue(int position, Vehicle vehicle) throws IOException {
        //validaccion antes de insertar 

        if (position >= 0 && position <= regsQuantity) {
            if (vehicle.Size() > regSize) {
                System.err.print("7001 record size is out of bounds");
                return false;
            } else {
                //escribir en el archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeInt(vehicle.getSeries());
                randomAccessFile.writeUTF(vehicle.getName());
                randomAccessFile.writeInt(vehicle.getYear());
                randomAccessFile.writeFloat(vehicle.getMilage());
                randomAccessFile.writeBoolean(vehicle.isAmerican());
                return true;
            }
        } else {
            System.err.println("7002 position is "
                    + "out of bounds of this file");
            return false;
        }
    }

    //agrega un registro nuevo pero al final del archivo, por esa razon se incrementa la cantidad de registros  
    public boolean addEndRecord(Vehicle vehicle) throws IOException {
        //Insertar al final del archivo
        boolean success = putValue(regsQuantity, vehicle);
        if (success) {
            ++regsQuantity;
        }
        return success;
    }

    //Metodo que obtiene un registro del vehiculo en la posicion indicada
    public Vehicle getVehicle(int position) throws IOException {
        //validacion de la posicion
        if (position >= 0 && position <= regsQuantity) {
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);

            //instancia del vehiculo
            Vehicle myVehicle = new Vehicle();

            //llevamos a cabo las lecturas 
            myVehicle.setSeries(randomAccessFile.readInt());
            myVehicle.setName(randomAccessFile.readUTF());
            myVehicle.setYear(randomAccessFile.readInt());
            myVehicle.setMilage(randomAccessFile.readFloat());
            myVehicle.setAmerican(randomAccessFile.readBoolean());

            //si es = delete no retorno 
            if (myVehicle.getSeries() != 0) {
                return myVehicle;
            } else {
                return null;
            }
        } else {
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }

    //consulta todos los registros de mi archivo y retorna una lista
    public List<Vehicle> getAllVehicle() throws IOException {

        //variables a retornar
        List<Vehicle> vehicle = new ArrayList();

        //recorro todos mis registros y los inserto en la lista
        for (int i = 0; i < regsQuantity; i++) {
            Vehicle vehicleTemp = this.getVehicle(i);

            if (vehicleTemp != null && vehicleTemp.getSeries() != 0) {
                vehicle.add(vehicleTemp);
            }
        }
        return vehicle;
    }

    //buscar el registro por serie para eliminarlo
    public boolean deleteRecord(int serie) throws IOException {
        Vehicle myVehicl;

        int temp;
        for (int i = 0; i < regsQuantity; i++) {
            myVehicl = this.getVehicle(i);
            if (myVehicl == null) {

            } else {
                temp = myVehicl.getSeries();
                if (temp == serie) {
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

    public Vehicle getVehicl(int serie) throws IOException {
        //validacion de la posicion
        for (int position = 0; position <= regsQuantity; position++) {
            if (position >= 0 && position <= regsQuantity) {
                //instancia del vehiculo
                Vehicle myVehicle;
                myVehicle = this.getVehicle(position);
                if (myVehicle == null) {

                } else {
                    if (myVehicle.getSeries() == serie) {

                        return myVehicle;
                    }
                }
            } else {
                return null;
            }
        }//fin for
        System.err.println("6001 position is out of bounds");
        return null;
    }

    public void getModVehicl(int serie, String name, int year, boolean isAmerica) throws IOException {

        //validacion de la posicion
        for (int position = 0; position <= regsQuantity; position++) {
            if (position >= 0 && position <= regsQuantity) {
                //instancia del vehiculo
                Vehicle myVehicle;
                myVehicle = this.getVehicle(position);
                if (myVehicle == null) {

                } else {
                    if (myVehicle.getSeries() == serie) {
                        //llevamos a cabo las lecturas 
                        //colocamos el puntero en el lugar 
                        randomAccessFile.seek(position * regSize);
                        //reemplazar
                        randomAccessFile.writeInt(serie);
                        randomAccessFile.writeUTF(name);
                        randomAccessFile.writeInt(year);
                        randomAccessFile.writeFloat(myVehicle.getMilage());
                        randomAccessFile.writeBoolean(isAmerica);
                    }
                }
            }
        }
    }

    public boolean SerieExist(int serie) throws IOException {

        Vehicle myVehicl;
        for (int i = 0; i < regsQuantity; i++) {
            myVehicl = this.getVehicle(i);
            if (myVehicl == null) {
            } else {
                if (myVehicl.getSeries() == serie) {
                    return true;
                }
            }
        }
        //si llega a este punto no encontro
        return false;
    }
}
