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
	private ClienteService srvCliente;
	@Autowired
	private ServicioService srvServicio;
	@Autowired
	private UsuarioService srvUsuario;
	
	
	
	@GetMapping(value="/create/{id}")
	public String create(Model model, @PathVariable(value="id") Integer id) {
		
			Master master = new Master();
		master.setClienteid(id);	
		Cliente cliente = srvCliente.findById(id);
		List<Usuario> usuarios = srvUsuario.findAll();
		List<Servicio> tipos = srvServicio.findAll();
		model.addAttribute("title", "Nuevo registro " );
		model.addAttribute("master", master);
		model.addAttribute("detalles", new ArrayList<Pedido>());
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tipos", tipos);		
		return "master/form";
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
		
		Cliente cliente = srvCliente.findById(master.getClienteid());
		master.setCliente(cliente);
		master.setDetalles(detalles);
		service.save(master);
		session.setComplete();		
		
		return "redirect:/";
	}
	
	@PostMapping(value="/addDetail", produces="application/json")
	public @ResponseBody List<Pedido> addDetail(@RequestBody Pedido detail, 
			@SessionAttribute(value="detalles") List<Pedido> detalles) {		
		Servicio servicio = srvServicio.findById(detail.getTipoexamenid());
		detail.setTipoServicio(servicio);	
		detalles.add(detail);		
		return detalles;		
	}
	
	
	
}
