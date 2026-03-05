package org.example.atividade1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Classe que representa a entidade "Curso" no banco de dados.
 *
 * @Entity    - Indica ao JPA que esta classe é uma entidade (será mapeada para uma tabela).
 * @Table     - Define o nome da tabela no banco de dados.
 * @Data      - Lombok: gera automaticamente getters, setters, toString, equals e hashCode.
 * @NoArgsConstructor  - Lombok: gera um construtor sem argumentos (exigido pelo JPA).
 * @AllArgsConstructor - Lombok: gera um construtor com todos os atributos.
 */
@Entity
@Table(name = "cursos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    /**
     * Chave primária da tabela.
     * @Id              - Marca este campo como a chave primária.
     * @GeneratedValue  - O valor será gerado automaticamente pelo banco de dados (auto-incremento).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do curso
     * @Column - Permite configurar detalhes da coluna (nullable = false significa que é obrigatório).
     */
    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * Relacionamento inverso com Aluno (One-to-Many).
     * Um curso tem vários alunos matriculados.
     *
     * @OneToMany - Um curso possui múltiplos alunos.
     * mappedBy - Indica que o relacionamento é mapeado pelo atributo "curso" na classe Aluno.
     */
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

}