package Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Entidades.Aluno;
import Entidades.Escola;
import Entidades.Matricula;
import Repository.MatriculaRepository;
import jakarta.transaction.Transactional;

public class MatriculaService {
    private final MatriculaRepository matriculaRepository;

    @Autowired
    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }
    
    @Transactional
    public Matricula criarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
    
    @Transactional
    public Matricula buscarMatricula(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }
    
    @Transactional
    public Matricula atualizarMatricula(Long id, Matricula matriculaAtualizada) {
        Matricula matriculaExistente = matriculaRepository.findById(id).orElse(null);

        if (matriculaExistente != null) {
            matriculaExistente.setAluno(matriculaAtualizada.getAluno());
            matriculaExistente.setEscola(matriculaAtualizada.getEscola());
            return matriculaRepository.save(matriculaExistente);
        }

        return null;
    }
    
    @Transactional
    public void deletarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }

	public Aluno buscarAluno(Long alunoIcpf) {
		return null;
	}

	public List<Matricula> getAllMatriculas() {
		return null;
	}

	public List<Matricula> getMatriculasPorEscolaEData(Escola escola, LocalDate dataSelecionada) {
		return null;
	}

	public long countMatriculasAtivasPorEscolaEData(Escola escola, LocalDate dataSelecionada) {
		return 0;
	}

	}


	