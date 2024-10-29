package Procces;

import java.io.IOException;

public class SegundoConBat {
    public static void main(String[] args) {
        //Esto de aquí es para abrir  el notepad y el calc
        String comando2 ="./src/Procces/a.bat";
        ProcessBuilder pb1 = new ProcessBuilder("cmd","/c","start C:\\Users\\Alumnadomañana\\Desktop\\Clase\\a.bat");
        String ruta = "";

        Runtime rt1 = Runtime.getRuntime();
        try{
            Process pro1 = pb1.start();

//            Process pro2 = rt1.exec(comando2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
