package modelo.contenido;

import enums.CategoriaPodcast;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.contenido.EpisodioNoEncontradoException;
import excepciones.contenido.TranscripcionNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Creador;

import java.util.ArrayList;

public class Podcast extends Contenido implements IDescargable, IReproducible {
    private Creador creador;
    private int numeroEpisodio;
    private int temporada;
    private String descripcion;
    private CategoriaPodcast categoria;
    private ArrayList<String> invitados;
    private String transcripcion;
    private boolean reproduciendo;
    private boolean pausado;
    private boolean descargado;



    public Podcast(String titulo, int duracionSegundos, Creador creador, int numeroEpisodio, int temporada, CategoriaPodcast categoria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.categoria = categoria;
        this.descripcion = null;
        this.invitados = new ArrayList<>();
        this.transcripcion = null;
        this.reproduciendo = false;
        this.pausado = true;
        this.descargado = false;
    }

    public Podcast(String titulo, int duracionSegundos, Creador creador, int numeroEpisodio, int temporada, String descripcion, CategoriaPodcast categoria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.invitados = new ArrayList<>();
        this.transcripcion = null;
        this.reproduciendo = false;
        this.pausado = true;
        this.descargado = false;
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

    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
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
            throw new ContenidoNoDisponibleException("El podcast no está disponible");
        }
    }




    @Override
    public void play() {
        this.reproduciendo = true;
        this.pausado = false;
        System.out.println("Reproduciendo: " + titulo + " - " + (creador != null ? creador.getNombreCanal() : "Desconocido"));
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
            throw new ContenidoYaDescargadoException("El Podcast ya está descargado.");
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
        return "Canción: " + titulo + ". Artista: " + (creador != null ? creador.getNombreCanal() : "Desconocido") + ".";
    }




    public String obtenerDescripcion() {
        if (descripcion == null || descripcion.isEmpty()) {
            return "Descripción no disponible";
        } else {
            return descripcion;
        }
    }

    public void agregarInvitado(String nombre) {
        if (!invitados.contains(nombre)) {
            this.invitados.add(nombre);
        }
    }

    public boolean esTemporadaNueva(){
        return numeroEpisodio == 1;
    }

    public String obtenerTranscripcion() throws TranscripcionNoDisponibleException {
        if (transcripcion == null || transcripcion.isEmpty()) {
            throw new TranscripcionNoDisponibleException("Transcripción no disponible.");
        } else {
            return transcripcion;
        }
    }

    public void validarEpisodio() throws EpisodioNoEncontradoException {
        if (numeroEpisodio <= 0 || temporada <= 0) {
            throw new EpisodioNoEncontradoException("Temporada/Episodio inválido/s");
        }
    }

}
