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

import com.clean.app.web.models.entities.Master;
import com.clean.app.web.models.services.IMasterService;

@Controller
@RequestMapping(value="/master")
public class MasterController {
	@Autowired
	private IMasterService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Master master = new Master();
		model.addAttribute("title", "Registro Master");
		model.addAttribute("master", master);
		return "master/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Master master = service.findById(id);
		model.addAttribute("master", master);
		return "master/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Master master = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ master.getObservacion());
		model.addAttribute("master", master);
		return "master/form";		
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
		return "redirect:/master/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Master master, Model model,
			RedirectAttributes flash) {
		try {
			service.save(master);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/master/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Master> lista = service.findAll();
		model.addAttribute("title", "Listado Master");
		model.addAttribute("master", lista);
		return "master/list";		
	} 
}
