package Controoler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entidades.Aluno;
import Service.AlunoService;

@RestController
@RequestMapping("/alunos")
@Validated
public class AlunoController {
	 private final AlunoService alunoService;

	    @Autowired
	    public AlunoController(AlunoService alunoService) {
	        this.alunoService = alunoService;
	    }

	    @PostMapping
	    public ResponseEntity<Aluno> criarAluno(@RequestBody @Validated Aluno aluno) {
	        Aluno novoAluno = alunoService.criarAluno(aluno);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
	    }

	    @GetMapping("/{cpf}")
	    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long cpf) {
	        Aluno aluno = alunoService.buscarAluno(cpf);

	        if (aluno != null) {
	            return ResponseEntity.ok(aluno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/{cpf}")
	    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long cpf, @RequestBody @Validated Aluno alunoAtualizado) {
	        Aluno aluno = alunoService.atualizarAluno(cpf, alunoAtualizado);

	        if (aluno != null) {
	            return ResponseEntity.ok(aluno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarAluno(@PathVariable Long cpf) {
	        alunoService.deletarAluno(cpf);
	        return ResponseEntity.noContent().build();
	    }
}

   