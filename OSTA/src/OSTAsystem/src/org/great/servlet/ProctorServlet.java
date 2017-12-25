package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.StuInfo;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.StuInfoDaoImpl;

import com.google.gson.Gson;

/**
@author  丘文龙
@date 创建时间：2017年7月10日 上午11:36:32 
@version 1.0 
@parameter  
@since  
@return  
*/
public class ProctorServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ProctorServlet() {
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
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String action=request.getParameter("action")!=null?request.getParameter("action"):"";
			
			String []stusta=request.getParameterValues("stu");
			StuInfoDaoImpl stuinfodaoimpl=(StuInfoDaoImpl) DaoFactory.getInstance(StuInfoDaoImpl.class.getName());
			List<StuInfo>stuinfo=(List<StuInfo>) stuinfodaoimpl.selectAll();
			if("stusta".equals(action)){
				Gson gson=new Gson();
				pw.println(gson.toJson(stuinfo));
				pw.flush();
				pw.close();
			}
			else if("cheating".equals(action)){
				for(int i=0;i<stusta.length;i++){
					String staid=stusta[i];
					boolean updatasta=stuinfodaoimpl.updataById("3",staid);
				}
				
			}
			else if("papers".equals(action)){
				for(int i=0;i<stusta.length;i++){
					String staid=stusta[i];
					boolean updatasta=stuinfodaoimpl.updataById("4",staid);
				}
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
