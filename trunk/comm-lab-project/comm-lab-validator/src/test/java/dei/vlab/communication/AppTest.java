package dei.vlab.communication;


import dei.vlab.communication.netlist.Netlist;
import dei.vlab.communication.netlist.exception.ParseElementExeception;
import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.CrossWireNetlistValidator;
import dei.vlab.communication.validator.decorator.DefaultNetlist;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    public void testValidation() throws ParseElementExeception{
    	String filePath ="C:/workspace/comm-lab-netlist-validattor/src/netlist1.txt";
    	NetlistValidator validator = new DefaultNetlist(new ValidatedNetlistData() );
    	NetlistValidator validator2 =new CrossWireNetlistValidator(validator);
    	  validator.doValidation();
    	  validator2.doValidation();
          System.out.println("log data" + validator.getLogData().getLogs());
    }
    
    /**
     * @return the suite of tests being tested
     */
    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
