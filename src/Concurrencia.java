import java.io.IOException;

public class Concurrencia {
    public static void main(String[] args) {
        int segundo = 0; // variable para saber el momento en el que nos encontramos
        try {
            Process p1 = new ProcessBuilder("ping", "-c", "5", "www.google.es").start(); //proceso 1
            Process p2 = new ProcessBuilder("ping", "-c", "10", "www.youtube.es").start(); //proceso 2
            while(p1.isAlive() || p2.isAlive()){// mientras alguno este vivo
                System.out.print("Durante el segundo " + segundo++); // por pantalla el segundo en el que estamos
                System.out.print(" el proceso 1 está " + (p1.isAlive()? "en marcha" : "parado")); // estado de 1
                System.out.println(" y el proceso 2 está " + (p2.isAlive()? "en marcha" : "parado")); // estado de 2
                Thread.sleep(1000); // pausa de 1 segundo. ¿mejor usar wait(1000)?
            }
        } catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        } catch (InterruptedException  e) {
            System.out.println("El proceso se ha interrumpido" + e.getMessage());
        }
    }
}
