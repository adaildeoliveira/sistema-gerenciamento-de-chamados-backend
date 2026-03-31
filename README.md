### Diagrama de Classes do Sistema

```mermaid
classDiagram
    class Usuario {
        -Long id
        -String nome
        -String email
        -String setor
        -String senha
        -boolean ativo
        -LocalDate dataCadastro
    }

    class Tecnico {
        -Long id
        -String nome
        -String email
        -String especialidade
        -boolean ativo
        -LocalDate dataCadastro
    }

    class Chamado {
        -Long id
        -String titulo
        -String descricao
        -LocalDate dataAbertura
        -String status
        -int prioridade
        -Usuario usuario
        -Tecnico tecnico
    }

    Chamado "0..*" --> "1" Usuario : abre
    Chamado "0..*" --> "1" Tecnico : atende
