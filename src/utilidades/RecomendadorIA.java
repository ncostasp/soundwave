package utilidades;

import enums.AlgoritmoRecomendacion;
import modelo.contenido.Contenido;

import java.util.ArrayList;
import java.util.HashMap;

public class RecomendadorIA {
    private HashMap<String, ArrayList<String>> matrizPreferencias;
    private HashMap<String, ArrayList<Contenido>> historialCompleto;
    private AlgoritmoRecomendacion algoritmo;
    private double umbralSimilitud;
    private boolean modeloEntrenado;


    public RecomendadorIA(HashMap<String, ArrayList<String>> matrizPreferencias, HashMap<String, ArrayList<Contenido>> historialCompleto, AlgoritmoRecomendacion algoritmo, double umbralSimilitud, boolean modeloEntrenado) {
        this.matrizPreferencias = matrizPreferencias;
        this.historialCompleto = historialCompleto;
        this.algoritmo = algoritmo;
        this.umbralSimilitud = umbralSimilitud;
        this.modeloEntrenado = modeloEntrenado;
    }



}
