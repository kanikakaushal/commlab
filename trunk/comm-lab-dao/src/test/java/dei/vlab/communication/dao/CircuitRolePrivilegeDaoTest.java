/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.model.CircuitPrivileges;
import dei.vlab.communication.model.CircuitRolePrivilege;
import dei.vlab.communication.model.Role;

/**
 * @author server
 *
 */
public class CircuitRolePrivilegeDaoTest extends BaseDaoTestCase{
	
	@Autowired
	private CircuitRolePrivilegeDao cirRolePrivDao;
	@Autowired
	private RolesDao rolesDao;
	
	/// save and update data ///
	@Test
	@Rollback(false)
	public void testCircuitRolePrivilageSaveData(){
		CircuitRolePrivilege circuitRolePrivlege = new  CircuitRolePrivilege();		
		 Circuit saveCircuit = new Circuit();
	        saveCircuit.setName("Push pull");
	        saveCircuit.setImageFile("pushpull.png");
	        saveCircuit.setNoceCordinate("pushpull cordinate");
	        saveCircuit.setConfigProperties("config propertyes");
	        saveCircuit.setRemark("test good");
	        saveCircuit.setType("test by type");
	        
	        //rolesDao.saveRole();
	        
	       // Assert.assertNotNull("id is circuit is",saveCircuit.getId());
	       // Collection<Circuit> circuit = new ArrayList<Circuit>();
	       // circuit.add(saveCircuit);
	        circuitRolePrivlege.setCircuit(saveCircuit);
	        
	        CircuitPrivileges circuitPriv=new CircuitPrivileges();
	        circuitPriv.setName("DiodeHalfWavet");
	        circuitPriv.setDescription("execuitt");
	        circuitRolePrivlege.setCircuitPrivilege(circuitPriv);
	        
	    
	        Role role = rolesDao.findRoleById(1l);
	     	Set<Role> roles= new HashSet<Role>();
	    	roles.add(role);
	    	assertNotNull(role.getId());
	    	circuitRolePrivlege.setRoles(roles);
	    	
	    	
	    	cirRolePrivDao.saveCircuitRoleprivlilege(circuitRolePrivlege);
	    	System.out.println("Circuit  is"+circuitRolePrivlege.getCircuit());
	    	System.out.println("Circuit privilage is"+circuitRolePrivlege.getCircuitPrivilege());
	    	System.out.println("Circuit privilage Role is"+circuitRolePrivlege.getRoles());
	    	System.out.println("All Circuit privilage "+cirRolePrivDao.getAll());
	    	assertNotNull(circuitRolePrivlege);
		
	}
	// circuit role privilege by id //
	@Test
	public void testCircuitRolePrivilegeById(){
		CircuitRolePrivilege circuitRolePrevDate=cirRolePrivDao.findCircuitRolePrivilegeById(1L);
		assertNotNull(circuitRolePrevDate);
		System.out.println("Circuit Role Privilege data"+circuitRolePrevDate);
	}
	// delete circuit role privilege //
	@Test
	public void testDeleteCircuitRolePrivilegeById(){
		
		cirRolePrivDao.deleteCorcuitRolePrivielgeById(1L);
		flush();
	}
}
