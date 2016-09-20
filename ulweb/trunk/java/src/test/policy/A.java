package test.policy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.UUID;

public class A {
	
	public static void aa(){
	}
	public static void main(String[] args) throws MalformedURLException {
	 
		String a = "C://apache-tomcat-6.0.18//webapps//fileupload//2010//5//14/22792786181910_AdobeSecDocSolSG.pdf";
		File file = new File(a);
		URL url = file.toURL();
		System.out.println(url.getPath());
//		URI uri = file.toURI();
//		a = a.replace("C:/apache-tomcat-6.0.18/webapps", "http://localhost");
//		System.out.println(a);
		System.out.println(File.separator);
		

		String extendName = a.substring(a.lastIndexOf("."));
		System.out.println(extendName);
	}

}
