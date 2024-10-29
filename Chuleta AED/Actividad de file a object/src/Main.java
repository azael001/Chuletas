import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//Esta linea hasta el siguiente comentario lee

        File file = new File("C:\\Users\\Alumnadomañana\\Desktop\\a.txt");
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String linea ="";
            while (linea != null){
                System.out.println(linea);
                linea=bufferedreader.readLine();
            }
// A partir de aquí leemos otra vez en oftro file reader y a su vez escribimos.
            try{
                File file2 = new File("C:\\Users\\Alumnadomañana\\Desktop\\b.txt");
                FileWriter fileWriter = new FileWriter(file2);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                FileReader fileReader2 = new FileReader("C:\\Users\\Alumnadomañana\\Desktop\\a.txt");
                BufferedReader bf = new BufferedReader(fileReader2);

                String linea2="";
                while (linea2 != null){
                    if (linea2 != null && linea2 !=""){
                        bufferedWriter.write(linea2);
                        bufferedWriter.newLine();
                    }
                    linea2=bf.readLine();
                    bufferedWriter.flush();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // A partir de aqui lo convertiremos en clase

        try {
            FileReader fileReadertoObject = new FileReader("C:\\Users\\Alumnadomañana\\Desktop\\b.txt");
            ArrayList<Objeto> objetos = new ArrayList<>();
            FileOutputStream fileOutputStream = new FileOutputStream("./Objeto.obj");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);

            try (BufferedReader br = new BufferedReader(fileReadertoObject)) {
                String linea3;
                while ((linea3 = br.readLine()) != null) {
                    String[] campos = linea3.split(",");

                    String nombre = campos[0];
                    String apellido = campos[1];
                    String nacionalidad = campos[2];
                    int edad = Integer.parseInt(campos[3]);
                    Objeto objeto= new Objeto(nombre,apellido,nacionalidad,edad);
                    objetos.add(objeto);
                    objectOutput.writeObject(new Objeto(nombre,apellido,nacionalidad,edad));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Objeto o : objetos) {
                System.out.println(o);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}