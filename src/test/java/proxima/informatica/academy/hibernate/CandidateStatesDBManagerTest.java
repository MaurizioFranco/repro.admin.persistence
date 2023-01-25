package proxima.informatica.academy.hibernate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.dto.CandidateStatesDto;

public class CandidateStatesDBManagerTest {
	private final static Logger logger = LoggerFactory.getLogger(CandidateStatesManager.class);
	
	@Test
	public void testInsertOk() {
		System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
		CandidateStatesDto candidateState = new CandidateStatesDto();
		candidateState.setRole_id(3);
		candidateState.setStatus_color("#af43g2");
		candidateState.setStatus_code(13);
		candidateState.setStatus_description("aaaa");  
		candidateState.setStatus_label("bbbb");    	
    	
    	
    	int id_inserted_value = CandidateStatesManager.insert(candidateState);
		logger.debug("@Test --> inserted: " + id_inserted_value);
        assertTrue( id_inserted_value>0 );
        System.out.println("#########");
		System.out.println("TEST INSERT");
		System.out.println("#########");
	}
	
	@Test
	public void testDeleteAll() {
		System.out.println("#########");
		System.out.println("TEST DELETE ALL - START");
		System.out.println("#########");
		boolean returnValue = CandidateStatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        System.out.println("#########");
		System.out.println("TEST DELETE ALL - END");
		System.out.println("#########");
	}
	
	@Test
	public void testSelectAllEmpty() {
		System.out.println("#########");
		System.out.println("TEST SELECT ALL EMPTY- START");
		System.out.println("#########");
		boolean returnValue = CandidateStatesManager.deleteAll();
		logger.debug("@Test --> returnValue: " + returnValue);
        assertTrue( returnValue );
        int selectAllSize = CandidateStatesManager.selectAll().size();
		logger.debug("@Test --> selectAllSize: " + selectAllSize);
        assertTrue( selectAllSize==0 );
        System.out.println("#########");
        System.out.println("TEST SELECT ALL EMPTY- END");
		System.out.println("#########");
	}
	
	
}
