package com.baiyuting.util;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MimeValidator {

	/**
	 * 是否是合法的上传文件
	 * 
	 * @param object
	 * @param request
	 * @return
	 */
	public static boolean isValidMime(Object object, HttpServletRequest request) {
		// 1、必须确定是否上传文件
		MultipartResolver multipartResolver = new CommonsMultipartResolver();// 准备进行上传文件的处理
		if (multipartResolver.isMultipart(request)) {
			String mimeContent = MessageUtil.getMessage(object, "mimeType");//
			if (StringUtils.isBlank(mimeContent)) {// 没有规则
				return true;
			} else {// 需要针对每一个操作进行规则的匹配检查
				String mimeRules[] = mimeContent.split("\\|");// 取出全部类型
				MultipartRequest multipartRequest = (MultipartRequest) request;// 处理上传的request
				Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();// 所有的上传文件内容
				if (fileMap.size() > 0) {// 当前的表单已经定义有指定的上传处理操作
					Iterator<Map.Entry<String, MultipartFile>> iterator = fileMap.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry<String, MultipartFile> entry = iterator.next();
						// System.out.println("参数名称：" + entry.getKey() +
						// "，文件大小：" + entry.getValue().getSize());
						if (entry.getValue().getSize() > 0) {// 现在表单有文件上传，就需要进行文件类型的匹配
							if (!ValidatorUtil.isValidMime(mimeRules, entry.getValue().getContentType())) {// 如果有一个不符合要求，返回
																											// false
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

}
