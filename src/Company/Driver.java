
package Company;

import Interface.Interface;

public abstract class Driver extends Employee{

    boolean Schedule;
    int hours;
    String kindLicense;
    boolean donor; 

    public Driver() {
        super();
        this.Schedule = false;
        this.hours = 0;
        this.kindLicense = "";
        this.donor = false;
    }

    public Driver(boolean Schedule, int hours, String kindLicense, boolean donor, String name, String lastName, String employeeCode, String iD, double salary, boolean quality,String position) {
        super(name, lastName, employeeCode, iD, salary, quality);
        this.Schedule = Schedule;
        this.hours = hours;
        this.kindLicense = kindLicense;
        this.donor = donor;
    }

    public boolean isSchedule() {
        return Schedule;
    }

    public void setSchedule(boolean Schedule) {
        this.Schedule = Schedule;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getKindLicense() {
        return kindLicense;
    }

    public void setKindLicense(String kindLicense) {
        this.kindLicense = kindLicense;
    }

    public boolean isDonor() {
        return donor;
    }

    public void setDonor(boolean donor) {
        this.donor = donor;
    }
        
    @Override
    public abstract void calculateSalary();
    
    

}
