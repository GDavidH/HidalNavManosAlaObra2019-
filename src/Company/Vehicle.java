package Company;

// Clase vehiculo
public class Vehicle {
    // Declaracion de variables de la clase
    private String name;
    private int year;
    private float milage;
    private boolean american; 
    private int series;
    
    // Constructores de la clase
    // Constructor que inicializa las variables
    public Vehicle() {
        this.name = "";
        this.year = 0;
        this.milage = 0;
        this.american = false;
        this.series = 0;
    }
    
    // Constructor que le da los valores a las variables
    public Vehicle(int series,String name, int year,  boolean american,float milage ) {
        this.name = name;
        this.year = year;
        this.milage = milage;
        this.american = american;
        this.series = series;
    }
    
    // Declaracion de Setter's y Getter's

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getMilage() {
        return milage;
    }

    public void setMilage(float milage) {
        this.milage = milage;
    }

    public boolean isAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
    
    @Override
    public String toString(){
        return "Serie: "+this.series+" .    Nombre: "+this.name+" .    Año: "+this.year
                +" .   Kilometraje: "+this.milage+" .   Americano: "+this.american +"\n";
    }
    
    //metodo que retorna el tamaño en bytes del objeto
    public int Size(){
        //tamaño de variables 
        return this.name.length()*2 + 13;
    }
}
