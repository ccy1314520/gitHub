package e_servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取servletContext的四种方式，随意采用，但是要注意版本兼容的问题
 * @author XHY
 */
@WebServlet("/e/context")
@SuppressWarnings("serial")
public class TestServletContext extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext a1=req.getServletContext();
		ServletContext a2=req.getSession().getServletContext();
		ServletContext a3=super.getServletContext();
		ServletContext a4=super.getServletConfig().getServletContext();
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		System.out.println(a1.getContextPath());
		System.err.println(a1.getRealPath("/"));
		System.out.println(a1.getServerInfo());
		System.out.println(a1.getInitParameter("encoding"));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
