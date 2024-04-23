package br.com.projeto.rh.model;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cargos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCargo;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private String nomeCargo;


	@ManyToOne
	@JoinColumn(name = "Departamento_codigo",nullable = false)
	private Departamento departamento;


	public Cargos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cargos(Integer codigo,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") String nome,
			Departamento departamento) {
		super();
		this.codCargo = codigo;
		this.nomeCargo = nome;
		this.departamento = departamento;
	}


	public Integer getCodigo() {
		return codCargo;
	}


	public void setCodigo(Integer codigo) {
		this.codCargo = codigo;
	}


	public String getNome() {
		return nomeCargo;
	}


	public void setNome(String nome) {
		this.nomeCargo = nome;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codCargo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargos other = (Cargos) obj;
		return Objects.equals(codCargo, other.codCargo);
	}


	@Override
	public String toString() {
		return "Cargos [codigo=" + codCargo + ", nome=" + nomeCargo + ", departamento=" + departamento + "]";
	}
	
	
	
}
