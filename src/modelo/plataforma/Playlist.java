package modelo.plataforma;

import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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

    public void setId(String id) {
        this.id = id;
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

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(ArrayList<Contenido> contenidos) {
        this.contenidos = contenidos;
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

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getMaxContenidos() {
        return maxContenidos;
    }

    public void setMaxContenidos(int maxContenidos) {
        this.maxContenidos = maxContenidos;
    }







    public int getMAX_CONTENIDOS_DEFAULT() {
        return MAX_CONTENIDOS_DEFAULT;
    }


}
