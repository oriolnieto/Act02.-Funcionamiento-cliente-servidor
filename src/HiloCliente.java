import java.io.*;
import java.net.*;

public class HiloCliente extends Thread {
    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println("El Cliente ha dicho: " + mensaje);

            // Salida de datos
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            salida.println("Hola Cliente! Soy el Servidor!");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}