package br.com.projeto.rh.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projeto.rh.exception.ServiceEXC;
import br.com.projeto.rh.model.Usuario;
import br.com.projeto.rh.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping(value = "/")
	public String login(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		return "/login";
	}
	
	
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		return "/index";
	}
	
	
	
	
	
	
	@PostMapping(value = "/logar")
	 public String login(@Valid Usuario usuario,Model model, BindingResult br,
	                              HttpSession session) throws NoSuchAlgorithmException, ServiceEXC {
	      
		 		 
	        Usuario userLogin = usuarioService.login(usuario.getLogin(), usuario.getSenha());
	       
	       
	        if(userLogin != null) {
	        	
	        	session.setAttribute("usuarioLogado", userLogin);
	        	  
	        	return "index";
	        } else {
	        	
	        	model.addAttribute("msg", "Login ou senha está incorreto");
	        	
	            return "login";
	        }

	     
	    }
	
	
	
	 	@GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        
	        return "redirect:/";
	    }
	
	
	
	
	
	
	
	
	
}
