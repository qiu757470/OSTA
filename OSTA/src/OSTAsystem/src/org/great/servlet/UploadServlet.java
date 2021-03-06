package org.great.servlet;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.great.bean.StuInfo;
import org.great.bean.TestAnswer;
import org.great.bean.TestPaper;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.StuInfoDaoImpl;
import org.great.daoimpl.TestPaperDaoImpl;
import org.great.util.CompressUtils;
import org.great.util.ReadExcelFileUtil;

import com.google.gson.Gson;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
/**
@author  丘文龙
@date 创建时间：2017年7月3日 下午12:13:15 
@version 1.0 
@parameter  
@since  
@return  
*/
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
    private PrintWriter writer;
    private List list;
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	public UploadServlet() {
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
	
		
		PrintWriter out = response.getWriter();
		list = new ArrayList();
		//解压密码
		String zip_pwd= request.getParameter("pwd");
		// 检测是否为多媒体上传
					if (!ServletFileUpload.isMultipartContent(request)) {
					    // 如果不是则停止
					    PrintWriter writer = response.getWriter();
					    writer.println("Error: 表单必须包含 enctype=multipart/form-data");
					    writer.flush();
					    return;
					}
			 
			        // 配置上传参数
			        DiskFileItemFactory factory = new DiskFileItemFactory();
			        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
			        factory.setSizeThreshold(MEMORY_THRESHOLD);
			        // 设置临时存储目录
			        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			 
			        ServletFileUpload upload = new ServletFileUpload(factory);
			         
			        // 设置最大文件上传值
			        upload.setFileSizeMax(MAX_FILE_SIZE);
			         
			        // 设置最大请求值 (包含文件和表单数据)
			        upload.setSizeMax(MAX_REQUEST_SIZE);

			        // 中文处理
			        upload.setHeaderEncoding("UTF-8"); 

			        // 构造临时路径来存储上传的文件
			        // 这个路径相对当前应用的目录
			        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			       
			         
			        // 如果目录不存在则创建
			        File uploadDir = new File(uploadPath);
			        if (!uploadDir.exists()) {
			            uploadDir.mkdir();
			        }
			 
			        try {
			            // 解析请求的内容提取文件数据
			            @SuppressWarnings("unchecked")
			          //  request.getParameter("fname")
			            
			            
			            List<FileItem> formItems = upload.parseRequest(request);
			 
			            if (formItems != null && formItems.size() > 0) {
			                // 迭代表单数据
			                for (FileItem item : formItems) {
			                    // 处理不在表单中的字段
			                    if (!item.isFormField()) {
			                        String fileName = new File(item.getName()).getName();
			                        String filePath = uploadPath + File.separator + fileName;
			                        File storeFile = new File(filePath);
			                        // 保存文件到硬盘
			                        item.write(storeFile);   //将文件存入
			                        request.setAttribute("message",
			                            "文件上传成功!");
			                        try {
			                        	//解压文件
			                        	CompressUtils.UnZip(storeFile, uploadPath, "123456");
									} catch (Exception e) {
										System.out.println("解析");
									}
			                        
			                    }
			                }
			                //解析文件导入数据库
			                ReadExcelFileUtil.readxls(uploadPath);
			                System.out.println(uploadPath+"111111");
			            }
			            
			            
			            
			        } catch (Exception ex) {
			        	System.err.println("wrong");
			        }
			       
	        request.getRequestDispatcher("/admin/paper.jsp").forward(request, response);
//	        return;
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
