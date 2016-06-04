package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Persona;

public interface PersonaService {

	void guardar(Persona persona);

	List<Persona> listarTodas();
	
	Persona buscarPorId(Long id);
}
