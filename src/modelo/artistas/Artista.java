package modelo.artistas;

import excepciones.artista.AlbumYaExisteException;
import excepciones.artista.ArtistaNoVerificadoException;
import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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


    public Artista(String nombreArtistico, String nombreReal, String paisOrigen) {
        this.nombreArtistico = nombreArtistico;
        this.nombreReal = nombreReal;
        this.paisOrigen = paisOrigen;
        this.id = UUID.randomUUID().toString();
        this.discografia = new ArrayList<>();
        this.albumes = new ArrayList<>();
        this.oyentesMensuales = 0;
        this.verificado = false;
        this.biografia = null;
    }


    public Artista(String nombreArtistico, String nombreReal, String paisOrigen, boolean verificado, String biografia) {
        this.nombreArtistico = nombreArtistico;
        this.nombreReal = nombreReal;
        this.paisOrigen = paisOrigen;
        this.verificado = verificado;
        this.biografia = biografia;
        this.id = UUID.randomUUID().toString();
        this.discografia = new ArrayList<>();
        this.albumes = new ArrayList<>();
        this.oyentesMensuales = 0;
    }




    public String getId() {
        return id;
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

    public ArrayList<Album> getAlbumes() {
        return albumes;
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



    @Override
    public String toString() {
        return "Artista: " + nombreArtistico + ". Oyentes Mensuales: " + oyentesMensuales + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artista artista = (Artista) obj;
        return id.equals(artista.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public void publicarCancion (Cancion cancion) {
        this.discografia.add(cancion);
    }

    public Album crearAlbum (String titulo, Date fecha) throws ArtistaNoVerificadoException, AlbumYaExisteException {
        if (!verificado) {
            throw new ArtistaNoVerificadoException("El artista no está verificado");
        }

        for (Album album : albumes) {
            if (album.getTitulo().equalsIgnoreCase(titulo)) {
                throw new AlbumYaExisteException("El álbum ya existe");
            }
        }

        this.albumes.add(new Album(titulo, this, fecha));

    }

    public ArrayList<Cancion> obtenerTopCanciones (int cantidad) {
        ArrayList<Cancion> ordenadas = new ArrayList<>(discografia);
        ordenadas.sort((c1, c2) -> c2.getReproducciones() - c1.getReproducciones());

        if (cantidad >= ordenadas.size()) {
            return ordenadas;
        }
        return new ArrayList<>(ordenadas.subList(0, cantidad));
    };

    public double calcularPromedioReproducciones () {
        return (double) getTotalReproducciones()/discografia.size();
    }

    public boolean esVerificado(){
        return verificado;
    }

    public int getTotalReproducciones () {
        if (discografia.isEmpty()) {
            return 0;
        }

        int totalReproducciones = 0;
        for (Cancion cancion : discografia ) {
            totalReproducciones += cancion.getReproducciones();
        }
        return totalReproducciones;
    }

    public void verificar () {
        this.verificado = true;
    }

    public void incrementarOyentes() {
        this.oyentesMensuales++;
    }

}
