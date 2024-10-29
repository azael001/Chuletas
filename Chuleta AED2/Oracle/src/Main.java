import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args)  {

        try {
            //Sentencias para la conexi�n
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","AZAEL","1234");
            Statement sentence=con.createStatement();
            Statement sentence2=con.createStatement();
            ResultSet resul=sentence.executeQuery("select * from Empleados");
            ResultSet result=sentence2.executeQuery("select * from Departamentos");

            //Mostrar datos. O se conce estructura o se programa con MetaData
            while(result.next()){
                System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3));
            }
            result.close();
            sentence2.close();

            while(resul.next()){
                System.out.println(resul.getInt(1) + " "+ resul.getString(2) +" "+ resul.getString(3) + " "+ resul.getString(4)+" "+
                        resul.getDouble(5) + " " + resul.getDouble(6) + " " + resul.getInt(7));
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