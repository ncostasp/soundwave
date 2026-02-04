package modelo.artistas;

import enums.GeneroMusical;
import excepciones.artista.AlbumCompletoException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.playlist.CancionNoEncontradaException;
import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Album {
    private String id;
    private String titulo;
    private Artista artista;
    private Date fechaLanzamiento;
    private ArrayList<Cancion> canciones;
    private String portadaURL;
    private String discografia;
    private String tipoAlbum;
    private static final int MAX_CANCIONES = 20;


    public Album(String titulo, Artista artista, Date fechaLanzamiento) {
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.id = UUID.randomUUID().toString();
        this.canciones = new ArrayList<>();
        this.portadaURL = "https://soundwave.com/portadas/" + id + ".jpg";
        this.discografia = null;
        this.tipoAlbum = null;
    }

    public Album(String titulo, Artista artista, Date fechaLanzamiento, String discografia, String tipoAlbum) {
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.discografia = discografia;
        this.tipoAlbum = tipoAlbum;
        this.id = UUID.randomUUID().toString();
        this.canciones = new ArrayList<>();
        this.portadaURL = "https://soundwave.com/portadas/album/" + id + ".jpg";
    }



    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public String getDiscografia() {
        return discografia;
    }

    public void setDiscografia(String discografia) {
        this.discografia = discografia;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public int getMAX_CANCIONES() {
        return MAX_CANCIONES;
    }



    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }



    public Cancion crearCancion (String titulo, int duracion, GeneroMusical genero) throws AlbumCompletoException, DuracionInvalidaException {return null;}
    public Cancion crearCancion (String titulo, int duracion, GeneroMusical genero, String letra, boolean explicit) throws AlbumCompletoException, DuracionInvalidaException {return null;}
    public void eliminarCancion (int posicion) throws CancionNoEncontradaException {}
    public void eliminarCancion (Cancion cancion) throws CancionNoEncontradaException {}
    public int getDuracionTotal () {return 0;}
    public String getDuracionTotalFormateada() {return "s";}
    public int getNumCanciones () {return 0;}
    public void ordenarPorPopularidad() {}
    public Cancion getCancion (int posicion) throws CancionNoEncontradaException {canciones;}
    public int getTotalReproducciones() {return 0;}
}
