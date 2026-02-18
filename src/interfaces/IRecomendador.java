package interfaces;

import excepciones.recomendacion.HistorialVacioException;
import excepciones.recomendacion.ModeloNoEntrenadoException;
import excepciones.recomendacion.RecomendacionException;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;

public interface IRecomendador {
    ArrayList<Contenido> recomendar (Usuario usuario) throws RecomendacionException, HistorialVacioException, ModeloNoEntrenadoException;
    ArrayList<Contenido> obtenerSimilares (Contenido contenido) throws RecomendacionException;
}
