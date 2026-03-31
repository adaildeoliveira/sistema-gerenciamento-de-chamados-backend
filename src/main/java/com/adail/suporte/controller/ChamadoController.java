package com.adail.suporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adail.suporte.dto.ChamadoRequest;
import com.adail.suporte.model.Chamado;
import com.adail.suporte.model.Usuario;
import com.adail.suporte.model.Tecnico;
import com.adail.suporte.repository.ChamadoRepository;
import com.adail.suporte.repository.UsuarioRepository;
import com.adail.suporte.repository.TecnicoRepository;

/*
 * Controller responsável por gerenciar as requisições relacionadas
 * à entidade Chamado.
 * 
 * Essa é a principal parte da API, pois aqui acontece o controle
 * dos chamados e o relacionamento com usuário e técnico.
 */
@RestController // Define como controller REST
@RequestMapping("/chamados") // Caminho base da API
public class ChamadoController {

    /*
     * Repository do chamado, responsável por acessar o banco.
     */
    @Autowired
    private ChamadoRepository repository;

    /*
     * Repository do usuário, utilizado para buscar o usuário
     * pelo ID informado na requisição.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /*
     * Repository do técnico, utilizado para buscar o técnico
     * pelo ID informado na requisição.
     */
    @Autowired
    private TecnicoRepository tecnicoRepository;

    /*
     * Método para listar todos os chamados.
     * 
     * GET /chamados
     */
    @GetMapping
    public List<Chamado> listar() {
        return repository.findAll();
    }

    /*
     * Método para buscar um chamado pelo ID.
     * 
     * GET /chamados/{id}
     */
    @GetMapping("/{id}")
    public Chamado buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /*
     * Método para criar um novo chamado.
     * 
     * POST /chamados
     * 
     * Utiliza a classe ChamadoRequest para receber os dados,
     * incluindo apenas os IDs do usuário e do técnico.
     */
    @PostMapping
    public Chamado criar(@RequestBody ChamadoRequest request) {

        /*
         * Busca o usuário no banco com base no ID informado
         */
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElse(null);

        /*
         * Busca o técnico no banco com base no ID informado
         */
        Tecnico tecnico = tecnicoRepository.findById(request.getTecnicoId()).orElse(null);

        /*
         * Cria um novo objeto Chamado e preenche os dados
         */
        Chamado chamado = new Chamado();
        chamado.setTitulo(request.getTitulo());
        chamado.setDescricao(request.getDescricao());
        chamado.setDataAbertura(request.getDataAbertura());
        chamado.setStatus(request.getStatus());
        chamado.setPrioridade(request.getPrioridade());

        /*
         * Define o relacionamento com usuário e técnico
         */
        chamado.setUsuario(usuario);
        chamado.setTecnico(tecnico);

        /*
         * Salva o chamado no banco de dados
         */
        return repository.save(chamado);
    }

    /*
     * Método para atualizar um chamado existente.
     * 
     * PUT /chamados/{id}
     */
    @PutMapping("/{id}")
    public Chamado atualizar(@PathVariable Long id, @RequestBody ChamadoRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElse(null);
        Tecnico tecnico = tecnicoRepository.findById(request.getTecnicoId()).orElse(null);

        Chamado chamado = new Chamado();
        chamado.setId(id);
        chamado.setTitulo(request.getTitulo());
        chamado.setDescricao(request.getDescricao());
        chamado.setDataAbertura(request.getDataAbertura());
        chamado.setStatus(request.getStatus());
        chamado.setPrioridade(request.getPrioridade());
        chamado.setUsuario(usuario);
        chamado.setTecnico(tecnico);

        return repository.save(chamado);
    }

    /*
     * Método para deletar um chamado.
     * 
     * DELETE /chamados/{id}
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}