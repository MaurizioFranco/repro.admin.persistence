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
		SurveyrepliesDto survey = new SurveyrepliesDto();
		BigInteger survey_id = new BigInteger("1");
		BigInteger user_id = new BigInteger("33");
		survey.setSurvey_id(survey_id);
		survey.setUser_id(user_id);
//		survey.setStarttime(null);
//		survey.setEndtime(null);
//		survey.setAnswers(null);
//		survey.setPdffilename(null);
//		survey.setPoints(null);
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        Object generatedIdentifier = session.save(survey);
//        logger.debug("insertNewUser - DEBUG - generatedIdentifier" + ((Integer)generatedIdentifier).intValue());
        int id_inserted_value = ((Integer)generatedIdentifier).intValue();
        session.getTransaction().commit();
        session.close();
    	
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
	}
	
}
