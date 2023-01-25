package proxima.informatica.academy.hibernate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

import java.util.List;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.SurveyDto;

/**
 * @author matteo.peruzza@gmail.com
 */

public class SurveyDBManagerTest {

	private final static Logger logger = LoggerFactory.getLogger(SurveyDBManagerTest.class);

	@Test
	public void testInsertOk() {

		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION");

		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");

	}

	@Test
	public void testDeleteAll() {

		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		boolean returnValue = SurveyManager.deleteAll();
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
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		int selectAllSize = SurveyManager.selectAll().size();
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
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		int selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==0 );
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(10001l);
		survey.setDescription("TEST DESCRIPTION");
		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue( id_inserted_value>0 );        
		selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==1 );
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");

	}

	@Test
	public void testDelete() {

		System.out.println("#########");
		System.out.println("TEST DELETE - START");
		System.out.println("#########");
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		int selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==0 );
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION"); 
		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
		selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==1 );
		SurveyManager.delete(survey);
		selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==0 );
		System.out.println("#########");
		System.out.println("TEST DELETE - END");
		System.out.println("#########");
		
	}
	
	@Test
	public void testSelectById () {
		
		System.out.println("#########");
		System.out.println("TEST SELECTBYID - START");
		System.out.println("#########");
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		int selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==0 );
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION"); 
		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
		List<SurveyDto> selectAll = SurveyManager.selectAll();
		survey = SurveyManager.selectById(selectAll.get(0).getId());
		assertTrue( survey != null);
		System.out.println("#########");
		System.out.println("TEST SELECTBYID - END");
		System.out.println("#########");
		
	}

}
