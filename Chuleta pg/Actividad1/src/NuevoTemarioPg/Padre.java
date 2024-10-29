package NuevoTemarioPg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Padre {public static void main(String[] args) {
        try {

            Process p = new ProcessBuilder("java","-jar","./out/artifacts/untitled_jar/untitled.jar").start();
            String st = "hola soy el padre \n";
            OutputStreamWriter osr = new OutputStreamWriter(p.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osr);
            bw.write(st);
            bw.flush();
            bw.close();

            InputStreamReader isr= new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line=br.readLine()) !=null){
                System.out.printf(line);
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}

