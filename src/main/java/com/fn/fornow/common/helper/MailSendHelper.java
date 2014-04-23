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
import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fn.fornow.common.init.SystemPropertyInit;

/**
 * @author Jiafa Lv
 * @date Apr 23, 2014 9:06:16 AM
 * @email simon-jiafa@126.com
 * 
 */
@Component
public class MailSendHelper {
	 @Autowired
	private JavaMailSender javaMailSender;
	
	private static Logger logger = Logger.getLogger(MailSendHelper.class);

	/**
	 * 发送的文本测试邮件
	 * 
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 */
	public void sendTextMail(String to,
			String mailSubject, String mailBody) {
		if (logger.isDebugEnabled())
			logger.debug("准备发送文本形式的邮件");
		SimpleMailMessage mail1 = new SimpleMailMessage();
		String from = SystemPropertyInit.getInstance().getProperty("mail.form");
		mail1.setFrom(from);// 发送人名片
		mail1.setTo(to);// 收件人邮箱
		mail1.setSubject(mailSubject);// 邮件主题
		mail1.setSentDate(new Date());// 邮件发送时间
		mail1.setText(mailBody);

		// 群发
		SimpleMailMessage[] mailMessages = { mail1 };
		javaMailSender.send(mailMessages);

		if (logger.isDebugEnabled())
			logger.debug("文本形式的邮件发送成功！！！");
	}

	/**
	 * 以 HTML脚本形式邮件发送
	 * 
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 */
	public void sendHtmlMail(String to, String mailSubject,
			String mailBody) {
		JavaMailSender mailSender = javaMailSender;
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			if (logger.isDebugEnabled())
				logger.debug("HTML脚本形式邮件正在发送");
			// 设置utf-8或GBK编码，否则邮件会有乱码
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,
					"UTF-8");
			// 设置发送人名片
			String from = SystemPropertyInit.getInstance().getProperty(
					"mail.form");
			helper.setFrom(from);
			// 设置收件人名片和地址
			helper.setTo(new InternetAddress("\""
					+ MimeUtility.encodeText("gamil邮箱") + "\" <" + to + ">"));// 发送者
			// 邮件发送时间
			helper.setSentDate(new Date());
			// 设置回复地址
			helper.setReplyTo(new InternetAddress(from));
			// 设置抄送的名片和地址
			// helper.setCc(InternetAddress.parse(MimeUtility.encodeText("抄送人001")
			// + " <@163.com>," + MimeUtility.encodeText("抄送人002")
			// + " <@foxmail.com>"));
			// 主题
			helper.setSubject("챔피언쉽");
			// 邮件内容，注意加参数true，表示启用html格式
			helper.setText(
					"<html><head></head><body><h1>hello!!我是乔布斯</h1></body></html>",
					true);
			// 发送
			 mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled())
			logger.debug("HTML脚本形式邮件发送成功！！！");
	}

	/**
	 * 以附件的形式发送邮件
	 * 
	 * @param to
	 *            收件人eamil 地址
	 * @param toName
	 *            收件人昵称
	 * @param mailSubject
	 *            主题
	 * @param mailBody
	 *            内容体
	 * @param files
	 *            附件
	 */
	public void sendFileMail(String to, String toName,
			String mailSubject, String mailBody, File[] files) {
		 JavaMailSender mailSender = javaMailSender;
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			if (logger.isDebugEnabled())
				logger.debug("带附件和图片的邮件正在发送");

			// 设置utf-8或GBK编码，否则邮件会有乱码
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,
					"UTF-8");
			// 设置发送人名片
			String from = SystemPropertyInit.getInstance().getProperty(
					"mail.form");
			helper.setFrom(from);

			// 设置收件人邮箱
			helper.setTo(new InternetAddress("\""
					+ MimeUtility.encodeText(toName) + "\" <" + to + ">"));

			// 设置回复地址
			// helper.setReplyTo(new InternetAddress("@qq.com"));

			// 设置收件人抄送的名片和地址(相当于群发了)
			// helper.setCc(InternetAddress.parse(MimeUtility.encodeText("邮箱001")
			// + " <@163.com>," + MimeUtility.encodeText("邮箱002")
			// + " <@foxmail.com>"));

			// 主题
			helper.setSubject(mailSubject);
			// 邮件内容，注意加参数true，表示启用html格式
			helper.setText(mailBody);
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++)
					// 加入附件
					helper.addAttachment(
							MimeUtility.encodeText(files[i].getName()),
							files[i]);
			}
			// 加入插图
			// helper.addInline(MimeUtility.encodeText("pic01"), new File(
			// "c:/temp/2dd24be463.jpg"));
			// 发送
			 mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("带附件和图片的邮件发送成功！！！");
		}
	}
}
