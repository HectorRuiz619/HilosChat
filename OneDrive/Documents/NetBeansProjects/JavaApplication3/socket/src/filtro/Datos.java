package filtro;

import java.io.Serializable;

/**
 * @author Pedro ML
 */
public class Datos implements Serializable {

    private String Mensaje;
    private String Fecha;
    private String Emisor;

    public Datos () {
        super();
    }

    public Datos(String Mensaje, String Fecha, String Emisor) {
        this.Mensaje = Mensaje;
        this.Fecha = Fecha;
        this.Emisor = Emisor;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEmisor() {
        return Emisor;
    }

    public void setEmisor(String Emisor) {
        this.Emisor = Emisor;
    }
    
}
