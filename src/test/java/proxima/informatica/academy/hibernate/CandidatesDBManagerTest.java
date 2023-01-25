/**
 * 
 */
package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidatesDto;

/**
 * @author AntoIannaccone
 *
 */
public class CandidatesDBManagerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(CandidatesDBManagerTest.class);
		
	@Test
	public void test2() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
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
    	
    	int id_inserted_value = CandidatesManager.insert(candidates);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
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
