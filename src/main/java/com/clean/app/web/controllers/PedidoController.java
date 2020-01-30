package com.clean.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clean.app.web.models.entities.Pedido;
import com.clean.app.web.models.services.IPedidoService; 

@Controller
@RequestMapping(value="/pedido")
public class PedidoController {
	@Autowired
	private IPedidoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("title", "Registro de un nuevo Pedido");
		model.addAttribute("pedido", pedido);
		return "pedido/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Pedido pedido = service.findById(id);
		model.addAttribute("pedido", pedido);
		return "pedido/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Pedido pedido = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ pedido.getServicio() +" "+ pedido.getCostefinal());
		model.addAttribute("pedido", pedido);
		return "pedido/form";		
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
		return "redirect:/pedido/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Pedido pedido, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				 				
				if(pedido.getServicio() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}				
				return"pedido/form";
			}			
			service.save(pedido);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Pedido> lista = service.findAll();
		model.addAttribute("title", "Listado de Pedidos");
		model.addAttribute("lista", lista);
		return "pedido/list";		
	} 

}
