import java.io.Serializable;

public class Objeto  implements Serializable {
    private String Nombres;
    private String Apellidos;
    private String nacionalidad;
    private int edad;

    public Objeto(String nombres, String apellidos, String nacionalidad, int edad) {
        Nombres = nombres;
        Apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
