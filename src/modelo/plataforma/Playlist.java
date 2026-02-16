package modelo.plataforma;

import enums.CriterioOrden;
import excepciones.playlist.ContenidoDuplicadoException;
import excepciones.playlist.PlaylistLlenaException;
import excepciones.playlist.PlaylistVaciaException;
import modelo.contenido.Cancion;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.*;

public class Playlist {
    private String id;
    private String nombre;
    private Usuario creador;
    private ArrayList<Contenido> contenidos;
    private boolean esPublica;
    private int seguidores;
    private String descripcion;
    private String portadaURL;
    private Date fechaCreacion;
    private int maxContenidos;
    private static final int MAX_CONTENIDOS_DEFAULT = 500;


    public Playlist(String nombre, Usuario creador) {
        this.nombre = nombre;
        this.creador = creador;
        this.id = UUID.randomUUID().toString();
        this.contenidos = new ArrayList<>();
        this.esPublica = true;
        this.seguidores = 0;
        this.descripcion = null;
        this.portadaURL = "https://soundwave.com/portadas/playlist/" + id + ".jpg";
        this.fechaCreacion = new Date();
        this.maxContenidos = MAX_CONTENIDOS_DEFAULT;
    }

    public Playlist(String nombre, Usuario creador, boolean esPublica, String descripcion) {
        this.nombre = nombre;
        this.creador = creador;
        this.esPublica = esPublica;
        this.descripcion = descripcion;
        this.id = UUID.randomUUID().toString();
        this.contenidos = new ArrayList<>();
        this.seguidores = 0;
        this.portadaURL = "https://soundwave.com/portadas/playlist/" + id + ".jpg";
        this.fechaCreacion = new Date();
        this.maxContenidos = MAX_CONTENIDOS_DEFAULT;
    }



    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getCreador() {
        return creador;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public boolean isEsPublica() {
        return esPublica;
    }

    public void setEsPublica(boolean esPublica) {
        this.esPublica = esPublica;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getMaxContenidos() {
        return maxContenidos;
    }



    @Override
    public String toString() {
        return "Playlist: " + getNombre() + ". Creador: " + getCreador() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Playlist playlist = (Playlist) obj;
        return id.equals(playlist.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public void agregarContenido (Contenido contenido) throws PlaylistLlenaException, ContenidoDuplicadoException {
        if (contenidos.size() >= maxContenidos) {
            throw new PlaylistLlenaException("La playlist ya está llena.");
        }

        if (contenidos.contains(contenido)) {
            throw new ContenidoDuplicadoException("El contenido ya está en la playlist");
        }

        this.contenidos.add(contenido);
    }

    public boolean eliminarContenido (String idContenido) {
        for (int i = 0; i < contenidos.size(); i++) {
            Contenido contenido = contenidos.get(i);
            if (contenido.getId().equals(idContenido)) {
                contenidos.remove(contenido);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarContenido (Contenido contenido) {
        if (contenidos.contains(contenido)) {
            contenidos.remove(contenido);
            return true;
        }
        return false;
    }

    public void ordenarPor (CriterioOrden criterio) throws PlaylistVaciaException {
        if (contenidos.isEmpty()) {
            throw new PlaylistVaciaException("La Playlist está vacía");
        }
        switch (criterio) {
            case FECHA_AGREGADO -> contenidos.sort((c1, c2) -> c2.getFechaPublicacion().compareTo(c1.getFechaPublicacion()));
            case POPULARIDAD -> contenidos.sort((c1, c2) -> c2.getReproducciones() - c1.getReproducciones());
            case DURACION -> contenidos.sort((c1, c2) -> c2.getDuracionSegundos() - c1.getDuracionSegundos());
            case ALFABETICO -> contenidos.sort((c1, c2) -> c2.getTitulo().compareToIgnoreCase(c1.getTitulo()));
            case ARTISTA -> contenidos.sort((c1, c2) -> ((Cancion) c1).getArtista().getNombreArtistico().compareToIgnoreCase(((Cancion) c2).getArtista().getNombreArtistico()));
            case ALEATORIO -> Collections.shuffle(contenidos);
        }
    }

    public int getDuracionTotal() {
        int duracionTotal = 0;
        for (Contenido contenido : contenidos) {
            duracionTotal = duracionTotal + contenido.getDuracionSegundos();
        }
        return duracionTotal;
    }

    public String getDuracionTotalFormateada () {
        int horas = getDuracionTotal()/3600;
        int minutos = (getDuracionTotal()%3600)/60;
        int segundos = (getDuracionTotal()%3600)%60;
        if (horas > 0 ) {
            return String.format("%02d:%02d", horas, minutos);
        }
        return String.format("%02d:%02d", minutos, segundos);
    }

    public void shuffle () {
        Collections.shuffle(contenidos);
    }

    public ArrayList<Contenido> buscarContenido (String termino) {
        ArrayList<Contenido> coincidencias = new ArrayList<>();
        for (Contenido contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(termino)) {
                coincidencias.add(contenido);
            }
        }
        return coincidencias;
    }

    public void hacerPublica () {
        this.esPublica = true;
    }

    public void hacerPrivada () {
        this.esPublica = false;
    }

    public void incrementarSeguidores () {
        this.seguidores++;
    }

    public void decrementarSeguidores () {
        if (this.seguidores > 0) {
            this.seguidores--;
        }
    }

    public int getNumContenidos () {
        return this.contenidos.size();
    }

    public boolean estaVacia () {
        return this.contenidos.isEmpty();
    }

    public Contenido getContenido (int posicion) {
        return this.contenidos.get(posicion);
    }



}
