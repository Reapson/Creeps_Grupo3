
package com.creeps.service;

import com.creeps.domain.Genero;
import java.util.List;


public interface GeneroService {
    
    public List<Genero> getGeneros();   

    public Genero getGenero(Genero genero);
}

