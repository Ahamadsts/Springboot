package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class DecodePassword {
	
	public String decode(String password)
	{
		String decoded_password="";
		password=password.toUpperCase();
		for(int i=0;i<password.length();i++)
		{
			if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
			{
				int num=password.charAt(i);
				int ch=155-num;
				char onechar=(char)ch;
				decoded_password+=onechar;
			}
			else if(password.charAt(i)>='0'&&password.charAt(i)<='9')
			{
				int num=password.charAt(i);
				int ch=105-num;
				char onenum=(char)ch;
				decoded_password+=onenum;
			}
			else
			{
				decoded_password+=password.charAt(i);
			}
		}
		return decoded_password;
	}

}
