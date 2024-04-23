package br.com.projeto.rh.DTO;

import br.com.projeto.rh.model.Cargos;

public class FuncionarioDTO {

	
	private String nome,nom;
	
	
	private Double salario;
	
	
	private Double total;
	
	
	private Cargos cargos;


	public FuncionarioDTO(String nome, String nom, Double salario, Double total, Cargos cargos) {
		super();
		this.nome = nome;
		this.nom = nom;
		this.salario = salario;
		this.total = total;
		this.cargos = cargos;
	}


	public FuncionarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Cargos getCargos() {
		return cargos;
	}


	public void setCargos(Cargos cargos) {
		this.cargos = cargos;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	


	
	
}
