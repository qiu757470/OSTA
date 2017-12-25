package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.basedao.IBaseDao;
import org.great.bean.TBteacher;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.TBteacherDaoImpl;
import org.great.util.DBUtil;

public class AdminLoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminLoginServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account=request.getParameter("acc");
		String pwd=request.getParameter("pwd");
		if(DBUtil.teachname.equals(account)&&DBUtil.teachpwd.equals(pwd)){
			HttpSession session=request.getSession();
			session.setAttribute("USERNAME", DBUtil.teachname);
			
			session.setAttribute("xiamen", DBUtil.xiamen);
			request.getRequestDispatcher("admin/interface.jsp").forward(request, response);
		}else{
			response.sendRedirect("adminlogin.jsp");
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
