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
	 * �Ƿ��ǺϷ����ϴ��ļ�
	 * 
	 * @param object
	 * @param request
	 * @return
	 */
	public static boolean isValidMime(Object object, HttpServletRequest request) {
		// 1������ȷ���Ƿ��ϴ��ļ�
		MultipartResolver multipartResolver = new CommonsMultipartResolver();// ׼�������ϴ��ļ��Ĵ���
		if (multipartResolver.isMultipart(request)) {
			String mimeContent = MessageUtil.getMessage(object, "mimeType");//
			if (StringUtils.isBlank(mimeContent)) {// û�й���
				return true;
			} else {// ��Ҫ���ÿһ���������й����ƥ����
				String mimeRules[] = mimeContent.split("\\|");// ȡ��ȫ������
				MultipartRequest multipartRequest = (MultipartRequest) request;// �����ϴ���request
				Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();// ���е��ϴ��ļ�����
				if (fileMap.size() > 0) {// ��ǰ�ı��Ѿ�������ָ�����ϴ��������
					Iterator<Map.Entry<String, MultipartFile>> iterator = fileMap.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry<String, MultipartFile> entry = iterator.next();
						// System.out.println("�������ƣ�" + entry.getKey() +
						// "���ļ���С��" + entry.getValue().getSize());
						if (entry.getValue().getSize() > 0) {// ���ڱ����ļ��ϴ�������Ҫ�����ļ����͵�ƥ��
							if (!ValidatorUtil.isValidMime(mimeRules, entry.getValue().getContentType())) {// �����һ��������Ҫ�󣬷���
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
