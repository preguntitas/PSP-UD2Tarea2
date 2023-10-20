import java.io.*;
import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        //Version Linux
        //ProcessBuilder pb = new ProcessBuilder("zsh");
        ProcessBuilder pb = new ProcessBuilder("cmd");
        pb.inheritIO(); // capturamos la salida y errores hacia el principal, y pasamos las entradas al subproceso
        try {
            Process p = pb.start();
           int codigoRetorno = p.waitFor();// saldremos cuando finalice, Cuando se use el comando exit
            System.out.println("El proceso ha finalizado con el codigo: " + codigoRetorno);
        } catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        }catch (InterruptedException e){
            System.out.println("El proceso se ha interrumpido: " + e.getMessage());
        }
    }
}
