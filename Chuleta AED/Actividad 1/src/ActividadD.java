import java.io.*;

public class ActividadD {
    public static void main(String[] args) {
        File fl = new File("./src/a.txt");
        File flw = new File("./src/c.txt");
        try{
            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw= new FileWriter(flw);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;
            //Escribir linea a linea
            while((linea=br.readLine()) !=null){
                System.out.println(linea);
            }
            br.close();

            for (int i=0; i<5; i++) {
                bw.write("Fila" + i + "Dam2");
                bw.newLine();
                bw.flush();

            }
            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
