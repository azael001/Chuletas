import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;
public class Parent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué comando quiere ejecutar?");
        String comando = sc.nextLine();

        try {
            Process p = (new ProcessBuilder("java", "-jar", "out/artifacts/Actividad2_jar/Actividad2.jar")).start();
            OutputStream osr = p.getOutputStream();
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            osr.write((comando + "\n").getBytes());
            osr.flush();
            // Leer la salida del hijo y mostrarla
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            osr.close();
            isr.close();
            p.waitFor(); // Esperar a que el proceso hijo termine

            // Esperar a que el proceso de música termine si no lo ha hecho ya
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}