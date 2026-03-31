package com.adail.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adail.suporte.model.Chamado;

/*
 * Interface responsável por acessar o banco de dados.
 * O Spring cria automaticamente os métodos CRUD.
 */
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
