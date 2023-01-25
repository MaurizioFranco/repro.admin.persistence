package proxima.informatica.academy.hibernate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

import proxima.informatica.academy.dto.SurveyDto;

/**
 * @author matteo.peruzza@gmail.com
 */

public class SurveyDBManagerTest {

	private final static Logger logger = LoggerFactory.getLogger(SurveyDBManagerTest.class);
	
	@Test
	public void test2() {
		
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
		
	}
	
}
