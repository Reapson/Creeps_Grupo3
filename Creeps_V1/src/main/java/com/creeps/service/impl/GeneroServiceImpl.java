
package com.creeps.service.impl;

import com.creeps.dao.GeneroDao;
import com.creeps.domain.Genero;
import com.creeps.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroDao generoDao;
    
    @Override
    public List<Genero> getGeneros() {
        var generos = generoDao.findAll();
        return generos;
    }

    @Override
    @Transactional(readOnly=true)
    public Genero getGenero(Genero genero) {
        return generoDao.findById(genero.getIdGenero()).orElse(null);
    }
}
