package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.manku.main.Applicant;
import co.manku.service.Service;

/**
 * Servlet implementation class InsertApplicantDetail
 */
@WebServlet("/InsertApplicant")
public class InsertApplicantDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertApplicantDetail() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		long mob=Long.parseLong(request.getParameter("mob"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Service serv=new Service();
		int applicantId=serv.getNewApplicantId();
		Applicant applicant=new Applicant();
		applicant.setName(name);
		applicant.setEmail(email);
		applicant.setMob(mob);
		applicant.setAddress(null);
		applicant.setPhoto(null);
		applicant.setApplicantId(applicantId);
		
		int statusAddApplicant=serv.insertApplicant(applicant);
		int statusAddLogin=-1;
		if(statusAddApplicant!=-1) {
			statusAddLogin=serv.insertApplicantLogin(username, password, applicantId);
		}
		PrintWriter out=response.getWriter();
		out.println("statusAddApplicant="+statusAddApplicant);
		out.println("statusAddLogin="+statusAddLogin);
		
		if(statusAddApplicant!=-1 && statusAddLogin!=-1) {
			response.sendRedirect("http://localhost:8080/appointment/ApplicantCredentials.jsp");
		}
		else
			out.println("Error Occured");
		
		
	}

}
