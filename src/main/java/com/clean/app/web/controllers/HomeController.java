package com.clean.app.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clean.app.web.models.services.UsuarioService;


@Controller
@RequestMapping(value="/")
public class HomeController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("framework", "Lumini SPA");
		model.addAttribute("title", "Ven relajate, disfruta.");				
		model.addAttribute("description", "SystemClean");
		return "home";
	}

	@GetMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "El usuario ya tiene una sesión activa.");
			return "redirect:/";
		}		
		if(error != null) {
			model.addAttribute("error", "Usuario o contraseña incorrectas");
		}				
		return "login";
	}
	

}
