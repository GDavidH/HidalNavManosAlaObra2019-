package Company;

public abstract class Employee {
    
   private String name,lastName,iD,employeeCode;
   private double salary; 
   private boolean quality;
   private String position;
   
    public Employee() {
        this.name = "";
        this.lastName = "";
        this.employeeCode = "";
        this.iD = "";
        this.salary = 0;
        this.quality = false;
        this.position ="";
    }
    
    public Employee(String name, String lastName,String iD, String employeeCode,  double salary, boolean quality) {
        this.name = name;
        this.lastName = lastName;
        this.employeeCode = employeeCode;
        this.iD = iD;
        this.salary = salary;
        this.quality = quality;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isQuality() {
        return quality;
    }

    public void setQuality(boolean quality) {
        this.quality = quality;
    }    

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
        
    public abstract void calculateSalary();

    //metodo que retorna el tamaño en bytes del objeto
    public int Size(){
        //tamaño de variables 
        return (this.name.length()*2) + (this.lastName.length()*2) + (this.employeeCode.length()*2 + (this.iD.length()*2)+1 );
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", lastName=" + lastName + ", iD=" + iD + ", employeeCode=" + employeeCode + ", quality=" + quality + '}';
    }


    
}
