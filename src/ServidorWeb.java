import java.io.*;
import java.net.*;
import java.util.*;

public final class ServidorWeb {
    public static void main(String[] args) throws Exception
    {
        // Establece el número de puerto.
        int puerto = 6789;

        // Estableciendo el socket de escucha.
       ServerSocket servidor = new ServerSocket(puerto);

        // Procesando las solicitudes HTTP en un ciclo infinito.
        while (true) {
            // Escuhando las solicitudes de conexión TCP.
            Socket cliente = servidor.accept();
            // Construye un objeto para procesar el mensaje de solicitud HTTP.
            SolicitudHttp solicitud = new SolicitudHttp( cliente );

            // Crea un nuevo hilo para procesar la solicitud.
            Thread hilo = new Thread(solicitud);

            // Inicia el hilo.
            hilo.start();
        }
    }
}
