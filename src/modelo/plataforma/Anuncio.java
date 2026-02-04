package modelo.plataforma;

import enums.TipoAnuncio;

import java.util.UUID;

public class Anuncio {
    private String id;
    private String empresa;
    private int duracionSegundos;
    private String audioURL;
    private TipoAnuncio tipo;
    private int impresiones;
    private double presupuesto;
    private boolean activo;


    public Anuncio(String empresa, TipoAnuncio tipo, double presupuesto) {
        this.empresa = empresa;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.id = UUID.randomUUID().toString();
        this.duracionSegundos = 0;
        this.audioURL = "https://soundwave.com/anuncio/" + id;
        this.impresiones = 0;
        this.activo = false;
    }

    public Anuncio(String empresa, TipoAnuncio tipo, double presupuesto, String audioURL) {
        this.empresa = empresa;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.audioURL = audioURL;
        this.id = UUID.randomUUID().toString();
        this.duracionSegundos = 0;
        this.impresiones = 0;
        this.activo = false;
    }


    public String getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public TipoAnuncio getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnuncio tipo) {
        this.tipo = tipo;
    }

    public int getImpresiones() {
        return impresiones;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }




    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }



    public void reproducir () {}
    public void registrarImpresion () {}
    public double calcularCostoPorImpresion () {return 0;}
    public double calcularCostoTotal () {return 0;}
    public int calcularImpresionesRestantes () {return 0;}
    public void desactivar () {}
    public void activar () {}
    public boolean puedeMostrarse () {return true;}
}
