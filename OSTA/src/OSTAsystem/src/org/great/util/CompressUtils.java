package org.great.util;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
@author  丘文龙
@date 创建时间：2017年7月6日 上午8:52:51 
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
	 * 对带指定密码的压缩文件zip进行解压
	 * @throws net.lingala.zip4j.exception.ZipException 
	 */
	public static void UnZip(File zipfile,String dest,String passwd)throws ZipException{
		// 传入ZIP文件地址，解压目录，zip文件密码
		
		 ZipFile zfile=new ZipFile(zipfile);
		 // 判断文件是否合法
		 if(!zfile.isValidZipFile()){
			throw new ZipException("压缩文件不合法，可能已经损坏！");
		 }
		 File file=new File(dest);
		 // 判断是否为文件夹以及是否存在文件
		 if(file.isDirectory() && !file.exists()){ 
			 
			 file.mkdirs();
		 }
		 //判断是否需要密码
		 if(zfile.isEncrypted()){
			 // 输入密码
			 zfile.setPassword(passwd.toCharArray());
		 }
		 // 进行解压
		 zfile.extractAll(dest);
		 
	}
}
