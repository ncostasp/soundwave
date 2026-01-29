package interfaces;

import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;

public interface IRecomendador {
    ArrayList<Contenido> recomendar (Usuario usuario);
    ArrayList<Contenido> obtenerSimilares (Contenido contenido);
}
