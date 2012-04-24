/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.service.impl;

import dei.vlab.communication.dao.CalendarrDao;
import dei.vlab.communication.dao.GenericDao;
import dei.vlab.communication.model.Calendarr;
import dei.vlab.communication.service.CalendareManager;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author server
 */
@Service("calendareManager")
public class CalendareManagerImpl extends GenericManagerImpl<Calendarr, Long> implements CalendareManager{

    private CalendarrDao calendarrDao;

    @Autowired
    public void setCalendarrDao(CalendarrDao calendarrDao) {
        this.calendarrDao = calendarrDao;
    }
    
    public Calendarr getCalendarDataByName(String name) {
        return  calendarrDao.findCalanderByName(name);
    }

    public void saveUpdate(Calendarr calendarr) {
        calendarrDao.saveCalendareData(calendarr);
    }

    public Calendarr getCalenderDataById(Long id) {
       return  calendarrDao.findeCalendarInfoById(id);
    }

 
    public List<Calendarr> getAllData() {
      return calendarrDao.findeAllInformaion();
    }
    
}
