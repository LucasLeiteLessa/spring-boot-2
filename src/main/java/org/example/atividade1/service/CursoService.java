package org.example.atividade1.service;

import org.example.atividade1.model.Curso;
import org.example.atividade1.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de serviço (Service) para a entidade Curso.
 *
 * A camada de serviço contém a lógica de negócio da aplicação.
 * Ela fica entre o Controller (que recebe as requisições) e o Repository (que acessa o banco).
 *
 * Essa separação em camadas (Controller → Service → Repository) é uma boa prática
 * que facilita manutenção, testes e reuso de código.
 *
 * @Service            - Marca esta classe como um componente de serviço do Spring.
 * @RequiredArgsConstructor - Lombok: gera um construtor com todos os atributos "final",
 *                           permitindo que o Spring faça a injeção de dependência automaticamente.
 */
@Service
@RequiredArgsConstructor
public class CursoService {

    // O Spring injeta automaticamente a implementação do repository aqui.
    private final CursoRepository cursoRepository;

    /**
     * Retorna todos os cursos cadastrados.
     */
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    /**
     * Busca um curso pelo ID.
     * Lança uma exceção caso não encontre (evita retornar null).
     */
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
    }

    /**
     * Salva um novo curso ou atualiza um existente.
     * O método save() do JPA verifica: se o objeto tem ID, ele atualiza; se não tem, ele insere.
     */
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    /**
     * Remove um curso pelo ID.
     */
    public void excluir(Long id) {
        // Verificamos se o curso existe antes de deletar
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado com o ID: " + id);
        }
        cursoRepository.deleteById(id);
    }
}

