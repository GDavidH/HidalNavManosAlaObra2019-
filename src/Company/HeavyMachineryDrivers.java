package Company;

public class HeavyMachineryDrivers extends Employee{
    
    int kind;
    int hours;
    double sal ;
    
    public HeavyMachineryDrivers() {
        super();
        this.kind =0;
        this.hours = 0;
        this.sal =0; 
    }

    public HeavyMachineryDrivers(String name, String lastName, String employeeCode, String iD,int kind, int hours,double sal,  double salary, boolean quality) {
        super(name, lastName, employeeCode, iD, salary, quality);
        this.kind = kind;
        this.hours = hours;
        this.sal = sal; 
    }

    //Calcula el salario de cada conductor de maquinaria pesada
    @Override
    public void calculateSalary() {
        switch (kind) {
            case 1:
                setSalary(16);
                if (isQuality()==true)
                    sal = (getSalary()*0.0395)+(getSalary()*hours);
                else
                    sal = getSalary()*hours;
                setSalary(sal);
                break;
            case 2:
                setSalary(18);
                if (isQuality()==true)
                    sal = (getSalary()*0.0395)+(getSalary()*hours);
                else
                    sal = getSalary()*hours;
                setSalary(sal);
                break;
            default:
                setSalary(24);
                if (isQuality()==true)
                    sal = (getSalary()*0.0395)+(getSalary()*hours);
                else
                    sal = getSalary()*hours;
                setSalary(sal);
                break;  
            }
        }
    }

