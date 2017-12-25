package org.great.bean;
/**
 * 标准答案表
 * @author Administrator
 *
 */
public class TestAnswer {
	private String test_answer_id;
	private String test_answer_no;
	private String test_answer_ans;
	private String test_answer_grade;
	private String test_answer_type;
	private String test_answer_tigan;
	private String test_answer_a;
	private String test_answer_b;
	private String test_answer_c;
	private String test_answer_d;
	public TestAnswer(){}
	
	

	public TestAnswer(String test_answer_id, String test_answer_no, String test_answer_ans, String test_answer_grade,
			String test_answer_type, String test_answer_tigan, String test_answer_a, String test_answer_b,
			String test_answer_c, String test_answer_d) {
		super();
		this.test_answer_id = test_answer_id;
		this.test_answer_no = test_answer_no;
		this.test_answer_ans = test_answer_ans;
		this.test_answer_grade = test_answer_grade;
		this.test_answer_type = test_answer_type;
		this.test_answer_tigan = test_answer_tigan;
		this.test_answer_a = test_answer_a;
		this.test_answer_b = test_answer_b;
		this.test_answer_c = test_answer_c;
		this.test_answer_d = test_answer_d;
	}



	/**
	 * 
	 * get与set方法
	 * @return
	 */
	public String getTest_answer_id() {
		return test_answer_id;
	}
	public void setTest_answer_id(String test_answer_id) {
		this.test_answer_id = test_answer_id;
	}
	public String getTest_answer_no() {
		return test_answer_no;
	}
	public void setTest_answer_no(String test_answer_no) {
		this.test_answer_no = test_answer_no;
	}
	public String getTest_answer_ans() {
		return test_answer_ans;
	}
	public void setTest_answer_ans(String test_answer_ans) {
		this.test_answer_ans = test_answer_ans;
	}
	public String getTest_answer_grade() {
		return test_answer_grade;
	}
	public void setTest_answer_grade(String test_answer_grade) {
		this.test_answer_grade = test_answer_grade;
	}

	public String getTest_answer_tigan() {
		return test_answer_tigan;
	}

	public void setTest_answer_tigan(String test_answer_tigan) {
		this.test_answer_tigan = test_answer_tigan;
	}

	public String getTest_answer_a() {
		return test_answer_a;
	}

	public void setTest_answer_a(String test_answer_a) {
		this.test_answer_a = test_answer_a;
	}

	public String getTest_answer_b() {
		return test_answer_b;
	}

	public void setTest_answer_b(String test_answer_b) {
		this.test_answer_b = test_answer_b;
	}

	public String getTest_answer_c() {
		return test_answer_c;
	}

	public void setTest_answer_c(String test_answer_c) {
		this.test_answer_c = test_answer_c;
	}

	public String getTest_answer_d() {
		return test_answer_d;
	}

	public void setTest_answer_d(String test_answer_d) {
		this.test_answer_d = test_answer_d;
	}

	public String getTest_answer_type() {
		return test_answer_type;
	}

	public void setTest_answer_type(String test_answer_type) {
		this.test_answer_type = test_answer_type;
	}
	
}
