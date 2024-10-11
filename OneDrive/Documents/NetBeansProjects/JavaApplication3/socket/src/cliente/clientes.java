package cliente;

import filtro.Datos;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Pedro ML
 */
public class clientes {

    public static void main(String[] args) {
        int puerto = 1024;
        String host = "localhost";

        try {
            // Establecemos la conexion con el servidor
            Socket cliente = new Socket(host, puerto);
            //Comenza a setear los daros que neviaremos
            ObjectOutputStream envioDatos = new ObjectOutputStream(cliente.getOutputStream());

            // Formar mensaje a enviar por medio del output
            Datos mensaje1 = new Datos();
            mensaje1.setEmisor("Juan");
            mensaje1.setMensaje("Hola desde el mensaje");
            mensaje1.setFecha(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
          
            envioDatos.writeObject(mensaje1);
            
            //mensajes.add(mensaje1);

            Datos mensaje2 = new Datos();
            mensaje2.setEmisor("Jose");
            mensaje2.setMensaje("Hola desde el mensaje 2");
            mensaje2.setFecha(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));

            // Enviar los datos al OputsStream
         
            cliente.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
