package utilidades;

import enums.AlgoritmoRecomendacion;
import excepciones.recomendacion.RecomendacionException;
import interfaces.IRecomendador;
import modelo.contenido.Cancion;
import modelo.contenido.Contenido;
import modelo.contenido.Podcast;
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
        this.modeloEntrenado = false;
        this.catalogoReferencia = new ArrayList<>();
    }

    public RecomendadorIA(AlgoritmoRecomendacion algoritmo) {
        this.algoritmo = algoritmo;
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.umbralSimilitud = UMBRAL_DEFAULT;
        this.modeloEntrenado = false;
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

        ArrayList<Contenido> recomendaciones = new ArrayList<>();

        switch (this.algoritmo) {
            case CONTENIDO -> {
                ArrayList<String> preferencias = matrizPreferencias.get(usuario.getId());
                for (Contenido c : catalogoReferencia) {
                    if (!usuario.getHistorial().contains(c) && calcularSimilitudContenido(c, preferencias) >= umbralSimilitud) {
                        recomendaciones.add(c);
                    }
                }
            }

            case COLABORATIVO -> {
                ArrayList<String> preferenciasUsuario = matrizPreferencias.get(usuario.getId());

                for (String u : historialCompleto.keySet()) {
                    if (u.equals(usuario.getId())) continue;

                    ArrayList<String> preferenciasOtro = matrizPreferencias.get(u);
                    ArrayList<Contenido> historialOtro = historialCompleto.get(u);

                    int coincidencias = 0;

                    for (String p : preferenciasUsuario) {
                        if (preferenciasOtro.contains(p)) {
                            coincidencias++;
                        }
                    }
                    double similitud = (double) coincidencias / preferenciasUsuario.size();
                    if (similitud < umbralSimilitud) continue;

                    for (Contenido c : historialOtro) {
                        if (!usuario.getHistorial().contains(c) && !recomendaciones.contains(c)) {
                            recomendaciones.add(c);
                        }
                    }
                }
            }

            case HIBRIDO -> {
                ArrayList<String> preferencias = matrizPreferencias.get(usuario.getId());

                for (Contenido c : catalogoReferencia) {
                    if (!usuario.getHistorial().contains(c) && calcularSimilitudContenido(c, preferencias) >= umbralSimilitud) {
                        recomendaciones.add(c);
                    }
                }

                for (String u : historialCompleto.keySet()) {
                    if (u.equals(usuario.getId())) continue;

                    ArrayList<String> preferenciasOtro = matrizPreferencias.get(u);
                    ArrayList<Contenido> historialOtro = historialCompleto.get(u);

                    int coincidencias = 0;

                    for (String p : preferencias) {
                        if (preferenciasOtro.contains(p)) {
                            coincidencias++;
                        }
                    }
                    double similitud = (double) coincidencias / preferencias.size();
                    if (similitud < umbralSimilitud) continue;

                    for (Contenido c : historialOtro) {
                        if (!usuario.getHistorial().contains(c) && !recomendaciones.contains(c)) {
                            recomendaciones.add(c);
                        }
                    }
                }
            }
        }
        return recomendaciones;
    }

    @Override
    public ArrayList<Contenido> obtenerSimilares(Contenido contenido) throws RecomendacionException {
        if (catalogoReferencia.isEmpty()) {
            throw new RecomendacionException("No es posible generar recomendaciones");
        }

        ArrayList<Contenido> similares = new ArrayList<>();

        for (Contenido c : catalogoReferencia) {
            if (c.equals(contenido)) continue;

            if (c instanceof Cancion && contenido instanceof Cancion) {
                if (((Cancion) c).getGenero().equalsIgnoreCase(((Cancion) contenido).getGenero())) {
                    similares.add(c);
                }
            }

            if (c instanceof Podcast && contenido instanceof Podcast) {
                if (((Podcast) c).getCategoria().equalsIgnoreCase(((Podcast) contenido).getCategoria())) {
                    similares.add(c);
                }
            }
        }
        return similares;
    }



    private double calcularSimilitudContenido (Contenido contenido, ArrayList<String> preferencias) {
        if (contenido instanceof Cancion) {
            if (preferencias.contains(((Cancion) contenido).getGenero())) {
                return 1;
            }
        } else if (contenido instanceof Podcast) {
            if (preferencias.contains(((Podcast) contenido).getCategoria())) {
                return 1;
            }
        }
        return 0;
    }



    public void entrenarModelo(ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            actualizarPreferencias(usuario);
            historialCompleto.put(usuario.getId(), usuario.getHistorial());
        }
        modeloEntrenado = true;
    }

    public void entrenarModelo(ArrayList<Usuario> usuarios, ArrayList<Contenido> catalogo) {
        entrenarModelo(usuarios);
        this.catalogoReferencia = catalogo;
    }

    public double calcularSimilitud(Usuario u1, Usuario u2) {
        actualizarPreferencias(u1);
        actualizarPreferencias(u2);

        ArrayList<String> pref1 = matrizPreferencias.get(u1.getId());
        ArrayList<String> pref2 = matrizPreferencias.get(u2.getId());

        if (pref1.isEmpty() || pref2.isEmpty()) {
            return 0;
        }

        int coincidencias = 0;

        for (String s : pref1) {
            if (pref2.contains(s)) {
                coincidencias++;
            }
        }
        return (double) coincidencias / pref1.size();
    }

    public void actualizarPreferencias(Usuario usuario) {
        ArrayList<String> preferencias = new ArrayList<>();
        for (Contenido c : usuario.getHistorial()) {
            if (c instanceof Cancion) {
                preferencias.add(((Cancion) c).getGenero());
            } else if (c instanceof Podcast) {
                preferencias.add(((Podcast) c).getCategoria());
            }
        }
        matrizPreferencias.put(usuario.getId(), preferencias);
    }

    public HashMap<String, Integer> obtenerGenerosPopulares(){
        HashMap<String, Integer> populares = new HashMap<>();

        for (ArrayList<Contenido> historialUsuario : historialCompleto.values()) {
            for (Contenido c : historialUsuario) {
                String key = null;
                if (c instanceof Cancion) {
                    key = ((Cancion) c).getGenero();
                } else if (c instanceof Podcast) {
                    key = ((Podcast) c).getCategoria();
                }

                if (key != null) {
                    populares.put(key, populares.getOrDefault(key, 0)+1);
                }
            }
        }
        return populares;
    }


}
