
package com.creeps.service;

import com.creeps.domain.Producto;
import java.util.List;


public interface ProductoService {
    
    public List<Producto> getProductos();
   
    // Se obtiene una Categoria, a partir del id de un categoria
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Producto producto); 
    
    
    
//    ProductoDao 
    public List<Producto> findByGeneroDescripcionContainingIgnoreCase(String genero);
    
    public List<Producto> getProductosByGenero(Long idGenero);
}
