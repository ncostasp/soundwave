package interfaces;

import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import modelo.contenido.Contenido;

public interface IDescargable {

    boolean descargar() throws LimiteDescargasException, ContenidoYaDescargadoException;
    boolean eliminarDescarga ();
    int espacioRequerido ();
}
