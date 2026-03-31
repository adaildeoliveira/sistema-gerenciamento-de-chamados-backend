package com.adail.suporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adail.suporte.model.Tecnico;
import com.adail.suporte.repository.TecnicoRepository;

/*
 * Controller responsável por gerenciar as requisições relacionadas
 * à entidade Tecnico.
 * 
 * Aqui são definidos os endpoints da API para realizar operações
 * de CRUD (Create, Read, Update, Delete) dos técnicos.
 */
@RestController // Indica que essa classe é um controller REST
@RequestMapping("/tecnicos") // Define o caminho base da API
public class TecnicoController {

    /*
     * Repository responsável por acessar o banco de dados.
     * O Spring injeta automaticamente essa dependência.
     */
    @Autowired
    private TecnicoRepository repository;

    /*
     * Método para listar todos os técnicos.
     * 
     * GET /tecnicos
     */
    @GetMapping
    public List<Tecnico> listar() {
        return repository.findAll();
    }

    /*
     * Método para buscar um técnico pelo ID.
     * 
     * GET /tecnicos/{id}
     */
    @GetMapping("/{id}")
    public Tecnico buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /*
     * Método para criar um novo técnico.
     * 
     * POST /tecnicos
     * Recebe os dados no corpo da requisição (JSON)
     */
    @PostMapping
    public Tecnico criar(@RequestBody Tecnico tecnico) {
        return repository.save(tecnico);
    }

    /*
     * Método para atualizar um técnico existente.
     * 
     * PUT /tecnicos/{id}
     */
    @PutMapping("/{id}")
    public Tecnico atualizar(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        tecnico.setId(id);
        return repository.save(tecnico);
    }

    /*
     * Método para deletar um técnico.
     * 
     * DELETE /tecnicos/{id}
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}