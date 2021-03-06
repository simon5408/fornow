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
package com.fn.fornow.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fn.fornow.base.entity.UploadFiles;
import com.fn.fornow.common.ViewName;
import com.fn.fornow.common.bean.Page;
import com.fn.fornow.common.controller.CommonController;
import com.fn.fornow.common.controller.Module;
import com.fn.fornow.common.controller.path.ResultPath;
import com.fn.fornow.common.helper.UploadHelper;
import com.fn.fornow.common.orm.PropertyFilter;
import com.fn.fornow.common.util.ImageUtils;
import com.fn.fornow.common.util.StringUtils;

/**
 * @author Jiafa Lv
 * @date Apr 21, 2014 10:52:20 AM
 * @email simon-jiafa@126.com
 * 
 */
@Controller
@RequestMapping(ResultPath.upload)
public class UploadController extends CommonController {

	@RequestMapping
	public String list(Page page, HttpServletRequest request,
			HttpServletResponse response) {
		uploadFilesService.findPage(page);
		return forward(ViewName.list);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, Page page, Model model) {
		List<PropertyFilter> filters = PropertyFilter
				.buildFromHttpRequest(request);
		uploadFilesService.findPage(page, filters);
		extractParams(request);
		return forward(ViewName.list);
	}

	@RequestMapping("/edit-new")
	public String editNew(Model model) {
		return forward(ViewName.insert);
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		logger.debug("edit: id[{}]", id);
		return forward(ViewName.insert);
	}

	@RequestMapping("/destroy/{id}")
	public String destroy(HttpServletRequest request, @PathVariable long id) {
		logger.debug("destroy: id[{}]", id);

		UploadFiles uploadFiles = uploadFilesService.get(id);
		if (uploadFiles != null) {
			String wholePath = request.getSession().getServletContext()
					.getRealPath("/");
			String originPath = wholePath + uploadFiles.getFilepath()
					+ uploadFiles.getFileExt();
			String mediumPath = wholePath + uploadFiles.getMediumpath()
					+ uploadFiles.getFileExt();
			String smallPath = wholePath + uploadFiles.getSmallpath()
					+ uploadFiles.getFileExt();
			if (UploadHelper.isSucc4DelFile(originPath)
					&& UploadHelper.isSucc4DelFile(mediumPath)
					&& UploadHelper.isSucc4DelFile(smallPath)) {
				logger.debug("Try to delete column by: id[{}]", id);
				uploadFilesService.delete(id);
			}
		}

		return redirect(ResultPath.upload);
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String getUploadFile(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Map<String, String> fileMap = UploadHelper.getFileNameByUpload(
					request, "uploadFile");
			String fileName = fileMap.get(UploadHelper.FILE_NAME);

			UploadFiles uploadFiles = new UploadFiles();
			uploadFiles.setFilepath(fileName);
			uploadFiles.setMediumpath(fileName + StringUtils.UNDERLINE
					+ ImageUtils.EXT_MEDIUM_SIZE);
			uploadFiles.setSmallpath(fileName + StringUtils.UNDERLINE
					+ ImageUtils.EXT_SMALL_SIZE);
			uploadFiles.setFileExt(fileMap.get(UploadHelper.FILE_EXT));
			uploadFilesService.save(uploadFiles);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return redirect(ResultPath.upload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fn.fornow.common.controller.CommonController#getModule()
	 */
	@Override
	protected String getModule() {
		return Module.example.getName();
	}

}
