package org.great.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.basedao.IBaseDao;
import org.great.basedao.StuInfoDao;
import org.great.bean.StuInfo;
import org.great.bean.TBteacher;
import org.great.bean.TestPaper;
import org.great.util.DBUtil;
/**
@author  丘文龙
@date 创建时间：2017年7月4日 下午5:38:02 
@version 1.0 
@parameter  
@since  
@return  
*/
public class StuInfoDaoImpl implements StuInfoDao{
	
	private Connection con=null;
	private PreparedStatement pro=null;
	private ResultSet rs = null;
	private static StuInfoDaoImpl stuInfoDaoImpl;
	private StuInfoDaoImpl(){}
	public static synchronized StuInfoDaoImpl getInstance(){

		if(stuInfoDaoImpl==null){

			stuInfoDaoImpl = new StuInfoDaoImpl();

		}
		return stuInfoDaoImpl;
	}
	@Override
	public List<?> selectAll() {

		try {
			con = DBUtil.getConn();

			pro = con.prepareStatement("select * from STU_INFO");

			rs = pro.executeQuery();

			List list=new ArrayList();

			while(rs.next()){
				StuInfo stuInfo=new StuInfo();
				stuInfo.setStu_info_grade(rs.getString("stu_info_grade"));
				stuInfo.setStu_info_id(rs.getString("stu_info_id"));
				stuInfo.setStu_info_identity(rs.getString("stu_info_identity"));
				stuInfo.setStu_info_name(rs.getString("stu_info_name"));
				stuInfo.setStu_info_ticket(rs.getString("stu_info_ticket"));
				stuInfo.setStu_info_sta(rs.getString("stu_info_sta"));

				list.add(stuInfo);
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
		StuInfo stuinfo=(StuInfo) bean;
		try {
			con=DBUtil.getConn();
			pro=con.prepareStatement("insert into STU_INFO(stu_info_grade,stu_info_id,stu_info_identity,stu_info_name,stu_info_ticket,stu_info_sta,Stu_info_no) values(?,S_INFO.nextval,?,?,?,?,?)");
			pro.setString(1,stuinfo.getStu_info_grade());
			pro.setString(2,stuinfo.getStu_info_identity().trim());
			pro.setString(3,stuinfo.getStu_info_name().trim());
			pro.setString(4,stuinfo.getStu_info_ticket());
			pro.setString(5,stuinfo.getStu_info_sta());
			pro.setString(6,stuinfo.getStu_info_no());
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
	public List<StuInfo> selecStuById() {
		try {
			con = DBUtil.getConn();

			pro = con.prepareStatement("select * from STU_INFO left join test_paper on STU_INFO.STU_INFO_ID=test_paper.TEST_PAPER_ID");
			rs = pro.executeQuery();
			List list=new ArrayList();
			while(rs.next()){
				StuInfo stuInfo=new StuInfo();
				stuInfo.setStu_info_grade(rs.getString("stu_info_grade"));
				stuInfo.setStu_info_id(rs.getString("stu_info_id"));
				stuInfo.setStu_info_identity(rs.getString("stu_info_identity"));
				stuInfo.setStu_info_name(rs.getString("stu_info_name"));
				stuInfo.setStu_info_ticket(rs.getString("stu_info_ticket"));
				stuInfo.setStu_info_sta(rs.getString("stu_info_sta"));
				list.add(stuInfo);
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
	public StuInfo selecByIdAndName(String accurate, String card, String uname) {
		StuInfo stuInfo=null;
		try {
			con=DBUtil.getConn();
			pro=con.prepareStatement("select * from STU_INFO where STU_INFO_TICKET=? and STU_INFO_IDENTITY=? and STU_INFO_NAME=?");
			pro.setString(1, accurate);
			pro.setString(2, card);
			pro.setString(3, uname);
			rs=pro.executeQuery();
			if(rs.next()){
				stuInfo=new StuInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con, rs, pro);
		}
		return stuInfo;
	}
	public boolean updataById(String sta, String staid) {
		
		try {
			con=DBUtil.getConn();
			pro=con.prepareStatement("update STU_INFO set STU_INFO_STA=? where STU_INFO_TICKET=? ");
			pro.setString(1, sta);
			pro.setString(2, staid);
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
	

}
