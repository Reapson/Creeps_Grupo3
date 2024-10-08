
package com.creeps.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data //Genera automáticamente el código boilerplate como getters, setters, y otros métodos comunes.
@Entity //Indica que esta clase es una entidad de JPA y está mapeada a una tabla de base de datos.
@Table(name = "producto")
public class Producto {
    
    private static final long serialVersionUID = 1L;

//  -------------------------  
// Clave primaria autoincremental
    @Id //Indica que el campo al que se aplica es la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Clave primaria sera generado automáticamente por la base de datos
    //Mapea el campo de la clase a una columna específica en la tabla de la base de datos
    private Long idProducto;
    
    private String nombre;    
    private String talla;
    private int precio;
    private int stock;
    private String urlImagen;
    
    @ManyToOne
    @JoinColumn(name = "id_genero")
    Genero genero;

    public Producto() {
    }       
    
}
