package httpConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpURLConnectionServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpURLConnectionServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy();
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//解决乱码问题
		String param =new String(request.getParameter("param").getBytes("ISO-8859-1"),"UTF-8"); 
		
		System.out.println("param is "+param);
		PrintWriter out = response.getWriter();
		out.println("httpURLConnection test");
		out.println("<br/>");
		out.println("param is "+param);
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          this.doGet(request, response);
	}
	
	public void init() throws ServletException {
		
	}

}
