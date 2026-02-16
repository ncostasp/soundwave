package modelo.contenido;

import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Contenido {
    protected String id;
    protected String titulo;
    protected int reproducciones;
    protected int likes;
    protected int duracionSegundos;
    protected ArrayList<String> tags;
    protected boolean disponible;
    protected Date fechaPublicacion;


    public Contenido(String titulo, int duracionSegundos) throws DuracionInvalidaException {
        if (duracionSegundos <= 0) {
            throw new DuracionInvalidaException("La pista está vacía");
        }
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.reproducciones = 0;
        this.likes = 0;
        this.tags = new ArrayList<>();
        this.disponible = true;
        this.fechaPublicacion = new Date();
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

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public int getLikes() {
        return likes;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }



    @Override
    public String toString() {
        return "Contenido: " + titulo + ". Duración: " + getDuracionFormateada() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contenido contenido = (Contenido) obj;
        return id.equals(contenido.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public abstract void reproducir () throws ContenidoNoDisponibleException;



    public void aumentarReproducciones () {
        this.reproducciones++;
    }

    public void agregarLike () {
        this.likes++;
    }

    public boolean esPopular () {
        return this.reproducciones > 100000;
    }

    public void validarDuracion () throws DuracionInvalidaException {
        if (duracionSegundos <= 0) {
            throw new DuracionInvalidaException("Duración incorrecta.");
        }
    }

    public void agregarTag(String tag) {
        if (tag != null && !tag.isEmpty() && !tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public boolean tieneTag(String tag) {
        return tags.contains(tag);
    }

    public void marcarNoDisponible() {
        this.disponible = false;
    }

    public void marcarDisponible() {
        this.disponible = true;
    }

    public String getDuracionFormateada() {
        int minutos = this.duracionSegundos/60;
        int segundos = this.duracionSegundos%60;
        return String.format("%d:%02d", minutos, segundos);
    }

}
