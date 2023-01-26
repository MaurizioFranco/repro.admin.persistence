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
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.SurveyDto;
import proxima.informatica.academy.dto.SurveyquestionsDto;
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
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
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
	public void testDeleteAllOK() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        int id_inserted_value_surveyreplies = SurveyrepliesManager.insert(surveyreplies);
		logger.debug("@Test --> inserted: " + id_inserted_value_surveyreplies);
        assertTrue( id_inserted_value_surveyreplies >0 );	
        session.beginTransaction();
		boolean returnValue = SurveyrepliesManager.deleteAll();
		session.getTransaction().commit();
		session.close();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testDeleteOK() {
		System.out.println("#########");
		System.out.println("TEST DELETE");
		System.out.println("#########");
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        assertTrue(SurveyrepliesManager.insert(surveyreplies)>0);
        SurveyrepliesManager.delete(surveyreplies);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		assertTrue(SurveyquestionsManager.selectAll().size() == 0);
	}
	
	@Test
	public void testSelectAllEmptyOK() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        assertTrue(SurveyrepliesManager.insert(surveyreplies)>0);
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
	public void testSelectAllOK() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL - START");
		System.out.println("#########");
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        assertTrue(SurveyrepliesManager.insert(surveyreplies)>0);
        session.getTransaction().commit();
        session.close();
        int selectAllSize = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize>0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllForOneOK() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
		int selectAllSurveyReplies = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> returnValue: " + selectAllSurveyReplies);
		assertTrue( selectAllSurveyReplies == 0 );
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        assertTrue(SurveyrepliesManager.insert(surveyreplies)>0);
        session.getTransaction().commit();
        session.close();       
        int selectAllSize = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==1 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectByIdOK () {
		
		System.out.println("#########");
		System.out.println("TEST SELECTBYID - START");
		System.out.println("#########");
		boolean deleteSurveyReplies = SurveyrepliesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurveyReplies);
		assertTrue( deleteSurveyReplies );
		boolean deleteSurvey = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteSurvey);
		assertTrue( deleteSurvey );
		boolean deleteUser = UserManager.deleteAll();
		logger.debug("@Test --> returnValue: " + deleteUser);
		assertTrue( deleteUser );
		int selectAllSurveyReplies = SurveyrepliesManager.selectAll().size();
		logger.debug("@Test --> returnValue: " + selectAllSurveyReplies);
		assertTrue( selectAllSurveyReplies == 0 );
		SurveyrepliesDto surveyreplies = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        assertTrue(SurveyrepliesManager.insert(surveyreplies)>0);
        session.getTransaction().commit();
        session.close();
		List<SurveyrepliesDto> selectAll = SurveyrepliesManager.selectAll();
		surveyreplies = SurveyrepliesManager.selectById(selectAll.get(0).getId());
		assertTrue( surveyreplies != null);
		System.out.println("#########");
		System.out.println("TEST SELECTBYID - END");
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
