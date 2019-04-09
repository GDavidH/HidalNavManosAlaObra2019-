package Company;

import File.EmployeeFile;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Manager extends Employee {
    
    int SotfwareKnowledge;
    String workArea;
    int category;
    double sal;

    public Manager() {
        super();
        this.SotfwareKnowledge = 0;
        this.workArea = "";
        this.category = 0;
        this.sal=0;
    }

    public Manager(String name, String lastName, String employeeCode, String iD, double sal, int SotfwareKnowledge, String workArea, int category, double salary, boolean quality) {
        super(name, lastName, employeeCode, iD, salary, quality);
        this.SotfwareKnowledge = SotfwareKnowledge;
        this.workArea = workArea;
        this.category = category;
        this.sal= sal;
    }

    @Override
    public void calculateSalary() {
      
    }
    public int calculateSalary(String name, String category) throws IOException {
        int salary=250;
        if(category.equalsIgnoreCase("Categoría 2"))
            salary=salary+(salary* 1/5);
        File fileEmployee = new File("./Files/Manager.dat");
        EmployeeFile my = new EmployeeFile(fileEmployee);            
        if(my.getEmploye(name).isQuality())
            salary=salary+(salary*393/10000);
        return salary;
    }


}
