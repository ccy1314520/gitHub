package com.zyz.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyz.empSys.pojo.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpServiceImpl;

/**
 * emp的servlet
 * 
 * @author XHY
 */
@WebServlet("/emp")
@SuppressWarnings("serial")
public class EmpServlet extends HttpServlet {
	// 声明员工服务接口的对象
	private static IEmpService ies = new EmpServiceImpl();
	// 声明全局的

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局配置参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置请求编码格式
		resp.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding(encoding);
		// 设置响应格式
		resp.setContentType("text/html;charset=" + encoding);
		// 获取到请求的方法类型
		String reqCommand = req.getParameter("reqCommand");
		
		 
		switch (reqCommand) {
		case "login":
			// 调用登录的方法进行登录
			login(req, resp);
			break;
		case "query":
			// 调用显示的方法进行显示
			displayAllEmp(req, resp);
			break;
		case "register":
			registeEmp(req, resp);
			break;
		case "displayEditInfo":
			// 调用显示修改对象信息的方法
			displayEditInfo(req, resp);
			break;
		case "delete":
			// 删除制定的员工
			deleteEmp(req, resp);
			break;
		case "editEmp":
			// 修改员工信息
			editEmp(req, resp);
			break;
		case "logOut":
			// 修改员工信息
			logOut(req, resp);
			break;	
		default:
			break;
		}
	}
	
	/**
	 * 安全退出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		
		if(emp!=null) {
			session.invalidate();
		}
		//请求重定向到指令
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * 员工进行登录验证
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String validate=req.getParameter("validate");
		String val_in_session=(String) req.getSession().getAttribute("validate");
		if(!val_in_session.equalsIgnoreCase(validate)) {
			req.setAttribute("val_msg", "验证码有误，请重新输入");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		// 调用IEmpService中的方法
		// 获取到查询到的员工的实体对象
		Emp emp = ies.empLoginByNameAndPassword(name, password);
		if (emp != null) {
			// 把登录的用户存入到session中，表示开启了一次会话
			HttpSession session = req.getSession();
			session.setAttribute("emp", emp);
			// System.out.println(emp);
			// 格式化时间日期
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String lastTime = sdf.format(new Date());
			// 获取请求中的cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				Cookie c = null;
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					if ("lastTime".equals(cookieName)) {
						c = cookie;
						break;
					}
				}
				if (c != null) {
					String value = c.getValue();
					req.setAttribute("lastTime", value);
					c.setValue(lastTime);
					resp.addCookie(c);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				} else {
					c = new Cookie("lastTime", lastTime);
					// 设置cookie
					// 设置全站路径
					c.setPath("/");
					c.setMaxAge(60 * 60 * 24);
					req.setAttribute("lastTime", lastTime);
					resp.addCookie(c);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
			} else {
				Cookie c = new Cookie("lastTime", lastTime);
				// 设置cookie
				c.setPath("/");
				c.setMaxAge(60 * 60 * 24);
				req.setAttribute("lastTime", lastTime);
				resp.addCookie(c);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}

			resp.getWriter().write("登录成功,3秒后前往主页");
			// resp.sendRedirect(context.getContextPath()+"/index.html");
			resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/index.jsp");
			return;
		} else {
			// 请求转发，把错误的信息转发到前端页面进行展示
			req.setAttribute("error_msg", "账号或密码有误，请检查后登录");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
	}

	/**
	 * 显示所有的员工信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void displayAllEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		List<Emp> list = ies.displayAllEmps();
		// 把所有员工信息存入到请求域中
		req.setAttribute("list", list);
		// 遍历员工集合
//		for (Emp emp : list) {
//			System.out.println(emp);
//		}
		// 请求转发
		req.getRequestDispatcher("/empList.jsp").forward(req, resp);
	}

	/**
	 * 绑定修改的员工的信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void displayEditInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取到empList.jsp发送过来的数据
		String id = req.getParameter("id");
		// System.out.println(id);
		// 获取到查询的结果信息
		Emp findEmp = ies.findEmpById(Integer.parseInt(id));
		// 将查询到的结果放入到请求域当中去
		req.setAttribute("findEmp", findEmp);
		// 请求转发
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
		// System.out.println(findEmp);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void registeEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取到register.jsp发送过来的数据
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		// System.out.println(name + "," + password + "," + gender + "," + age + "," +
		// phone + "," + email);

		// 获取到注册的时间
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String registerTime = sdf.format(new Date());
		System.out.println(registerTime);

		// 将注册信息封装到emp对象中去
		Emp registerEmp = new Emp(name, password, gender, age, phone, email);
		// System.out.println(registerEmp);
		boolean isRegisterSuccess = ies.registerEmp(registerEmp);
		if (isRegisterSuccess == true) {
			// System.out.println("注册成功");
			// 请求转发到EmpListServlet中区重新显示员工列表
			req.getRequestDispatcher("/emp?reqCommand=query").forward(req, resp);
		}
	}

	/**
	 * 删除指定的员工信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取到选中的id
		String id = req.getParameter("id");
		// 服务层调用删除方法
		// 服务层首先调用查询方法将要删除的员工放入一个临时的list集合中
		Emp emp = ies.findEmpById(Integer.parseInt(id));
		List<Emp> tempList = new ArrayList<>();
		if (emp != null) {
			// System.out.println("可以进行删除");
			tempList.add(emp);
			boolean isSuccesss = ies.deleteByIdSuccess(Integer.parseInt(id));
			if (isSuccesss) {
				// System.out.println("删除成功");
				req.getRequestDispatcher("/emp?reqCommand=query").forward(req, resp);
			}
		}
	}

	public void editEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("获取到修改后提交的信息");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String date = req.getParameter("date");
		String salary = req.getParameter("salary");
		String gender = req.getParameter("gender");
		String id = req.getParameter("id");
		
		// System.out.println(name + "," + password + "," + age + "," + phone + "," +
		// email + "," + salary + ","
		// + Date.valueOf(date));
		// System.out.println(gender);
		// System.out.println(id);
		// 将修改后的值封装到实体对象中去
		Emp emp = new Emp(Integer.parseInt(id), name, password, gender, age, java.sql.Date.valueOf(date),
				Double.parseDouble(salary), phone, email);
		boolean editSuccess = ies.editSuccess(emp);
		if (editSuccess == true) {
			// 请求转发到显示页面重新显示
			req.getRequestDispatcher("/emp?reqCommand=query").forward(req, resp);
		}
	}

}
