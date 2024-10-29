import java.util.ArrayList;

public class Empleados {
    int num_ep;
    String nombre;
    String long9;
    Double salario;
    ArrayList<Empleados> empleadosArray = new ArrayList<>();


    public Empleados(int num_ep, String nombre, String long9, Double salario) {
        this.num_ep = num_ep;
        this.nombre = nombre;
        this.long9 = long9;
        this.salario = salario;

    }

    public int getNum_ep() {
        return num_ep;
    }

    public void setNum_ep(int num_ep) {
        this.num_ep = num_ep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLong9() {
        return long9;
    }

    public void setLong9(String long9) {
        this.long9 = long9;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public ArrayList<Empleados> getEmpleadosArray() {
        return empleadosArray;
    }

    public void setEmpleadosArray(ArrayList<Empleados> empleadosArray) {
        this.empleadosArray = empleadosArray;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "num_ep=" + num_ep +
                ", nombre='" + nombre + '\'' +
                ", long9='" + long9 + '\'' +
                ", salario=" + salario +
                ", empleadosArray=" + empleadosArray +
                '}';
    }




}
