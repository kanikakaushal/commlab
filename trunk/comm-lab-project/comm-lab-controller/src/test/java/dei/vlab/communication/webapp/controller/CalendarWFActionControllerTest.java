/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.webapp.controller;

import dei.vlab.communication.model.Calendarr;
import dei.vlab.communication.service.CalendareManager;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 *
 * @author server
 */
public class CalendarWFActionControllerTest extends BaseControllerTestCase{
    
    @Autowired
    private CalendareManager calendareManager;
    private ServletContext servletContext;
    final Log log = LogFactory.getLog(CalendarWFActionController.class);
    private List<Calendarr> allData;
    
    @Test
    public void testGetCalendarData() throws Exception{
       // MockHttpServletRequest request = new MockHttpServletRequest();
       // request.addParameter("GET", "/calendar");
        allData= calendareManager.getAllData();
        System.out.print(">>>>>sec calendar maping "+allData);
        
    }
  
    
    
}
