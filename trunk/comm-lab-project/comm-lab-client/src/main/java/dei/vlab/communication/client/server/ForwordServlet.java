package dei.vlab.communication.client.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwordServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String m=req.getParameter("m");
		if(null!=m && m.equalsIgnoreCase("admin")){
			res.sendRedirect("admin.html");
		}
		else if(null!=m && m.equalsIgnoreCase("workspace")){
			res.sendRedirect("workspace.html");
		}
		
		res.sendRedirect("login.html");
	}
	

}
