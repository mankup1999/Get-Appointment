package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.manku.service.Service;

/**
 * Servlet implementation class suggestCelebs
 */
@WebServlet("/suggestCelebs")
public class suggestCelebs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suggestCelebs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("q");
		if(name!=null) {
			int n=name.length();
			PrintWriter out=response.getWriter();
			if(n!=0) {
				Service serv=new Service();
				ArrayList<Integer> celebID=serv.getVerifiedCelebs();
				ArrayList<String> celebName=new ArrayList<String>();
				int celebSize=celebID.size();
				for(int i=0;i<celebSize;i++) {
					celebName.add(serv.getCelebrity(celebID.get(i)).getName());
				}
				for(int i=0;i<celebSize;i++) {
					int celebId=celebID.get(i);
					String celName=celebName.get(i);
					if(name.equalsIgnoreCase(celName.substring(0,n))) {
						out.print("<a style='text-decoration:none' href='showCelebGet?celebId="+celebId+"'>"+celName+"</a>"+"<br>");
						//System.out.println("<a href='showCelebGet?celebId="+celebId+"'><b>"+celName+"</b></a>"+"<br>");
					}
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
