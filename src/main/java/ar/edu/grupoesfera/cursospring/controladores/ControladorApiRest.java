package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoesfera.cursospring.modelo.Persona;
import ar.edu.grupoesfera.cursospring.servicios.PersonaService;

@RestController
public class ControladorApiRest {

	@Inject
	private PersonaService personaService;
	
	@RequestMapping(name="/personas", method = RequestMethod.GET)
	public List<Persona> test(){
		Persona seba = new Persona();
		seba.setApellido("Ismael");
		seba.setEmail("seba@seba.com");
		seba.setNombre("Sebastian");
		personaService.guardar(seba);
		List<Persona> personas = this.personaService.listarTodas();
		return personas;
	}
	
	@RequestMapping("/persona/{id}")
	public Persona helloWorld2(@PathVariable Long id) {
		return this.personaService.buscarPorId(id);
	}
}
