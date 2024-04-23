package br.com.projeto.rh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.rh.model.Usuario;
import br.com.projeto.rh.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public void inserir(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}
	
	
	
	public void excluir(Integer codigo) {
		
		usuarioRepository.deleteById(codigo);
	}
	
	
	
	public List<Usuario> listar(){
		
		return usuarioRepository.findAll();
	}
	
	
	
	public Usuario editar(Integer codigo) {
		
		  Optional<Usuario> us = usuarioRepository.findById(codigo);
			
		  Usuario usuario = null;
		  
		  if (us.isPresent()) {
			  
			  usuario = us.get();
			  
		  }else {
			  
			  throw new RuntimeException(" Usuario não existe :: " + codigo);
		  }
		  
		  return usuario;
		}
	
	
	
	public Usuario login(String login,String senha) {
		
		return usuarioRepository.buscarLogin(login, senha);
	}
	
	
	
	public Usuario buscarPorId(Integer codigo) {
		
		return usuarioRepository.findById(codigo).get();
	}
	
	
	
	
	
	
}
