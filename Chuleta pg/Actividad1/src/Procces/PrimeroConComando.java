package Procces;

import java.io.IOException;

public class PrimeroConComando {
    public static void main(String[] args) {
        //Esto de aquí es para abrir  el notepad y el calc
        String comando1="notepad.exe";
        String comando2 ="calc.exe";
        ProcessBuilder pb1= new ProcessBuilder(comando1);


        Runtime rt1 = Runtime.getRuntime();
        try{
             pb1.start();

            rt1.exec(comando2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}