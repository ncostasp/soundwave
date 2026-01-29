package modelo.contenido;

import enums.CategoriaPodcast;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Creador;

import java.util.ArrayList;
import java.util.Date;

public class Podcast extends Contenido implements IDescargable, IReproducible {
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

    public String obtenerDescripcion() {return descripcion;}
    public void agregarInvitado(String nombre) {}
    public boolean esTemporadaNueva(){return true;}



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
