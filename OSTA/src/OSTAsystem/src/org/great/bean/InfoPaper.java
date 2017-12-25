package org.great.bean;
/**
 * 
 * 考生和考卷信息外键表
 * @author Administrator
 *
 */
public class InfoPaper {
	private String stu_info_id;
	private String test_paper_id;
	public InfoPaper(){}
	public InfoPaper(String stu_info_id, String test_paper_id) {
		super();
		this.stu_info_id = stu_info_id;
		this.test_paper_id = test_paper_id;
	}
	/**
	 * get与set方法
	 * @return
	 */
	public String getStu_info_id() {
		return stu_info_id;
	}
	public void setStu_info_id(String stu_info_id) {
		this.stu_info_id = stu_info_id;
	}
	public String getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(String test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	
}
