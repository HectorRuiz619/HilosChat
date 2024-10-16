package cliente;

import filtro.Datos;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor
        int puerto = 1024; // El puerto del servidor

        try {
            // Establecemos la conexión con el servidor
            Socket cliente = new Socket(host, puerto);
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());

            // Crear un scanner para leer el input del usuario
            Scanner scanner = new Scanner(System.in);
            String mensajeTexto;

            System.out.println("Escribe un mensaje (escribe 'salir' para terminar):");

            // Bucle para enviar múltiples mensajes
            while (true) {
                mensajeTexto = scanner.nextLine();

                if (mensajeTexto.equalsIgnoreCase("salir")) {
                    break; // Salir del bucle y cerrar la conexión
                }

                // Creamos un objeto Datos con el mensaje que queremos enviar
                Datos mensaje = new Datos();
                mensaje.setEmisor("Héctor");  // Nombre del emisor
                mensaje.setMensaje(mensajeTexto); // Mensaje escrito por el usuario
                mensaje.setFecha(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime())); // Fecha actual

                // Enviamos el mensaje al servidor
                output.writeObject(mensaje);
            }

            // Cerramos la conexión después de salir del bucle
            output.close();
            cliente.close();
            System.out.println("Conexión cerrada.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
