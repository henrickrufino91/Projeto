package br.com.projeto.rh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.rh.model.Cargos;

import br.com.projeto.rh.service.CargosService;
import br.com.projeto.rh.service.DepartamentoService;

@Controller
public class CargosController {

	
	@Autowired
	private CargosService cargosService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	
	@GetMapping(value = "/novoCargo")
	public String novoCargo(Model model) {
		
		model.addAttribute("cargo", new Cargos());
		model.addAttribute("departamentos", departamentoService.listar());
		
		
		return "novoCargo";
	}
	
	
	@PostMapping(value = "/inserirCargo")
	public String inserir(@Valid Cargos cargos,Model model) {
		
		if (cargos != null) {
			
			cargosService.inserir(cargos);
						
			
		}else {
			
			model.addAttribute("msg", "Favor preencha os campos corretamente");
		}
		
				
		return "redirect:/novoCargo";
	}
	
	
	@GetMapping(value = "/listaCargos")
	public String listar(Model model) {
		
		model.addAttribute("cargos", cargosService.listar());
		
		return "/listaCargos";
	}
	
	
	
	@GetMapping("/editarCargo")
    public ModelAndView editar(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editarCargo");
    
        Cargos cargos = cargosService.buscarPorID(codigo);
        mv.addObject("cargo",  cargos);
        mv.addObject("departamentos",  departamentoService.listar());
       
        return mv;
   
    }
		
	
	@GetMapping("/removerCargo")
    public String remover(@RequestParam Integer codigo){
        
		Cargos cargos = cargosService.buscarPorID(codigo);
		cargosService.excluir(cargos);
		
        

        return "redirect:/listaCargos";
    }
	

}
