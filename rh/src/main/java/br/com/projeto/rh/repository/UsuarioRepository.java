package br.com.projeto.rh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.rh.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	
	@Query("select j from Usuario j where j.login = :login and j.senha = :senha")
	public Usuario buscarLogin(String login,String senha);
	
	
	
	
	
}
