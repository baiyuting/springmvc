package com.baiyuting.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ValidatorRules {

	private Object object;

	private String rules[];

	private HttpServletRequest request;

	/**
	 * 
	 * @param object
	 *            当前要执行操作的 Action 程序类
	 * @param rules
	 *            所有的验证规则
	 * @param request
	 *            进行参数的接收处理
	 */
	public ValidatorRules(Object object, String[] rules, HttpServletRequest request) {
		super();
		this.object = object;
		this.rules = rules;
		this.request = request;
	}

	/**
	 * 实现具体的验证处理操作
	 * 
	 * @return
	 */
	public Map<String, String> validate() {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < rules.length; i++) {
			String temp[] = rules[i].split(":");
			String paramValue = request.getParameter(temp[0]);
			switch (temp[1]) {
			case "string":
				if (!ValidatorUtil.isValidString(paramValue)) {
					map.put(temp[0], MessageUtil.getMessage(object, "invalidate.string.error.msg"));
				}
				break;
			case "int":
				if (!ValidatorUtil.isValidInteger(paramValue)) {
					map.put(temp[0], MessageUtil.getMessage(object, "invalidate.int.error.msg"));
				}
				break;
			case "double":
				if (!ValidatorUtil.isValidDouble(paramValue)) {
					map.put(temp[0], MessageUtil.getMessage(object, "invalidate.double.error.msg"));
				}
				break;
			case "date":
				if (!ValidatorUtil.isValidDate(paramValue)) {
					map.put(temp[0], MessageUtil.getMessage(object, "invalidate.date.error.msg"));
				}
				break;
			case "datetime":
				if (!ValidatorUtil.isValidDatetime(paramValue)) {
					map.put(temp[0], MessageUtil.getMessage(object, "invalidate.datetime.error.msg"));
				}
				break;
			default:
				break;
			}
		}
		return map;
	}

}
