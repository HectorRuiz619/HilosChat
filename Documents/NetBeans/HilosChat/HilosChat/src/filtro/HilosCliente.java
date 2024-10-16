package filtro;

import java.io.ObjectInputStream;
import java.net.Socket;

public class HilosCliente implements Runnable {

    private Socket cliente;

    public HilosCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            // Creamos el flujo para recibir objetos desde el cliente
            ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());

            // El servidor sigue escuchando los mensajes del cliente en un bucle
            while (true) {
                // Leemos el objeto 'Datos' enviado por el cliente
                Datos mensaje = (Datos) input.readObject();

                // Mostramos el mensaje en la consola del servidor
                System.out.println(mensaje.getEmisor() + " dice: " + mensaje.getMensaje());
            }

        } catch (Exception e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();  // Asegúrate de cerrar el socket cuando termines
            } catch (Exception e) {
                System.out.println("Error al cerrar el cliente: " + e.getMessage());
            }
        }
    }
}
