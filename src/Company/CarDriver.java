package Company;

import File.EmployeeFile;
import Interface.Interface;
import java.io.File;
import java.io.IOException;

public class CarDriver extends Driver {

    private double s;

    public CarDriver() {
        super();
        s = 0;
    }

    public CarDriver(String name, String lastName, String employeeCode, String iD, double salary, boolean quality, boolean Schedule, double s,
             int hours, String kindLicense, boolean donor) {
        super(Schedule, hours, kindLicense, donor, name, lastName, employeeCode, iD, salary, quality, iD);
        this.s = s;
    }

    @Override
    public void calculateSalary() {

    }

    public int calculateSalary(String name, int hours, String schedule, String vehicle) throws IOException {
        int salary = hours * 10;
        if (schedule.equalsIgnoreCase("Noche")) {
            salary = salary * 2;
        }

        if (vehicle.equalsIgnoreCase("Grua")) {
            salary = salary + 8;
        }
        if (vehicle.equalsIgnoreCase("Vagoneta")) {
            salary = salary + 6;
        }
        if (vehicle.equalsIgnoreCase("Monta cargas")) {
            salary = salary + 14;
        }

        File fileEmployee = new File("./Files/Driver.dat");
        EmployeeFile my = new EmployeeFile(fileEmployee);
        if (my.getEmploye(name).isQuality()) {
            salary = salary + (salary * 393 / 10000);
        }

        return salary;
    }

}
