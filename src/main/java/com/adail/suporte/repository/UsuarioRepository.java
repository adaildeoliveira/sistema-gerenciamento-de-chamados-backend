package com.adail.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adail.suporte.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}