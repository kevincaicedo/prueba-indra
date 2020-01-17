package com.indra.prueba.repository;

import com.indra.prueba.model.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleRepository
 */
@Repository
public interface CalculoRepository extends JpaRepository<Calculo, Long> {
    List<Calculo> findCalculosByResultadoBetweenAndUsuario(Long min, Long max, String usuario);
    List<Calculo> findCalculosByResultadoBetween(Long min, Long max);
}
