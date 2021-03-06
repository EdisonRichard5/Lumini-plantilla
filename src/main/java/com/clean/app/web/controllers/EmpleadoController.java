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

import com.clean.app.web.models.entities.Empleado;
import com.clean.app.web.models.services.IEmpleadoService;

@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("title", "Registro de un nuevo empleado");
		model.addAttribute("empleado", empleado);
		return "empleado/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado", empleado);
		return "empleado/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Empleado empleado = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ empleado.getNombre());
		model.addAttribute("empleado", empleado);
		return "empleado/form";		
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
		return "redirect:/empleado/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Empleado empleado, Model model,
			RedirectAttributes flash) {
		try {
			service.save(empleado);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/empleado/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Empleado> lista = service.findAll();
		model.addAttribute("title", "Listado de Empleados");
		model.addAttribute("lista", lista);
		return "empleado/list";		
	} 

}
