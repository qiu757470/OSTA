package org.great.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.basedao.IBaseDao;
import org.great.bean.TestPaper;
import org.great.servlet.PreviewServlet;
import org.great.util.DBUtil;

/**
@author  丘文龙
@date 创建时间：2017年7月5日 上午9:27:15 
@version 1.0 
@parameter  
@since  
@return  
*/
public class TestPaperDaoImpl implements IBaseDao{
	private Connection con=null;
	private PreparedStatement pro=null;
	private ResultSet rs = null;
	private static TestPaperDaoImpl testPaperDaoImpl;
	private TestPaperDaoImpl(){}
	public static synchronized TestPaperDaoImpl getInstance(){

		if(testPaperDaoImpl==null){

			testPaperDaoImpl = new TestPaperDaoImpl();

		}
		return testPaperDaoImpl;
	}
	@Override
	public List<?> selectAll() {

		try {
			con = DBUtil.getConn();
			pro = con.prepareStatement("select * from test_paper");
			rs = pro.executeQuery();
			List list=new ArrayList();

			while(rs.next()){
				TestPaper testPaper=new TestPaper();
				testPaper.setTest_paper_id(rs.getString("test_paper_id"));
				testPaper.setTest_paper_grade(rs.getString("test_paper_grade"));
				testPaper.setTest_paper_level(rs.getString("test_paper_level"));
				testPaper.setTest_paper_mechanism(rs.getString("test_paper_mechanism"));
				testPaper.setTest_paper_name(rs.getString("test_paper_name"));
				testPaper.setTest_paper_test(rs.getString("test_paper_test"));
				testPaper.setTest_paper_time(rs.getString("test_paper_time"));
				testPaper.setTest_paper_type(rs.getString("test_paper_type"));
				testPaper.setTest_paper_work(rs.getString("test_paper_work"));
				testPaper.setTest_paper_single(rs.getString("test_paper_single"));
				testPaper.setTest_paper_multiple(rs.getString("test_paper_multiple"));
				testPaper.setTest_paper_no(rs.getString("test_paper_no"));
				list.add(testPaper);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con,rs, pro);
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertByBean(Object bean) {
		TestPaper testpapeer=(TestPaper) bean;
		try {
			con=DBUtil.getConn();
			pro=con.prepareStatement("insert into TEST_PAPER(Test_paper_id,Test_paper_no,Test_paper_grade,Test_paper_level,Test_paper_mechanism,Test_paper_multiple," +
					"Test_paper_name,Test_paper_single,Test_paper_time,Test_paper_type,Test_paper_work) " +" values(T_PAPER.nextval,?,?,?,?,?,?,?,?,?,?)");
			pro.setString(1,testpapeer.getTest_paper_grade());
			pro.setString(2,testpapeer.getTest_paper_no());
			pro.setString(3,testpapeer.getTest_paper_level());
			pro.setString(4,testpapeer.getTest_paper_mechanism());
			pro.setString(5,testpapeer.getTest_paper_multiple());
			pro.setString(6,testpapeer.getTest_paper_name());
			pro.setString(7,testpapeer.getTest_paper_single());
			pro.setString(8,testpapeer.getTest_paper_time());
			pro.setString(9,testpapeer.getTest_paper_type());
			pro.setString(10,testpapeer.getTest_paper_work());
			int count= 	pro.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con, null, pro);
		}
		return false;
	}

	@Override
	public boolean updataByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	public TestPaper selecTestById() {
		try {
			con = DBUtil.getConn();
			pro = con.prepareStatement("select * from test_paper where test_paper_id=?");
			pro.setString(1,PreviewServlet.test_paper_id);
			rs = pro.executeQuery();
			if(rs.next()){
				TestPaper testPaper=new TestPaper();
				testPaper.setTest_paper_grade(rs.getString("test_paper_grade"));
				testPaper.setTest_paper_id(rs.getString("test_paper_id"));
				testPaper.setTest_paper_level(rs.getString("test_paper_level"));
				testPaper.setTest_paper_mechanism(rs.getString("test_paper_mechanism"));
				testPaper.setTest_paper_name(rs.getString("test_paper_name"));
				testPaper.setTest_paper_test(rs.getString("test_paper_test"));
				testPaper.setTest_paper_time(rs.getString("test_paper_time"));
				testPaper.setTest_paper_type(rs.getString("test_paper_type"));
				testPaper.setTest_paper_work(rs.getString("test_paper_work"));
				return testPaper;

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con,rs, pro);
		}
		return null;
	}

}
