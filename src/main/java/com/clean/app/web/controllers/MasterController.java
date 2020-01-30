package com.clean.app.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clean.app.web.models.entities.Cliente; 
import com.clean.app.web.models.entities.Master;
import com.clean.app.web.models.entities.Pedido;
import com.clean.app.web.models.entities.Servicio;
import com.clean.app.web.models.entities.Usuario;
import com.clean.app.web.models.services.ClienteService;
import com.clean.app.web.models.services.IMasterService;
import com.clean.app.web.models.services.ServicioService;
import com.clean.app.web.models.services.UsuarioService;
 

@Controller
@RequestMapping(value="/master")

@SessionAttributes({"detalles"})
public class MasterController {
	@Autowired
	private IMasterService service;
	@Autowired
	private ClienteService srvSocio;
	@Autowired
	private ServicioService srvMetodoPago;
	@Autowired
	private UsuarioService srvUsuario;
	
	
	
	@GetMapping(value="/create/{id}")
	public String create(Model model, @PathVariable(value="id") Integer id) {
		Master master = new Master();
		master.setPersonaid(id);	
		Cliente cliente = srvSocio.findById(id);
		List<Usuario> usuarios = srvUsuario.findAll();
		List<Servicio> tipos = srvMetodoPago.findAll();
		model.addAttribute("title", "Nuevo registro para " + cliente);
		model.addAttribute("cliente", cliente);
		model.addAttribute("detalles", new ArrayList<Pedido>());
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tipos", tipos);		
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
	public String save(@Valid Master master, 
			BindingResult result, Model model,
			RedirectAttributes mensaje
			, @SessionAttribute(value="detalles") List<Pedido> detalles
			, SessionStatus session){
		
		if(result.hasErrors()) {
			return "master/form";
		}
		
		Cliente cliente = srvSocio.findById(master.getPersonaid());
		master.setCliente(cliente);
		master.setDetalles(detalles);
		service.save(master);
		session.setComplete();		
		
		return "redirect:/";
	}
	
	@PostMapping(value="/addDetail", produces="application/json")
	public @ResponseBody List<Pedido> addDetail(@RequestBody Pedido detail, 
			@SessionAttribute(value="detalles") List<Pedido> detalles) {		
		Servicio servicio = srvMetodoPago.findById(detail.getIdpedido());
		detail.setServicio(servicio);		
		detalles.add(detail);		
		return detalles;		
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Master> lista = service.findAll();
		model.addAttribute("title", "Listado Master");
		model.addAttribute("master", lista);
		return "master/list";		
	} 
}
