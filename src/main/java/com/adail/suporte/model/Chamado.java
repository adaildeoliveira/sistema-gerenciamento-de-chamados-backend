package com.adail.suporte.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/*
 * Classe que representa a entidade Chamado no sistema.
 * 
 * Essa é a principal entidade do projeto, pois representa
 * o registro de um problema ou solicitação de suporte.
 * 
 * Além dos dados do chamado, essa classe também faz o relacionamento
 * com as entidades Usuario e Tecnico, ligando quem abriu o chamado
 * a quem será responsável pelo atendimento.
 */
@Entity // Indica que essa classe será transformada em tabela no banco de dados
public class Chamado {

    /*
     * Identificador único do chamado.
     * 
     * @Id -> define a chave primária
     * @GeneratedValue -> informa que o banco gera esse valor automaticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título resumido do chamado
    private String titulo;

    // Descrição detalhada do problema relatado
    private String descricao;

    // Data em que o chamado foi aberto
    private LocalDate dataAbertura;

    /*
     * Status atual do chamado.
     * Exemplos: Aberto, Em andamento, Fechado
     */
    private String status;

    /*
     * Prioridade do chamado.
     * Exemplo:
     * 1 = baixa
     * 2 = média
     * 3 = alta
     */
    private int prioridade;

    /*
     * Relacionamento com a entidade Usuario.
     * 
     * @ManyToOne indica que muitos chamados podem estar ligados
     * a um único usuário.
     * 
     * Exemplo:
     * Um mesmo usuário pode abrir vários chamados.
     */
    @ManyToOne
    private Usuario usuario;

    /*
     * Relacionamento com a entidade Tecnico.
     * 
     * @ManyToOne indica que muitos chamados podem ser atendidos
     * por um único técnico.
     * 
     * Exemplo:
     * Um técnico pode ser responsável por vários chamados.
     */
    @ManyToOne
    private Tecnico tecnico;

    /*
     * Construtor vazio obrigatório para o JPA.
     */
    public Chamado() {
    }

    /*
     * Construtor com parâmetros para facilitar a criação
     * de objetos chamados já com todos os dados preenchidos.
     */
    public Chamado(Long id, String titulo, String descricao, LocalDate dataAbertura, String status, int prioridade,
                   Usuario usuario, Tecnico tecnico) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.prioridade = prioridade;
        this.usuario = usuario;
        this.tecnico = tecnico;
    }

    // Getters e Setters (responsáveis por acessar e modificar os dados da classe)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}