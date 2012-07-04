/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.webapp.controller;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import dei.vlab.communication.model.Calendarr;
import dei.vlab.communication.service.CalendareManager;

/**
 *
 * @author server
 */
@Controller
public class CalendarWFActionController implements ServletContextAware{
    
    @Autowired
    private CalendareManager calendareManager;
    private ServletContext servletContext;
    
    public ServletContext getServletContext() {
        return servletContext;
    }
   

    public void setCalendareManager(CalendareManager calendareManager) {
        this.calendareManager = calendareManager;
    }
    
    @RequestMapping(value="/calendar*", method= RequestMethod.GET)
    public @ResponseBody
    List<CalendareData> listCalendar(HttpServletRequest request,HttpServletResponse response) throws  Exception {
        System.out.print(">>>>>frist calendar maping "+calendareManager);
        List<CalendareData> calendareDatas= new ArrayList<CalendareData>();
        try {
            List<Calendarr> calendarr = calendareManager.getAllData();
        
        System.out.print(">>>>>sec calendar "+calendarr);
        if(calendarr!=null&&!calendarr.isEmpty()){
            for(Calendarr calendarr1:calendarr){
                calendareDatas.add(CalendareData.populate(calendarr1));
            }
        }
        } catch (Exception e) {
            System.out.print(">>>>>>>>>>>>Cause "+e.getCause()+e);
        }
        
        System.out.print(">>>>>frist calendar maping "+calendareDatas);
        return calendareDatas;
    }
    
    @RequestMapping(value="/calendar*", method=RequestMethod.PUT)
	public @ResponseBody
	String saveUpdateCalendar(@ModelAttribute CalendareData calendareData) throws Exception {
		int id = calendareData.getId()!=null ?calendareData.getId().intValue():0;
		Calendarr calendarr =calendareManager.getCalenderDataById(new Long(id));
		if(calendarr==null){
		 calendarr= new Calendarr();
		}
		System.out.println(">>>>>>>>>>>>>>"+calendarr);
                calendarr.setName(calendareData.getName());
                calendarr.setDescription(calendareData.getDescription());
                calendarr.setStart(calendareData.getStart());
                calendarr.setEnd(calendareData.getEnd());
                calendareManager.saveUpdate(calendarr);
                System.out.println(">>>>>saveUpdateCalendar data" +calendareData);
		return "success";
	}

    public void setServletContext(ServletContext servletContext) {
    this.servletContext= servletContext; 
    }


}
