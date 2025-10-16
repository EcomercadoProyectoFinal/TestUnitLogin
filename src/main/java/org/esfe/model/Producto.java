package org.esfe.model;


public class Producto {

   
     private String nombre;

    private double precio;

    private String descripcion;

    private int stock;

    private String categoria;

    private String urlImagen;



    public Producto(String nombre, double precio, String descripcion, int stock, String categoria, String urlImagen) {

        this.nombre = nombre;

        this.precio = precio;

        this.descripcion = descripcion;

        this.stock = stock;

        this.categoria = categoria;

        this.urlImagen = urlImagen;

    }



    public String getNombre() { return nombre; }

    public double getPrecio() { return precio; }

    public String getDescripcion() { return descripcion; }

    public int getStock() { return stock; }

    public String getCategoria() { return categoria; }

    public String getUrlImagen() { return urlImagen; }

}