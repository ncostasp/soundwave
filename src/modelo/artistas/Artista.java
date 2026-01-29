package modelo.artistas;

import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;

public class Artista {
    private String id;
    private String nombreArtistico;
    private String nombreReal;
    private String paisOrigen;
    private ArrayList<Cancion> discografia;
    private ArrayList<Album> albumes;
    private int oyentesMensuales;
    private boolean verificado;
    private String biografia;


    public Artista(String id, String nombreArtistico, String nombreReal, String paisOrigen, ArrayList<Cancion> discografia, ArrayList<Album> albumes, int oyentesMensuales, boolean verificado, String biografia) {
        this.id = id;
        this.nombreArtistico = nombreArtistico;
        this.nombreReal = nombreReal;
        this.paisOrigen = paisOrigen;
        this.discografia = new ArrayList<>();
        this.albumes = new ArrayList<>();
        this.oyentesMensuales = oyentesMensuales;
        this.verificado = verificado;
        this.biografia = biografia;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public ArrayList<Cancion> getDiscografia() {
        return discografia;
    }

    public void addDiscografia(Cancion discografia) {
        this.discografia.add(discografia);
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void addAlbumes(Album album) {
        this.albumes.add(album);
    }

    public int getOyentesMensuales() {
        return oyentesMensuales;
    }

    public void setOyentesMensuales(int oyentesMensuales) {
        this.oyentesMensuales = oyentesMensuales;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }


    public void publicarCancion (Cancion cancion) {}
    public Album crearAlbum (String titulo, Date fecha) {return null;};
    public ArrayList<Cancion> obtenerTopCanciones (int cantidad) {return null;};
    public double calcularPromedioReproducciones (){return 0;}
    public boolean esVerificado(){return true;}
}
