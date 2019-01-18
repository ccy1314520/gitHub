package a_forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/a/AServlet")
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
		req.getRequestDispatcher("/a/BServlet").forward(req, resp);
		//A服务器接收的请求转发到b服务器去时是由A服务器做出的响应
		resp.getWriter().write("A服务器发出的反应");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
