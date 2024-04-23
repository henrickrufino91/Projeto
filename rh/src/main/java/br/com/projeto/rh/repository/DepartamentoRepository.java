package br.com.projeto.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.rh.model.Departamento;
import java.util.List;


public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

	@Query("select d from Departamento d where d.nomeDepartamento like %?1% ")
	List<Departamento> findByNome(String nome);
	
	
	
	
	
	
	
	
}
