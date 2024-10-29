import java.io.File;
import java.util.Scanner;

public class ActividadB {
    public static void main(String[] args) {


        //Actividad B
        Scanner inputB = new Scanner(System.in);
        System.out.println("Hola buenas, pásame el directorio el cual quiere la lista");
        String directorio2 = inputB.nextLine();
        File file3 = new File(directorio2);
        //Ejemplo para poner C:\\Users\\Alumnadomañana\\Desktop\\Clase//

        System.out.println(" El nombre Es " + file3.getName());
        System.out.println("La ruta relativa será " + file3.getPath());
        System.out.println("La ruta Absoluta será " + file3.getAbsolutePath());
        if (file3.isDirectory()) {
            System.out.println("El archivo es un directorio");
        } else {
            System.out.println("El archivo no es un directorio");
        }
        if (file3.isFile()) {
            System.out.println("El archivo es un fichero");
        } else {
            System.out.println("El archivo no es un fichero");
        }
        if (file3.canRead()) {
            System.out.println("El arhivo es de lectura");
        } else {
            System.out.println("El archivo no es de lectura");
        }
        if (file3.canWrite()) {
            System.out.println("El archivo es de escritura");
        } else {
            System.out.println("El archivo no es de escritura");
        }
        System.out.println("El tamaño es de " + file3.length());


        System.out.println("La lista de ficheros y subdirectorios son:");
        String lista3[] = file3.list();
        for (int i = 0; i < lista3.length; i++) {
            System.out.println(lista3[i]);
        }
    }

}
