package proxima.informatica.academy.hibernate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

import proxima.informatica.academy.dto.AbstractCommonDto;
import proxima.informatica.academy.dto.SurveyDto;

/**
 * @author matteo.peruzza@gmail.com
 */

public class SurveyDBManagerTest {

	private final static Logger logger = LoggerFactory.getLogger(SurveyDBManagerTest.class);

	@Test
	public void testInsertOk() {

		logger.debug("#########");
		logger.debug("TEST INSERT");
		logger.debug("#########");
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION");

		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
		logger.debug("#########");
		logger.debug("TEST INSERT");
		logger.debug("#########");

	}

	@Test
	public void testDeleteAll() {

		logger.debug("#########");
		logger.debug("TEST DELETE ALL - START");
		logger.debug("#########");
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		logger.debug("#########");
		logger.debug("TEST DELETE ALL - END");
		logger.debug("#########");

	}

	@Test
	public void testSelectAllEmpty() {

		logger.debug("#########");
		logger.debug("TEST SELECT ALL EMPTY- START");
		logger.debug("#########");
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
		assertTrue( returnValue );
		int selectAllSize = SurveyManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
		assertTrue( selectAllSize==0 );
		logger.debug("#########");
		logger.debug("TEST SELECT ALL EMPTY- END");
		logger.debug("#########");

	}

	@Test
	public void testSelectAllForOne() {

		logger.debug("#########");
		logger.debug("TEST SELECT ALL FOR ONE - START");
		logger.debug("#########");
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
		logger.debug("#########");
		logger.debug("TEST SELECT ALL FOR ONE - END");
		logger.debug("#########");

	}

	@Test
	public void testDelete() {

		logger.debug("#########");
		logger.debug("TEST DELETE - START");
		logger.debug("#########");
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
		logger.debug("#########");
		logger.debug("TEST DELETE - END");
		logger.debug("#########");
		
	}
	
	@Test
	public void testSelectById () {
		
		logger.debug("#########");
		logger.debug("TEST SELECTBYID - START");
		logger.debug("#########");
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
		survey = SurveyManager.selectAll().get(0);
		assertTrue( survey != null);
		logger.debug("#########");
		logger.debug("TEST SELECTBYID - END");
		logger.debug("#########");
		
	}
	
	@Test
	public void testUpdate() {
		
		logger.debug("#########");
		logger.debug("TEST UPDATE - START");
		logger.debug("#########");
		
		boolean returnValue = SurveyManager.deleteAll();
		logger.debug("#########");
		logger.debug("TEST UPDATE - DEBUG 1 - @Test --> deleteAll: " + returnValue);
		logger.debug("#########");
		assertTrue( returnValue );
		
		SurveyDto survey = new SurveyDto();
		survey.setLabel("testLabel");
		survey.setTime(1l);
		survey.setDescription("TEST DESCRIPTION");
		int id_inserted_value = SurveyManager.insert(survey);
		logger.debug("#########");
		logger.debug("TEST UPDATE - DEBUG 2 - @Test --> insert: " + id_inserted_value);
		logger.debug("#########");
		assertTrue(id_inserted_value > 0);
		
		survey = SurveyManager.selectById(id_inserted_value);
		logger.debug("#########");
		logger.debug("TEST UPDATE - DEBUG 4 - @Test --> selectById: " + survey);
		logger.debug("#########");
		survey.setDescription("NEW DESCRIPTION");
		logger.debug("#########");
		logger.debug("TEST UPDATE - DEBUG 5 - @Test --> trying to update: " + survey);
		logger.debug("#########");
		AbstractCommonDto updatedItem = SurveyManager.update(survey) ;
		logger.debug("#########");
		logger.debug("TEST UPDATE - DEBUG 6 - @Test --> updatedItem: " + updatedItem);
		logger.debug("#########");
		assertTrue(SurveyManager.selectAll().size()==1);
		survey = SurveyManager.selectAll().get(0);
		assertTrue(survey.getDescription().equals("NEW DESCRIPTION"));
		
		logger.debug("#########");
		logger.debug("TEST UPDATE - END");
		logger.debug("#########");
		
	}

}
