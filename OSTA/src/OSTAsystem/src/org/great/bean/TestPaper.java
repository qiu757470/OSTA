package org.great.bean;
/**
 * 
 * 试卷信息表
 * @author Administrator
 *
 */
public class TestPaper {
	private String test_paper_id;
	private String test_paper_name;
	private String test_paper_grade;
	private String test_paper_work;
	private String test_paper_type;
	private String test_paper_level;
	private String test_paper_time;
	private String test_paper_mechanism;
	private String test_paper_test;
	private String test_paper_single;
	private String test_paper_multiple;
	private String test_paper_no;
	public TestPaper(){}
	
	

	public TestPaper(String test_paper_id, String test_paper_name, String test_paper_grade, String test_paper_work,
			String test_paper_type, String test_paper_level, String test_paper_time, 
			String test_paper_mechanism, String test_paper_test, String test_paper_single, String test_paper_multiple,
			String test_paper_no) {
		super();
		this.test_paper_id = test_paper_id;
		this.test_paper_name = test_paper_name;
		this.test_paper_grade = test_paper_grade;
		this.test_paper_work = test_paper_work;
		this.test_paper_type = test_paper_type;
		this.test_paper_level = test_paper_level;
		this.test_paper_time = test_paper_time;
		this.test_paper_mechanism = test_paper_mechanism;
		this.test_paper_test = test_paper_test;
		this.test_paper_single = test_paper_single;
		this.test_paper_multiple = test_paper_multiple;
		this.test_paper_no = test_paper_no;
	}



	/**
	 * 
	 * get与set方法
	 * @return
	 */
	public String getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(String test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	public String getTest_paper_name() {
		return test_paper_name;
	}
	public void setTest_paper_name(String test_paper_name) {
		this.test_paper_name = test_paper_name;
	}
	public String getTest_paper_grade() {
		return test_paper_grade;
	}
	public void setTest_paper_grade(String test_paper_grade) {
		this.test_paper_grade = test_paper_grade;
	}
	public String getTest_paper_work() {
		return test_paper_work;
	}
	public void setTest_paper_work(String test_paper_work) {
		this.test_paper_work = test_paper_work;
	}
	public String getTest_paper_type() {
		return test_paper_type;
	}
	public void setTest_paper_type(String test_paper_type) {
		this.test_paper_type = test_paper_type;
	}
	public String getTest_paper_level() {
		return test_paper_level;
	}
	public void setTest_paper_level(String test_paper_level) {
		this.test_paper_level = test_paper_level;
	}
	public String getTest_paper_time() {
		return test_paper_time;
	}
	public void setTest_paper_time(String test_paper_time) {
		this.test_paper_time = test_paper_time;
	}


	public String getTest_paper_mechanism() {
		return test_paper_mechanism;
	}


	public void setTest_paper_mechanism(String test_paper_mechanism) {
		this.test_paper_mechanism = test_paper_mechanism;
	}


	public String getTest_paper_test() {
		return test_paper_test;
	}


	public void setTest_paper_test(String test_paper_test) {
		this.test_paper_test = test_paper_test;
	}



	public String getTest_paper_single() {
		return test_paper_single;
	}



	public void setTest_paper_single(String test_paper_single) {
		this.test_paper_single = test_paper_single;
	}



	public String getTest_paper_multiple() {
		return test_paper_multiple;
	}



	public void setTest_paper_multiple(String test_paper_multiple) {
		this.test_paper_multiple = test_paper_multiple;
	}



	public String getTest_paper_no() {
		return test_paper_no;
	}



	public void setTest_paper_no(String test_paper_no) {
		this.test_paper_no = test_paper_no;
	}

	
}
