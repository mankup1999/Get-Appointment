package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.manku.main.Celebrity;
import co.manku.service.Service;

/**
 * Servlet implementation class InsertCelebDetail
 */
@WebServlet("/InsertCeleb")
public class InsertCelebDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCelebDetail() {
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
		String needReferral=null;
		String officeAddress=request.getParameter("officeAddress");
		Service serv=new Service();
		int celebId=serv.getNewCelebId();
		Celebrity celeb=new Celebrity();
		celeb.setCelebId(celebId);
		celeb.setName(name);
		celeb.setEmail(email);
		celeb.setMob(mob);
		celeb.setEnableMail("1");
		celeb.setEnableMsg("1");
		celeb.setIsPaid("1");
		celeb.setNeedReferral(needReferral);
		celeb.setOfficeAddress(officeAddress);
		celeb.setPhoto(null);
		celeb.setVerifyStatus("0");
		
		//System.out.println(celeb.toString());
		
		int statusAddCeleb=serv.insertCeleb(celeb);
		int statusLoginCeleb=-1;
		if(statusAddCeleb!=-1) {
			statusLoginCeleb=serv.insertCelebLogin(username, password, celebId);
		}
		PrintWriter out=response.getWriter();
		out.println("StatusAddCeleb="+statusAddCeleb);
		out.println("StatusLoginCeleb="+statusLoginCeleb);
		if(statusAddCeleb!=-1 && statusLoginCeleb!=-1) {
			int statusAdminVerify=serv.adminVerify(celebId);
			out.println("StatusAdminVerify="+statusAdminVerify);
			HttpSession session=request.getSession();
			String celebDetail=serv.getCelebrity(celebId).toString();
			session.setAttribute("celebDetail", celebDetail);
			response.sendRedirect("http://localhost:8080/appointment/CelebDetail.jsp");
		}
		
		else {
			System.out.println("Error Occured");
		}
			
	}

}
