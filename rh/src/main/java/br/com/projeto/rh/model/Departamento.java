package br.com.projeto.rh.model;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;


import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDepartamento;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@Column(nullable = false)
	private String nomeDepartamento;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "departamento",cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Cargos> cargos;


	public Departamento(Integer codDepartamento,
			@NotBlank(message = "Campo não pode ser vazio") String nomeDepartamento, List<Cargos> cargos) {
		super();
		this.codDepartamento = codDepartamento;
		this.nomeDepartamento = nomeDepartamento;
		this.cargos = cargos;
	}


	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodDepartamento() {
		return codDepartamento;
	}


	public void setCodDepartamento(Integer codDepartamento) {
		this.codDepartamento = codDepartamento;
	}


	public String getNomeDepartamento() {
		return nomeDepartamento;
	}


	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}


	public List<Cargos> getCargos() {
		return cargos;
	}


	public void setCargos(List<Cargos> cargos) {
		this.cargos = cargos;
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
		return "Departamento [codDepartamento=" + codDepartamento + ", nomeDepartamento=" + nomeDepartamento
				+ ", cargos=" + cargos + "]";
	}


}
