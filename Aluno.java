package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="Aluno")
public class Aluno {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long cpf;
	    private String nome;
	    private String sexo;
	    private int idade;
	    private int cep;
	    private int telefone;
	    private int rg;
	    
	    // Construtores, getters e setters

	    public Aluno() {
	    }

	    public Aluno(String nome, int idade) {
	        this.setNome(nome);
	        this.setIdade(idade);
	    }

	    
	    // Getters e setters
	   
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public int getCep() {
			return cep;
		}

		public void setCep(int cep) {
			this.cep = cep;
		}

		public int getTelefone() {
			return telefone;
		}

		public void setTelefone(int telefone) {
			this.telefone = telefone;
		}

		public int getRg() {
			return rg;
		}

		public void setRg(int rg) {
			this.rg = rg;
		}

		public boolean isTransferencia() {
			return false;
		}

		public boolean isExclusao() {
			return false;
		}
	    
	   
}