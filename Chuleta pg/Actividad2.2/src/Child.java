import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Child {
    public static void main(String[] args) {
        try {
            // Abre una ventana de cmd y ejecuta 'tasklist'
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "tasklist /SVC /FO LIST");
            Process proces = pb.start();


             InputStreamReader isr = new InputStreamReader(proces.getInputStream());
             BufferedReader br = new BufferedReader(isr);
             String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException var9) {
            throw new RuntimeException(var9);
        }
    }
}
