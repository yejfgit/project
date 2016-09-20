package test.policy;
/*
 * Created on 2007-3-15
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import com.adobe.edc.sdk.EDCFactory;
import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.UserManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class addExternalUser extends HttpServlet {
  public static void main(String[] arg) throws SDKException{

    Properties apsProperty = new Properties();
    String userId = "administrator";
    String password = "password";
    apsProperty.setProperty("username", userId);
    apsProperty.setProperty("password", password);
    apsProperty.setProperty("mode", "ejb");
    apsProperty.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
    apsProperty.setProperty("java.naming.provider.url","172.86.50.51:1099");
    apsProperty.setProperty("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");

    EDCFactory apsSession = null;
    String rev = "";

        apsSession = EDCFactory.connect(apsProperty);
      UserManager um = apsSession.getUserManager();
        Object vec[] = {
            "awei@indigopacific.com.cn"
        };
        java.util.List l = Arrays.asList(vec);
        um.inviteExternalUsers(l);

        System.out.println("ok");
   // }catch(Exception e){
  //  	System.out.println("error:" + e.getMessage());
 //  }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException{
  	 Properties apsProperty = new Properties();
     String userId = "administrator";
     String password = "password";
     apsProperty.setProperty("username", userId);
     apsProperty.setProperty("password", password);
     apsProperty.setProperty("mode", "ejb");
     EDCFactory apsSession = null;
     String rev = "";
   try{
         apsSession = EDCFactory.connect(apsProperty);
       UserManager um = apsSession.getUserManager();
         Object vec[] = {
             "lni@indigopacific.com.cn"
         };
         java.util.List l = Arrays.asList(vec);
         um.inviteExternalUsers(l);

         System.out.println("ok");
   }catch(Exception e){
   	  System.out.println("error:"+ e.getMessage());
   }
  }
}
