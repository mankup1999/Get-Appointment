package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.manku.service.Service;

/**
 * Servlet implementation class ValidCelebDetails
 */
@WebServlet("/validCeleb")
public class ValidCelebDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidCelebDetails() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Service service=new Service();
		int celebId=service.isCelebrityDetailsValid(username, password);
		PrintWriter out=response.getWriter();
		out.println(username);
		out.println(password);
		out.println(celebId);
		if(celebId!=-1) {
			String celebDetail=service.getCelebrity(celebId).toString();
			HttpSession session=request.getSession();
			session.setAttribute("celebDetail", celebDetail);
			response.sendRedirect("http://localhost:8080/appointment/CelebDetail.jsp");
		}
		else
			response.sendRedirect("http://localhost:8080/appointment/CelebCredentials.jsp");
	}

}
