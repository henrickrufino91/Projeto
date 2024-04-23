package br.com.projeto.rh.model;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import jakarta.persistence.Column;
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
	@Column(nullable = false)
	private String nomeCargo;


	@ManyToOne
	@JoinColumn(name = "Departamento_codigo",nullable = false)
	private Departamento departamento;


	public Cargos(Integer codCargo,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") String nomeCargo,
			Departamento departamento) {
		super();
		this.codCargo = codCargo;
		this.nomeCargo = nomeCargo;
		this.departamento = departamento;
	}


	public Cargos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodCargo() {
		return codCargo;
	}


	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}


	public String getNomeCargo() {
		return nomeCargo;
	}


	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
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
		return "Cargos [codCargo=" + codCargo + ", nomeCargo=" + nomeCargo + ", departamento=" + departamento + "]";
	}


	
	
}
