package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Entidades.Aluno;
import Repository.AlunoRepository;
import jakarta.transaction.Transactional;

public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    @Transactional
    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno buscarAluno(Long cpf) {
        return alunoRepository.findById(cpf).orElse(null);
    }
    
    @Transactional
    public Aluno atualizarAluno(Long cpf, Aluno alunoAtualizado) {
        Aluno alunoExistente = alunoRepository.findById(cpf).orElse(null);

        if (alunoExistente != null) {
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setIdade(alunoAtualizado.getIdade());
            return alunoRepository.save(alunoExistente);
        }
		return alunoExistente;
  
        
    }
    @Transactional
    public void deletarAluno(Long cpf) {
        alunoRepository.deleteById(cpf);
    }

	public List<Aluno> getAllAlunos() {
		return null;
	}


}
    
