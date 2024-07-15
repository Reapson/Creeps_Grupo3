
package com.creeps.dao;

import com.creeps.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository <Producto,Long>{
    
}
