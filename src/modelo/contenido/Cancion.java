package modelo.contenido;

import enums.GeneroMusical;
import excepciones.contenido.ArchivoAudioNoEncontradoException;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.contenido.LetraNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Album;
import modelo.artistas.Artista;


public class Cancion extends Contenido implements IReproducible, IDescargable {
    private String letra;
    private Artista artista;
    private Album album;
    private GeneroMusical genero;
    private String audioURL;
    private boolean explicit;
    private String ISRC;
    private boolean reproduciendo;
    private boolean pausado;
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
        this.pausado = true;
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
        this.pausado = true;
        this.descargado = false;
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

    public boolean isReproduciendo() {
        return reproduciendo;
    }

    public boolean isPausado() {
        return pausado;
    }

    public boolean isDescargado() {
        return descargado;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }




    @Override
    public void reproducir() throws ContenidoNoDisponibleException {
        if (disponible) {
            play();
            this.reproducciones++;
        } else {
            throw new ContenidoNoDisponibleException("La canción no está disponible");
        }
    }



    @Override
    public void play() {
        this.reproduciendo = true;
        this.pausado = false;
        System.out.println("Reproduciendo: " + titulo + " - " + (artista != null ? artista.getNombreArtistico() : "Desconocido"));
    }

    @Override
    public void pause() {
        if (reproduciendo) {
            this.reproduciendo = false;
            this.pausado = true;
            System.out.println("Reproducción pausada.");
        }
    }

    @Override
    public void stop() {
        this.reproduciendo = false;
        this.pausado = false;
        System.out.println("Reproducción detenida.");
    }

    @Override
    public int getDuracion() {
        return duracionSegundos;
    }




    @Override
    public boolean descargar() throws ContenidoYaDescargadoException {
        if (descargado) {
            throw new ContenidoYaDescargadoException("La canción ya está descargada.");
        } else {
            this.descargado = true;
        }
        return true;
    }

    @Override
    public boolean eliminarDescarga() {
        if (descargado) {
            this.descargado = false;
            return true;
        }
        return false;
    }

    @Override
    public int espacioRequerido() {
        return duracionSegundos/60;
    }




    @Override
    public String toString() {
        return "Canción: " + titulo + ". Artista: " + (artista != null ? artista.getNombreArtistico() : "Desconocido") + ".";
    }



    private String generarISRC() {
        return id.substring(0,8).toUpperCase();
    }



    public String obtenerLetra() throws LetraNoDisponibleException {
        if (letra == null || letra.isEmpty()) {
            throw new LetraNoDisponibleException("Letra no disponible");
        } else {
            return letra;
        }
    }
    public boolean esExplicit() {
        return explicit;
    }

    public void validarAudioURL() throws ArchivoAudioNoEncontradoException {
        if (audioURL == null || audioURL.isEmpty()) {
            throw new ArchivoAudioNoEncontradoException("Archivo de audio no encontrado");
        }
    }
}
