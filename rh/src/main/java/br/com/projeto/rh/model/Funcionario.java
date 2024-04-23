package br.com.projeto.rh.model;

import java.time.LocalDate;
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
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFuncionario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private String nomeFuncionario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private Double salario;
	
	
	@NotBlank(message = "Campo não pode ser vazio")
	@NotNull(message = "Campo não pode ser vazio")
	@NotEmpty(message = "Campo não pode ser vazio")
	private LocalDate dataEntrada;
	
	
	
	private LocalDate dataSaida;
	
	
	@ManyToOne
	@JoinColumn(name = "Cargos_codigo",nullable = false)
	private Cargos cargos;


	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Funcionario(Integer codigo,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") String nome,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") LocalDate dataNascimento,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") Double salario,
			@NotBlank(message = "Campo não pode ser vazio") @NotNull(message = "Campo não pode ser vazio") @NotEmpty(message = "Campo não pode ser vazio") LocalDate dataEntrada,
			LocalDate dataSaida, Cargos cargos) {
		super();
		this.codFuncionario = codigo;
		this.nomeFuncionario = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.cargos = cargos;
	}


	public Integer getCodigo() {
		return codFuncionario;
	}


	public void setCodigo(Integer codigo) {
		this.codFuncionario = codigo;
	}


	public String getNome() {
		return nomeFuncionario;
	}


	public void setNome(String nome) {
		this.nomeFuncionario = nome;
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
		return "Funcionario [codigo=" + codFuncionario + ", nome=" + nomeFuncionario + ", dataNascimento=" + dataNascimento + ", salario="
				+ salario + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", cargos=" + cargos + "]";
	}
	
	
}
