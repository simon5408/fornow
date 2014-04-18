package com.fn.fornow.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.fn.fornow.common.ViewName;
import com.fn.fornow.common.bean.Page;
import com.fn.fornow.common.controller.CommonController;
import com.fn.fornow.common.controller.Module;
import com.fn.fornow.common.controller.path.ResultPath;
import com.fn.fornow.common.orm.PropertyFilter;
import com.fn.fornow.common.util.HttpUtils;
import com.fn.fornow.demo.entity.Demo;
import com.fn.fornow.demo.entity.FriendsBean;
import com.fn.fornow.demo.entity.JsonBean;
import com.fn.fornow.demo.entity.ReturnJsonBean;
import com.fn.fornow.enums.ReturnModule;

/**
 * @author Simon Lv
 * @since 2012-8-9
 */
@Controller
@RequestMapping(ResultPath.demo)
public class DemoController extends CommonController {

	@RequestMapping
	public String list(Page page, HttpServletRequest request,
			HttpServletResponse response) {
		demoService.findPage(page);
		return forward(ViewName.list);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, Page page, Model model) {
		List<PropertyFilter> filters = PropertyFilter
				.buildFromHttpRequest(request);
		demoService.findPage(page, filters);
		extractParams(request);
		return forward(ViewName.list);
	}

	@RequestMapping("/edit-new")
	public String editNew(Model model) {
		return forward(ViewName.insert);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(Demo demo) {
		logger.debug("create: demo[{}]", demo);
		demoService.save(demo);
		return redirect(ResultPath.demo);
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		logger.debug("edit: id[{}]", id);
		return forward(ViewName.edit);
	}

	@RequestMapping(value = "/update/{demo.id}", method = RequestMethod.POST)
	public String update(Demo demo) {
		return redirect(ResultPath.demo);
	}

	@RequestMapping("/destroy/{id}")
	public String destroy(@PathVariable long id) {
		logger.debug("destroy: id[{}]", id);
		demoService.delete(id);
		return redirect(ResultPath.demo);
	}

	@ModelAttribute("demo")
	public Demo getDemo(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		Long id = extractId(requestURI);
		if (id == null) {
			return new Demo();
		}
		return demoService.get(id);
	}

	@RequestMapping(value = "/getJsonInfo", method = RequestMethod.GET)
	public void getJsonInfo(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		logger.debug("[DemoController] getExpInfo ==> ");

		String retStr = new Gson().toJson(this.getJsonBean());
		logger.debug("[getJsonInfo] retStr ==> " + retStr);
		HttpUtils.respWrite(response, retStr);
	}

	private JsonBean getJsonBean() {
		List<FriendsBean> friends = new ArrayList<FriendsBean>();
		friends.add(new FriendsBean("Goorge", 1, 32));
		friends.add(new FriendsBean("Enjoy", 1, 23));
		friends.add(new FriendsBean("Tomy", 1, 26));

		return new JsonBean("Simon", 33, friends);
	}

	@RequestMapping(value = "/saveJsonInfo", method = RequestMethod.POST)
	public void saveJsonInfo(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		logger.debug("[DeliveryController] saveJsonInfo ==> ");

		this.str2bean(HttpUtils.getReqJson(request));

		HttpUtils.respWrite(response,
				new ReturnJsonBean(ReturnModule.success.getStatus()).toJson());
	}

	private void str2bean(String jsonStr) {
		logger.debug("[str2bean] jsonStr ==> " + jsonStr);
		JsonBean jsonBean = new Gson().fromJson(jsonStr, JsonBean.class);
		logger.debug("[str2bean] name ==> " + jsonBean.getName());
		logger.debug("[str2bean] friends name ==> "
				+ jsonBean.getFrines().get(0).getName());
	}

	@RequestMapping(value = "/saveDemoInfo", method = RequestMethod.POST)
	public void saveDemoInfo(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Demo demo = new Gson().fromJson(HttpUtils.getReqJson(request),
				Demo.class);
		demoService.save(demo);

		HttpUtils.respWrite(response,
				new ReturnJsonBean(ReturnModule.success.getStatus()).toJson());
	}

	@RequestMapping(value = "/getAllDemoInfos", method = RequestMethod.GET)
	public void getAllDemoInfos(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		logger.debug("[DemoController] getAllDemoInfos ==> ");

		String retStr = new Gson().toJson(demoService.findAll());
		logger.debug("[getJsonInfo] retStr ==> " + retStr);
		HttpUtils.respWrite(response, retStr);
	}

	@Override
	protected String getModule() {
		return Module.example.getName();
	}

}
