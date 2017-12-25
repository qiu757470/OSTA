package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.StuInfo;
import org.great.bean.TestPaper;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.StuInfoDaoImpl;
import org.great.daoimpl.TestPaperDaoImpl;

/**
@author  丘文龙
@date 创建时间：2017年7月8日 上午10:26:09 
@version 1.0 
@parameter  
@since  
@return  
*/
public class StudentLoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public StudentLoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String accurate=request.getParameter("accurate");
		String card=request.getParameter("card");
		String uname =request.getParameter("uname");
		StuInfoDaoImpl stuinfodaoimpl=(StuInfoDaoImpl) DaoFactory.getInstance(StuInfoDaoImpl.class.getName());
		StuInfo stuinfo=stuinfodaoimpl.selecByIdAndName(accurate,card,uname);
		
		if(null!=stuinfo){
			request.setAttribute("STUINFO", stuinfo);
			TestPaperDaoImpl tsetpaperdaoimpl=(TestPaperDaoImpl) DaoFactory.getInstance(TestPaperDaoImpl.class.getName());
			List<TestPaper>testpapers=(List<TestPaper>) tsetpaperdaoimpl.selectAll();
			request.setAttribute("TESTPAPERLIST", (TestPaper)testpapers.get(0));
			request.getRequestDispatcher("studentmain.jsp").forward(request, response);
		}else{
			response.sendRedirect("studentlogin.jsp");
		}
		String action=request.getParameter("action")!=null?request.getParameter("action"):"";
		if("stupreview".equals(action)){
			
			request.getRequestDispatcher("admin/OtsaPreview.jsp").forward(request, response);
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
