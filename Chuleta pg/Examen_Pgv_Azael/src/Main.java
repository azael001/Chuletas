import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        try {
            // La clase de la cuál ejecutaré el jar será Child
            ProcessBuilder pr1 = new ProcessBuilder("java", "-jar", "out/artifacts/Examen_Pgv_Azael_jar/Examen_Pgv_Azael.jar");
            ProcessBuilder pr2 = new ProcessBuilder("cmd.exe", "/C", "sc query");

            // Ejecuto los dos procesos a la vez para que se haga de forma concurrente
            Process p1 = pr1.start();
            Process p2 = pr2.start();
            InputStreamReader isr = new InputStreamReader(p2.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            ArrayList<String> li = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                li.add(line);
            }

            //He creado estas dos variables por si queremos en un futuro coger el segundo servicio o el tercero, solo tenemos que aumentar el nProcesoRequerido
            // Cuidado con no pasarte del número máximo que tiene el comando, si quieres el segundo le sumas uno, el tercero le sumas dos y así...
            int nFijo=10;
            int nProcesoRequerido=0;
            String separador[]= li.get(1+(nFijo*nProcesoRequerido)).split(" ");
            String servicio = separador[1];


            File ejecutable = new File("src/ejecutable.bat");
            String ejecutableAbsolutePath=ejecutable.getAbsolutePath();
            ProcessBuilder pr3 = new ProcessBuilder("cmd","/c",ejecutableAbsolutePath,servicio);
            Process p3= pr3.start();
            InputStreamReader isrs = new InputStreamReader(p3.getInputStream());
            BufferedReader brs = new BufferedReader(isrs);
            String lineS;
            while ((lineS = brs.readLine()) != null) {
                System.out.println(lineS);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}