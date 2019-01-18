package b_redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/b/AServlet")
@SuppressWarnings("serial")
public class AServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String user=req.getParameter("user");
		System.out.println("这是A服务器接收到的值"+user);
		//使用forward可以访问内部资源
		//req.getRequestDispatcher("/WEB-INF/index.html").forward(req, resp);
		resp.sendRedirect("/web03/b/BServlet");
		resp.getWriter().write("A服务器发出的反应");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
