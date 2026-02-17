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
        calcularEstadisticas();
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
        return "Creador: " + getCreador() + ". Suscriptores: " + getTotalSuscriptores() + ".";
    }


    private void calcularEstadisticas() {
        for (Podcast p : creador.getEpisodios()) {
            this.totalEpisodios++;

            this.totalLikes += p.getLikes();
            this.duracionTotalSegundos += p.getDuracionSegundos();

            if (this.episodioMasPopular == null || this.episodioMasPopular.getReproducciones() < p.getReproducciones()) {
                this.episodioMasPopular = p;
            }

            int temporada = p.getTemporada();
            this.episodiosPorTemporada.put(
                    temporada,
                    this.episodiosPorTemporada.getOrDefault(temporada, 0) + 1
            );
        }
        this.totalReproducciones = creador.getTotalReproducciones();
        this.promedioReproducciones = creador.calcularPromedioReproducciones();
        this.totalSuscriptores = creador.getSuscriptores();
    }

    private String formatearDuracion () {
        return String.valueOf(duracionTotalSegundos);
    }


    public String generarReporte() {
        return "Creador: " + getCreador() + "\n" +
                "Suscriptores: " + getTotalSuscriptores() + "\n" +
                "Likes: " + getTotalLikes() + "\n" +
                "Total episodios: " + getTotalEpisodios() + "\n" +
                "Duración Total (s): " + getDuracionTotalSegundos() + "\n" +
                "Total reproducciones: " + getTotalReproducciones() + "\n" +
                "Promedio reproducciones: " + getPromedioReproducciones() + "\n" +
                "Episodio más popular: " + getEpisodioMasPopular() + "\n" +
                "Episodios por temporada: " + getEpisodiosPorTemporada();
    }

    public double calcularEngagement () {
        return ((double) getTotalLikes() /getTotalReproducciones())*100;
    }

    public int estimarCrecimientoMensual() {
        return (int) (getPromedioReproducciones()/100);
    }
}
