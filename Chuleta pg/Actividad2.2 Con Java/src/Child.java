import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Child {
    public static void main(String[] args) {

       try{
           InputStream in = System.in;
           InputStreamReader inr = new InputStreamReader(in);
           BufferedReader bfr = new BufferedReader(inr);
           String serviceName= bfr.readLine();
           System.out.println(serviceName);
//Acuerdate de dejar espacio entre sc qc y service name

           ProcessBuilder pb = new ProcessBuilder("cmd","/C","sc qc" + serviceName);
           Process p = pb.start();

           InputStreamReader im = new InputStreamReader(p.getInputStream());
           BufferedReader bf = new BufferedReader(im);
           String line;
           while((line=bf.readLine())!=null){
               System.out.println(line);
           }

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
