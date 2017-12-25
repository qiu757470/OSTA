package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.TestPaper;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.TestPaperDaoImpl;

/**
@author  丘文龙
@date 创建时间：2017年7月11日 下午2:29:14 
@version 1.0 
@parameter  
@since  
@return  
*/
public class PreviewInfoServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public PreviewInfoServlet() {
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		TestPaperDaoImpl testpaper=(TestPaperDaoImpl) DaoFactory.getInstance(TestPaperDaoImpl.class.getName());
		List<TestPaper> testpaperlist=(List<TestPaper>) testpaper.selectAll();
		writer.print("{\"name\":\""+testpaperlist.get(0).getTest_paper_name()+"\"," 
				    + "\"grade\":\""+testpaperlist.get(0).getTest_paper_grade()+"\","
				    + "\"time\":\""+testpaperlist.get(0).getTest_paper_time()+"\","
				     + "\"test\":\""+testpaperlist.get(0).getTest_paper_test()+"\","
				     +"\"type\":\""+testpaperlist.get(0).getTest_paper_type()+"\","
				     +"\"work\":\""+testpaperlist.get(0).getTest_paper_work()+"\","
				     +"\"mechanism\":\""+testpaperlist.get(0).getTest_paper_mechanism()+"\","
				     +"\"level\":\""+testpaperlist.get(0).getTest_paper_level()+"\","
				     +"\"no\":\""+testpaperlist.get(0).getTest_paper_no()+"\","
				     +"\"renshu\":\""+10+"\"}");
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
