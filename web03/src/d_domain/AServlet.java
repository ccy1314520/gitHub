package d_domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/A")
@SuppressWarnings("serial")
public class AServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 在请求域中设置值
		req.setAttribute("name_in_req", "request");
		// 在session域中设置值
		req.getSession().setAttribute("name_in_session", "session");
		// 在application域中设置值
		req.getServletContext().setAttribute("name_in_app", "application");
		//删除域对象中的数据
		req.removeAttribute("name_in_req");
		req.getSession().removeAttribute("name_in_session");
		req.getServletContext().removeAttribute("name_in_app");
		req.getRequestDispatcher("/B").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
