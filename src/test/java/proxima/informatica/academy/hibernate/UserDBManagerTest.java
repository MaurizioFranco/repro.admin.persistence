/**
 * 
 */
package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.UserDto;

/**
 * @author maurizio
 *
 */
public class UserDBManagerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(UserDBManagerTest.class);
	
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		UserDto user = new UserDto();
    	user.setEmail("giammarco.lucchetti@hotmail.it");
    	user.setPassword("ciao");
    	user.setFirstname("Giammarco");
    	user.setLastname("Lucchetti");
    	user.setEnabled(false);
    	user.setRole(0);
    	user.setDateofbirth(Date.valueOf(LocalDate.now()));
    	user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        Object generatedIdentifier = session.save(user);
//        logger.debug("insertNewUser - DEBUG - generatedIdentifier" + ((Integer)generatedIdentifier).intValue());
        int id_inserted_value = ((Integer)generatedIdentifier).intValue();
        session.getTransaction().commit();
        session.close();
    	
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
	}
	
}
