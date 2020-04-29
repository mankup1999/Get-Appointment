package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.manku.service.Service;

/**
 * Servlet implementation class DoVerify
 */
@WebServlet("/doVerify")
public class DoVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoVerify() {
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
		Enumeration<String> ex=request.getParameterNames();
		int celebId=-1;
		if(ex.hasMoreElements()) {
			celebId=Integer.parseInt(ex.nextElement());
		}
		//update verifyStatus and Delete from AdminVerification
		Service serv=new Service();
		int isVerified=serv.verifyStatus(celebId);
		PrintWriter out=response.getWriter();
		if(isVerified!=-1) {
			out.println("Celebrity ID ("+celebId+") is Verified ");
			int deleteCelebVerify=serv.deleteAdminVerify(celebId);
			if(deleteCelebVerify>0)
				out.println("Removed from Admin queue");
			response.sendRedirect("http://localhost:8080/appointment/Admin.jsp");
		}
		else
			out.println("Error");
	}

}
