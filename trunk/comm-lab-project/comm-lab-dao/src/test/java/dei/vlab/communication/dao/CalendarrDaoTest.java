/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.dao;
import static org.junit.Assert.assertNotNull;
import dei.vlab.communication.model.Calendarr;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author server
 */
public class CalendarrDaoTest extends BaseDaoTestCase{
    @Autowired
    private CalendarrDao calendarrDao;
    
    @Test
    @Rollback(false)
    public void saveCalendarData (){
        Calendarr calendarr = new Calendarr();
        calendarr.setName("goutam");
        calendarr.setDescription("getUp");
        calendarr.setStart(getCurrentTime());
        calendarr.setEnd(getCurrentTime());
        
        Calendarr calendarr1 = new Calendarr();
        calendarr1.setName("goutam1");
        calendarr1.setDescription("getUp1");
        calendarr1.setStart(getCurrentTime());
        calendarr1.setEnd(getCurrentTime());
        calendarrDao.save(calendarr1);
        calendarrDao.saveCalendareData(calendarr);
         assertNotNull(calendarr1.getName());
    }
    
    
    @Test
    public void  getCalendarData(){
        
        List<Calendarr> ca = calendarrDao.findeAllInformaion();
        System.out.print("calendar data "+ca);
    }
    
    public static Timestamp getCurrentTime(){
	return new Timestamp(System.currentTimeMillis());
	}
    
}
