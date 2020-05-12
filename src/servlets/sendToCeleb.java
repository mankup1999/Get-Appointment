package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.manku.service.Service;

/**
 * Servlet implementation class sendToCeleb
 */
@WebServlet("/sendToCeleb")
public class sendToCeleb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendToCeleb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		if(session.getAttribute("applicantId")==null || request.getParameter("applicationId")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		else {
			int applicationId=Integer.parseInt(request.getParameter("applicationId"));
			String data=request.getParameter("data");
			Service serv=new Service();
			if(serv.getApplicationMessagingStatus(applicationId)==0)
				response.sendRedirect("http://localhost:8080/appointment/");
			else {
				int status=serv.insertChatData(applicationId, data, "applicant");
				response.getWriter().println(status);
				if(status<=0)
					response.getWriter().println("Technical Error");
				else
					response.sendRedirect("http://localhost:8080/appointment/ChatForApplicant.jsp?applicationId="+applicationId);
			}
				
		}
	}

}
