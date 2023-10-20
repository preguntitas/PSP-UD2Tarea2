import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Consola2 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("bash");
        builder.redirectErrorStream(true);
        Process process = builder.start();

        OutputStream stdin = process.getOutputStream();
        BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));

        Thread reader = new Thread(() -> {
            String line;
            try {
                while ((line = stdout.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reader.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = in.readLine()) != null) {
            stdin.write((input + "\n").getBytes());
            stdin.flush();
        }
    }
}