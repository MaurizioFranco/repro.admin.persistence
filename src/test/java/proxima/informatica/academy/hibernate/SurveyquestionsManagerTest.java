package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.SurveyquestionsDto;

public class SurveyquestionsManagerTest {
	private final static Logger logger = LoggerFactory.getLogger(SurveyquestionsManagerTest.class);

	@Test
	public void deleteAllOK() {
		logger.debug("#########");
		logger.debug("TEST DELETE ALL");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);
		SurveyquestionsManager.insert(sq);
		assertTrue(SurveyquestionsManager.deleteAll());
	}

	@Test
	public void insertOK() {
		logger.debug("#########");
		logger.debug("TEST INSERT");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);

		int id_inserted_value = SurveyquestionsManager.insert(sq);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
	}

	@Test
	public void selectAllOK() {
		logger.debug("#########");
		logger.debug("TEST SELECT ALL");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);
		SurveyquestionsManager.insert(sq);
		assertTrue(SurveyquestionsManager.selectAll().size() > 0);
	}

	@Test
	public void selectByIdOK() {
		logger.debug("#########");
		logger.debug("TEST SELECT BY ID");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);
		SurveyquestionsManager.insert(sq);
		List<SurveyquestionsDto> list = SurveyquestionsManager.selectAll();
		assertTrue(SurveyquestionsManager.selectById(list.get(0).getId()) != null);
	}

	@Test
	public void deleteOK() {
		logger.debug("#########");
		logger.debug("TEST DELETE");
		logger.debug("#########");
		SurveyquestionsManager.deleteAll();
		SurveyquestionsDto sq = new SurveyquestionsDto();
		sq.setQuestionId(1);
		sq.setSurveyId(1);
		SurveyquestionsManager.delete(sq);
		assertTrue(SurveyquestionsManager.selectAll().size() == 0);
	}
}
