package com.zyz.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyz.empSys.pojo.CartItem;
import com.zyz.empSys.pojo.ShoppingCart;
import com.zyz.empSys.service.IProductService;
import com.zyz.empSys.service.impl.ProductServiceImpl;

/**
 * 购物的servlet
 * 
 * @author XHY
 */
@WebServlet("/shop")
@SuppressWarnings("serial")
public class ShoppingServlet extends HttpServlet {
	// 声明服务接口的引用
	IProductService ips = new ProductServiceImpl();
	//创建购物车
	ShoppingCart cart=new ShoppingCart();

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
		
		
		/*// 将数据库中查询出的items列表项封装到ShoppingCart的items集合中，模拟购物车当中已经存在了商品
		List<CartItem> items = ips.displayAllProducts();
		for (CartItem cartItem : items) {
			//添加至购物车中
			cart.addItem(cartItem);
		}*/
		
		/*for (CartItem cartItem : currenttem) {
			System.out.println(cartItem);
		}*/
		
		String cmd = req.getParameter("cmd");
		if (("display").equals(cmd)) {
			// 调用显示的方法
			display(req, resp);
		} else if ("add".equals(cmd)) {
			// 调用添加商品的方法
			addItemInCart(req, resp);
		}else if("go".equals(cmd)) {
			//前往购物车
			goCart(req,resp);
		}else if("clearAll".equals(cmd)) {
			//清空购物车
			clearAll(req,resp);
		}else if("clearOne".equals(cmd)) {
			clearOne(req,resp);
		}
	}

	/**
	 * 删除一件商品
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void clearOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("pid");
		//System.out.println(id);
		cart.delItem(Integer.parseInt(id));
		
		List<CartItem> items = cart.getItems();
		/*for (CartItem cartItem : items) {
			System.out.println(cartItem);
		}*/
		//查看当前购物车集合
		// 将当前购物车的集合存入到session域当中去
		HttpSession session = req.getSession();
		session.setAttribute("products", items);
		
		req.getRequestDispatcher("/cartList.jsp").forward(req, resp);
		
	}

	/**
	 * 清空购物车
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void clearAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//销毁session
		session.invalidate();
		//创建新的购物车
		cart=new ShoppingCart();
		// 重定向到主页
	    resp.sendRedirect(req.getContextPath()+"/cartList.jsp");
		/*req.getRequestDispatcher("/cartList.jsp").forward(req, resp);*/
	}

	/**
	 * 前往购物车
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void goCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/cartList.jsp").forward(req, resp);
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addItemInCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取添加购物的商品的id
		String pid = req.getParameter("pid");
		// 获取到添加购物车的数量
	    String number = req.getParameter("number");
	    List<CartItem> items = ips.displayAllProducts();
		if("1".equals(pid)) {
			CartItem item = items.get(0);
			item.setNumber(Integer.parseInt(number));
			
			cart.addItem(item);
		}else if("2".equals(pid)) {
			CartItem item = items.get(1);
			item.setNumber(Integer.parseInt(number));
			
			cart.addItem(item);
		}else if("3".equals(pid)) {
			CartItem item = items.get(2);
			item.setNumber(Integer.parseInt(number));
			
			cart.addItem(item);
		}
		
		
		/*System.out.println(pid);
		System.out.println(number);*/
		
		
		
		List<CartItem> currenttem = cart.getItems();
		//查看当前购物车集合
		// 将当前购物车的集合存入到session域当中去
		HttpSession session = req.getSession();
		session.setAttribute("products", currenttem);
		
		req.getRequestDispatcher("/shop.jsp").forward(req, resp);
		
	}

	/**
	 * 显示购物车列表
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*// 获取到数据库当中显示的结果
		List<CartItem> items = ips.displayAllProducts();
		// 将items放入到请求域当中去
		req.setAttribute("items", items);
		// 转发请求
*/		req.getRequestDispatcher("/cartList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
