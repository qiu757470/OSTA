package org.great.bean;
/**
 * 
 * 教师表
 * @author Administrator
 *
 */
public class TBteacher {
	private int id;
	private String t_name;
	private String t_account;
	private String t_pwd;
	public TBteacher(){}
	
	public TBteacher(int id, String t_name, String t_account, String t_pwd) {
		super();
		this.id = id;
		this.t_name = t_name;
		this.t_account = t_account;
		this.t_pwd = t_pwd;
	}
	/**
	 * 
	 * get与set方法
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_account() {
		return t_account;
	}
	public void setT_account(String t_account) {
		this.t_account = t_account;
	}
	public String getT_pwd() {
		return t_pwd;
	}
	public void setT_pwd(String t_pwd) {
		this.t_pwd = t_pwd;
	}
	
}
