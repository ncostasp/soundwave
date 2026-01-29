package modelo.artistas;

import enums.CategoriaPodcast;
import modelo.contenido.Podcast;
import utilidades.EstadisticasCreador;

import java.util.ArrayList;
import java.util.HashMap;

public class Creador {
    private String id;
    private String nombreCanal;
    private String nombre;
    private ArrayList<Podcast> episodios;
    private int suscriptores;
    private String descripciones;
    private HashMap<String,String> redesSociales;
    private ArrayList<CategoriaPodcast> categoriasPrincipales;


    public Creador(String id, String nombreCanal, String nombre, ArrayList<Podcast> episodios, int suscriptores, String descripciones, HashMap<String, String> redesSociales, ArrayList<CategoriaPodcast> categoriasPrincipales) {
        this.id = id;
        this.nombreCanal = nombreCanal;
        this.nombre = nombre;
        this.episodios = new ArrayList<>();
        this.suscriptores = suscriptores;
        this.descripciones = descripciones;
        this.redesSociales = new HashMap<>();
        this.categoriasPrincipales = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Podcast> getEpisodios() {
        return episodios;
    }

    public void addEpisodios(Podcast episodio) {
        this.episodios.add(episodio);
    }

    public int getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(int suscriptores) {
        this.suscriptores = suscriptores;
    }

    public String getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    public HashMap<String, String> getRedesSociales() {
        return redesSociales;
    }

    public void addRedesSociales(String key, String redSocial) {
        this.redesSociales.put(key, redSocial);
    }

    public ArrayList<CategoriaPodcast> getCategoriasPrincipales() {
        return categoriasPrincipales;
    }

    public void addCategoriasPrincipales(CategoriaPodcast categoriaPrincipal) {
        this.categoriasPrincipales.add(categoriaPrincipal);
    }


    public void publicarPodcast (Podcast episodio) {}
    public EstadisticasCreador obtenerEstadisticas;
    public void agregarRedSocial (String red, String usuario) {}
    public double calcularPromedioReproducciones () {return 0;}
    public void eliminarEpisodio (String idEpisodio) {}
}
