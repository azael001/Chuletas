import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        //Intento de escribir el archivo
        File f = new File("./src/Empleados2.dat");
        try {
            RandomAccessFile alea = new RandomAccessFile(f, "rw");

            String name[] = {"David", "Pepe", "Mario", "Maria", "Miguel", "Luis"};
            int num_emp[] = {1, 2, 3, 4, 5, 6,};
            String telefono[] = {"123456789", "987654321", "135798642", "975286421", "123645978", "978645312"};
            Double salario[] = {170.23, 1720.04, 1985.45, 1634.13, 1928.04, 2435.03};

            for (int i = 0; i < name.length; i++) {
                alea.writeInt(num_emp[i]);
                StringBuffer buf = new StringBuffer(name[i]);
                buf.setLength(25);
                for (int j = name[i].length(); j < 25; j++) {
                    buf.setCharAt(j, ' ');
                } //Esto es para rellenar espacios
                alea.writeChars(buf.toString());
                StringBuffer bufTel = new StringBuffer(telefono[i]);
                bufTel.setLength(9);
                alea.writeChars(bufTel.toString());
                alea.writeDouble(salario[i]);

            }
            alea.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buscarEmpleado();
        addExtraSalary();
        telefonoEmpleado();


    }
    //Métodos

    private static void buscarEmpleado() {
        File fr = new File("./src/Empleados2.dat");
        System.out.println("Dime el número de un empleado y te mostraré sus datos");
        Scanner in = new Scanner(System.in);
        int empleado = in.nextInt();
        int comprobar = 1;

        try {
            RandomAccessFile aleat = new RandomAccessFile(fr, "r");
            int id, pos = 0;
            char cnombre[] = new char[25], aux;
            char ctel[] = new char[9], auxx;
            Double sal = 0.00;

            while (true) {
                aleat.seek(pos);
                id = aleat.readInt();
                for (int i = 0; i < cnombre.length; i++) {
                    aux = aleat.readChar();
                    cnombre[i] = aux;
                }
                String vnombre = new String(cnombre).trim(); //el trim es para quitar espacios
                for (int i = 0; i < ctel.length; i++) {
                    auxx = aleat.readChar();
                    ctel[i] = auxx;
                }
                String vtel = new String(ctel);
                sal = aleat.readDouble();

                pos = pos + 80;

                if (empleado == comprobar) {
                    Empleados e = new Empleados(id, vnombre, vtel, sal);

                    System.out.println(e.toString());
                    break;
                }

                comprobar++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No existe el empleado");
        }


    }

    private static void addExtraSalary() {
        File fr = new File("./src/Empleados2.dat");
        System.out.println("Dime el númerdel empleado al cuál quieras añadir un bonus extra");
        Scanner in = new Scanner(System.in);
        int empleado = in.nextInt();
        System.out.println("Ahora cuanto dinero quieres añadir");
        Scanner input = new Scanner(System.in);
        Double extra = input.nextDouble();
        Double nuevo ;
            try {
                RandomAccessFile aleat = new RandomAccessFile(fr, "rw");
                int id, pos = 0;
                char cnombre[] = new char[25], aux;
                char ctel[] = new char[9], auxx;
                Double sal = 0.00;

                while (true) {
                    aleat.seek(pos);
                    id = aleat.readInt();
                    for (int i = 0; i < cnombre.length; i++) {
                        aux = aleat.readChar();
                        cnombre[i] = aux;
                    }
                    String vnombre = new String(cnombre).trim(); //el trim es para quitar espacios
                    for (int i = 0; i < ctel.length; i++) {
                        auxx = aleat.readChar();
                        ctel[i] = auxx;
                    }
                    String vtel = new String(ctel);
                    sal = aleat.readDouble();


                    if(empleado==id){
                        System.out.println("existe");

                        System.out.println("El salario antiguo del empleado elejido es " + sal);

                        System.out.println("El nuevo será");
                        aleat.seek((pos+72));
                        aleat.writeDouble(sal+extra);
                        aleat.seek((pos+72));
                        nuevo=aleat.readDouble();

                        System.out.println(nuevo.toString());
                        break;
                    }
                    pos = pos + 80;
                }


            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No existe el empleado");
        }
    }
    private static void telefonoEmpleado(){
        File fr = new File("./src/Empleados2.dat");
        try {
            RandomAccessFile aleat = new RandomAccessFile(fr, "r");
            char ctel[] = new char[9], auxx;

                aleat.seek(294);
                for (int i = 0; i < ctel.length; i++) {
                    auxx = aleat.readChar();
                    ctel[i] = auxx;
                }
                String vtel = new String(ctel);
            System.out.printf(vtel);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }

}


