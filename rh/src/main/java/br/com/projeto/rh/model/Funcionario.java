package br.com.projeto.rh.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFuncionario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@Column(nullable = false)
	private String nomeFuncionario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@NotBlank(message = "Campo não pode ser vazio")
	@Column(nullable = false)
	private Double salario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@Column(nullable = false)
	private LocalDate dataEntrada;
	
	
	@Column(nullable = true)
	private LocalDate dataSaida;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(nullable = false)
	private Cargos cargos;


	public Funcionario(Integer codFuncionario, @NotBlank(message = "Campo não pode ser vazio") String nomeFuncionario,
			@NotBlank(message = "Campo não pode ser vazio") LocalDate dataNascimento,
			@NotBlank(message = "Campo não pode ser vazio") Double salario,
			@NotBlank(message = "Campo não pode ser vazio") LocalDate dataEntrada, LocalDate dataSaida, Cargos cargos) {
		super();
		this.codFuncionario = codFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.cargos = cargos;
	}


	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodFuncionario() {
		return codFuncionario;
	}


	public void setCodFuncionario(Integer codFuncionario) {
		this.codFuncionario = codFuncionario;
	}


	public String getNomeFuncionario() {
		return nomeFuncionario;
	}


	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Cargos getCargos() {
		return cargos;
	}


	public void setCargos(Cargos cargos) {
		this.cargos = cargos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codFuncionario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(codFuncionario, other.codFuncionario);
	}


	@Override
	public String toString() {
		return "Funcionario [codFuncionario=" + codFuncionario + ", nomeFuncionario=" + nomeFuncionario
				+ ", dataNascimento=" + dataNascimento + ", salario=" + salario + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + ", cargos=" + cargos + "]";
	}


}
