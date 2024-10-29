import java.io.*;

public class ActivdadC {
    public static void main(String[] args)  {

        //Actividad c

        // Leer fichero//
        File file = new File("./src/a.txt");
//        try {
//            FileReader fileReader = new FileReader(file);
//            int character;
//            while((character =fileReader.read()) != -1){
//                System.out.println((char)character);
//
//            }
//            fileReader.close();
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // De 10 en 10 characteres
//        try {
//            FileReader fr10 = new FileReader(file);
//            BufferedReader bf = new BufferedReader(fr10);
//            String linea;
//            int character10;
//            int diez = 0;
//            while((linea = bf.readLine() )!=null) {
//                String lineaSinEspacios = linea.replaceAll("\\s","");
//               for(int i = 0; i<lineaSinEspacios.length(); i++){
//                   if (diez<10) {
//                       System.out.print(lineaSinEspacios.charAt(i));
//                       diez++;
//                   }
//                   else{
//                       System.out.print("\n");
//                       diez=0;
//                   }
//                }
//            }
//            fr10.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

        //Escribir

        try {
            FileReader fr = new FileReader(file);
            File arc = new File("./src/b.txt");
            FileWriter fw = new FileWriter(arc);
            String fin = "Y esto es el final";
          if(arc.exists()){
              arc.delete();
              System.out.println("El archivo ya existía y lo hemos borrao");
          }
          int character ;
          while ((character=fr.read()) != -1){
              fw.write((char)character);
              fw.flush();
          }
          fw.write(fin);
          fw.flush();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}