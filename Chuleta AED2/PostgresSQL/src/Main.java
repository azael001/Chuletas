import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args)  {

        try {
            //Sentencias para la conexi�n
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","1234");
            Statement sentence=con.createStatement();


            ResultSet resul=sentence.executeQuery("select * from Departamentos");

            //Mostrar datos. O se conce estructura o se programa con MetaData
            while(resul.next()){
                System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));
            }
            resul.close();
            sentence.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Error clase JDBC");
        } catch (SQLException e) {
            System.err.println("Error SQL");
        }
    }
}