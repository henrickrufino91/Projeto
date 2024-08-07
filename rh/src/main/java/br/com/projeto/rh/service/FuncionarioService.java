package br.com.projeto.rh.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.rh.DTO.FuncionarioDTO;
import br.com.projeto.rh.model.Funcionario;
import br.com.projeto.rh.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	public void inserir(Funcionario funcionario) {
		
		funcionarioRepository.save(funcionario);
	}
	
	
	
	public void excluir(Funcionario funcionario) {
		
		funcionarioRepository.delete(funcionario);
	}
	
	
	
	public List<Funcionario> listar(){
		
		return funcionarioRepository.findByTodos();
	}
	
	
	
	public Funcionario editar(Integer codigo) {
		
		  Optional<Funcionario> us = funcionarioRepository.findById(codigo);
			
		  Funcionario funcionario = null;
		  
		  if (us.isPresent()) {
			  
			  funcionario = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Funcionario não existe :: " + codigo);
		  }
		  
		  return funcionario;
		}
	
	
	

	
	public Funcionario buscarPorId(Integer codigo) {
		
		return funcionarioRepository.findById(codigo).get();
	}
	
	
	public List<Funcionario> listaPorNome(String nome){
		
		return funcionarioRepository.findByNome(nome);
	}
	
	
	public List<Funcionario> listaPorSalario(Double salario1,Double salario2){
		
		return funcionarioRepository.findBySalario(salario1, salario2);
	}
	
	

	public List<FuncionarioDTO> listaPorGastos(){
		return funcionarioRepository.consulta();
	}
	
	
	
	
	
}
