package Procces;

import java.io.IOException;

public class TerceroConJar { public static void main(String[] args) {

    // Mirarlo en casa y aclararlo bien
    //Esto de aquí es para abrir  el notepad y el calc
    String comando = "java -jar ./src/a.jar";

//    ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "start C:\\Users\\Alumnadomañana\\Desktop\\Clase\\a.bat");
//    String ruta = "";

    Runtime rt1 = Runtime.getRuntime();
    try {
//            Process pro1 = pb1.start();

        Process pro2 = rt1.exec(comando);

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
