package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncode {
	
	public String encodepassword(String password)
	{
		String encoded_Password="";
		password=password.toUpperCase();
		for(int i=0;i<password.length();i++)
		{
			if(password.charAt(i)>='A'&&password.charAt(i)<='Z')//condition for alphabetical character
			{
				int num=password.charAt(i);
				int ch=155-num;
				char onechar=(char)ch;
				encoded_Password+=onechar;
			}
			else if (password.charAt(i)>='0'&&password.charAt(i)<='9')  // condition for Numerical character
			{
				int num=password.charAt(i);
				
				int number=105-num;
				char onenumber=(char)number;
				encoded_Password+=onenumber;
			}
			else
				encoded_Password+=password.charAt(i);
		}
		return encoded_Password;
	}

}
