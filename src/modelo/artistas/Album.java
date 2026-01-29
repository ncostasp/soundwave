package modelo.artistas;

import enums.GeneroMusical;
import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;

public class Album {
    private String id;
    private String titulo;
    private Artista artista;
    private Date fechaLanzamiento;
    private ArrayList<Cancion> canciones;
    private String portadaURL;
    private String discografia;
    private String tipoAlbum;


    public Album(String id, String titulo, Artista artista, Date fechaLanzamiento, ArrayList<Cancion> canciones, String portadaURL, String discografia, String tipoAlbum) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
        this.portadaURL = portadaURL;
        this.discografia = discografia;
        this.tipoAlbum = tipoAlbum;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void addCanciones(Cancion cancion) {
        this.canciones.add(cancion);
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


    public Cancion crearCancion (String titulo, int duracion, GeneroMusical genero) {return null;};
    public void agregarCancion (Cancion cancion) {}
    public void eliminarCancion (int posicion) {}
    public int getDuracionTotal () {return 0;}
    public int getNumCanciones () {return 0;}
    public void ordenarPorPopularidad() {}
}
