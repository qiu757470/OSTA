package org.great.bean;
/**
 * 
 * 考生答题表
 * @author Administrator
 *
 */
public class StuAnswer {
	private String stu_answer_id;
	private String stu_answer_no;
	private String stu_answer_ans;
	private String stu_answer_grade;
	private String test_paper_id;
	public StuAnswer(){}
	public StuAnswer(String stu_answer_id, String stu_answer_no, String stu_answer_ans, String stu_answer_grade,
			String test_paper_id) {
		super();
		this.stu_answer_id = stu_answer_id;
		this.stu_answer_no = stu_answer_no;
		this.stu_answer_ans = stu_answer_ans;
		this.stu_answer_grade = stu_answer_grade;
		this.test_paper_id = test_paper_id;
	}
	/**
	 * get与set方法
	 * @return
	 */
	public String getStu_answer_id() {
		return stu_answer_id;
	}
	public void setStu_answer_id(String stu_answer_id) {
		this.stu_answer_id = stu_answer_id;
	}
	public String getStu_answer_no() {
		return stu_answer_no;
	}
	public void setStu_answer_no(String stu_answer_no) {
		this.stu_answer_no = stu_answer_no;
	}
	public String getStu_answer_ans() {
		return stu_answer_ans;
	}
	public void setStu_answer_ans(String stu_answer_ans) {
		this.stu_answer_ans = stu_answer_ans;
	}
	public String getStu_answer_grade() {
		return stu_answer_grade;
	}
	public void setStu_answer_grade(String stu_answer_grade) {
		this.stu_answer_grade = stu_answer_grade;
	}
	public String getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(String test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	
}
