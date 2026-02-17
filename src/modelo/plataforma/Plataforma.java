package modelo.plataforma;

import enums.CategoriaPodcast;
import enums.GeneroMusical;
import enums.TipoSuscripcion;
import excepciones.artista.AlbumCompletoException;
import excepciones.artista.AlbumYaExisteException;
import excepciones.artista.ArtistaNoVerificadoException;
import excepciones.artista.LimiteEpisodiosException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.plataforma.ArtistaNoEncontradoException;
import excepciones.plataforma.ContenidoNoEncontradoException;
import excepciones.plataforma.UsuarioYaExisteException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;
import modelo.artistas.Album;
import modelo.artistas.Artista;
import modelo.artistas.Creador;
import modelo.contenido.Cancion;
import modelo.contenido.Contenido;
import modelo.contenido.Podcast;
import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioGratuito;
import modelo.usuarios.UsuarioPremium;
import utilidades.RecomendadorIA;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Plataforma {
    private static Plataforma instancia;
    private String nombre;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Usuario> usuariosPorEmail;
    private ArrayList<Contenido> catalogo;
    private ArrayList<Playlist> playlistsPublicas;
    private HashMap<String, Artista> artistas;
    private HashMap<String, Artista> creadores;
    private ArrayList<Album> albumes;
    private ArrayList<Anuncio> anuncios;
    private RecomendadorIA recomendador;
    private int totalAnunciosReproducidos;


    private Plataforma(String nombre) {
        this.nombre = nombre;
        this.usuarios = new HashMap<>();
        this.usuariosPorEmail = new HashMap<>();
        this.catalogo = new ArrayList<>();
        this.playlistsPublicas = new ArrayList<>();
        this.artistas = new HashMap<>();
        this.creadores = new HashMap<>();
        this.albumes = new ArrayList<>();
        this.anuncios = new ArrayList<>();
        this.recomendador = new RecomendadorIA();
        this.totalAnunciosReproducidos = 0;
    }



    public String getNombre() {
        return nombre;
    }

    public ArrayList<Contenido> getCatalogo() {
        return catalogo;
    }

    public HashMap<String, Artista> getArtistas() {
        return artistas;
    }

    public HashMap<String, Artista> getCreadores() {
        return creadores;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public RecomendadorIA getRecomendador() {
        return recomendador;
    }

    public int getTotalAnunciosReproducidos() {
        return totalAnunciosReproducidos;
    }



    @Override
    public String toString() {
        return super.toString();
    }



    public static synchronized Plataforma getInstancia(String nombre) {}
    public static synchronized Plataforma getInstancia() {}
    public static synchronized void reiniciarInstancia() {}



    // Gestión de usuarios

    public UsuarioPremium registrarUsuarioPremium(String nombre, String email, String password, TipoSuscripcion tipo) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException {}
    public UsuarioPremium registrarUsuarioPremium(String nombre, String email, String password) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException {}
    public UsuarioGratuito registrarUsuarioGratuito(String nombre, String email, String password) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException {}
    public ArrayList<UsuarioPremium> getUsuariosPremium() {}
    public ArrayList<UsuarioGratuito> getUsuariosGratuitos() {}
    public ArrayList<Usuario> getTodosLosUsuarios() {}
    public Usuario buscarUsuarioPorEmail(String email) {}


    // Gestión de artistas

    public Artista registrarArtista(String nombreArtistico, String nombreReal, String paisOrigen, boolean verificado) {}
    public void registrarArtista(Artista artista) {}
    public ArrayList<Artista> getArtistasVerificados() {}
    public ArrayList<Artista> getArtistasNoVerificados() {}
    public Artista buscarArtista(String nombre) throws ArtistaNoEncontradoException {}


    // Gestión de álbumes

    public Album crearAlbum(Artista artista, String titulo, Date fecha) throws ArtistaNoVerificadoException, AlbumYaExisteException {}
    public ArrayList<Album> getAlbumes() {}


    // Gestión de canciones

    public Cancion crearCancion(String titulo, int duracion, Artista artista, GeneroMusical genero) throws DuracionInvalidaException {}
    public Cancion crearCancionEnAlbum(String titulo, int duracion, Artista artista, GeneroMusical genero, Album album) throws DuracionInvalidaException, AlbumCompletoException {}
    public void agregarContenidoCatalogo(Contenido contenido) {}
    public ArrayList<Cancion> getCanciones() {}


    // Gestión de creadores/podcasts

    public Creador registrarCreador(String nombreCanal, String nombre, String descripcion) {}
    public void registrarCreador(Creador creador) {}
    public Podcast crearPodcast(String titulo, int duracion, Creador creador, int numEpisodio, int temporada, CategoriaPodcast categoria) throws DuracionInvalidaException, LimiteEpisodiosException {}
    public ArrayList<Podcast> getPodcasts() {}
    public ArrayList<Creador> getTodosLosCreadores() {}


    // Gestión de playlists públicas
    public Playlist crearPlaylistPublica(String nombre, Usuario creador) {}
    public ArrayList<Playlist> getPlaylistsPublicas() {}


    // Búsquedas

    public ArrayList<Contenido> buscarContenido(String termino) throws ContenidoNoEncontradoException {}
    public ArrayList<Cancion> buscarPorGenero(GeneroMusical genero) throws ContenidoNoEncontradoException {}
    public ArrayList<Podcast> buscarPorCategoria(CategoriaPodcast categoria) throws ContenidoNoEncontradoException {}
    public ArrayList<Contenido> obtenerTopContenidos(int cantidad) {}


    // Anuncios

    public Anuncio obtenerAnuncioAleatorio() {
        Random r = new Random();
        return anuncios.get(r.nextInt(anuncios.size()));
    }

    public void incrementarAnunciosReproducidos() {}


    // Estadísticas

    public String obtenerEstadisticasGenerales() {}

}
