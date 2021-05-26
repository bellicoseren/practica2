package mx.com.bellicose.centre.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import mx.com.bellicose.centre.entities.Rol;
import mx.com.bellicose.centre.entities.User;

@SpringBootTest
//@ContextConfiguration
public class UserTest {
	private static final Logger log = LogManager.getLogger(UserTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarUsuario(){
		log.debug(">Entrando a debeGuardarUsuario <");
		
	
		User u = new User();
		
		log.debug(">Creo Usuario <");
		u.setEdad(23);
		u.setNombre("Benjamin");
		u.setSexo("F");
		u.setTelefono("5565373222");
		u.setApellidoMaterno("Morales");
		u.setApellidoPaterno("Gomez");
		u.setCorreo("mogo@gmail.com");
		u.setDireccion("selene num 43");
		
		Rol r = new Rol();
		r.setNombre("profesor");
		Rol r2 = new Rol();
		r2.setNombre("administrador");
		Rol r3 = new Rol();
		r3.setNombre("alumno");
		
		List<Rol> roles = new ArrayList<>();
		roles.add(r);
		roles.add(r3);
		u.setRoles(roles);

		
		em.persist(u);
		em.flush();

	
	}
}
