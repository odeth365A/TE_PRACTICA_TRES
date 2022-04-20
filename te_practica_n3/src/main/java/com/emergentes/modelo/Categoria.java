package com.emergentes.modelo;

public class Categoria {
    private int id;
    private String descripcion;

    public Categoria() {
    }
    
    public Categoria(int id, String descripcion){
        this.id=id;
        this.descripcion = descripcion;               
    }
    //metodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
