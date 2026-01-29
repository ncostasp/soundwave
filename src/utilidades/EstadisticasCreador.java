package utilidades;

import enums.CategoriaPodcast;
import modelo.contenido.Podcast;

import java.util.HashMap;

public class EstadisticasCreador {
    private int totalEpisodios;
    private long totalReproducciones;
    private double promedioReproducciones;
    private Podcast episodioMasPopular;
    private HashMap<CategoriaPodcast, Integer> categoriasFrecuentes;


    public EstadisticasCreador(int totalEpisodios, long totalReproducciones, double promedioReproducciones, Podcast episodioMasPopular, HashMap<CategoriaPodcast, Integer> categoriasFrecuentes) {
        this.totalEpisodios = totalEpisodios;
        this.totalReproducciones = totalReproducciones;
        this.promedioReproducciones = promedioReproducciones;
        this.episodioMasPopular = episodioMasPopular;
        this.categoriasFrecuentes = categoriasFrecuentes;
    }


    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public void setTotalEpisodios(int totalEpisodios) {
        this.totalEpisodios = totalEpisodios;
    }

    public long getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(long totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }

    public double getPromedioReproducciones() {
        return promedioReproducciones;
    }

    public void setPromedioReproducciones(double promedioReproducciones) {
        this.promedioReproducciones = promedioReproducciones;
    }

    public Podcast getEpisodioMasPopular() {
        return episodioMasPopular;
    }

    public void setEpisodioMasPopular(Podcast episodioMasPopular) {
        this.episodioMasPopular = episodioMasPopular;
    }

    public HashMap<CategoriaPodcast, Integer> getCategoriasFrecuentes() {
        return categoriasFrecuentes;
    }

    public void setCategoriasFrecuentes(HashMap<CategoriaPodcast, Integer> categoriasFrecuentes) {
        this.categoriasFrecuentes = categoriasFrecuentes;
    }


    public String generarReporte(){return "h";}
}
