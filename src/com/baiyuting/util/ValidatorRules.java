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
	 *            ��ǰҪִ�в����� Action ������
	 * @param rules
	 *            ���е���֤����
	 * @param request
	 *            ���в����Ľ��մ���
	 */
	public ValidatorRules(Object object, String[] rules, HttpServletRequest request) {
		super();
		this.object = object;
		this.rules = rules;
		this.request = request;
	}

	/**
	 * ʵ�־������֤�������
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
