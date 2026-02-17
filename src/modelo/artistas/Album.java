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
    private static final int MaxCanciones = 20;


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

    public int getMaxCanciones() {
        return MaxCanciones;
    }



    @Override
    public String toString() {
        return "Album: " + getTitulo() + ". Artista: " + getArtista() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Album album = (Album) obj;
        return id.equals(album.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public Cancion crearCancion (String titulo, int duracion, GeneroMusical genero) throws AlbumCompletoException, DuracionInvalidaException {
        if (this.canciones.size() >= MaxCanciones) {
            throw new AlbumCompletoException("El álbum ya está completo");
        }

        if (duracion <= 0) {
            throw new DuracionInvalidaException("Duración inválida");
        }

        Cancion cancion = new Cancion(titulo, duracion, this.artista, genero);
        cancion.setAlbum(this);
        this.canciones.add(cancion);

        if (artista != null) {
            artista.publicarCancion(cancion);
        }

        return cancion;
    }

    public Cancion crearCancion (String titulo, int duracion, GeneroMusical genero, String letra, boolean explicit) throws AlbumCompletoException, DuracionInvalidaException {
        if (this.canciones.size() >= MaxCanciones) {
            throw new AlbumCompletoException("El álbum ya está completo");
        }

        if (duracion <= 0) {
            throw new DuracionInvalidaException("Duración inválida");
        }

        Cancion cancion = new Cancion(titulo, duracion, this.artista, genero, letra, explicit);
        cancion.setAlbum(this);
        this.canciones.add(cancion);

        if (artista != null) {
            artista.publicarCancion(cancion);
        }

        return cancion;
    }


    public void eliminarCancion (int posicion) throws CancionNoEncontradaException {
        if (posicion > this.canciones.size() || posicion < 1) {
            throw new CancionNoEncontradaException("Canción no encontrada");
        }
        Cancion cancion = this.canciones.remove(posicion-1);
        cancion.setAlbum(null);
    }

    public void eliminarCancion (Cancion cancion) throws CancionNoEncontradaException {
       if (!this.canciones.contains(cancion)) {
           throw new CancionNoEncontradaException("Canción no encontrada");
       }
       this.canciones.remove(cancion);
       cancion.setAlbum(null);
    }

    public int getDuracionTotal () {
        int duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal = duracionTotal + cancion.getDuracion();
        }
        return duracionTotal;
    }

    public String getDuracionTotalFormateada() {
        int totalSegundos = getDuracionTotal();
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;

        if (horas > 0) {
            return String.format("%d:%02d:%02d", horas, minutos, segundos);
        }
        return String.format("%02d:%02d", minutos, segundos);
    }

    public int getNumCanciones () {
        return this.canciones.size();
    }

    public void ordenarPorPopularidad() {
        ArrayList<Cancion> ordenadas = new ArrayList<>(canciones);
        ordenadas.sort((c1, c2) -> c2.getReproducciones() - c1.getReproducciones());
    }

    public Cancion getCancion (int posicion) throws CancionNoEncontradaException {
        if (posicion > this.canciones.size() || posicion < 1) {
            throw new CancionNoEncontradaException();
        }
        return this.canciones.get(posicion-1);
    }

    public int getTotalReproducciones() {
        int totalReproducciones = 0;
        for (Cancion cancion : canciones) {
            totalReproducciones += cancion.getReproducciones();
        }
        return totalReproducciones;
    }
}
