import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {

        try {
            Process p = new ProcessBuilder("java", "-jar", "out/artifacts/Actividad2_2_jar/Actividad2.2.jar").start();
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            // Leer la salida del hijo y mostrarla
            String line;
            ArrayList<String> li = new ArrayList<>();
            int recorri = 0;
            while ((line = br.readLine()) != null) {
                li.add(line);
            }
            for (int i = 0; i < li.size(); i++) {
                if (li.get(i).equals("")) {
                    li.remove(i);
                }
            }
            for (int i = 0; i < li.size(); i++) {
                if (li.get(i).equals("Nombre de imagen:   svchost.exe")) {
                    for (int u = 0; u < 3; u++) {
                        System.out.println(li.get(i + u).toString());

                    }
                }

            }


            isr.close();


            // Esperar a que el proceso de música termine si no lo ha hecho ya
        } catch (Exception e) {
            e.printStackTrace();
        }

        String serviceName = "PolicyAgent";

        // Usamos ProcessBuilder para iniciar el proceso hijo
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "C:\\Users\\pc\\Desktop\\DAM2-master\\PGV\\Actividad2.2\\src\\alg.bat"); // Ruta del BAT que se ejecutará


        try {
            // Iniciar el proceso hijo
            Process process = processBuilder.start();

            // Enviar la cadena al proceso hijo usando OutputStream
            OutputStream outputStream = process.getOutputStream();
            outputStream.write(serviceName.getBytes());  // Enviamos el nombre del servicio
            outputStream.flush();  // Aseguramos que se envíe
            outputStream.close();  // Cerramos el OutputStream después de enviar los datos

            // Leer la salida del proceso hijo
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Imprimimos la salida del comando
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("\nEl proceso terminó con código: " + exitCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

