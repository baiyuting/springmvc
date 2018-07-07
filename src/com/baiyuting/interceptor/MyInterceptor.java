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
		// 获取要读取资源文件中的 key，读取资源为 Validators.properties，内容
		String validatorKey = handlerMethod.getBeanType().getSimpleName() + "." + handlerMethod.getMethod().getName()
				+ ".rules";
		// 调用方法取得验证内容
		String valueString = MessageUtil.getMessage(handlerMethod.getBean(), validatorKey);
		// System.out.println("resoled value " + valueString);
		if (valueString == null || "".equals(valueString)) {
			return true;
		}
		// 针对每一个具体的操作进行验证处理，就需要使用此验证规则进行具体的操作
		String rules[] = valueString.split("\\|");
		Map<String, String> result = new ValidatorRules(handlerMethod.getBean(), rules, request).validate();
		if (result.size() > 0) {// 有错误
			request.setAttribute("errors", result);
			request.getRequestDispatcher("/errors.jsp").forward(request, response);
			return false;// 不再往下执行
		} else { // 随后进行上传文件是否合法的验证
			boolean validMime = MimeValidator.isValidMime(handlerMethod.getBean(), request);
			if (!validMime) {// 验证失败
				result.put("file", MessageUtil.getMessage(handlerMethod.getBean(), "invalidate.file.mime.error.msg"));
				request.setAttribute("errors", result);
				request.getRequestDispatcher("/errors.jsp").forward(request, response);
				return false;// 不再往下执行
			}
		}

		return true;// 如果不返回true表示截停，不执行后续控制层操作
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
