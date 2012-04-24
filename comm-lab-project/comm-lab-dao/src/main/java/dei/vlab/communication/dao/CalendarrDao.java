/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.dao;


import dei.vlab.communication.model.Calendarr;
import java.util.List;

/**
 *
 * @author server
 */
public interface CalendarrDao extends GenericDao<Calendarr, Long> {
    /*
     * Finde calendare inforamtion by id
     */
    Calendarr findeCalendarInfoById(Long id);
    /*
     * finde all information 
     */
    List<Calendarr> findeAllInformaion();
    /*
     * Finde calendar data by name 
     */
    Calendarr findCalanderByName(String name);
    /*
     * save calandar data into database 
     */
    Calendarr saveCalendareData(Calendarr calendar);
    /*
     * Delete calendare data .
     */
    void deleteCalendarDataById(Long id);
    
}
