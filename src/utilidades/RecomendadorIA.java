package utilidades;

import enums.AlgoritmoRecomendacion;
import excepciones.recomendacion.RecomendacionException;
import interfaces.IRecomendador;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class RecomendadorIA implements IRecomendador {
    private HashMap<String, ArrayList<String>> matrizPreferencias;
    private HashMap<String, ArrayList<Contenido>> historialCompleto;
    private AlgoritmoRecomendacion algoritmo;
    private double umbralSimilitud;
    private boolean modeloEntrenado;
    private ArrayList<Contenido> catalogoReferencia;
    private static final double UMBRAL_DEFAULT = 0.6;


    public RecomendadorIA() {
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.algoritmo = AlgoritmoRecomendacion.HIBRIDO;
        this.umbralSimilitud = UMBRAL_DEFAULT;
        this.modeloEntrenado = true;
        this.catalogoReferencia = new ArrayList<>();
    }

    public RecomendadorIA(AlgoritmoRecomendacion algoritmo) {
        this.algoritmo = algoritmo;
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.umbralSimilitud = UMBRAL_DEFAULT;
        this.modeloEntrenado = true;
        this.catalogoReferencia = new ArrayList<>();
    }


    public AlgoritmoRecomendacion getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(AlgoritmoRecomendacion algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getUmbralSimilitud() {
        return umbralSimilitud;
    }

    public void setUmbralSimilitud(double umbralSimilitud) {
        this.umbralSimilitud = umbralSimilitud;
    }

    public boolean isModeloEntrenado() {
        return modeloEntrenado;
    }

    public HashMap<String, ArrayList<String>> getMatrizPreferencias() {
        return matrizPreferencias;
    }

    public void setCatalogoReferencia(ArrayList<Contenido> catalogoReferencia) {
        this.catalogoReferencia = catalogoReferencia;
    }




    @Override
    public ArrayList<Contenido> recomendar(Usuario usuario) throws RecomendacionException {
        if (!modeloEntrenado || historialCompleto.isEmpty()) {
            throw new RecomendacionException("No es posible generar recomendaciones");
        }

    }

    @Override
    public ArrayList<Contenido> obtenerSimilares(Contenido contenido) throws RecomendacionException {
        return null;
    }



    private double calcularSimilitudContenido (Contenido contenido, ArrayList<String> preferencias) {return 0;}



    public void entrenarModelo(ArrayList<Usuario> usuarios) {}
    public void entrenarModelo(ArrayList<Usuario> usuarios, ArrayList<Contenido> catalogo) {}
    public double calcularSimilitud(Usuario u1, Usuario u2) {return 0;}
    public void actualizarPreferencias(Usuario usuario) {}
    public HashMap<String, Integer> obtenerGenerosPopulares(){}


}
