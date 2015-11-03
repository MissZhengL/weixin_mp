/**
 * hofan.cn Inc.
 * Copyright (c) 2006-2015 All Rights Reserved.
 */
package cn.hofan.weixin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lizhenhai
 * @version $Id: FileUtil.java, v 0.1 2015年9月24日 下午3:06:25 lizhenhai Exp $
 */
public class FileUtil {

	private static Log log = LogFactory.getLog(FileUtil.class);

	public static File createFile(String path,String filename) throws Exception {
		File pathname = new File(path);
		if (!pathname.exists()) {
			pathname.mkdirs();
		}
		File fileName = new File(pathname, filename);
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				log.info("创建空文件"+path+"/"+filename+"成功");
			} else {
				fileName.delete();
				fileName.createNewFile();
				log.info("删除之前的然后再创建空文件"+path+"/"+filename+"成功");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return fileName;
	}
	
	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		boolean flag = false;
		FileOutputStream o = null;
		
			try {
				o = new FileOutputStream(fileName);
				o.write(content.getBytes("utf-8"));
				o.close();
				if ("/opt/soft/tomcat_weixin/webapps/accesstoken.txt".equals(fileName.toString())) {
					log.info("把access_token写入"+fileName.toString()+"成功");
				}else {
					log.info("把orderdetails写入"+fileName.toString()+"成功");
				}
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		return flag;
	}
	
	/**
	 * 读TXT文件内容
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(File fileName) throws Exception {
		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					result = read;
				}
			} catch (Exception e) {
				log.error(e);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
//		log.info("读取出来的accesstoken是: "+result);
		return result;
	}

}
