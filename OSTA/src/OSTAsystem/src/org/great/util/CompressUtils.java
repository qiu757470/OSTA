package org.great.util;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
@author  ������
@date ����ʱ�䣺2017��7��6�� ����8:52:51 
@version 1.0 
@parameter  
@since  
@return  
*/
public class CompressUtils {
	/**
	 * 
	 * @param zipfile
	 * @param dest
	 * @param passwd
	 * @throws ZipException
	 * �Դ�ָ�������ѹ���ļ�zip���н�ѹ
	 * @throws net.lingala.zip4j.exception.ZipException 
	 */
	public static void UnZip(File zipfile,String dest,String passwd)throws ZipException{
		// ����ZIP�ļ���ַ����ѹĿ¼��zip�ļ�����
		
		 ZipFile zfile=new ZipFile(zipfile);
		 // �ж��ļ��Ƿ�Ϸ�
		 if(!zfile.isValidZipFile()){
			throw new ZipException("ѹ���ļ����Ϸ��������Ѿ��𻵣�");
		 }
		 File file=new File(dest);
		 // �ж��Ƿ�Ϊ�ļ����Լ��Ƿ�����ļ�
		 if(file.isDirectory() && !file.exists()){ 
			 
			 file.mkdirs();
		 }
		 //�ж��Ƿ���Ҫ����
		 if(zfile.isEncrypted()){
			 // ��������
			 zfile.setPassword(passwd.toCharArray());
		 }
		 // ���н�ѹ
		 zfile.extractAll(dest);
		 
	}
}
