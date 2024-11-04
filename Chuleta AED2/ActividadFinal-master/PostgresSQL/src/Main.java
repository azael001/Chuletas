import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            //Sentencias para la conexi�n
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            Statement sentence = con.createStatement();

            //Estas son las dos sentencia de la bas e de datos . Por si las quieres comprobar
            String sqlCreaciónTabla = "CREATE TABLE Proveedores ( Cod_prov char(4) PRIMARY KEY, Nombre_prov char(30),  Direccion char(30),Telefono char(9), Bonifica int) ";
            String sql2CreaciónTabla= "CREATE TABLE Productos (Cod_prod CHAR(5) PRIMARY KEY, Nombre_prod CHAR(30), precio " +
                    "NUMERIC, stock INT, Cod_prov CHAR(4), CONSTRAINT fk_Proveedor FOREIGN KEY (Cod_prov) REFERENCES Proveedores(Cod_prov));";


            // Aquí están todas las sentencias.
            File sentences = new File("src/Sentencias.sql");
            try {
                FileReader fileRsen = new FileReader(sentences);
                BufferedReader bfSen = new BufferedReader(fileRsen);
                String lineSentence;
                ArrayList<String> sentencias = new ArrayList<>(1);
                while ((lineSentence = bfSen.readLine()) != null) {
                    sentencias.add(lineSentence);
                }

                //1 select  Cambié la sentencia a 100 porque había puesto datos menores
                String sqlSentence1 = sentencias.get(0);
                PreparedStatement stmt = con.prepareStatement(sqlSentence1);
                ResultSet rSentence1 = stmt.executeQuery();
                while (rSentence1.next()) {
                    System.out.println("Nombre producto: " + rSentence1.getString(1) + "Nombre Proveedor: " + rSentence1.getString(2));
                }
                // 2 select
                String sqlSentence2 = sentencias.get(1);
                PreparedStatement stmt2 = con.prepareStatement(sqlSentence2);
                ResultSet rSentence2 = stmt2.executeQuery();
                while (rSentence2.next()) {
                    System.out.println("Nombre proveedor: " + rSentence2.getString(1) + "TLF: " + rSentence2.getString(2));
                }
                // 3 select
                String sqlSentence3 = sentencias.get(2);
                PreparedStatement stmt3 = con.prepareStatement(sqlSentence3);
                ResultSet rSentence3 = stmt3.executeQuery();
                while (rSentence3.next()) {
                    System.out.println("El nombre de los productos < 20 será: " + rSentence3.getString(1));
                }
                //4 select
                String sqlSentence4 = sentencias.get(4);
                PreparedStatement stmt4 = con.prepareStatement(sqlSentence4);
                ResultSet rSentence4 = stmt4.executeQuery();
                while (rSentence4.next()) {
                    System.out.println("Nombre del proveedor: " + rSentence4.getString(1) + "Número de productos: " + rSentence4.getInt(2) + " Media:" + rSentence4.getInt(3));
                }
                //5 select
                String sqlSentence5 = sentencias.get(5);
                PreparedStatement stmt5 = con.prepareStatement(sqlSentence5);
                ResultSet rSentence5 = stmt5.executeQuery();
                while (rSentence5.next()) {
                    System.out.println("Nombre proveedor " + rSentence5.getString(1) + " Direccion: " + rSentence5.getString(2) + "telefono: " + rSentence5.getString(3));
                }
               // El update que se pide de las sentencias

                String sqlUpdate = sentencias.get(3);
                PreparedStatement stmtUpdate = con.prepareStatement(sqlUpdate);
                stmtUpdate.executeUpdate();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // A partir de aquí hacemos la prueba del llamado al procedimiento almacenado.
            try{
                String sqlPrueba = "call PRUEBA(?, ?)";
                PreparedStatement prepareCall = con.prepareCall(sqlPrueba);
                prepareCall.setString(1, "P001");
                prepareCall.setInt(2, 50);

                // Ejecutar el procedimiento
                prepareCall.execute();
                System.out.println("Procedimiento ejecutado correctamente.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//            Update que reaccionará el trigger
                String sqlUpdateTrigger = "update productos set stock = 6 WHERE Cod_prod='PR001'";
                PreparedStatement stmtUpdate = con.prepareStatement(sqlUpdateTrigger);
                stmtUpdate.executeUpdate();




                con.close();
            } catch (SQLException e) {
                System.err.println("Error SQL");
            } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }


        public static void insert(){
        //Esto es la insercción de datos que solo se utilizará una vez
        try {
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

            //Todo esto es del insert
            File InsTabProve = new File("src/InsertProveedor.sql");
            File InsTabProd = new File("src/InsertProduct.sql");
            //Todo esto es el insert de las tablas. No quitar si no se inserta varias veces
            String InsertSqlProve = "Insert into Proveedores VALUES(?,?,?,?,?)";
            String InsertSqlProduct = "Insert into Productos VALUES(?,?,?,?,?)";

            PreparedStatement stmtInsert = con.prepareStatement(InsertSqlProve);
            PreparedStatement stmtInsert2 = con.prepareStatement(InsertSqlProduct);

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void selectTablas() {
        //Esta función hace un select a las dos tablas
        try {
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

            String sql = "SELECT * FROM Proveedores";
            PreparedStatement stmt12 = con.prepareStatement(sql);
            ResultSet rs = stmt12.executeQuery();
            while (rs.next()) {
                System.out.println("Cod prov: " + rs.getString(1) +
                        " Nombre prov: " + rs.getString(2) +
                        " Direccion: " + rs.getString(3) +
                        " Telefono: " + rs.getString(4) +
                        " Bonifica: " + rs.getInt(5));
            }
            String sql1 = "SELECT * FROM Productos";
            PreparedStatement stmt123 = con.prepareStatement(sql1);
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//(10,2 ) CUIDADOOOO
}