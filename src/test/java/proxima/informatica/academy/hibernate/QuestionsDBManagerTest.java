package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.QuestionsDto;
import proxima.informatica.academy.dto.RoleDto;

public class QuestionsDBManagerTest {

	private final static Logger logger = LoggerFactory.getLogger(QuestionsDBManagerTest.class);
	
	@Test
	public void insertQuestion() {
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
	
	@Test
	public void selectById() {
		System.out.println("#########");
		System.out.println("TEST SELECT BY ID");
		System.out.println("#########");
		QuestionsDto question = new QuestionsDto();
		question.setLabel("test label");
		int idToFind = QuestionsManager.insert(question);
		logger.debug("@Test --> idAdded: " + idToFind);
		assertTrue( idToFind == QuestionsManager.selectById(idToFind).getId());
	}
	
	
	@Test
	public void deleteById() {
		System.out.println("#########");
		System.out.println("TEST delete BY ID");
		System.out.println("#########");
		QuestionsDto question = new QuestionsDto();
		question.setLabel("test label");
		int idToDelete = QuestionsManager.insert(question);
		System.out.println("Id da eliminare: " + idToDelete);
		logger.debug("@Test --> idAdded: " + idToDelete);
		assertTrue(QuestionsManager.deleteById(idToDelete));
	}
	
	
	@Test
	public void deleteAll() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL");
		System.out.println("#########");
		boolean value = QuestionsManager.deleteAll();
		logger.debug("@Test --> value: " + value);
		assertTrue( value );
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	
	@Test
	public void selectAllEmpty() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		boolean returnValue = QuestionsManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = QuestionsManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY- END");
		System.out.println("#########");
	}
	
	
	
	@Test
	public void selectAllForOne() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean returnValue = QuestionsManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = QuestionsManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        QuestionsDto question = new QuestionsDto();
        question.setLabel("test label");
    	int id_inserted_value = QuestionsManager.insert(question);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );        
        selectAllSize = QuestionsManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==1 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
}
