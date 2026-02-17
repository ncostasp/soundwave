package modelo.artistas;

import enums.CategoriaPodcast;
import excepciones.artista.LimiteEpisodiosException;
import excepciones.contenido.EpisodioNoEncontradoException;
import modelo.contenido.Cancion;
import modelo.contenido.Podcast;
import utilidades.EstadisticasCreador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Creador {
    private String id;
    private String nombreCanal;
    private String nombre;
    private ArrayList<Podcast> episodios;
    private int suscriptores;
    private String descripciones;
    private HashMap<String,String> redesSociales;
    private ArrayList<CategoriaPodcast> categoriasPrincipales;
    private static final int MAX_EPISODIOS = 500;


    public Creador(String nombreCanal, String nombre) {
        this.nombreCanal = nombreCanal;
        this.nombre = nombre;
        this.id = UUID.randomUUID().toString();
        this.episodios = new ArrayList<>();
        this.suscriptores = 0;
        this.descripciones = null;
        this.redesSociales = new HashMap<>();
        this.categoriasPrincipales = new ArrayList<>();
    }

    public Creador(String nombreCanal, String nombre, String descripciones) {
        this.nombreCanal = nombreCanal;
        this.nombre = nombre;
        this.descripciones = descripciones;
        this.id = UUID.randomUUID().toString();
        this.episodios = new ArrayList<>();
        this.suscriptores = 0;
        this.redesSociales = new HashMap<>();
        this.categoriasPrincipales = new ArrayList<>();
    }




    public String getId() {
        return id;
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

    public ArrayList<CategoriaPodcast> getCategoriasPrincipales() {
        return categoriasPrincipales;
    }

    public int getMAX_EPISODIOS() {
        return MAX_EPISODIOS;
    }



    @Override
    public String toString() {
        return "Creador: " + getNombreCanal() + ". Suscriptores: " + getSuscriptores() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Creador creador = (Creador) obj;
        return id.equals(creador.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public void publicarPodcast (Podcast episodio) throws LimiteEpisodiosException {
        if (this.episodios.size() >= MAX_EPISODIOS) {
            throw new LimiteEpisodiosException("Límite de episodios");
        }
        this.episodios.add(episodio);
    }

    public EstadisticasCreador obtenerEstadisticas () {
        return new EstadisticasCreador(this);
    }

    public void agregarRedSocial (String red, String usuario) {
        if (red != null && usuario != null && !red.isEmpty() && !usuario.isEmpty()) {
            redesSociales.put(red, usuario);
        }
    }

    public double calcularPromedioReproducciones () {
        return (double) getTotalReproducciones() / episodios.size();
    }


    public void eliminarEpisodio(String idEpisodio) throws EpisodioNoEncontradoException {
        for (int i = 0; i < episodios.size(); i++) {
            Podcast episodio = episodios.get(i);

            if (episodio.getId().equals(idEpisodio)) {
                episodios.remove(i);
                return;
            }
        }
        throw new EpisodioNoEncontradoException("Episodio no encontrado");
    }


    public int getTotalReproducciones () {
        if (episodios.isEmpty()) {
            return 0;
        }

        int totalReproducciones = 0;
        for (Podcast episodio : episodios) {
            totalReproducciones += episodio.getReproducciones();
        }
        return totalReproducciones;
    }

    public void incrementarSuscriptores () {
        this.suscriptores++;
    }

    public ArrayList<Podcast> obtenerTopEpisodios(int cantidad) {
        ArrayList<Podcast> ordenados = new ArrayList<>(episodios);
        ordenados.sort((c1, c2) -> c2.getReproducciones() - c1.getReproducciones());

        if (cantidad >= ordenados.size()) {
            return ordenados;
        }
        return new ArrayList<>(ordenados.subList(0, cantidad));
    }

    public int getUltimaTemporada () {
        int temporadaMax = 0;

        for (Podcast episodio : episodios) {
            if (episodio.getTemporada() > temporadaMax) {
                temporadaMax = episodio.getTemporada();
            }
        }
        return temporadaMax;
    }




    public int getNumEpisodios () {
        return episodios.size();
    }
}
