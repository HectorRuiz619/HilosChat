package filtro;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author hecto
 */
public class HiloCliente implements Runnable {

    private Socket client;

    public HiloCliente(Socket c) {
        this.client = c;
    }

    @Override
    public void run() {
        try {
            // Creamos un ObjectInputStream para leer los datos del cliente
            ObjectInputStream envioDatos = new ObjectInputStream(client.getInputStream());

            // Recibimos el objeto Datos desde el cliente
            Datos mensaje = (Datos) envioDatos.readObject();

            // Mostramos los datos recibidos en consola
            System.out.println(mensaje.getEmisor() + " dice: " + mensaje.getMensaje());
            System.out.println("Enviado: " + mensaje.getFecha());
            System.out.println("----------------------------------------------------------");

            // Cerramos la conexión con el cliente
            envioDatos.close();
            client.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
