package enums;

public enum AlgoritmoRecomendacion {
    COLABORATIVO,
    CONTENIDO,
    HIBRIDO;


    private String descripcion;


    AlgoritmoRecomendacion() {
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
