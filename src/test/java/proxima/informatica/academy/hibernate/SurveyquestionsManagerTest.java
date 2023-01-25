package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyquestionsDto;

public class SurveyquestionsManagerTest {
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManagerTest.class);
	
	@Test
	public void insertTest() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);
    	
    	int id_inserted_value = SurveyquestionsManager.insert(sq);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
	}
}
