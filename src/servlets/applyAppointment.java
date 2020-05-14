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
 * Servlet implementation class applyAppointment
 */
@WebServlet("/applyAppointment")
public class applyAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public applyAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		if(session.getAttribute("applicantID")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session=request.getSession();
		if(session.getAttribute("applicantId")==null)
				response.sendRedirect("http://localhost:8080/appointment/");
		else {
			int applicantId=-1;
			try {
				applicantId=(Integer)session.getAttribute("applicantId");
				int celebId=(Integer)session.getAttribute("celebId");
				Service serv=new Service();
				int applicationId=serv.getNewApplicationId();
				
				String intent=request.getParameter("intent");
				
				//response.getWriter().println(intent+" "+applicantId+" "+celebId+" "+applicationId);
				
				int status=serv.insertApplicationRecord(applicationId, intent);
				if(status!=-1) {
					status=serv.insertApplication(applicationId, applicantId, celebId);
				}
				
				if(status==-1)
						response.getWriter().println("Apllication Failed due to some technical issue");
				else {
					response.sendRedirect("http://localhost:8080/appointment/applicationSubmitted.jsp");
				}
				
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
		}

}
