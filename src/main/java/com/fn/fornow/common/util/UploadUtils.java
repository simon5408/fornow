/*****************************************************************************
 *
 *                      FORNOW PROPRIETARY INFORMATION
 *
 *          The information contained herein is proprietary to ForNow
 *           and shall not be reproduced or disclosed in whole or in part
 *                    or used for any design or manufacture
 *              without direct written authorization from ForNow.
 *
 *            Copyright (c) 2014 by ForNow.  All rights reserved.
 *
 *****************************************************************************/
package com.fn.fornow.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 2:11:40 PM
 * @email simon-jiafa@126.com
 * 
 */
@Component
public class UploadUtils {
	public static final String UPLOAD_PATH = "/home/simon/javaspace/upload";

	private static Logger logger = LoggerFactory.getLogger(UploadUtils.class);

	/**
	 * 
	 * @param request
	 * @param inputFileName
	 * @return
	 * @throws IOException
	 */
	public static String getFileNameByUpload(HttpServletRequest request, String inputFileName)
			throws IOException {
		String fileName = null;
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			logger.debug("Spring3 MVC upload file with Multipart form");

			MultipartFile file = multipartRequest.getFiles(inputFileName).get(0);
			long size = file.getSize();
			byte[] data = new byte[(int) size];
			InputStream input = file.getInputStream();
			input.read(data);

			// create file, if no app context path, will throws access denied.
			// seems like you could not create any file at tomcat/bin
			// directory!!!
			logger.debug("file.getOriginalFilename() ==> "
					+ file.getOriginalFilename());
			logger.debug("file.getContentType() ==> " + file.getContentType());
			logger.debug("file.getName() ==> " + file.getName());
			fileName = getWholeFileName(file.getOriginalFilename());
			File outFile = new File(fileName);
			logger.debug("file WholeName ==> " + UPLOAD_PATH + File.separator
					+ fileName);
			if (!outFile.exists()) {
				makeDir(outFile.getParentFile());
				outFile.createNewFile();
				logger.debug("full path = " + outFile.getAbsolutePath());
			} else {
				logger.debug("full path = " + outFile.getAbsolutePath());
			}
			FileOutputStream outStream = new FileOutputStream(outFile);

			outStream.write(data);
			outStream.close();
			input.close();
		}

		return fileName;
	}

	private static String getWholeFileName(String fileName) {
		StringBuffer sb = new StringBuffer(UPLOAD_PATH);
		sb.append(File.separator).append(System.currentTimeMillis())
				.append(fileName);

		return sb.toString();
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean isSucc4DelFile(String sPath) {
		boolean flag = false;
		logger.debug(sPath);
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			logger.debug("File is delete successfully!");
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = isSucc4DelFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create package
	 * 
	 * @param dir
	 */
	private static void makeDir(File dir) {
		if (!dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
}
