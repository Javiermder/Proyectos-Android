package com.pmdm.actividadlistas;

public class Bici {
    private String nombre;
    private String descripcion;
    //private String urlImagen;


    public Bici(String Nombre, String Descripcion){

        this.nombre = Nombre;
        this.descripcion = Descripcion;
        //this.urlImagen = urlImagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
public int getUrlImagen() {
    return urlImagen;
}

public void setUrlImagen(String urlImagen) {
    this.urlImagen = urlImagen;
}*/

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
