import java.io.*;

public class ActividadF {
    public static void main(String[] args) {

        try {
            FileOutputStream fl = new FileOutputStream("./src/e.txt");
            ObjectOutputStream ob = new ObjectOutputStream(fl);
            String[] nombre = {"Ana", "Luis", "Carlos", "María", "Jorge", "Lucía"};
            String[] dni = {"12345678A", "23456789B", "34567890C", "45678901D", "56789012E", "67890123F"};
            int[] edad = {25, 30, 22, 28, 35, 24};
            double[] salario = {2500.0, 2700.0, 2300.0, 3000.0, 3200.0, 2800.0};
            for (int i = 0; i < nombre.length; i++) {
                Personas persona = new Personas(nombre[i], dni[i], edad[i], salario[i]);
                // Escribir cada objeto en el fichero
                ob.writeObject(persona);
                ob.flush();
            }
            ob.close();
            FileInputStream fi = new FileInputStream("./src/e.txt");
            ObjectInputStream ib = new ObjectInputStream(fi);
            while(true){
                try{
                    Personas persona = (Personas) ib.readObject();
                    System.out.println(persona);
                    // Esta excepción es la necesaria para romper el bucle
                } catch (EOFException eof) {
                    break;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            ib.close();
            // si no hacemos to string no se ve nada
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
