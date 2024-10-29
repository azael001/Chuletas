import java.io.File;
import java.util.Scanner;

public class ActividadA {
    public static void main(String[] args) {

        // Actividad A //
        // Asi se optiene el Directorio actual//
        String currentDictory = System.getProperty("user.dir");

        File file = new File(currentDictory);
        String lista[] = file.list();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }

        // Segunda parte de la actividad A
        Scanner input = new Scanner(System.in);
        System.out.println("Hola buenas, pásame el directorio el cual quiere la lista");
        String directorio = input.nextLine();
        File file2 = new File(directorio);
        //Ejemplo para poner C:\\Users\\Alumnadomañana\\Desktop\\Clase//
        String lista2[] = file2.list();
        for (int i = 0; i < lista2.length; i++) {
            System.out.println(lista2[i]);
        }
    }
}
