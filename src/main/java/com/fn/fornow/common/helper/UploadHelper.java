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
package com.fn.fornow.common.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fn.fornow.common.util.DateUtils;
import com.fn.fornow.common.util.ImageUtils;
import com.fn.fornow.common.util.StringUtils;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 2:11:40 PM
 * @email simon-jiafa@126.com
 * 
 */
@Component
public class UploadHelper {
	public static final String UPLOAD_PATH = "upload/";
	public static final String FILE_NAME = "fileName";
	public static final String FILE_EXT = "fileExt";

	private static Logger logger = LoggerFactory.getLogger(UploadHelper.class);

	/**
	 * 
	 * @param request
	 * @param inputFileName
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> getFileNameByUpload(
			HttpServletRequest request, String inputFileName) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		String realDirPath = request.getSession().getServletContext()
				.getRealPath("/");
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			logger.debug("Spring3 MVC upload file with Multipart form");

			MultipartFile file = multipartRequest.getFiles(inputFileName)
					.get(0);
			long size = file.getSize();
			byte[] data = new byte[(int) size];
			InputStream input = file.getInputStream();
			input.read(data);

			// create file, if no app context path, will throws access denied.
			// seems like you could not create any file at tomcat/bin
			// directory!!!

			logger.debug("file.getContentType() ==> " + file.getContentType());
			String fileName = getWholeFileName();
			map.put(FILE_NAME, fileName);
			logger.debug("fileName ==> " + fileName);
			String fileExt = StringUtils.getFileExt(file.getOriginalFilename());
			map.put(FILE_EXT, fileExt);
			logger.debug("fileExt ==> " + fileExt);

			String wholeFileName = realDirPath + fileName + fileExt;
			logger.debug("file WholeName ==> " + wholeFileName);
			File outFile = new File(wholeFileName);

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

			// Save 640X320 image
			save640X320Image(realDirPath + fileName, fileExt);

			// Save 80X80 image
			save80X80Image(realDirPath + fileName, fileExt);
		}

		return map;
	}

	/**
	 * Save image as 640X320 size
	 * 
	 * @param realDirPath
	 * @param fileExt
	 * @throws Exception
	 */
	private static void save640X320Image(String realDirPath, String fileExt)
			throws Exception {
		String outFilePath = realDirPath + StringUtils.UNDERLINE
				+ ImageUtils.EXT_MEDIUM_SIZE + fileExt;
		ImageUtils.saveImageAsJpg(realDirPath + fileExt, outFilePath,
				ImageUtils.MEDIUM_WIDTH, ImageUtils.MEDIUM_HEIGHT);
	}

	/**
	 * Save image as 80X80 size
	 * 
	 * @param realDirPath
	 * @param fileExt
	 * @throws Exception
	 */
	private static void save80X80Image(String realDirPath, String fileExt)
			throws Exception {
		String outFilePath = realDirPath + StringUtils.UNDERLINE
				+ ImageUtils.EXT_SMALL_SIZE + fileExt;
		ImageUtils.saveImageAsJpg(realDirPath + fileExt, outFilePath,
				ImageUtils.SMALL_SIZE, ImageUtils.SMALL_SIZE);
	}

	/**
	 * Get the whole file name
	 * 
	 * @param fileName
	 * @return
	 */
	private static String getWholeFileName() {
		StringBuffer sb = new StringBuffer(UPLOAD_PATH);
		sb.append(DateUtils.todayToString()).append(File.separator)
				.append(UUID.randomUUID());

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
	public static void makeDir(File dir) {
		if (!dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
}
