package com.ulic.ulweb.frame.util;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class PasswordDigest {
	static MessageDigest md = null; 

	public PasswordDigest() 
	{ 
		this("MD5"); 
	} 

	public PasswordDigest(String digest) 
	{ 
		try 
		{ 
			md = MessageDigest.getInstance(digest); 
		}
		catch (NoSuchAlgorithmException e) 
		{ 
			try 
			{ 
				md = MessageDigest.getInstance("MD5"); 
			} 
			catch (NoSuchAlgorithmException e1) { } 
		} 
	} 

	/** 
	* Digest function from Tomcat. 
	*/ 
	public String digest(String credentials) 
	{ 
		if (md == null) 
		{ 
			return credentials; 
		}
		synchronized (this) 
		{ 
			try 
			{ 
				md.reset(); 
				md.update(credentials.getBytes()); 
				return (HexUtils.convert(md.digest())); 
			} 
			catch (Exception e) 
			{ 
				return credentials; 
			} 
		} 
	} 
}
