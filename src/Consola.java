import java.io.*;
import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("zsh");
        pb.inheritIO();
        Scanner entrada = new Scanner(System.in);
        try {
            Process p = pb.start();
            while (p.isAlive()) {
                entrada.nextLine();
            }
            int codigoRetorno = p.waitFor();
            System.out.println("El proceso ha finalizado con el codigo: " + codigoRetorno);
        } catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        }catch (InterruptedException e){
            System.out.println("El proceso se ha interrumpido: " + e.getMessage());
        }
    }
}
