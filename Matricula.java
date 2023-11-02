package Entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Matricula")
public class Matricula {

	

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	  
	  @ManyToOne
	    @JoinColumn(name = "cpf")
	    private Aluno aluno;
	  
	   @ManyToOne
	    @JoinColumn(name = "cnpj")
	    private Escola escola;

	private Date dataMatricula;
	   
	   // Construtores, getters e setters
	   
	   public Matricula() {
	        this.dataMatricula = new Date(id); // Define a data de matrícula como a data atual por padrão.
	    }

	    public Matricula(Aluno aluno, Escola escola) {
	        this.aluno = aluno;
	        this.escola = escola;
	        this.dataMatricula = new Date(id); // Define a data de matrícula como a data atual por padrão.
	    }
	    
	    // Getters e setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Aluno getAluno() {
	        return aluno;
	    }

	    public void setAluno(Aluno aluno) {
	        this.aluno = aluno;
	    }

	    public Escola getEscola() {
	        return escola;
	    }

	    public void setEscola(Escola escola) {
	        this.escola = escola;
	    }

	    public Date getDataMatricula() {
	        return dataMatricula;
	    }

	    public void setDataMatricula(Date dataMatricula) {
	        this.dataMatricula = dataMatricula;
	    }

		public boolean isTransferencia() {
			
			return false;
		}

		public boolean isExclusao() {
			
			return false;
		}
	   

}