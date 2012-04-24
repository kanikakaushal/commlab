/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.service;


import dei.vlab.communication.model.Calendarr;
import java.util.List;

/**
 *@author server
 */
public interface CalendareManager extends GenericManager<Calendarr, Long> {
    
    public Calendarr getCalendarDataByName(String name);
    
    public void saveUpdate(Calendarr calendarr);
  
    public List<Calendarr> getAllData();
    
    public Calendarr getCalenderDataById(Long id);

}
