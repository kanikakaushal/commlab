package dei.vlab.communication.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/start")
public class AfterLoginRedirectController {
	   private transient final Log log = LogFactory.getLog(AfterLoginRedirectController.class);

	   
	@RequestMapping(method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
       log.info("Redirecting to aplication after successfull login. ");
        ModelAndView mv = new ModelAndView("redirect:/application.html");

         return mv;

    }

}
