package modelo.usuarios;

import enums.TipoSuscripcion;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String password;
    private TipoSuscripcion suscripcion;
    private ArrayList<Playlist> misPlaylists;
    private ArrayList<Contenido> historial;
    private Date fechaRegistro;



    public Usuario(String id, String nombre, String email, String password, TipoSuscripcion suscripcion, ArrayList<Playlist> misPlaylists, ArrayList<Contenido> historial, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.suscripcion = suscripcion;
        this.misPlaylists = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.fechaRegistro = fechaRegistro;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void addMisPlaylists(Playlist misPlaylists) {
        this.misPlaylists.add(misPlaylists);
    }

    public ArrayList<Contenido> getHistorial() {
        return historial;
    }

    public void addHistorial(Contenido historial) {
        this.historial.add(historial);
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public abstract void reproducir (Contenido contenido);


    public Playlist crearPlaylist(String nombre) {
        Playlist playlist = new Playlist(nombre);
        misPlaylists.add(playlist);
        return playlist;
    }

    public void seguirPlaylist (Playlist playlist) {}
    public void darLike (Contenido contenido) {}
    public boolean validarEmail () {return true;}
    public boolean validarPassword () {return true;}
    public void agregarAlHistorial(Contenido contenido) {}




}
