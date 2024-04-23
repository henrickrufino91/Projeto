package br.com.projeto.rh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.rh.model.Departamento;

import br.com.projeto.rh.repository.DepartamentoRepository;

@Service
public class DepartamentoService {


	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	
	
	public void inserir(Departamento departamento) {
		
		departamentoRepository.save(departamento);
	}
	
	
	
	public void excluir(Departamento departamento) {
		
		departamentoRepository.delete(departamento);
	}
	
	
	
	public List<Departamento> listar(){
		
		return departamentoRepository.findAll();
	}
	
	
	
	public Departamento editar(Integer codigo) {
		
		  Optional<Departamento> us = departamentoRepository.findById(codigo);
			
		  Departamento departamento = null;
		  
		  if (us.isPresent()) {
			  
			  departamento = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Departamento não existe :: " + codigo);
		  }
		  
		  return departamento;
		}
	
	
	
	public Departamento buscarPorId(Integer codigo) {
		
		return departamentoRepository.findById(codigo).get();
	}
	
	
	
	public List<Departamento> listaPorNome(String nome){
		
		return departamentoRepository.findByNome(nome);
	}
	
	
	
	
	
	
	
	
	
	

}
