package br.com.projeto.rh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.rh.model.Departamento;

import br.com.projeto.rh.service.DepartamentoService;

@Controller
public class DepartamentoController {

	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	
	@GetMapping(value = "/novoDepartamento")
	public String novoDepartamento(Model model) {
		
		model.addAttribute("departamento", new Departamento());
		
		
		return "novoDepartamento";
	}
	
	
	@PostMapping(value = "/inserirDepartamento")
	public String inserir(@Valid Departamento departamento,Model model) {
		
		if (departamento != null) {
			
			departamentoService.inserir(departamento);
						
			
		}else {
			
			model.addAttribute("msg", "Favor preencha os campos corretamente");
		}
		
				
		return "redirect:/novoDepartamento";
	}
	
	
	@GetMapping(value = "/listaDepartamentos")
	public String listar(Model model) {
		
		model.addAttribute("departamentos", departamentoService.listar());
		
		return "/listaDepartamentos";
	}
	
	
	
	@GetMapping("/editarDepartamento")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editarDepartamento");
    
        Departamento departamento = departamentoService.buscarPorId(codigo);
        mv.addObject("departamento",  departamento);
               
        return mv;
   
    }
		
	
	@GetMapping("/removerDepartamento")
    public String remover(@RequestParam Integer codigo){
        
		Departamento departamento = departamentoService.buscarPorId(codigo);
		departamentoService.excluir(departamento);
		
        

        return "redirect:/listaDepartamentos";
    }
	
	
	
}
