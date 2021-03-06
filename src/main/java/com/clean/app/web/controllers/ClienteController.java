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

import com.clean.app.web.models.entities.Cliente;
import com.clean.app.web.models.services.IClienteService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	@Autowired
	private IClienteService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("title", "Registro de un nuevo cliente");
		model.addAttribute("cliente", cliente);
		return "cliente/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = service.findById(id);
		model.addAttribute("cliente", cliente);
		return "cliente/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ cliente.getNombre());
		model.addAttribute("cliente", cliente);
		return "cliente/form";		
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
		return "redirect:/cliente/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Cliente cliente, Model model,
			RedirectAttributes flash) {
		try {
			service.save(cliente);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/cliente/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cliente> lista = service.findAll();
		model.addAttribute("title", "Listado de Clientes");
		model.addAttribute("lista", lista);
		return "cliente/list";		
	} 

}
