import java.io.*;

public class Main {
    public static void main(String[] args) {
//          Esta sería la otra manera de hacerlo 
//          String relativePath= "./src/msconfig.bat";
//          ProcessBuilder pb1 = new ProcessBuilder(relativePath);

        //no poner msconfig
        try {
            ProcessBuilder pb1= new ProcessBuilder("msconfig.exe");
            ProcessBuilder pb2 = new ProcessBuilder("java", "-jar", "out/artifacts/IntegradoraPgv_jar/IntegradoraPgv.jar");
            Process proc1 = pb1.start();
            Process proc2 = pb2.start();


            InputStreamReader isr = new InputStreamReader(proc2.getInputStream());
            //poner en el 4 igual
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            proc2.waitFor();

            File carp = new File("./src/Carpeta-Integradora-Pgv");
            String integradora= carp.getAbsolutePath();
            ProcessBuilder pb4 = new ProcessBuilder("cmd", "/c", "dir", integradora);
            Process proc4 = pb4.start();
            //Este comando es para que se muestre por consola del padre
            InputStreamReader isr4 = new InputStreamReader(proc4.getInputStream());
            //poner en el 4 igual
            BufferedReader br4 = new BufferedReader(isr4);
            String line4;
            while((line4=br4.readLine())!=null){
                System.out.println(line4);
            }

            if(proc1.isAlive()){
                System.out.println("El primer proceso se destruirá");
                proc1.destroy();
            }
            else{
                System.out.println("El primer proceso ya había terminado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}