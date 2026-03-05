package org.example.atividade1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa a entidade "Aluno" no banco de dados.
 *
 * @Entity    - Indica ao JPA que esta classe é uma entidade (será mapeada para uma tabela).
 * @Table     - Define o nome da tabela no banco de dados.
 * @Data      - Lombok: gera automaticamente getters, setters, toString, equals e hashCode.
 * @NoArgsConstructor  - Lombok: gera um construtor sem argumentos (exigido pelo JPA).
 * @AllArgsConstructor - Lombok: gera um construtor com todos os atributos.
 */
@Entity
@Table(name = "alunos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    /**
     * Chave primária da tabela.
     * @Id              - Marca este campo como a chave primária.
     * @GeneratedValue  - O valor será gerado automaticamente pelo banco de dados (auto-incremento).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do aluno.
     * @Column - Permite configurar detalhes da coluna (nullable = false significa que é obrigatório).
     */
    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * E-mail do aluno (deve ser único na tabela).
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * Matrícula do aluno (identificador acadêmico único).
     */
    @Column(nullable = false, unique = true, length = 20)
    private String matricula;

    /**
     * Relacionamento com Curso (Many-to-One).
     * Vários alunos podem estar matriculados no mesmo curso.
     *
     * @ManyToOne - Um aluno pertence a um curso.
     * @JoinColumn - Define a coluna de chave estrangeira (curso_id).
     * @FetchType.LAZY - Carrega o curso sob demanda (melhor performance).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

}