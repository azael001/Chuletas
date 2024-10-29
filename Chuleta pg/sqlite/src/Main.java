import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
       try{
           Class.forName("org.sqlite.jdbc3");
           Connection conexion = DriverManager.getConnection("jdbc:sqlite:DB/actividad1.db")
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

    }
}