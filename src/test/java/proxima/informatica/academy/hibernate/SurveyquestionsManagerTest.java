package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.QuestionsDto;
import proxima.informatica.academy.dto.SurveyDto;
import proxima.informatica.academy.dto.SurveyquestionsDto;

public class SurveyquestionsManagerTest {
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManagerTest.class);

	@Test
	public void deleteAllOK() {
		logger.debug("#########");
		logger.debug("TEST DELETE ALL");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsManager.insert(getFakeItem ());
		assertTrue(SurveyquestionsManager.deleteAll());
	}

//	@Test
//	public void insertOK() {
//		logger.debug("#########");
//		logger.debug("TEST INSERT");
//		logger.debug("#########");
//		SurveyquestionsManager.deleteAll();
//		SurveyquestionsDto sq = new SurveyquestionsDto();
//		sq.setQuestionId(1);
//		sq.setSurveyId(1);
//
//		int id_inserted_value = SurveyquestionsManager.insert(sq);
//		logger.debug("@Test --> inserted: " + id_inserted_value);
//		assertTrue(id_inserted_value > 0);
//	}
	
	
	@Test
	public void testInsertOk() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		
    	
    	int id_inserted_value = SurveyquestionsManager.insert(getFakeItem ());
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
        System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
	}
	
	

	@Test
	public void selectAllOK() {
		logger.debug("#########");
		logger.debug("TEST SELECT ALL");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();		
		SurveyquestionsManager.insert(getFakeItem ());
		assertTrue(SurveyquestionsManager.selectAll().size() > 0);
	}

	@Test
	public void selectByIdOK() {
		logger.debug("#########");
		logger.debug("TEST SELECT BY ID");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsManager.insert(getFakeItem ());
		List<SurveyquestionsDto> list = SurveyquestionsManager.selectAll();
		assertTrue(SurveyquestionsManager.selectById(list.get(0).getId()) != null);
	}

	@Test
	public void deleteOK() {
		logger.debug("#########");
		logger.debug("TEST DELETE");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		
		SurveyquestionsManager.delete(getFakeItem ());
		assertTrue(SurveyquestionsManager.selectAll().size() == 0);
	}
	
	private SurveyquestionsDto getFakeItem () {
        QuestionsManager.deleteAll();
        SurveyManager.deleteAll();
        SurveyquestionsManager.deleteAll();
        
		SurveyDto surveyToInsert = new SurveyDto("test"+Math.random(), 20l, "Test Descritption"+Math.random()) ;
		int surveyId = SurveyManager.insert(surveyToInsert);
		
		QuestionsDto qd = new QuestionsDto();
		qd.setLabel("test"+Math.random());
		int questionId = QuestionsManager.insert(qd);

		SurveyquestionsDto item = new SurveyquestionsDto();
		item.setSurveyId(surveyId);
		item.setQuestionId(questionId);
		return item ;
	}
	
	
}
