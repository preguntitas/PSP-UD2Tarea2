import java.io.IOException;

public class Concurrencia {
    public static void main(String[] args) {
        int segundo = 0;
        try {
            Process p1 = new ProcessBuilder("ping", "-c", "5", "www.google.es").start();
            Process p2 = new ProcessBuilder("ping", "-c", "10", "www.youtube.es").start();
            while(p1.isAlive() || p2.isAlive()){
                System.out.print("Durante el segundo " + segundo++);
                System.out.print(" el proceso 1 está " + (p1.isAlive()? "en marcha" : "parado"));
                System.out.println(" y el proceso 2 está " + (p2.isAlive()? "en marcha" : "parado"));
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        } catch (InterruptedException  e) {
            System.out.println("El proceso se ha interrumpido" + e.getMessage());
        }
    }
}
