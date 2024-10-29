package Actividad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué comando quiere ejecutar?");
        String comando = sc.nextLine();
        try {

            Process p = new ProcessBuilder("java", "-jar", "out/artifacts/untitled_jar2/untitled.jar").start();
            OutputStream osr = p.getOutputStream();
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            osr.write(((comando + "\n")).getBytes());
            osr.flush();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            osr.close();
            isr.close();
            p.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


