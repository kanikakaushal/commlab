/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.dao.hibernate;

import dei.vlab.communication.dao.CalendarrDao;
import dei.vlab.communication.model.Calendarr;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author server
 */
@Repository
public class CalendarrDaoHibernate extends GenericDaoHibernate<Calendarr, Long> implements CalendarrDao{

    public CalendarrDaoHibernate() {
        super(Calendarr.class);
    }
    
    @Override
    public Calendarr findeCalendarInfoById(Long id) {
        List listInfo =null;
        listInfo = getHibernateTemplate().find("from Calendarr where id=?", id);
        if(listInfo==null){
           return  null;
        }
        return (Calendarr) listInfo.get(0);
    }

    @Override
    public List<Calendarr> findeAllInformaion() {
       List allInfoList = null;
        allInfoList = getHibernateTemplate().find("from Calendarr");
        if (allInfoList.isEmpty()) {
            return null;
        }
        return allInfoList;
    }

    @Override
    public Calendarr findCalanderByName(String name) {
         List listInfo =null;
        listInfo = getHibernateTemplate().find("from Calendarr where name=?", name);
        if(listInfo==null){
           return  null;
        }
        return (Calendarr) listInfo.get(0);
    }

    @Override
    public Calendarr saveCalendareData(Calendarr calendar) {
        if (log.isDebugEnabled()) {
            log.debug("calendar data save and update" + calendar);
        }
        getHibernateTemplate().saveOrUpdate(calendar);
        return calendar;
    }

    @Override
    public void deleteCalendarDataById(Long id) {
      if (log.isDebugEnabled()) {
            log.debug("Delete circuit id " + id);
        }
        Object deletObject = getHibernateTemplate().load(Calendarr.class, id);
        if (deletObject != null) {
            getHibernateTemplate().delete(deletObject);
        }
    }
    
}
