package modelo.usuarios;

import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;
import modelo.plataforma.Anuncio;

import java.util.Date;

public class UsuarioGratuito extends Usuario {
    private int anunciosEscuchados;
    private Date ultimoAnuncio;
    private int reproduccionesHoy;
    private int limiteReproducciones;
    private int cancionesSinAnuncio;
    private Date fechaUltimaReproduccion;
    private static final int LIMITE_DIARIO = 50;
    private static final int CANCIONES_ENTRE_ANUNCIOS = 3;


    public UsuarioGratuito(String nombre, String email, String password) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, TipoSuscripcion.GRATUITO);
        this.anunciosEscuchados = 0;
        this.ultimoAnuncio = new Date();
        this.reproduccionesHoy = 0;
        this.limiteReproducciones = LIMITE_DIARIO;
        this.cancionesSinAnuncio = CANCIONES_ENTRE_ANUNCIOS;
        this.fechaUltimaReproduccion = new Date();
    }



    public int getAnunciosEscuchados() {
        return anunciosEscuchados;
    }

    public Date getUltimoAnuncio() {
        return ultimoAnuncio;
    }

    public int getReproduccionesHoy() {
        return reproduccionesHoy;
    }

    public void setReproduccionesHoy(int reproduccionesHoy) {
        this.reproduccionesHoy = reproduccionesHoy;
    }

    public int getLimiteReproducciones() {
        return limiteReproducciones;
    }

    public int getCancionesSinAnuncio() {
        return cancionesSinAnuncio;
    }

    public void setCancionesSinAnuncio(int cancionesSinAnuncio) {
        this.cancionesSinAnuncio = cancionesSinAnuncio;
    }



    @Override
    public void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException {
        if (!puedeReproducir()) {
            throw new LimiteDiarioAlcanzadoException("Límite diario alcanzado");
        }
        if (debeVerAnuncio()) {
            throw new AnuncioRequeridoException("Anuncio requerido");
        }
        contenido.reproducir();
        this.reproduccionesHoy++;
        this.cancionesSinAnuncio--;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public void verAnuncio () {

    }

    public void verAnuncio(Anuncio anuncio) {

    }

    public boolean puedeReproducir () {
        return this.reproduccionesHoy < this.limiteReproducciones;
    }

    public boolean debeVerAnuncio () {
        return this.cancionesSinAnuncio <= 0;
    }

    public void reiniciarContadorDiario() {
        this.reproduccionesHoy = 0;
    }

    public int getReproduccionesRestantes () {
        return this.limiteReproducciones - this.reproduccionesHoy;
    }

    public int getCancionesHastaAnuncio () {
        return this.cancionesSinAnuncio;
    }

}
