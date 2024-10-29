import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Child {
    public static void main(String[] args) {
        //Esta es la clase la cuál se tiene que hacer el jar.
        // Ejecuta el paint.
         try {
             ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
             Process proces = pb.start();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
