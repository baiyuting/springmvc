package com.baiyuting.util;

import java.lang.reflect.Method;

public class MessageUtil {

	public static String getMessage(Object object, String key) {
		Method msgSourceMethod;
		try {
			msgSourceMethod = object.getClass().getMethod("getMessage", String.class);
			return (String) msgSourceMethod.invoke(object, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
