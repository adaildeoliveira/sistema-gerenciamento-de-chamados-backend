package com.adail.suporte.dto;

import java.time.LocalDate;

/*
 * Classe DTO (Data Transfer Object) utilizada para receber
 * os dados enviados nas requisições de criação e atualização
 * de chamados.
 * 
 * Essa classe não representa uma tabela no banco, ela serve
 * apenas como "intermediária" entre o Insomnia (requisição)
 * e a entidade Chamado.
 * 
 * O principal objetivo dela é simplificar o envio dos dados,
 * utilizando apenas os IDs do usuário e do técnico.
 */
public class ChamadoRequest {

    // Título do chamado
    private String titulo;

    // Descrição do problema informado pelo usuário
    private String descricao;

    // Data em que o chamado foi aberto
    private LocalDate dataAbertura;

    // Status do chamado (Aberto, Em andamento, Fechado)
    private String status;

    // Prioridade do chamado (1 = baixa, 2 = média, 3 = alta)
    private int prioridade;

    /*
     * ID do usuário que abriu o chamado.
     * 
     * Aqui usamos apenas o ID em vez de enviar o objeto inteiro,
     * facilitando a requisição no Insomnia.
     */
    private Long usuarioId;

    /*
     * ID do técnico responsável pelo chamado.
     * 
     * Assim como o usuário, utilizamos apenas o ID para simplificar
     * o envio e evitar erros de conversão de JSON.
     */
    private Long tecnicoId;

    /*
     * Construtor vazio obrigatório.
     */
    public ChamadoRequest() {
    }

    // Getters e Setters (utilizados para acessar e modificar os dados)

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Long tecnicoId) {
        this.tecnicoId = tecnicoId;
    }
}