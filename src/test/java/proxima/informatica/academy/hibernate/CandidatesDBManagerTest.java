/**
 * 
 */
package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidatesDto;
import proxima.informatica.academy.dto.UserDto;

/**
 * @author AntoIannaccone
 *
 */
public class CandidatesDBManagerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(CandidatesDBManagerTest.class);
		
	@Test
	public void testInsertOk() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		
		assertTrue(SurveyManager.deleteAll());
		assertTrue(UserManager.deleteAll());
		
		CandidatesDto candidates = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        session.beginTransaction();
        int id_inserted_value_candidates = CandidatesManager.insert(candidates);
        session.getTransaction().commit();
        session.close();
		logger.debug("@Test --> inserted: " + id_inserted_value_candidates);
        assertTrue( id_inserted_value_candidates > 0);
	}
	
	@Test
	public void testDeleteAll() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		boolean returnValue = CandidatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue(returnValue);
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllEmpty() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY - START");
		System.out.println("#########");
		boolean returnValue = CandidatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue(selectAllSize==0);
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY- END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllForOne() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean returnValue = CandidatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue(selectAllSize==0);
        CandidatesDto candidates = new CandidatesDto();
        candidates.setUser_id(1);
		candidates.setCourse_code("MIGEN01");
		candidates.setCandidacy_date_time(LocalDateTime.now());
		candidates.setFirstname("Antonio");
		candidates.setLastname("Iannaccone");
		candidates.setEmail("antonio.iannaccone@outlook.com");
		candidates.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		candidates.setInserted_by(1);
		candidates.setCandidate_state_code(1);
    	int id_inserted_value = CandidatesManager.insert(candidates);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );        
        selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue(selectAllSize==1);
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
	
	@Test
	public void testDeleteAll2() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		
		CandidatesDto candidates = insertAllTables();
    	Session session = DBManager.getSessionFactory().openSession();
        int id_inserted_value_candidates = CandidatesManager.insert(candidates);
		logger.debug("@Test --> inserted: " + id_inserted_value_candidates);
        assertTrue( id_inserted_value_candidates > 0);
			
		boolean returnValue = CandidatesManager.deleteAll();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue(returnValue);
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllEmpty2() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		
		CandidatesDto candidates = new CandidatesDto();
		candidates.setUser_id(1);
		candidates.setCourse_code("MIGEN01");
		candidates.setCandidacy_date_time(LocalDateTime.now());
		candidates.setFirstname("Antonio");
		candidates.setLastname("Iannaccone");
		candidates.setEmail("antonio.iannaccone@outlook.com");
		candidates.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		candidates.setInserted_by(1);
		candidates.setCandidate_state_code(1);
		Session session = DBManager.getSessionFactory().openSession();
        int id_inserted_value_candidates = CandidatesManager.insert(candidates);
        assertTrue(id_inserted_value_candidates>0);
		
        boolean returnValue = CandidatesManager.deleteAll();
        logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        int selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllForOne2() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL FOR ONE - START");
		System.out.println("#########");
		boolean returnValue = CandidatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        CandidatesDto candidates = new CandidatesDto();
        candidates.setUser_id(1);
		candidates.setCourse_code("MIGEN01");
		candidates.setCandidacy_date_time(LocalDateTime.now());
		candidates.setFirstname("Antonio");
		candidates.setLastname("Iannaccone");
		candidates.setEmail("antonio.iannaccone@outlook.com");
		candidates.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		candidates.setInserted_by(1);
		candidates.setCandidate_state_code(1);
    	int id_inserted_value = CandidatesManager.insert(candidates);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );        
        selectAllSize = CandidatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==1 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL FOR ONE - END");
		System.out.println("#########");
	}
	
	
	public CandidatesDto insertAllTables() {
		
		//Entità referenziata dalla foreign key
		//SurveyDto coursepage = new CoursePageDto();
		//coursepage.setLabel("testLabel");
		//coursepage.setTime(1l);
		//coursepage.setDescription("TEST DESCRIPTION");
		//int id_inserted_value_survey = SurveyManager.insert(coursepage);
		//assertTrue( id_inserted_value_survey >0 );
		
		UserDto user = new UserDto();
    	user.setEmail("antonio.iannaccone@outlook.com");
    	user.setPassword("aaa");
    	user.setFirstname("Antonio");
    	user.setLastname("Iannaccone");
    	user.setEnabled(false);
    	user.setRole(0);
    	user.setDateofbirth(Date.valueOf(LocalDate.now()));
    	user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
    	user.setRole(10);
    	int id_inserted_value_user = UserManager.insert(user);
    	assertTrue( id_inserted_value_user > 0);
		
		CandidatesDto candidates = new CandidatesDto();
		Integer user_id = Integer.valueOf(user.getId());
		candidates.setUser_id(user_id);
		candidates.setCourse_code("MIGEN01");
		candidates.setCandidacy_date_time(LocalDateTime.now());
		candidates.setFirstname("Antonio");
		candidates.setLastname("Iannaccone");
		candidates.setEmail("antonio.iannaccone@outlook.com");
		candidates.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		candidates.setInserted_by(1);
		candidates.setCandidate_state_code(1);
		return candidates;
	}
	
	/*`id` bigint(20) NOT NULL AUTO_INCREMENT,
	  `user_id` bigint(20) NOT NULL,
	  `domicile_city` varchar(100) DEFAULT NULL,
	  `study_qualification` varchar(300) DEFAULT NULL,
	  `graduate` tinyint(1) DEFAULT NULL,
	  `high_graduate` tinyint(1) DEFAULT NULL,
	  `still_high_study` tinyint(1) DEFAULT NULL,
	  `mobile` varchar(20) DEFAULT NULL,
	  `cv_external_path` varchar(1000) DEFAULT NULL,
	  `course_code` varchar(100) NOT NULL,
	  `candidacy_date_time` datetime NOT NULL,
	  `label` varchar(200) DEFAULT NULL,
	  `firstname` varchar(50) NOT NULL,
	  `lastname` varchar(50) NOT NULL,
	  `email` varchar(100) NOT NULL,
	  `dateofbirth` date DEFAULT NULL,
	  `regdate` datetime NOT NULL,
	  `technical_note` varchar(2000) DEFAULT NULL,
	  `hr_note` varchar(2000) DEFAULT NULL,
	  `inserted_by` bigint(20) NOT NULL,
	  `imgpath` varchar(255) DEFAULT NULL,
	  `candidate_state_code` int(11) NOT NULL,*/
	
	/*private BigInteger id;
	private BigInteger user_id;
	private String domicile_city;
	private String study_qualification;
	private Byte graduate;
	private Byte high_graduate;
	private Byte still_high_study;
	private String mobile;
	private String cv_external_path;
	private String course_code;
	private Long candidacy_date_time;
	private String label;
	private String firstname;
	private String lastname;
	private String email;
	private Long dateofbirth;
	private Long regdate;
	private String technical_note;
	private String hr_note;
	private BigInteger inserted_by;
	private String imgpath;
	private Integer candidate_state_code;*/
}
