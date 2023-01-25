/**
 * 
 */
package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.SurveyDto;
import proxima.informatica.academy.dto.SurveyrepliesDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * @author maurizio
 *
 */
public class SurveyrepliesDBManagerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(SurveyrepliesDBManagerTest.class);
	
	@Test
	public void testInsertOK() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		
		assertTrue(SurveyrepliesManager.deleteAll());
		assertTrue(SurveyManager.deleteAll());
		assertTrue(UserManager.deleteAll());
		
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        int id_inserted_value_surveyreplies = SurveyrepliesManager.insert(surveyreplies);
        session.getTransaction().commit();
        session.close();
		logger.debug("@Test --> inserted: " + id_inserted_value_surveyreplies);
        assertTrue( id_inserted_value_surveyreplies >0 );
	}
	
	@Test
	public void testDeleteAll() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        int id_inserted_value_surveyreplies = SurveyrepliesManager.insert(surveyreplies);
		logger.debug("@Test --> inserted: " + id_inserted_value_surveyreplies);
        assertTrue( id_inserted_value_surveyreplies >0 );
			
		boolean returnValue = SurveyrepliesManager.deleteAll();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllEmpty() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		
		SurveyrepliesDto surveyreplies = new SurveyrepliesDto();
		BigInteger surveyreplies_id = new BigInteger("5");
		BigInteger userreplies_id = new BigInteger("37");
		surveyreplies.setSurvey_id(surveyreplies_id);
		surveyreplies.setUser_id(userreplies_id);
		Session session = DBManager.getSessionFactory().openSession();
        int id_inserted_value_surveyreplies = SurveyrepliesManager.insert(surveyreplies);
        assertTrue( id_inserted_value_surveyreplies >0 );
		
        boolean returnValue = SurveyrepliesManager.deleteAll();
        logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        int selectAllSize = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY- END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllForOne() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean returnValue = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        SurveyrepliesDto survey = new SurveyrepliesDto();
        BigInteger survey_id = new BigInteger("1");
		BigInteger user_id = new BigInteger("33");
		survey.setSurvey_id(survey_id);
		survey.setUser_id(user_id);
    	int id_inserted_value = SurveyrepliesManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );        
        selectAllSize = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==1 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
	
	
	
	public SurveyrepliesDto insertAllTables() {
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION");
		int id_inserted_value_survey = SurveyManager.insert(survey);
		assertTrue( id_inserted_value_survey >0 );
		
		UserDto user = new UserDto();
    	user.setEmail("giammarclucchetti@hotmail.it");
    	user.setPassword("ciao");
    	user.setFirstname("Giammarco");
    	user.setLastname("Lucchetti");
    	user.setEnabled(false);
    	user.setRole(0);
    	user.setDateofbirth(Date.valueOf(LocalDate.now()));
    	user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	int id_inserted_value_user = UserManager.insert(user);
    	assertTrue( id_inserted_value_user >0 );
		
		SurveyrepliesDto surveyreplies = new SurveyrepliesDto();
		String survey_id = String.valueOf(survey.getId());
		String user_id = String.valueOf(user.getId());
		BigInteger surveyreplies_id = new BigInteger(survey_id);
		BigInteger userreplies_id = new BigInteger(user_id);
		surveyreplies.setSurvey_id(surveyreplies_id);
		surveyreplies.setUser_id(userreplies_id);
		return surveyreplies;
	}
}
