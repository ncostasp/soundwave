package modelo.contenido;

import enums.GeneroMusical;
import excepciones.contenido.DuracionInvalidaException;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Album;
import modelo.artistas.Artista;

import java.util.ArrayList;
import java.util.Date;

public class Cancion extends Contenido implements IReproducible, IDescargable {
    private String letra;
    private Artista artista;
    private Album album;
    private GeneroMusical genero;
    private String audioURL;
    private boolean explicit;
    private String ISRC;
    private boolean reproduciendo;
    private boolean pausando;
    private boolean descargado;


    public Cancion(String titulo, int duracionSegundos, Artista artista, GeneroMusical genero) {
        super(titulo, duracionSegundos);
        this.artista = artista;
        this.genero = genero;
        this.letra = null;
        this.album = null;
        this.audioURL = "https://soundwave.com/audio/" + id + ".mp3";
        this.explicit = false;
        this.ISRC = generarISRC();
        this.reproduciendo = false;
        this.pausando = true;
        this.descargado = false;
    }


    public Cancion(String titulo, int duracionSegundos, Artista artista, GeneroMusical genero, String letra, boolean explicit) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.artista = artista;
        this.genero = genero;
        this.letra = letra;
        this.explicit = explicit;
        this.album = null;
        this.audioURL = "https://soundwave.com/audio/" + id + ".mp3";
        this.ISRC = generarISRC();
        this.reproduciendo = false;
        this.pausando = true;
        this.descargado = false;
    }

    // ESTAMOS AQUÍ

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getISRC() {
        return ISRC;
    }

    public void setISRC(String ISRC) {
        this.ISRC = ISRC;
    }


    @Override
    public void reproducir() {

    }


    public String obtenerLetra(){return letra;}
    public boolean esExplicit(){return true;}
    public void cambiarGenero(GeneroMusical genero){};



    @Override
    public boolean descargar(Contenido contenido) {
        return false;
    }

    @Override
    public boolean eliminarDescarga(Contenido contenido) {
        return false;
    }

    @Override
    public int espacioRequerido() {
        return 0;
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int getDuracion() {
        return 0;
    }
}
