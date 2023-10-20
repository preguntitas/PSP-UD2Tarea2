import java.io.*;
import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("bash");
//        pb.inheritIO();
        Scanner entrada = new Scanner(System.in);
        String comando;
        try {
            Process p = pb.start();
            while (p.isAlive()) {
                try (InputStream is = p.getInputStream();
                     InputStreamReader isr = new InputStreamReader(is);
                     BufferedReader br = new BufferedReader(isr)) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.print("\n" + linea);

                    }
                }
                try (OutputStream os = p.getOutputStream();
                     OutputStreamWriter osr = new OutputStreamWriter(os)) {
                    System.out.print("Introduce comando:");
                    comando = entrada.nextLine();
                    if (!comando.equals("exit")) {
                        osr.write(comando);
                        osr.flush();
                    }
                }
            }

                } catch (IOException e) {
                    System.out.println("Error en el proceso: " + e.getMessage());
                }
            }
        }
