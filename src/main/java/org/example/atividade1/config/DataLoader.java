package org.example.atividade1.config;

import org.example.atividade1.model.Aluno;
import org.example.atividade1.model.Curso;
import org.example.atividade1.repository.AlunoRepository;
import org.example.atividade1.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe que popula o banco de dados com dados iniciais para demonstração.
 *
 * CommandLineRunner é uma interface do Spring Boot que executa o método run()
 * automaticamente assim que a aplicação inicia. Ideal para carregar dados de exemplo.
 *
 * @Component - Marca como um componente gerenciado pelo Spring.
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    @Override
    public void run(String... args) {
        // Só insere dados se o banco estiver vazio (evita duplicação ao reiniciar)
        if (cursoRepository.count() == 0) {
            // Criar 5 cursos
            Curso curso1 = new Curso(null, "Engenharia de Software", null);
            Curso curso2 = new Curso(null, "Ciência da Computação", null);
            Curso curso3 = new Curso(null, "Sistemas de Informação", null);
            Curso curso4 = new Curso(null, "Análise e Desenvolvimento de Sistemas", null);
            Curso curso5 = new Curso(null, "Engenharia de Computação", null);

            curso1 = cursoRepository.save(curso1);
            curso2 = cursoRepository.save(curso2);
            curso3 = cursoRepository.save(curso3);
            curso4 = cursoRepository.save(curso4);
            curso5 = cursoRepository.save(curso5);

            // Criar alunos (mínimo 3) vinculados aos cursos com matrícula e semestre
            alunoRepository.save(new Aluno(null, "João Silva", "joao.silva@email.com", "20240001", 3, curso1));
            alunoRepository.save(new Aluno(null, "Maria Santos", "maria.santos@email.com", "20240002", 5, curso2));
            alunoRepository.save(new Aluno(null, "Pedro Oliveira", "pedro.oliveira@email.com", "20240003", 2, curso3));

            System.out.println(">>> Dados iniciais carregados com sucesso!");
            System.out.println(">>> Cursos criados: " + cursoRepository.count());
            System.out.println(">>> Alunos criados: " + alunoRepository.count());
        }
    }
}