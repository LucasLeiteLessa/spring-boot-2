package org.example.atividade1.controller;

import org.example.atividade1.model.Aluno;
import org.example.atividade1.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller responsável por tratar as requisições HTTP relacionadas a Estudantes.
 *
 * O Controller é a camada que recebe as requisições do navegador,
 * chama a camada de serviço para processar a lógica e retorna a view (página HTML).
 *
 * Fluxo: Navegador → Controller → Service → Repository → Banco de Dados
 *
 * @RestController      - Indica que esta classe é um REST controller que retorna JSON.
 * @RequestMapping  - Define o prefixo "/api/estudantes" para todas as rotas deste controller.
 * @RequiredArgsConstructor - Lombok: injeta automaticamente as dependências via construtor.
 */
@RestController
@RequestMapping("/api/estudantes")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    /**
     * GET /api/estudantes/{matricula}
     * Busca um estudante pela matrícula
     */
    @GetMapping("/{matricula}")
    public ResponseEntity<Map<String, Object>> buscarPorMatricula(@PathVariable String matricula) {
        try {
            Aluno aluno = alunoService.buscarPorMatricula(matricula);
            Map<String, Object> response = Map.of(
                    "matricula", aluno.getMatricula(),
                    "nome", aluno.getNome(),
                    "curso", aluno.getCurso().getNome(),
                    "semestre", aluno.getSemestre() != null ? aluno.getSemestre() : 1
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET /api/estudantes
     * Lista todos os estudantes
     */
    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok(alunos);
    }

    /**
     * POST /api/estudantes
     * Cria um novo estudante com os dados do corpo da requisição em JSON.
     *
     * @param aluno - Objeto preenchido automaticamente com os dados do JSON.
     */
    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno saved = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * PUT /api/estudantes/{id}
     * Atualiza os dados de um estudante existente.
     *
     * @PathVariable - Captura o valor {id} da URL.
     * @RequestBody  - Mapeia o corpo da requisição JSON para o objeto Aluno.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            Aluno existing = alunoService.buscarPorId(id);
            existing.setNome(aluno.getNome());
            existing.setEmail(aluno.getEmail());
            existing.setMatricula(aluno.getMatricula());
            existing.setCurso(aluno.getCurso());
            Aluno saved = alunoService.salvar(existing);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/estudantes/{id}
     * Exclui um estudante pelo ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            alunoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET /api/estudantes/saudacao/{id}
     * Retorna uma saudação personalizada em JSON.
     */
    @GetMapping("/saudacao/{id}")
    public ResponseEntity<Map<String, String>> saudacao(@PathVariable Long id) {
        try {
            Aluno aluno = alunoService.buscarPorId(id);
            Map<String, String> response = Map.of("saudacao", "Olá, " + aluno.getNome() + "! Bem-vindo(a) ao Spring Boot!");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}