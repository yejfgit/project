package test.policy;

import com.adobe.document.pdf.PDFDocument;
import com.adobe.document.pdf.PDFFactory;
import com.adobe.document.pdf.PDFFactoryHelper;
import com.adobe.edc.sdk.*;
import com.adobe.edc.sdk.infomodel.* ;
import com.adobe.service.ConnectionFactory;
import com.adobe.service.DataBuffer;
import com.adobe.service.DataManager;
import com.adobe.service.DataManagerHelper;
import com.adobe.service.FileDataBuffer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;
import java.util.Properties;
import javax.naming.Context;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
/*
 * Created on 2006-6-5
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class test {
	public static void main(String[] args) throws NamingException, SDKException {
		  System.out.println("33");
		 try
		{
		  	Properties p = null;
		    p = new Properties();
			Properties apsProperty = new Properties();
////			  Specify property values
			  apsProperty.setProperty(EDCFactory.USERNAME_PROPERTY_NAME,"administrator");
			  apsProperty.setProperty(EDCFactory.PASSWORD_PROPERTY_NAME,"password");
			  apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME,"ejb");
			  apsProperty.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			  apsProperty.setProperty(Context.PROVIDER_URL,"jnp://172.86.50.58:1099/");
			  apsProperty.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			  //apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME,"SOAP");
			  //apsProperty.setProperty(EDCFactory.URL_PROPERTY_NAME, "");
			  EDCFactory apsSession = EDCFactory.connect(apsProperty);

			  PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		      //Create a PolicySearchFilter object
		      PolicySearchFilter sf = new PolicySearchFilter();
		      //Get the first ten policies
		      Policy[] allPolicies = apsPolicyManager.getPolicies(sf, 10);//这一行抛出的exception
		      //Iterate through the Policy array and get policy names
		      for (int zz = 0; zz < allPolicies.length; zz++) {
		        Policy myPolicy = (Policy) allPolicies[zz];
		        System.out.println("***********************The policy name is " + myPolicy.getName() +" id "+myPolicy.getId());
		       // System.out.println( myPolicy.toString());
		      }

		  	//DocumentManager apsDocManager = apsSession.getDocumentManager();
			/*FileInputStream fis=new FileInputStream("C:\\test1.pdf");
			byte[] pdfContent=new byte[fis.available()];
			fis.read(pdfContent);
			fis.close();
			*/
			InitialContext namingContext = new InitialContext();
			p = new Properties();
			p.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
			p.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
			p.put("java.naming.provider.url","jnp://172.86.50.49:1099/");
			p.put("java.naming.rmi.security.manager","yes");
			namingContext = new InitialContext(p);

			Object o = namingContext.lookup("PDFManipulation");
 		    ConnectionFactory connectionFactory;
 		    connectionFactory = (ConnectionFactory) PortableRemoteObject.narrow(o,ConnectionFactory.class);
			PDFFactory pdfFactory = PDFFactoryHelper.narrow((org.omg.CORBA.Object)connectionFactory.getConnection());
			DataManager dataManager = DataManagerHelper.narrow((org.omg.CORBA.Object)connectionFactory.getConnection());
			FileDataBuffer pdfFile = dataManager.createFileDataBuffer("c:\\test1.pdf");
			PDFDocument pdfDocument=pdfFactory.openPDF(pdfFile);


			pdfDocument.applyPolicy("37F21277-EF13-6287-52BD-425AFC01B74E", "test1", "12345^a", "c:\\test1_policy.pdf", "foo");
			DataBuffer result=pdfDocument.save();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

