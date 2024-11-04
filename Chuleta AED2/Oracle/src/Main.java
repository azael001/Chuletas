import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        coneccion();
        String sqlCreaciónTabla = "CREATE TABLE Proveedores ( Cod_prov char(4) PRIMARY KEY, Nombre_prov char(30),  Direccion char(30),Telefono char(9), Bonifica int) ";
        String sql2CreaciónTabla= "CREATE TABLE Productos ( Cod_prod char(5) PRIMARY KEY, Nombre_prod char(30),  precio number, stock  int,Cod_prov char(4)," +
                " CONSTRAINT fk_Proveedor FOREIGN KEY (Cod_prov) REFERENCES Proveedores(Cod_prov))";

        try {
            coneccion().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Connection coneccion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "AZAEL", "1234");
            return con;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert() {
        //Esto es la insercción de datos que solo se utilizará una vez
        try {
            coneccion();

            //Todo esto es del insert
            File InsTabProve = new File("src/InsertProveedor.sql");
            File InsTabProd = new File("src/InsertProduct.sql");
            //Todo esto es el insert de las tablas. No quitar si no se inserta varias veces
            String InsertSqlProve = "Insert into Proveedores VALUES(?,?,?,?,?)";
            String InsertSqlProduct = "Insert into Productos VALUES(?,?,?,?,?)";

            PreparedStatement stmtInsert = coneccion().prepareStatement(InsertSqlProve);
            PreparedStatement stmtInsert2 = coneccion().prepareStatement(InsertSqlProduct);

            try {
                FileReader frproov = new FileReader(InsTabProve);
                BufferedReader bf1 = new BufferedReader(frproov);
                FileReader frproduct = new FileReader(InsTabProd);
                BufferedReader bf2 = new BufferedReader(frproduct);


                String line;
                //Separar por ,


                while ((line = bf1.readLine()) != null) {
                    String[] elementos = line.split(",");
                    stmtInsert.setString(1, elementos[0]);
                    stmtInsert.setString(2, elementos[1]);
                    stmtInsert.setString(3, elementos[2]);
                    stmtInsert.setString(4, elementos[3]);
                    stmtInsert.setInt(5, Integer.parseInt(elementos[4]));
                    stmtInsert.executeUpdate();
                }
                stmtInsert.close();
                bf1.close();
                String lineP;
                while ((lineP = bf2.readLine()) != null) {
                    String[] elementos = lineP.split(",");
                    stmtInsert2.setString(1, elementos[0]);
                    stmtInsert2.setString(2, elementos[1]);
                    stmtInsert2.setDouble(3, Double.parseDouble(elementos[2]));
                    stmtInsert2.setInt(4, Integer.parseInt(elementos[3]));
                    stmtInsert2.setString(5, elementos[4]);
                    stmtInsert2.executeUpdate();
                }
                bf2.close();
                stmtInsert2.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public static void selectTablas() {
            //Esta función hace un select a las dos tablas
            try {
               coneccion();
                String sql = "SELECT * FROM Proveedores";
                PreparedStatement stmt12 =  coneccion().prepareStatement(sql);
                ResultSet rs = stmt12.executeQuery();
                while (rs.next()) {
                    System.out.println("Cod prov: " + rs.getString(1) +
                            " Nombre prov: " + rs.getString(2) +
                            " Direccion: " + rs.getString(3) +
                            " Telefono: " + rs.getString(4) +
                            " Bonifica: " + rs.getInt(5));
                }
                String sql1 = "SELECT * FROM Productos";
                PreparedStatement stmt123 =  coneccion().prepareStatement(sql1);
                ResultSet rs1 = stmt123.executeQuery();
                while (rs1.next()) {
                    System.out.println("Cod prod: " + rs1.getString("Cod_prod") +
                            " Nombre prod: " + rs1.getString("Nombre_prod") +
                            " Precio: " + rs1.getDouble("precio") +
                            " Stock: " + rs1.getInt("stock") +
                            " Cod prov: " + rs1.getString("Cod_prov"));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
