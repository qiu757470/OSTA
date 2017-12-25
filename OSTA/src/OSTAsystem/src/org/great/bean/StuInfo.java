package org.great.bean;

import java.util.List;

/**
 * 
 * 考生信息表
 * @author Administrator
 *
 */
public class StuInfo {
	private String stu_info_id;
	private String stu_info_name;
	private String stu_info_identity;
	private String stu_info_ticket;
	private String stu_info_grade;
	private String stu_info_sta;
	private String stu_info_no;
	public StuInfo(){}
	
	
	public StuInfo(String stu_info_id, String stu_info_name, String stu_info_identity, String stu_info_ticket,
			String stu_info_grade, String stu_info_sta, String stu_info_no) {
		super();
		this.stu_info_id = stu_info_id;
		this.stu_info_name = stu_info_name;
		this.stu_info_identity = stu_info_identity;
		this.stu_info_ticket = stu_info_ticket;
		this.stu_info_grade = stu_info_grade;
		this.stu_info_sta = stu_info_sta;
		this.stu_info_no = stu_info_no;
	}


	/**
	 * 
	 * get与set方法
	 * @return
	 */
	public String getStu_info_id() {
		return stu_info_id;
	}
	public void setStu_info_id(String stu_info_id) {
		this.stu_info_id = stu_info_id;
	}
	public String getStu_info_name() {
		return stu_info_name;
	}
	public void setStu_info_name(String stu_info_name) {
		this.stu_info_name = stu_info_name;
	}
	public String getStu_info_identity() {
		return stu_info_identity;
	}
	public void setStu_info_identity(String stu_info_identity) {
		this.stu_info_identity = stu_info_identity;
	}
	public String getStu_info_ticket() {
		return stu_info_ticket;
	}
	public void setStu_info_ticket(String stu_info_ticket) {
		this.stu_info_ticket = stu_info_ticket;
	}
	public String getStu_info_grade() {
		return stu_info_grade;
	}
	public void setStu_info_grade(String stu_info_grade) {
		this.stu_info_grade = stu_info_grade;
	}
	public String getStu_info_sta() {
		return stu_info_sta;
	}
	public void setStu_info_sta(String stu_info_sta) {
		this.stu_info_sta = stu_info_sta;
	}
	public String getStu_info_no() {
		return stu_info_no;
	}
	public void setStu_info_no(String stu_info_no) {
		this.stu_info_no = stu_info_no;
	}
	
}
