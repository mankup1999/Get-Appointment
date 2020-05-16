package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class passwordValidate
 */
@WebServlet("/passwordValidate")
public class passwordValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("password");
		if(username!=null) {
			PrintWriter out=response.getWriter();
			int n=username.length();
			if(n<6)
				out.print("<span style='color:red;opacity:.4;font-size:12px;'>Password must contain atleast 6 letters</span>");
			else if(!hasUpperCase(username,n))
				out.print("<span style='color:red;opacity:.4;font-size:12px;'>Password must contain atleast 1 UpperCase letter</span>");
			else if(!hasLowerCase(username,n))
				out.print("<span style='color:red;opacity:.4;font-size:12px;'>Password must contain atleast 1 LowerCase letter</span>");
			else if(!hasDigit(username, n))
				out.print("<span style='color:red;opacity:.4;font-size:12px;'>Password must contain atleast 1 digit</span>");
			else if(!hasSpecial(username,n))
				out.print("<span style='color:red;opacity:.4;font-size:12px;'>Password must contain atleast 1 special letter like @,#,$..</span>");
		}
	}
	
	public static boolean hasUpperCase(String x,int n) {
		for(int i=0;i<n;i++)
			if(x.charAt(i)>='A' && x.charAt(i)<='Z')
				return true;
		return false;
	}
	
	public static boolean hasLowerCase(String x,int n) {
		for(int i=0;i<n;i++)
			if(x.charAt(i)>='a' && x.charAt(i)<='z')
				return true;
		return false;
	}
	
	public static boolean hasDigit(String x,int n) {
		for(int i=0;i<n;i++)
			if(x.charAt(i)>='0' && x.charAt(i)<='9')
				return true;
		return false;
	}
	
	public static boolean hasSpecial(String x,int n) {
		for(int i=0;i<n;i++)
			if(x.charAt(i)=='@' || x.charAt(i)=='#' || x.charAt(i)=='$' || x.charAt(i)=='%')
				return true;
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
