package com.adail.suporte.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * Classe que representa a entidade Tecnico no sistema.
 * 
 * Essa entidade corresponde aos profissionais responsáveis
 * por atender os chamados abertos pelos usuários.
 * 
 * Assim como Usuario, essa classe será transformada em uma
 * tabela no banco de dados.
 */
@Entity // Indica que essa classe é uma entidade JPA (tabela no banco)
public class Tecnico {

    /*
     * Identificador único do técnico.
     * 
     * @Id -> chave primária
     * @GeneratedValue -> valor gerado automaticamente pelo banco
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do técnico/analista
    private String nome;

    // Email do técnico (utilizado para identificação)
    private String email;

    /*
     * Especialidade do técnico.
     * Exemplo: Suporte N1, Analista de Sistemas, Infraestrutura, etc.
     */
    private String especialidade;

    // Indica se o técnico está ativo no sistema
    private boolean ativo;

    // Data em que o técnico foi cadastrado
    private LocalDate dataCadastro;

    /*
     * Construtor vazio obrigatório para o funcionamento do JPA.
     */
    public Tecnico() {
    }

    /*
     * Construtor com parâmetros para facilitar a criação do objeto.
     */
    public Tecnico(Long id, String nome, String email, String especialidade, boolean ativo, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters (responsáveis por acessar e modificar os dados)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}