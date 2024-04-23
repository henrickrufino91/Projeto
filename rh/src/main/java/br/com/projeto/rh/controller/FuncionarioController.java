package br.com.projeto.rh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.rh.model.Funcionario;
import br.com.projeto.rh.service.CargosService;
import br.com.projeto.rh.service.FuncionarioService;




@Controller
public class FuncionarioController {

	
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargosService cargosService;
	
	
	@GetMapping(value = "/novoFuncionario")
	public String novoFuncionario(Model model) {
		
		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("carg", cargosService.listar());
		
		
		return "novoFuncionario";
	}
	
	
	@PostMapping(value = "/inserirFuncionario")
	public String inserir(@Valid Funcionario funcionario,Model model) {
		
		
		if (funcionario.getCodFuncionario() == null) {
			funcionarioService.inserir(funcionario);
		} else {
			Funcionario funcionario2 = funcionarioService.buscarPorId(funcionario.getCodFuncionario());
			funcionario2.setNomeFuncionario(funcionario.getNomeFuncionario());
			funcionario2.setSalario(funcionario.getSalario());
			funcionario2.setDataNascimento(funcionario.getDataNascimento());
			funcionario2.setDataEntrada(funcionario.getDataEntrada());
			funcionario2.setDataSaida(funcionario.getDataSaida());
			funcionario2.setCargos(funcionario.getCargos());
			
			funcionarioService.inserir(funcionario2);
			
		}
		
				
		return "redirect:/novoFuncionario";
	}
	
	
	@GetMapping(value = "/listaFuncionarios")
	public String listar(Model model,Funcionario funcionario) {
		
		model.addAttribute("funcionarios", funcionarioService.listar());
		model.addAttribute("funcionario", funcionario);
		
		return "/listaFuncionarios";
	}
	
	
	
	@GetMapping("/editarFuncionario")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editarFuncionario");
    
        Funcionario funcionario = funcionarioService.buscarPorId(codigo);
        mv.addObject("funcionario",  funcionario);
        mv.addObject("carg",  cargosService.listar());
       
        return mv;
   
    }
		
	
	@GetMapping("/removerFuncionario")
    public String remover(@RequestParam Integer codigo){
        
		Funcionario funcionario = funcionarioService.buscarPorId(codigo);
		funcionarioService.excluir(funcionario);
		
        

        return "redirect:/listaFuncionarios";
    }
	
	

	
	@PostMapping(value = "/listaNome")
	public ModelAndView listaPorNome(@RequestParam("nomePesquisa") String nomePesquisa) {
		
		ModelAndView modelAndView = new ModelAndView("listaFuncionarios");
		modelAndView.addObject("funcionarios", funcionarioService.listaPorNome(nomePesquisa));
		modelAndView.addObject("funcionario", new Funcionario());
		
		return modelAndView;
		
	}
	
	
	@PostMapping(value = "/listaSalario")
	public ModelAndView listaPorSalario(@RequestParam("salario1") Double salario1,
			@RequestParam("salario2") Double salario2) {
		
		ModelAndView modelAndView = new ModelAndView("listaFuncionarios");
		modelAndView.addObject("funcionarios", funcionarioService.listaPorSalario(salario1, salario2));
		modelAndView.addObject("funcionario", new Funcionario());
		
		return modelAndView;
		
	}
	
	

	@GetMapping(value = "/listaGastos")
	public ModelAndView listaPorNome() {
		
		ModelAndView modelAndView = new ModelAndView("listaDepartamentosGastos");
		modelAndView.addObject("funcionarioss", funcionarioService.listaPorGastos());
		modelAndView.addObject("funcionario", new Funcionario());
		
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
