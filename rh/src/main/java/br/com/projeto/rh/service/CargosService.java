package br.com.projeto.rh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.rh.model.Cargos;

import br.com.projeto.rh.repository.CargosRepository;

@Service
public class CargosService {

	
	@Autowired
	private CargosRepository cargosRepository;
	
	
	
	
	public void inserir(Cargos cargos) {
		
		cargosRepository.save(cargos);
	}
	
	
	
	public void excluir(Cargos cargos) {
		
		cargosRepository.delete(cargos);
	}
	
	
	
	public List<Cargos> listar(){
		
		return cargosRepository.findAll();
	}
	
	
	
	public Cargos editar(Integer codigo) {
		
		  Optional<Cargos> us = cargosRepository.findById(codigo);
			
		  Cargos cargos = null;
		  
		  if (us.isPresent()) {
			  
			  cargos = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Cargo não existe :: " + codigo);
		  }
		  
		  return cargos;
		}
	
	
	public Cargos buscarPorID(Integer codigo) {
		
		return cargosRepository.findById(codigo).get();
	}
	
	
	
	
	
	
}
