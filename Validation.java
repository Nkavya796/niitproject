package com.niit.SkillMappingBackEnd.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public boolean validateEmail(String emailId) {

		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(emailId);
		return matcher.matches();
	}


	public boolean validateContactNo(String contactNo) {
		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher matcher = p.matcher(contactNo);
		return matcher.matches();
	}
}
