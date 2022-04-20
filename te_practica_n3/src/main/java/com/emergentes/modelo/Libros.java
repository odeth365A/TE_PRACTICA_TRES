package com.emergentes.modelo;

public class Libros {
    private int id;
    private String titulo;
    private String autor;
    private String estado;
    private Categoria cat;

    public Libros() {
    }
    
    public Libros(int id, String titulo, String autor, String estado, Categoria cat){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
        this.cat = cat;
    }
    //metodos getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
}
