package servidor;
import filtro.Datos;
import filtro.HiloCliente;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Pedro ML
 */
public class servidors {
    
    public static void main(String[] args) {
        int puerto= 1024;
        try (ServerSocket servidor = new ServerSocket (puerto);){
            System.out.println("Servidor en escucha ");
            while (true) {                
               Socket cliente = servidor.accept();
                
                new Thread(new HiloCliente(cliente)).start();
            }
            
             
       
             
             
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }

}