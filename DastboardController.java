package Controoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Entidades.Aluno;
import Entidades.Escola;
import Entidades.Matricula;
import Service.AlunoService;
import Service.EscolaService;
import Service.MatriculaService;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EscolaService escolaService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Matricula> matriculas = matriculaService.getAllMatriculas();
        List<Aluno> alunos = alunoService.getAllAlunos();
        List<Escola> escolas = escolaService.getAllEscolas();

        long numeroDeTransferenciasMatricula = 0;
        long numeroDeExclusoesMatricula = 0;
        long numeroDeTransferenciasAluno = 0;
        long numeroDeExclusoesAluno = 0;

        for (Matricula matricula : matriculas) {
            if (matricula.isTransferencia()) {
                numeroDeTransferenciasMatricula++;
            }
            if (matricula.isExclusao()) {
                numeroDeExclusoesMatricula++;
            }
        }

        for (Aluno aluno : alunos) {
            if (aluno.isTransferencia()) {
                numeroDeTransferenciasAluno++;
            }
            if (aluno.isExclusao()) {
                numeroDeExclusoesAluno++;
            }
        }

        model.addAttribute("matriculas", matriculas);
        model.addAttribute("alunos", alunos);
        model.addAttribute("escolas", escolas);
        model.addAttribute("numeroTransferenciasMatricula", numeroDeTransferenciasMatricula);
        model.addAttribute("numeroExclusoesMatricula", numeroDeExclusoesMatricula);
        model.addAttribute("numeroTransferenciasAluno", numeroDeTransferenciasAluno);
        model.addAttribute("numeroExclusoesAluno", numeroDeExclusoesAluno);

        return "dashboard";
    }
}
