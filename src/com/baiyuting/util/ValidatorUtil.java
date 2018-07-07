package com.baiyuting.util;

public class ValidatorUtil {

	public static boolean isValidString(String string) {
		if (null == string || "".equals(string)) {
			return false;
		}
		return true;
	}

	public static boolean isValidInteger(String string) {
		if (isValidString(string)) {
			return string.matches("\\d+");
		}
		return false;
	}

	public static boolean isValidDouble(String string) {
		if (isValidString(string)) {
			return string.matches("\\d+(\\.\\d+)?");
		}
		return false;
	}

	public static boolean isValidDate(String string) {
		if (isValidString(string)) {
			return string.matches("\\d{4}-\\d{2}-\\d{2}");
		}
		return false;
	}

	public static boolean isValidDatetime(String string) {
		if (isValidString(string)) {
			return string.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return false;
	}

	public static boolean isValidMime(String mimeRules[], String mime) {
		if (isValidString(mime)) {
			for (int i = 0; i < mimeRules.length; i++) {
				if (mime.equalsIgnoreCase(mimeRules[i])) {
					return true;
				}
			}
		}
		return false;
	}

}
