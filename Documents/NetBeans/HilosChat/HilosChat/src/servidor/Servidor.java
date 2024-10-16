package servidor;

import filtro.HilosCliente;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 1024; // Puerto donde el servidor escuchará

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            // El servidor acepta múltiples conexiones en un bucle infinito
            while (true) {
                Socket cliente = servidor.accept(); // Acepta la conexión de un cliente

                // Crea un nuevo hilo para gestionar al cliente
                new Thread(new HilosCliente(cliente)).start();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
