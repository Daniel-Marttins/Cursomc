package com.retribution.cursomc.repositories;

import com.retribution.cursomc.domain.CategoriaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaDomain, Integer> {

}
