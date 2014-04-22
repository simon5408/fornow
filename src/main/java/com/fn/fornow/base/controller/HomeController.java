/**
 * 
 */
package com.fn.fornow.base.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fn.fornow.common.controller.CommonController;
import com.fn.fornow.common.controller.Module;
import com.fn.fornow.common.controller.path.ResultPath;
import com.fn.fornow.common.util.FreemarkerUtils;

/**
 * @author Simon Lv
 * @since Oct 29, 2013
 */
@Controller
@RequestMapping()
public class HomeController extends CommonController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		model.addAttribute("serverTime", dateFormat.format(new Date()));

		return ResultPath.GOTO_HOME;
	}

	@RequestMapping(value = ResultPath.login, method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("errorMessages", "");
		return ResultPath.GOTO_LOGIN;
	}

	@RequestMapping(value = ResultPath._403, method = RequestMethod.GET)
	public String limitFor403(Model model) {
		return ResultPath.GOTO_403;
	}

	@RequestMapping(value = ResultPath.logout, method = RequestMethod.GET)
	public String logout(Model model) {
		return ResultPath.GOTO_INDEX;
	}

	@RequestMapping("/hello")
	public String sayHello(HttpServletRequest request) {
		System.out.println("say Hello ……");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", " World!");
		String targetPath = "hello.html";
		FreemarkerUtils.crateHTML(request.getSession().getServletContext(), map, "/hello.ftl", targetPath);
		return redirect("/html/"+targetPath);
	}

	@RequestMapping("/hi")
	public String sayHi(HttpServletRequest request) {
		System.out.println("say hi ……");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Simon");
		String targetPath = "hi.html";
		FreemarkerUtils.crateHTML(request.getSession().getServletContext(), map, "/hi.ftl", targetPath);
		return redirect("/html/"+targetPath);
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
