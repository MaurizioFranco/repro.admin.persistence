package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidateStatesDto;

public class CandidateStatesDBManagerTest {
	private final static Logger logger = LoggerFactory.getLogger(RoleDBManagerTest.class);

	@Test
	public void test() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		CandidateStatesDto candidate = new CandidateStatesDto();
		candidate.setRole_id(3);
		candidate.setStatus_code(10);
		candidate.setStatus_color("#FFFFFF");
		candidate.setStatus_description("testLabel2");
		candidate.setStatus_label("testlabel3");
		

		int id_inserted_value = CandidateStatesManager.insert(candidate);
		logger.debug("@Test --> inserted: " + id_inserted_value);
		assertTrue(id_inserted_value > 0);
	}
}
