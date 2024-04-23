package br.com.projeto.rh.model;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departamento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDepartamento;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private String nomeDepartamento;


	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Departamento(Integer codigo,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") String nome) {
		super();
		this.codDepartamento = codigo;
		this.nomeDepartamento = nome;
	}


	public Integer getCodigo() {
		return codDepartamento;
	}


	public void setCodigo(Integer codigo) {
		this.codDepartamento = codigo;
	}


	public String getNome() {
		return nomeDepartamento;
	}


	public void setNome(String nome) {
		this.nomeDepartamento = nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codDepartamento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(codDepartamento, other.codDepartamento);
	}


	@Override
	public String toString() {
		return "Departamento [codigo=" + codDepartamento + ", nome=" + nomeDepartamento + "]";
	}
	
	
	
}
