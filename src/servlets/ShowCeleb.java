package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.manku.main.Celebrity;
import co.manku.service.Service;

/**
 * Servlet implementation class ShowCeleb
 */
@WebServlet("/showCeleb")
public class ShowCeleb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCeleb() {
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
		Service serv=new Service();
		Celebrity celeb=serv.getCelebrity(celebId);
		if(celeb!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("celebDetail", celeb.toString());
			response.sendRedirect("http://localhost:8080/appointment/CelebDetail.jsp");
		}
	}

}
