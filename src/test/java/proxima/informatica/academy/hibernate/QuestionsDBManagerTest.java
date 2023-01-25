package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.QuestionsDto;

public class QuestionsDBManagerTest {

	private final static Logger logger = LoggerFactory.getLogger(QuestionsDBManagerTest.class);
	
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		QuestionsDto question = new QuestionsDto();
		question.setLabel("testLabel");
		question.setDescription("testDescription");
		question.setAnsa("answer a");
		question.setAnsb("answer b");
		question.setAnsc("answer c");
		question.setAnsd("answer d");
		question.setCansa(true);
		question.setCansb(true);
		question.setCansc(false);
		question.setCansd(false);
    	question.setFull_answer("test Full answer");
    	
    	int id_inserted_value = QuestionsManager.insert(question);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
	}
}
