package com.clean.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clean.app.web.models.entities.Herramienta;
import com.clean.app.web.models.services.IHerramientaService;

@Controller
@RequestMapping(value="/herramienta")
public class HerramientaController {

	@Autowired
	private IHerramientaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Herramienta herramienta = new Herramienta();
		model.addAttribute("title", "Registro de un nuevo Servicio");
		model.addAttribute("herramienta", herramienta);
		return "herramienta/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Herramienta herramienta = service.findById(id);
		model.addAttribute("herramienta", herramienta);
		return "herramienta/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Herramienta herramienta = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ herramienta.getNombre());
		model.addAttribute("herramienta", herramienta);
		return "herramienta/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/herramienta/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Herramienta herramienta, Model model,
			RedirectAttributes flash) {
		try {
			service.save(herramienta);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/herramienta/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Herramienta> lista = service.findAll();
		model.addAttribute("title", "Listado de Herramientas");
		model.addAttribute("lista", lista);
		return "herramienta/list";		
	} 

}
