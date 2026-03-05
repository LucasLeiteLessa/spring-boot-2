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
            // Criar cursos
            Curso cursoBCC = new Curso(null, "Engenharia de Software", null);
            Curso cursoCC = new Curso(null, "Ciência da Computação", null);
            Curso cursoSI = new Curso(null, "Sistemas de Informação", null);

            cursoBCC = cursoRepository.save(cursoBCC);
            cursoCC = cursoRepository.save(cursoCC);
            cursoSI = cursoRepository.save(cursoSI);

            // Criar alunos vinculados aos cursos
            alunoRepository.save(new Aluno(null, "Eduardo Longen Correa", "eduardo.longen@email.com", "20222720", cursoBCC));
            alunoRepository.save(new Aluno(null, "Maria Bordignon", "maria.bordignon@email.com", "2025002", cursoCC));
            alunoRepository.save(new Aluno(null, "Daemon Targaryen", "daemon@email.com", "2025003", cursoSI));

            System.out.println(">>> Dados iniciais carregados com sucesso!");
            System.out.println(">>> Cursos criados: " + cursoRepository.count());
            System.out.println(">>> Alunos criados: " + alunoRepository.count());
        }
    }
}