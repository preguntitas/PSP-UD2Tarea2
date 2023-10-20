import java.io.*;

public class Ruta {
    public static void main(String[] args) {
        if (args.length<=0){
            System.out.println("No se ha pasado el directorio");
            System.exit(2);
        } else if (args.length>1) {
            System.out.println("Introduce solo un parámetro");
            System.exit(3);
        }
        // Version original en Linux
        //ProcessBuilder pb = new ProcessBuilder("ls");
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
        File directorio = new File(args[0]);
        if(!(directorio.exists() && directorio.isDirectory())) {
            System.out.println("El directorio no existe o no es un directorio");
            System.exit(4);
        }
        pb.directory(directorio);
        try{
            Process p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
            int codigoRetorno = p.waitFor();
            System.out.println("El proceso " + pb.command() + " ha finalizado con el codigo " + codigoRetorno);
        }catch (IOException e) {
            System.out.println("Error en el proceso: " + e.getMessage());
        }catch (InterruptedException e) {
            System.out.println("El proceso se ha interrumpido: " + e.getMessage() );
        }
    }
}
