package com.adail.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adail.suporte.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}