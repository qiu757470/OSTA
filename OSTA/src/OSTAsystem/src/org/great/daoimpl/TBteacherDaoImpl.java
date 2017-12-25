package org.great.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.great.basedao.IBaseDao;
import org.great.bean.TBteacher;
import org.great.util.DBUtil;

public class TBteacherDaoImpl implements IBaseDao{
	private Connection con=null;
	private PreparedStatement pro=null;
	private ResultSet rs=null;
	private static TBteacherDaoImpl tbteacherDaoImpl;
	private TBteacherDaoImpl(){}
	public static synchronized TBteacherDaoImpl getInstance(){

		if(tbteacherDaoImpl==null){

			tbteacherDaoImpl = new TBteacherDaoImpl();

		}
		return tbteacherDaoImpl;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updataByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	public TBteacher selectIdAndPwd(String t_account,String t_pwd) {
		TBteacher teacher=null;
		try {
			con=DBUtil.getConn();
			pro=con.prepareStatement("select*from tb_teacher where t_account=? and t_pwd=?");
			pro.setString(1, t_account);
			pro.setString(2, t_pwd);
			rs=pro.executeQuery();
			if(rs.next()){
				teacher=(new TBteacher(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(con, rs, pro);
		}
		return teacher;
	}
}
