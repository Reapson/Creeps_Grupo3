
package com.creeps.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto {

    private int cantidad; // Almacenar la cantidad de items de un producto

    // Constructor por defecto
    public Item() {
    }

    // Constructor que inicializa un Item a partir de un Producto existente
    public Item(Producto producto) {
        super.setIdProducto(producto.getIdProducto());
        super.setNombre(producto.getNombre());
        super.setTalla(producto.getTalla());
        super.setPrecio(producto.getPrecio());
        super.setStock(producto.getStock());
        super.setUrlImagen(producto.getUrlImagen());
        super.setGenero(producto.getGenero());
        this.cantidad = 0;
    }
}