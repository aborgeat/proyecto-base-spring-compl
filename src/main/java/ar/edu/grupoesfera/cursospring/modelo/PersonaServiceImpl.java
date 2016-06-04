package ar.edu.grupoesfera.cursospring.modelo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.PersonaDao;
import ar.edu.grupoesfera.cursospring.servicios.PersonaService;

@Service("personaService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PersonaServiceImpl implements PersonaService{
	@Inject
	private PersonaDao personaDao;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void guardar(Persona persona){
		personaDao.save(persona);
	}
	
	public List<Persona> listarTodas(){
		return personaDao.findAll();
	}

	public Persona buscarPorId(Long id) {
		return personaDao.findById(id);
	}

}
