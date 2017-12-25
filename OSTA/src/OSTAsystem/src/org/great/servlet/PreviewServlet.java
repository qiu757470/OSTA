package org.great.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.StuInfo;
import org.great.bean.TestAnswer;
import org.great.bean.TestPaper;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.StuInfoDaoImpl;
import org.great.daoimpl.TestAnswerDaoImpl;
import org.great.daoimpl.TestPaperDaoImpl;

/**
@author  丘文龙
@date 创建时间：2017年7月6日 上午10:53:27 
@version 1.0 
@parameter  
@since  
@return  
*/
public class PreviewServlet extends HttpServlet {
	public static String test_paper_id="27";
	/**
		 * Constructor of the object.
		 */
	public PreviewServlet() {
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
		//考试信息	
		TestAnswerDaoImpl testanswerdaoimpl=(TestAnswerDaoImpl) DaoFactory.getInstance(TestAnswerDaoImpl.class.getName());
		TestPaperDaoImpl tsetpaperdaoimpl=(TestPaperDaoImpl) DaoFactory.getInstance(TestPaperDaoImpl.class.getName());
		StuInfoDaoImpl stuinfodaoimpl=(StuInfoDaoImpl) DaoFactory.getInstance(StuInfoDaoImpl.class.getName());
		
		String action=request.getParameter("action")!=null?request.getParameter("action"):"";
		//试卷预览
		if("pretest".equals(action)){
			
			List<TestAnswer>testanswerone=testanswerdaoimpl.selecById("单选题",test_paper_id);
			request.setAttribute("TESTANSWERONE",testanswerone);
			
			List<TestAnswer>testanswermuch=testanswerdaoimpl.selecById("多选题",test_paper_id);
			request.setAttribute("TESTANSWERMUCH", testanswermuch);
			
			TestPaper testpaper=tsetpaperdaoimpl.selecTestById();
			request.setAttribute("TESTPAPER",testpaper);
			request.getRequestDispatcher("admin/OtsaPreview.jsp").forward(request, response);
		}
		 //考生信息预览
		else if("prestudent".equals(action)){
			List<StuInfo> stuinfo=stuinfodaoimpl.selecStuById();
			request.setAttribute("STUINFO", stuinfo);
			request.getRequestDispatcher("admin/candidate-list.jsp").forward(request, response);
			
		}
		//确认考试信息
		else if("confirm".equals(action)){
			List<StuInfo> stuinfo=(List<StuInfo>) stuinfodaoimpl.selectAll();
			request.setAttribute("STUDENT", stuinfo);
			 List<TestPaper>testpapers=(List<TestPaper>) tsetpaperdaoimpl.selectAll();
			request.setAttribute("TESTPAPERS", (TestPaper)testpapers.get(0));
			 	if(stuinfo!=null&&testpapers!=null){
				request.getRequestDispatcher("admin/proctor.jsp").forward(request, response);
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
