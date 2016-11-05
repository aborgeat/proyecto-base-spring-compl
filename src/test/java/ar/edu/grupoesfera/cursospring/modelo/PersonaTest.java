package ar.edu.grupoesfera.cursospring.modelo;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.grupoesfera.cursospring.SpringTest;

public class PersonaTest extends SpringTest{

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void lis2tar(){
//		System.out.println("2 " + getSession().createCriteria(Persona.class).list().size());
//	}
	
	@Test
	@Transactional // para que corra dentro de un contexto de una transaccion de BD
	@Rollback(true)// cuando se termina de ejecutar el test borra los datos de test y no los deja en la bd
	               // para hacer un rollback hay que poner el @transactional
	public void testPersona(){
		Persona seba = new Persona();
		seba.setApellido("Ismael");
		seba.setEmail("seba@seba.com");
		seba.setNombre("Sebastian");
        // aca  seba.id is NULl  
		getSession().save(seba); // aca es donde se usa la session de la session Factory
       //Luego de ejecutar esta sentencias genera el Id lo guarda en la BD con ID=1

		
//		getSession().flush();
//		getSession().getTransaction().commit();
		assertThat(getSession().get(Persona.class, seba.getId())).isNotNull();
	                       //  .get Busca un Objeto por su ID
		
		System.out.println(getSession().get(Persona.class, seba.getId()).getId());
		System.out.println(getSession().get(Persona.class, 1L).getApellido());
		
		Persona miPersona = getSession().get(Persona.class, 1L);
		miPersona.setApellido("borgeat");
		System.out.println(miPersona.getApellido());
		getSession().save(miPersona);
		miPersona.setApellido("molaro");
		System.out.println(getSession().get(Persona.class, 1L).getApellido());
		miPersona.setApellido("martinez"); 
		System.out.println(getSession().get(Persona.class, 1L).getApellido());
		
	}
}

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void listar(){
//	
//		System.out.println("1 " + getSession().createCriteria(Persona.class).list().size());
//	}
