package com.baiyuting.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baiyuting.util.MessageUtil;
import com.baiyuting.util.MimeValidator;
import com.baiyuting.util.ValidatorRules;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("*****************prehandle*************" + handler.getClass());

		HandlerMethod handlerMethod = (HandlerMethod) handler;// HandlerMethod
		// ��ȡҪ��ȡ��Դ�ļ��е� key����ȡ��ԴΪ Validators.properties������
		String validatorKey = handlerMethod.getBeanType().getSimpleName() + "." + handlerMethod.getMethod().getName()
				+ ".rules";
		// ���÷���ȡ����֤����
		String valueString = MessageUtil.getMessage(handlerMethod.getBean(), validatorKey);
		// System.out.println("resoled value " + valueString);
		if (valueString == null || "".equals(valueString)) {
			return true;
		}
		// ���ÿһ������Ĳ���������֤��������Ҫʹ�ô���֤������о���Ĳ���
		String rules[] = valueString.split("\\|");
		Map<String, String> result = new ValidatorRules(handlerMethod.getBean(), rules, request).validate();
		if (result.size() > 0) {// �д���
			request.setAttribute("errors", result);
			request.getRequestDispatcher("/errors.jsp").forward(request, response);
			return false;// ��������ִ��
		} else { // �������ϴ��ļ��Ƿ�Ϸ�����֤
			boolean validMime = MimeValidator.isValidMime(handlerMethod.getBean(), request);
			if (!validMime) {// ��֤ʧ��
				result.put("file", MessageUtil.getMessage(handlerMethod.getBean(), "invalidate.file.mime.error.msg"));
				request.setAttribute("errors", result);
				request.getRequestDispatcher("/errors.jsp").forward(request, response);
				return false;// ��������ִ��
			}
		}

		return true;// ���������true��ʾ��ͣ����ִ�к������Ʋ����
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		System.out.println("*****************postHandle*************" + handler.getClass() + "--modelAndView " + mav);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		System.out.println("*****************afterCompletion*************" + handler.getClass());
	}

}
