import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {

        String serviceName = " PolicyAgent";

        // Usamos ProcessBuilder para iniciar el proceso hijo
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "out/artifacts/Actividad2_2_jar/Actividad2.2.jar"); // Ruta del BAT que se ejecutará
        try {
            // Iniciar el proceso hijo
            Process process = processBuilder.start();
            // Enviar la cadena al proceso hijo usando OutputStream
            OutputStream outputStream = process.getOutputStream();
            outputStream.write((serviceName + "\n").getBytes());  // Enviamos el nombre del servicio
            outputStream.flush();  // Aseguramos que se envíe
            outputStream.close();  // Cerramos el OutputStream después de enviar los datos

            // Leer la salida del proceso hijo
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Imprimimos la salida del comando
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

