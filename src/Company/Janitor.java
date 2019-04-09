
package Company;

import File.EmployeeFile;
import java.io.File;
import java.io.IOException;

public class Janitor extends Employee{
    
    private double sal;
    private int overTime;
    private String cleanArea;
    private boolean janitorPosition;
    
    public Janitor() {
        super();
        this.sal=0;
        this.overTime = 0;
        this.cleanArea = "";
        this.janitorPosition = false;
    }

    public Janitor(String name, String lastName, String employeeCode, String iD,double sal, double salary, int overTime, String cleanArea, boolean janitorPosition,  boolean quality) {
        super(name, lastName, employeeCode, iD, salary, quality);
        this.sal = sal;
        this.overTime = overTime;
        this.cleanArea = cleanArea;
        this.janitorPosition = janitorPosition;
    }
    @Override
    public void calculateSalary() {
        
    }
     public int calculateSalary(String name, int hours) throws IOException {       
        int salary= 120 + (hours*(120*1/4));
        File fileEmployee = new File("./Files/Janitor.dat");
        EmployeeFile my = new EmployeeFile(fileEmployee);            
        if(my.getEmploye(name).isQuality())
            salary=salary+(salary*393/10000);
        return salary;    
    }
                      
}
        
