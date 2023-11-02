package Controoler;

import java.util.List;

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

import Entidades.Matricula;
import Repository.MatriculaRepository;
import Service.MatriculaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/matriculas")
@Validated
public class MatriculaController {
	   private final MatriculaService matriculaService;

	    @Autowired
	    public MatriculaController(MatriculaService matriculaService) {
	        this.matriculaService = matriculaService;
	    }
	    
	    @PostMapping
	    public ResponseEntity<Matricula> criarMatricula(@RequestBody @Validated Matricula matricula) {
	        Matricula novaMatricula = matriculaService.criarMatricula(matricula);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Matricula> buscarMatricula(@PathVariable Long id) {
	        Matricula matricula = matriculaService.buscarMatricula(id);

	        if (matricula != null) {
	            return ResponseEntity.ok(matricula);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Matricula> atualizarMatricula(@PathVariable Long id, @RequestBody @Validated Matricula matriculaAtualizada) {
	        Matricula matricula = matriculaService.atualizarMatricula(id, matriculaAtualizada);

	        if (matricula != null) {
	            return ResponseEntity.ok(matricula);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
	        matriculaService.deletarMatricula(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @Transactional
	    public List<Matricula> buscarMatriculasPorAlunoOuEscola(Long alunocpf, Long escolacnpj) {
	        return MatriculaRepository.findByAlunoIdOrEscolaId(alunocpf, escolacnpj);
	    }
}
