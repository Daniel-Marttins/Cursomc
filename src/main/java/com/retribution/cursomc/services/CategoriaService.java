package com.retribution.cursomc.services;

import com.retribution.cursomc.domain.CategoriaDomain;
import com.retribution.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public CategoriaDomain buscar(Integer id){
        Optional<CategoriaDomain> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
