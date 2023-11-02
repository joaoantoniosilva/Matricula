package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Escola")
public class Escola {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	  private Long cnpj;
	  
	  @NotBlank(message = "O campo nome é obrigatório")
	    private String nome;
	  
	  @NotBlank(message = "O campo endereço é obrigatório")
	    private String endereco;

	    @NotBlank(message = "O campo cidade é obrigatório")
	    private String cidade;

	    @NotBlank(message = "O campo estado é obrigatório")
	    private String estado;
	    
	    // Construtores, getters e setters

	    public Escola() {
	    }

	    public Escola(String nome, String endereco, String cidade, String estado) {
	        this.nome = nome;
	        this.endereco = endereco;
	        this.cidade = cidade;
	        this.estado = estado;
	    }
	    
	    // Getters e Setters
	    public Long getId() {
	        return cnpj;
	    }

	    public void setId(Long cnpj) {
	        this.cnpj = cnpj;
	    }
	    
	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getEndereco() {
	        return endereco;
	    }

	    public void setEndereco(String endereco) {
	        this.endereco = endereco;
	    }

	    public String getCidade() {
	        return cidade;
	    }

	    public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	
}
