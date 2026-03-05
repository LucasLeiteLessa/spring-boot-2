package org.example.atividade1.controller;

import org.example.atividade1.model.Curso;
import org.example.atividade1.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por tratar as requisições HTTP relacionadas a Cursos.
 *
 * @RestController      - Indica que esta classe é um REST controller que retorna JSON.
 * @RequestMapping  - Define o prefixo "/cursos" para todas as rotas deste controller.
 * @RequiredArgsConstructor - Lombok: injeta automaticamente as dependências via construtor.
 */
@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    /**
     * GET /cursos
     * Lista todos os cursos cadastrados e retorna como JSON.
     */
    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.listarTodos();
        return ResponseEntity.ok(cursos);
    }

    /**
     * GET /cursos/{id}
     * Busca um curso pelo ID e retorna como JSON.
     *
     * @PathVariable - Captura o valor {id} da URL.
     * Exemplo: /cursos/1 → id = 1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        try {
            Curso curso = cursoService.buscarPorId(id);
            return ResponseEntity.ok(curso);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * POST /cursos
     * Cria um novo curso com os dados do corpo da requisição em JSON.
     *
     * @param curso - Objeto preenchido automaticamente com os dados do JSON.
     */
    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        Curso saved = cursoService.salvar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * PUT /cursos/{id}
     * Atualiza os dados de um curso existente.
     *
     * @PathVariable - Captura o valor {id} da URL.
     * @RequestBody  - Mapeia o corpo da requisição JSON para o objeto Curso.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        try {
            Curso existing = cursoService.buscarPorId(id);
            existing.setNome(curso.getNome());
            Curso saved = cursoService.salvar(existing);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /cursos/{id}
     * Exclui um curso pelo ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            cursoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
