package org.great.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.great.bean.StuInfo;
import org.great.bean.TestAnswer;
import org.great.bean.TestPaper;
import org.great.daofactory.DaoFactory;
import org.great.daoimpl.StuInfoDaoImpl;
import org.great.daoimpl.TestAnswerDaoImpl;
import org.great.daoimpl.TestPaperDaoImpl;

public class ReadExcelFileUtil { 
	/**
	 * ����excel�ķ���
	 * @param fileName excel�ļ���·��
	 * @return ���ؽ������
	 */
	public static List<List<String>> readExcelData(String fileName) {

		List<List<String>> result = new ArrayList<List<String>>();
		try {

			//������������������������ the xlsx/xls file  
			FileInputStream fis = new FileInputStream(fileName);  

			//(����������ʵ��)Create Workbook instance for xlsx/xls file input stream  
			Workbook workbook = null;

			//�ж�excel�ļ�����
			if(fileName.toLowerCase().endsWith("xlsx")){  
				workbook = new XSSFWorkbook(fis);  
			}else if(fileName.toLowerCase().endsWith("xls")){  
				workbook = new HSSFWorkbook(fis);  
			}

			//����ȡ��xlsx�����sheet�����Get the number of sheets in the xlsx file  
			int numberOfSheets = workbook.getNumberOfSheets();  

			//����Ȼ�Ǳ���ÿһ��sheet��loop through each of the sheets
			for(int i=0; i < numberOfSheets; i++){  

				//���϶���λsheet��Get the nth sheet from the workbook  
				Sheet sheet = workbook.getSheetAt(i);  

				//����Ȼ��sheet����ô������һ���Ǳ���sheet��ÿһ�У�every sheet has rows, iterate over them  
				Iterator<Row> rowIterator = sheet.iterator();  
				while (rowIterator.hasNext()){ 
					//������List
					List<String> rowList = new ArrayList<String>();

					//���õ�ÿһ�еĶ���Get the row object  
					Row row = rowIterator.next();  

					//����ÿһ�ж��ɶ����Ԫ����ɣ����Կ϶��Ǳ���ÿ�еĵ�Ԫ��Every row has columns, get the column iterator and iterate over them  
					Iterator<Cell> cellIterator = row.cellIterator();  
					while (cellIterator.hasNext())   {
						//��ȡcell����
						Cell cell = cellIterator.next();  

						//�����ÿ����Ԫ�����ͣ����Ǹ�ʲô�����������Ǹ���˼�ˣ�check the cell type and process accordingly  
						switch(cell.getCellType()){

						//�жϵ�Ԫ���Ƿ�Ϊstring����
						case Cell.CELL_TYPE_STRING:
							//��ÿ��cell���ݷŽ���List��
							rowList.add(cell.getStringCellValue()+"_");  
							break;  

						case Cell.CELL_TYPE_NUMERIC:  
							//��ÿ��cell���ݷŽ���List��
							String str = cell.getNumericCellValue()+"_";
							rowList.add(str);
							break; 
						}

					} //������ǽ�����Ԫ�������end of cell iterator  

					//���м�����ӵ����������
					result.add(rowList);
				}
			}   
			//��������Ҫ������close file input stream  
			fis.close();  
		}catch (IOException e) {
			System.out.println("read excel wrong"); 
		}  

		//���ؽ����
		return result;  
	} 
	
	public static void readxls(String uploadPath){
		String fileName =uploadPath+File.separator+"exam\\PaperInfo.xls";
		List<List<String>> list = ReadExcelFileUtil.readExcelData(fileName);

		String stringTitle[]=String.valueOf(list.get(1)).split("_,");
		TestPaper testPaper=new TestPaper();
		testPaper.setTest_paper_no(stringTitle[0]);
		System.out.println(stringTitle[1]);
		testPaper.setTest_paper_name(stringTitle[1]);
		testPaper.setTest_paper_time(stringTitle[2]);
		testPaper.setTest_paper_type(stringTitle[3]);
		testPaper.setTest_paper_work(stringTitle[4]);
		testPaper.setTest_paper_mechanism(stringTitle[5]);
		testPaper.setTest_paper_level(stringTitle[6]);
		testPaper.setTest_paper_grade(stringTitle[7]);
		testPaper.setTest_paper_single(stringTitle[8]);
		testPaper.setTest_paper_multiple(stringTitle[9]);
		TestPaperDaoImpl testPaperDaoImpl=(TestPaperDaoImpl)DaoFactory.
				getInstance(TestPaperDaoImpl.class.getName());
		testPaperDaoImpl.insertByBean(testPaper);
		for (int i = 3; i < list.size(); i++) {
			String stringC[]=String.valueOf(list.get(i)).split("_,");

			TestAnswer testAnswer=new TestAnswer();
			testAnswer.setTest_answer_type(stringC[0].substring(stringC[0].indexOf("[")+1));
			testAnswer.setTest_answer_no(stringC[1]);
			testAnswer.setTest_answer_tigan(stringC[2]);
			testAnswer.setTest_answer_a(stringC[3]);
			testAnswer.setTest_answer_b(stringC[4]);
			testAnswer.setTest_answer_c(stringC[5]);
			testAnswer.setTest_answer_d(stringC[6]);
			testAnswer.setTest_answer_ans(stringC[7]);
			testAnswer.setTest_answer_grade(stringC[8].substring(0,stringC[8].indexOf("_]")));
			TestAnswerDaoImpl testAnswerDaoImpl=(TestAnswerDaoImpl)DaoFactory.getInstance(TestAnswerDaoImpl.class.getName());
			testAnswerDaoImpl.insertByBean(testAnswer);
		}


		String fileNameOtherOne =uploadPath+File.separator+ "exam\\UserInfo.xls";
		List<List<String>> listOtherOne = ReadExcelFileUtil.readExcelData(fileNameOtherOne);
		for (int i = 1; i < listOtherOne.size(); i++) {
			String stringU[]=String.valueOf(listOtherOne.get(i)).split("_,");
			StuInfo stuInfo=new StuInfo();
			stuInfo.setStu_info_ticket(stringU[0].substring(stringU[0].indexOf("[")+1).trim());
			stuInfo.setStu_info_name(stringU[1]);
			stuInfo.setStu_info_identity(stringU[2]);
			stuInfo.setStu_info_no(stringU[3].substring(0,stringU[3].indexOf("_]")).trim());
			StuInfoDaoImpl stuinfodaoimpl=(StuInfoDaoImpl) DaoFactory.getInstance(StuInfoDaoImpl.class.getName());
			stuinfodaoimpl.insertByBean(stuInfo);
		}

	}
}
