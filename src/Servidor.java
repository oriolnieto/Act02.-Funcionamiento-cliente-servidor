import java.io.*;
import java.net.*;

public class Servidor {
public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor esperando conexión...");

            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());
                new HiloCliente(socket).start(); // para iniciar en forma de hilo el cliente cada vez
            }
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
}