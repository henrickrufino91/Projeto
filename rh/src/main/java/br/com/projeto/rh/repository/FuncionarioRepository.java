package br.com.projeto.rh.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.rh.DTO.FuncionarioDTO;
import br.com.projeto.rh.model.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query("select f from Funcionario f where f.nomeFuncionario like %?1% ")
	List<Funcionario> findByNome(String nome);
	
	@Query("select f from Funcionario f where f.salario between :salario1 and :salario2 ")
	List<Funcionario> findBySalario(Double salario1,Double salario2);
	
	
	@Query("select f from Funcionario f")
	List<Funcionario> findByTodos();
	
	
	

	@Query("select new br.com.projeto.rh.DTO.FuncionarioDTO(SUM(f.salario) as total, d.nomeDepartamento as nome)"
			+ " from Funcionario f,Cargos c,Departamento d"
			+ " where d.codDepartamento = c.departamento.codDepartamento and c.codCargo = f.cargos.codCargo"
			+ " group by d.nomeDepartamento")
	List<FuncionarioDTO> consulta();
	
	
	
	
}
