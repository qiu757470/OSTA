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
@author  ������
@date ����ʱ�䣺2017��7��3�� ����12:13:15 
@version 1.0 
@parameter  
@since  
@return  
*/
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
    private PrintWriter writer;
    private List list;
    // �ϴ�����
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
		//��ѹ����
		String zip_pwd= request.getParameter("pwd");
		// ����Ƿ�Ϊ��ý���ϴ�
					if (!ServletFileUpload.isMultipartContent(request)) {
					    // ���������ֹͣ
					    PrintWriter writer = response.getWriter();
					    writer.println("Error: ��������� enctype=multipart/form-data");
					    writer.flush();
					    return;
					}
			 
			        // �����ϴ�����
			        DiskFileItemFactory factory = new DiskFileItemFactory();
			        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
			        factory.setSizeThreshold(MEMORY_THRESHOLD);
			        // ������ʱ�洢Ŀ¼
			        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			 
			        ServletFileUpload upload = new ServletFileUpload(factory);
			         
			        // ��������ļ��ϴ�ֵ
			        upload.setFileSizeMax(MAX_FILE_SIZE);
			         
			        // �����������ֵ (�����ļ��ͱ�����)
			        upload.setSizeMax(MAX_REQUEST_SIZE);

			        // ���Ĵ���
			        upload.setHeaderEncoding("UTF-8"); 

			        // ������ʱ·�����洢�ϴ����ļ�
			        // ���·����Ե�ǰӦ�õ�Ŀ¼
			        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			       
			         
			        // ���Ŀ¼�������򴴽�
			        File uploadDir = new File(uploadPath);
			        if (!uploadDir.exists()) {
			            uploadDir.mkdir();
			        }
			 
			        try {
			            // ���������������ȡ�ļ�����
			            @SuppressWarnings("unchecked")
			          //  request.getParameter("fname")
			            
			            
			            List<FileItem> formItems = upload.parseRequest(request);
			 
			            if (formItems != null && formItems.size() > 0) {
			                // ����������
			                for (FileItem item : formItems) {
			                    // �����ڱ��е��ֶ�
			                    if (!item.isFormField()) {
			                        String fileName = new File(item.getName()).getName();
			                        String filePath = uploadPath + File.separator + fileName;
			                        File storeFile = new File(filePath);
			                        // �����ļ���Ӳ��
			                        item.write(storeFile);   //���ļ�����
			                        request.setAttribute("message",
			                            "�ļ��ϴ��ɹ�!");
			                        try {
			                        	//��ѹ�ļ�
			                        	CompressUtils.UnZip(storeFile, uploadPath, "123456");
									} catch (Exception e) {
										System.out.println("����");
									}
			                        
			                    }
			                }
			                //�����ļ��������ݿ�
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
