package modelo.usuarios;

import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected String password;
    protected TipoSuscripcion suscripcion;
    protected ArrayList<Playlist> misPlaylists;
    protected ArrayList<Contenido> historial;
    protected Date fechaRegistro;
    protected ArrayList<Playlist> playlistsSeguidas;
    protected ArrayList<Contenido> contenidosLiked;


    public Usuario(String nombre, String email, String password, TipoSuscripcion suscripcion) throws EmailInvalidoException, PasswordDebilException {
        this.nombre = nombre;
        this.email = email;
        validarEmail();
        this.password = password;
        validarPassword();
        this.suscripcion = suscripcion;
        this.id = UUID.randomUUID().toString();
        this.misPlaylists = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.fechaRegistro = new Date();
        this.playlistsSeguidas = new ArrayList<>();
        this.contenidosLiked = new ArrayList<>();
    }



    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoSuscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(TipoSuscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public ArrayList<Playlist> getMisPlaylists() {
        return misPlaylists;
    }

    public ArrayList<Contenido> getHistorial() {
        return historial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public ArrayList<Playlist> getPlaylistsSeguidas() {
        return playlistsSeguidas;
    }

    public ArrayList<Contenido> getContenidosLiked() {
        return contenidosLiked;
    }



    @Override
    public String toString() {
        return "Usuario: " + getNombre() + ". Email: " + getEmail() + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public abstract void reproducir (Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException;




    public Playlist crearPlaylist(String nombrePlaylist) {
        Playlist playlist = new Playlist(nombrePlaylist, this);
        playlist.setEsPublica(false);
        this.misPlaylists.add(playlist);
        return playlist;
    }

    public void seguirPlaylist (Playlist playlist) {
        if (playlist.isEsPublica()) {
            playlist.incrementarSeguidores();
            this.playlistsSeguidas.add(playlist);
        }
    }

    public void dejarDeSeguirPlaylist(Playlist playlist) {
        if (this.playlistsSeguidas.contains(playlist)) {
            playlist.decrementarSeguidores();
            this.playlistsSeguidas.remove(playlist);
        }
    }

    public void darLike (Contenido contenido) {
        contenido.agregarLike();
        this.contenidosLiked.add(contenido);
    }

    public void quitarLike (Contenido contenido) {
        this.contenidosLiked.remove(contenido);
    }

    public boolean validarEmail () throws EmailInvalidoException {
        if (this.email == null || !this.email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new EmailInvalidoException("Email inválido");
        }
        return true;
    }

    public boolean validarPassword () throws PasswordDebilException {
        if (this.password == null || !this.password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%&*?]).{8,20}$")) {
            throw new PasswordDebilException("Contraseña débil/inválida");
        }
        return true;
    }

    public void agregarAlHistorial(Contenido contenido) {
        if (this.historial.size() < 10) {
            this.historial.add(contenido);
        }
    }

    public void limpiarHistorial() {
        this.historial.clear();
    }

    public boolean esPremium() {
        return this.suscripcion.equals(TipoSuscripcion.PREMIUM);
    }

}
