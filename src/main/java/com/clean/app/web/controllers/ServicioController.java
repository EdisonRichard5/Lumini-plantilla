package com.clean.app.web.controllers;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clean.app.web.models.entities.Servicio;
import com.clean.app.web.models.services.IServicioService;
import com.clean.app.web.reporting.LlaveValor;

@Controller
@RequestMapping(value="/servicio")
public class ServicioController {
	@Autowired
	private IServicioService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Servicio servicio = new Servicio();
		model.addAttribute("title", "Registro de un nuevo Servicio");
		model.addAttribute("servicio", servicio);
		return "servicio/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Servicio servicio = service.findById(id);
		model.addAttribute("servicio", servicio);
		return "servicio/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Servicio servicio = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ servicio.getTipo());
		model.addAttribute("servicio", servicio);
		return "servicio/form";		
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
		return "redirect:/servicio/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Servicio servicio, Model model,
			RedirectAttributes flash) {
		try {
			service.save(servicio);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/servicio/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Servicio> lista = service.findAll();
		model.addAttribute("title", "Listado de Servicios");
		model.addAttribute("lista", lista);
		return "servicio/list";		
	} 
	

	@GetMapping(value = "/report")
	public String report(Model model) {		
		model.addAttribute("title", "Reporte");
		return "servicio/report";
	}



	@GetMapping(value = "/loadData/{id}", produces="application/json")
	public @ResponseBody List<LlaveValor> loadData(@PathVariable(value = "id") Integer id) {	
		List<LlaveValor> lista = service.countServicio(id);
		return lista;
	}

	

}
