package interfaces;

import modelo.contenido.Contenido;

public interface IDescargable {

    boolean descargar(Contenido contenido);

    boolean eliminarDescarga (Contenido contenido);

    int espacioRequerido ();
}
