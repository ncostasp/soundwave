package modelo.contenido;

import enums.GeneroMusical;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Album;
import modelo.artistas.Artista;

import java.util.ArrayList;
import java.util.Date;

public class Cancion extends Contenido implements IReproducible, IDescargable {
    public String letra;
    public Artista artista;
    public Album album;
    public GeneroMusical genero;
    public String audioURL;
    public boolean explicit;
    public String ISRC;


    public Cancion(String id, String titulo, int reproducciones, int likes, int duracionSegundos, ArrayList<String> tags, boolean disponible, Date fechaPublicacion, String letra, Artista artista, Album album, GeneroMusical genero, String audioURL, boolean explicit, String ISRC) {
        super(id, titulo, reproducciones, likes, duracionSegundos, tags, disponible, fechaPublicacion);
        this.letra = letra;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.audioURL = audioURL;
        this.explicit = explicit;
        this.ISRC = ISRC;
    }


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
