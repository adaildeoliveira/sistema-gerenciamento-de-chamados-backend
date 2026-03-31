package com.adail.suporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adail.suporte.model.Usuario;
import com.adail.suporte.repository.UsuarioRepository;

/*
 * Controller responsável por gerenciar as requisições relacionadas
 * à entidade Usuario.
 * 
 * Aqui são definidos os endpoints da API para realizar operações
 * de CRUD (Create, Read, Update, Delete).
 */
@RestController // Indica que essa classe é um controller REST
@RequestMapping("/usuarios") // Define o caminho base da API
public class UsuarioController {

    /*
     * Repository responsável por acessar o banco de dados.
     * O Spring injeta automaticamente essa dependência.
     */
    @Autowired
    private UsuarioRepository repository;

    /*
     * Método para listar todos os usuários.
     * 
     * GET /usuarios
     */
    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    /*
     * Método para buscar um usuário pelo ID.
     * 
     * GET /usuarios/{id}
     */
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /*
     * Método para criar um novo usuário.
     * 
     * POST /usuarios
     * Recebe os dados no corpo da requisição (JSON)
     */
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    /*
     * Método para atualizar um usuário existente.
     * 
     * PUT /usuarios/{id}
     * Atualiza os dados com base no ID informado
     */
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    /*
     * Método para deletar um usuário.
     * 
     * DELETE /usuarios/{id}
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}