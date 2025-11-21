package com.pmdm.ud9_listas;

public class Concepto {

    private String nombre;
    private String deficinion;

    public Concepto(String Nombre, String Definicion){
        this.nombre  = Nombre;
        this.deficinion = Definicion;
    }

    public String getDeficinion() {
        return deficinion;
    }

    public void setDeficinion(String deficinion) {
        this.deficinion = deficinion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
