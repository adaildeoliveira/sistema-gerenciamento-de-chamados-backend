package com.adail.suporte.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * Classe que representa a entidade Usuario no sistema.
 * 
 * Essa classe será mapeada para uma tabela no banco de dados,
 * onde cada objeto Usuario corresponde a um registro.
 * 
 * O usuário é quem pode abrir chamados dentro do sistema.
 */
@Entity // Indica que essa classe é uma entidade JPA (tabela no banco)
public class Usuario {

    /*
     * Identificador único do usuário.
     * 
     * @Id -> define como chave primária da tabela
     * @GeneratedValue -> indica que o valor será gerado automaticamente pelo banco
     * GenerationType.IDENTITY -> usa auto incremento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do usuário que utiliza o sistema
    private String nome;

    // Email do usuário (utilizado para identificação/login)
    private String email;

    // Setor ou departamento do usuário (ex: Financeiro, Vendas, TI)
    private String setor;

    // Senha de acesso do usuário ao sistema
    private String senha;

    // Indica se o usuário está ativo (true) ou inativo (false)
    private boolean ativo;

    // Data em que o usuário foi cadastrado no sistema
    private LocalDate dataCadastro;

    /*
     * Construtor vazio obrigatório para o funcionamento do JPA.
     * O framework utiliza esse construtor para criar objetos automaticamente.
     */
    public Usuario() {
    }

    /*
     * Construtor com parâmetros.
     * Permite criar um usuário já com todos os dados preenchidos.
     */
    public Usuario(Long id, String nome, String email, String setor, String senha, boolean ativo, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
        this.senha = senha;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    // Métodos getters e setters (usados para acessar e modificar os dados)

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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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