import java.io.Serializable;
import java.util.ArrayList;

public class Personas implements Serializable {
    String nombre;
    String DNI;
    int edad;
    ArrayList<Personas> personas = new ArrayList<>();
    Double salario;

    public Personas(String nombre, String DNI, int edad, Double salario) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.personas = personas;
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public ArrayList<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Personas> personas) {
        this.personas = personas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", edad=" + edad +
                ", personas=" + personas +
                ", salario=" + salario +
                '}';
    }
}
