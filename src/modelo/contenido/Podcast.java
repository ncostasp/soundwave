package modelo.contenido;

import enums.CategoriaPodcast;
import modelo.artistas.Creador;

import java.util.ArrayList;
import java.util.Date;

public class Podcast extends Contenido {
    private Creador creador;
    private int numeroEpisodio;
    private int temporada;
    private String descripcion;
    private CategoriaPodcast categoria;
    private ArrayList<String> invitados;
    private String transcripcion;


    public Podcast(String id, String titulo, int reproducciones, int likes, int duracionSegundos, ArrayList<String> tags, boolean disponible, Date fechaPublicacion, Creador creador, int numeroEpisodio, int temporada, String descripcion, CategoriaPodcast categoria, ArrayList<String> invitados, String transcripcion) {
        super(id, titulo, reproducciones, likes, duracionSegundos, tags, disponible, fechaPublicacion);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.invitados = new ArrayList<>();
        this.transcripcion = transcripcion;
    }


    public Creador getCreador() {
        return creador;
    }

    public void setCreador(Creador creador) {
        this.creador = creador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaPodcast getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPodcast categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getInvitados() {
        return invitados;
    }

    public void addInvitados(String invitado) {
        this.invitados.add(invitado);
    }

    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }


    @Override
    public void reproducir() {

    }


    // Faltan los métodos
}
