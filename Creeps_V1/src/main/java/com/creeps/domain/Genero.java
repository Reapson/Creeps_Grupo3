
package com.creeps.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;


@Data //Genera automáticamente el código boilerplate como getters, setters, y otros métodos comunes.
@Entity //Indica que esta clase es una entidad de JPA y está mapeada a una tabla de base de datos.
@Table(name = "genero")
public class Genero {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private Long idGenero;
    
    private String descripcion;
    
    @OneToMany
    @JoinColumn(name = "id_genero", updatable=false)
    List<Producto> productos;

//    Constructores
    public Genero() {
    }    
    
    public Genero(String descripcion) {
        this.descripcion = descripcion;
    }     
}