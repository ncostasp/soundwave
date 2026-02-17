package modelo.usuarios;
import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;

import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private boolean descargasOffline;
    private int maxDescargas;
    private ArrayList<Contenido> descargados;
    private String calidadAudio;
    private static final int MAX_DESCARGAS_DEFAULT = 100;


    public UsuarioPremium(String nombre, String email, String password) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, TipoSuscripcion.PREMIUM);
        this.descargasOffline = true;
        this.maxDescargas = MAX_DESCARGAS_DEFAULT;
        this.descargados = new ArrayList<>();
        this.calidadAudio = null;
    }

    public UsuarioPremium(String nombre, String email, String password, TipoSuscripcion suscripcion) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, suscripcion);
        this.descargasOffline = true;
        this.maxDescargas = MAX_DESCARGAS_DEFAULT;
        this.descargados = new ArrayList<>();
        this.calidadAudio = null;
    }



    public boolean isDescargasOffline() {
        return descargasOffline;
    }

    public void setDescargasOffline(boolean descargasOffline) {
        this.descargasOffline = descargasOffline;
    }

    public int getMaxDescargas() {
        return maxDescargas;
    }

    public ArrayList<Contenido> getDescargados() {
        return descargados;
    }

    public int getMAX_DESCARGAS_DEFAULT() {
        return MAX_DESCARGAS_DEFAULT;
    }

    public String getCalidadAudio() {
        return calidadAudio;
    }

    public void setCalidadAudio(String calidadAudio) {
        this.calidadAudio = calidadAudio;
    }



    @Override
    public void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException {
        contenido.reproducir();
    }


    @Override
    public String toString() {
        return super.toString();
    }



    public void descargar (Contenido contenido) throws LimiteDescargasException, ContenidoYaDescargadoException {
        if (this.descargados.contains(contenido)) {
            throw new ContenidoYaDescargadoException("Contenido ya descargado");
        }
        if (this.descargados.size() >= this.maxDescargas) {
            throw new LimiteDescargasException("Límite de descargas alcanzado");
        }
        this.descargados.add(contenido);
    }

    public boolean eliminarDescarga(Contenido contenido) {
        if (this.descargados.contains(contenido)) {
            this.descargados.remove(contenido);
            return true;
        }
        return false;
    }

    public boolean verificarEspacioDescarga() {
        return this.descargados.size() < this.maxDescargas;
    }

    public int getDescargasRestantes() {
        return this.maxDescargas - this.descargados.size();
    }

    public void cambiarCalidadAudio(String calidad) {
        if (calidad != null) {
            this.calidadAudio = calidad;
        }
    }

    public void limpiarDescargas () {
        this.descargados.clear();
    }




    public int getNumDescargados () {
        return descargados.size();
    }


}
