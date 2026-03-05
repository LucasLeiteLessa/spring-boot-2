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
 * Controller responsável por tratar as requisições HTTP relacionadas a Alunos.
 *
 * O Controller é a camada que recebe as requisições do navegador,
 * chama a camada de serviço para processar a lógica e retorna a view (página HTML).
 *
 * Fluxo: Navegador → Controller → Service → Repository → Banco de Dados
 *
 * @RestController      - Indica que esta classe é um REST controller que retorna JSON.
 * @RequestMapping  - Define o prefixo "/alunos" para todas as rotas deste controller.
 * @RequiredArgsConstructor - Lombok: injeta automaticamente as dependências via construtor.
 */
@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    /**
     * GET /alunos
     * Lista todos os alunos cadastrados e retorna como JSON.
     */
    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok(alunos);
    }

    /**
     * GET /alunos/{id}
     * Busca um aluno pelo ID e retorna como JSON.
     *
     * @PathVariable - Captura o valor {id} da URL.
     * Exemplo: /alunos/1 → id = 1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        try {
            Aluno aluno = alunoService.buscarPorId(id);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * POST /alunos
     * Cria um novo aluno com os dados do corpo da requisição em JSON.
     *
     * @param aluno - Objeto preenchido automaticamente com os dados do JSON.
     */
    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno saved = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * PUT /alunos/{id}
     * Atualiza os dados de um aluno existente.
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
     * DELETE /alunos/{id}
     * Exclui um aluno pelo ID.
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
     * GET /alunos/saudacao/{id}
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