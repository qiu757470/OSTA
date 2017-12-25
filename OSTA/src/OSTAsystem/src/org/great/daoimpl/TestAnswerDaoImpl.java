package org.great.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.basedao.IBaseDao;
import org.great.bean.TestAnswer;
import org.great.servlet.PreviewServlet;
import org.great.util.DBUtil;

/**
@author  丘文龙
@date 创建时间：2017年7月6日 上午9:29:32 
@version 1.0 
@parameter  
@since  
@return  
*/
public class TestAnswerDaoImpl implements IBaseDao{
	private static TestAnswerDaoImpl testAnswerDaoImpl;
	private Connection con = null;
	private PreparedStatement pro = null;
	private ResultSet rs = null;
	private TestAnswerDaoImpl(){}
	public static synchronized TestAnswerDaoImpl getInstance(){

		if(testAnswerDaoImpl==null){

			testAnswerDaoImpl = new TestAnswerDaoImpl();

		}
		return testAnswerDaoImpl;
	}
	@Override
	public List<?> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertByBean(Object bean) {
		TestAnswer testAnswer=(TestAnswer)bean;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBUtil.getConn();
			
			String sql="insert into test_answer(TEST_ANSWER_ID,Test_answer_a,Test_answer_ans,Test_answer_b,Test_answer_c,Test_answer_d," +
					"Test_answer_grade,Test_answer_no,Test_answer_tigan,Test_answer_type,TEST_PAPER_ID) " +" values(T_ANSWER.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,testAnswer.getTest_answer_a());
			ps.setString(2,testAnswer.getTest_answer_ans());
			ps.setString(3,testAnswer.getTest_answer_b());
			ps.setString(4,testAnswer.getTest_answer_c());
			ps.setString(5,testAnswer.getTest_answer_d());
			ps.setString(6,testAnswer.getTest_answer_grade());
			ps.setString(7,testAnswer.getTest_answer_no());
			ps.setString(8,testAnswer.getTest_answer_tigan());
			ps.setString(9,testAnswer.getTest_answer_type());
			ps.setString(10,PreviewServlet.test_paper_id);
			int count = ps.executeUpdate();
			if(count > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con, null, ps);
		}
		return false;
	}

	@Override
	public boolean updataByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<TestAnswer> selecById(String test_answer_type, String test_paper_id) {
		try {
			con = DBUtil.getConn();

			pro = con.prepareStatement("select *from test_answer where test_answer_type=? and test_paper_id=?");
	        pro.setString(1, test_answer_type);
	        pro.setString(2, test_paper_id);
			rs = pro.executeQuery();

			List list=new ArrayList();

			while(rs.next()){
				TestAnswer testPaper=new TestAnswer();
				testPaper.setTest_answer_a(rs.getString("test_answer_a"));
				testPaper.setTest_answer_ans(rs.getString("test_answer_ans"));
				testPaper.setTest_answer_b(rs.getString("test_answer_b"));
				testPaper.setTest_answer_c(rs.getString("test_answer_c"));
				testPaper.setTest_answer_d(rs.getString("test_answer_d"));
				testPaper.setTest_answer_grade(rs.getString("test_answer_grade"));
				testPaper.setTest_answer_id(rs.getString("test_answer_id"));
				testPaper.setTest_answer_no(rs.getString("test_answer_no"));
				testPaper.setTest_answer_tigan(rs.getString("test_answer_tigan"));
				testPaper.setTest_answer_type(rs.getString("test_answer_type"));
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

}
