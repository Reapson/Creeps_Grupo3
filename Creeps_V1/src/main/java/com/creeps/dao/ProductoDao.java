
package com.creeps.dao;

import com.creeps.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository <Producto,Long>{
    public List<Producto> findByGeneroDescripcionContainingIgnoreCase(String descripcion); 
    
    public List<Producto> findByGeneroIdGenero(Long idGenero);
}
