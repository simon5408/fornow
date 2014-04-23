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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fn.fornow.base.entity.EmailInfo;
import com.fn.fornow.common.controller.CommonController;
import com.fn.fornow.common.controller.Module;
import com.fn.fornow.common.controller.path.ResultPath;
import com.fn.fornow.common.helper.FreemarkerHelper;
import com.fn.fornow.common.helper.JSONHelper;
import com.fn.fornow.common.helper.MailSendHelper;
import com.fn.fornow.common.util.HttpUtils;
import com.fn.fornow.demo.entity.ReturnJsonBean;
import com.fn.fornow.enums.ReturnModule;

/**
 * @author Simon Lv
 * @since Oct 29, 2013
 */
@Controller
@RequestMapping()
public class HomeController extends CommonController {
	@Autowired
	private MailSendHelper sendMaileUtil;

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
		FreemarkerHelper.crateHTML(request.getSession().getServletContext(),
				map, "/hello.ftl", targetPath);
		return redirect(FreemarkerHelper.STATIC_FTL_PATH + targetPath);
	}

	@RequestMapping("/hi")
	public String sayHi(HttpServletRequest request) {
		System.out.println("say hi ……");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Simon");
		String targetPath = "hi.html";
		FreemarkerHelper.crateHTML(request.getSession().getServletContext(),
				map, "/hi.ftl", targetPath);
		return redirect(FreemarkerHelper.STATIC_FTL_PATH + targetPath);
	}

	@RequestMapping(value = "/mail")
	public String gotoMail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug(" Go to Mail page ==> ");
		return ResultPath.mail;
	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public void saveJsonInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug(" Send Email ==> ");

		EmailInfo emailInfo = JSONHelper.fromJson(HttpUtils.getReqJson(request),
				EmailInfo.class);

		sendMaileUtil.sendTextMail(emailInfo.getMailTo(),
				emailInfo.getMailSubject(), emailInfo.getMailContent());

		HttpUtils.respWrite(response,
				new ReturnJsonBean(ReturnModule.success.getStatus()).toJson());
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
