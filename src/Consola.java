import java.io.*;
import java.util.Scanner;

public class Consola {
    public static void main (String[] args){
        ProcessBuilder pb = new ProcessBuilder("bash");
//        pb.inheritIO();
        Scanner entrada = new Scanner(System.in);
        String comando;
        try{
            Process p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea;
            OutputStream os = p.getOutputStream();
            OutputStreamWriter osr = new OutputStreamWriter(os);
            do{
                while((linea=br.readLine()) != null) {
                    System.out.print("\n" +linea);
                }
                System.out.print("Introduce comando:");
                comando = entrada.nextLine();
                if(!comando.equals("exit")){
                    osr.write(comando + "\n");
                    osr.flush();
                }
            }while(!comando.equals("exit"));
        }catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        }
    }
}
