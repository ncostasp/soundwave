package utilidades;

import modelo.artistas.Creador;
import modelo.contenido.Podcast;

import java.util.HashMap;

public class EstadisticasCreador {
    private Creador creador;
    private int totalEpisodios;
    private long totalReproducciones;
    private double promedioReproducciones;
    private int totalSuscriptores;
    private int totalLikes;
    private int duracionTotalSegundos;
    private Podcast episodioMasPopular;
    private HashMap<Integer, Integer> episodiosPorTemporada;


    public EstadisticasCreador(Creador creador) {
        this.creador = creador;
        this.totalEpisodios = 0;
        this.totalReproducciones = 0;
        this.promedioReproducciones = 0;
        this.totalSuscriptores = 0;
        this.totalLikes = 0;
        this.duracionTotalSegundos = 0;
        this.episodioMasPopular = null;
        this.episodiosPorTemporada = new HashMap<>();
    }



    public Creador getCreador() {
        return creador;
    }

    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public long getTotalReproducciones() {
        return totalReproducciones;
    }

    public double getPromedioReproducciones() {
        return promedioReproducciones;
    }

    public int getTotalSuscriptores() {
        return totalSuscriptores;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getDuracionTotalSegundos() {
        return duracionTotalSegundos;
    }

    public Podcast getEpisodioMasPopular() {
        return episodioMasPopular;
    }

    public HashMap<Integer, Integer> getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }



    @Override
    public String toString() {
        return super.toString();
    }


    private void calcularEstadisticas() {}
    private String formatearDuracion () {return "o";}


    public String generarReporte(){return "h";}
    public double calcularEngagement () {return 0;}
    public int estimarCrecimientoMensual() {return 0;}
}
