package com.retribution.cursomc.resources;

import com.retribution.cursomc.domain.CategoriaDomain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoriaDomain> listar(){
        CategoriaDomain cat1 = new CategoriaDomain(1, "Informatica");
        CategoriaDomain cat2 = new CategoriaDomain(2, "Escritório");

        List<CategoriaDomain> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}
