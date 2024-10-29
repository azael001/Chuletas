import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Child {
    public static void main(String[] args) {
            File file = new File("src/Carpeta-Integradora-Pgv");
            System.out.println("La carpeta es " + file.getName());
            String absolutePathCarpeta = file.getAbsolutePath();
            //pasar del padre al hijo

            //La única ruta absoluta que tiene que cambiar de  Child es esta , ya que no conseguí que se pudiera hacer con rutas relativas.
            String absolutePathBat= "C:\\Users\\DAM2\\Desktop\\Pgv_Integradora_U1\\src\\pgv.bat";
            try{
                for (int i=0; i<file.list().length; i++){
                    String nombreArchivo= file.list()[i];
                    ProcessBuilder pr = new ProcessBuilder(absolutePathBat,absolutePathCarpeta,nombreArchivo);
                    Process pb = pr.start();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}