package test.policy;
/*
 * Created on 2007-3-16
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


import com.adobe.edc.sdk.EDCFactory;
import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.UserManager;
import com.adobe.edc.sdk.PolicyManager;


import com.adobe.edc.sdk.infomodel.InfomodelObjectFactory;
import com.adobe.edc.sdk.infomodel.PDRLException;
import com.adobe.edc.sdk.infomodel.PrincipalSearchFilter;
import com.adobe.edc.sdk.infomodel.Principal;
import com.adobe.edc.sdk.infomodel.Policy;
import com.adobe.edc.sdk.infomodel.PolicySearchFilter;
import com.adobe.edc.sdk.infomodel.Permission;
import com.adobe.edc.sdk.infomodel.PolicyEntry;

import java.util.Properties;


/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class createPolicy {
  public static void main(String[] arg) throws PDRLException{

  	 EDCFactory edcFactory = null;
     InfomodelObjectFactory objFactory = null; // All methods static
     Properties properties = new Properties();
     properties.setProperty(EDCFactory.USERNAME_PROPERTY_NAME, "test");
     properties.setProperty(EDCFactory.PASSWORD_PROPERTY_NAME, "12345^a");
     properties.setProperty(EDCFactory.MODE_PROPERTY_NAME, "ejb");
     //properties.setProperty(EDCFactory.URL_PROPERTY_NAME,"http://172.86.50.54:8080/edcws/services/EDCPolicyService?wsdl");
     //properties.setProperty(EDCFactory.MODE_PROPERTY_NAME,"soap");


     try {


     	edcFactory = EDCFactory.connect(properties);


     	  PrincipalSearchFilter psf = new PrincipalSearchFilter();
          psf.setUserId("test1");
          UserManager um = edcFactory.getUserManager();
          Principal[] customers = um.getUsers(psf, 1);



     PolicyManager pm = edcFactory.getPolicyManager();
     PolicySearchFilter sf = new PolicySearchFilter();
     sf.setName("MyNewPolicy");
     Policy[] policies = pm.getPolicies(sf, 1);

    


     //
     // If we did not find an existing policy by the same name, create
     // a new policy object.
     //

     Policy policy = null;
     if ((policies == null) || (policies.length == 0))
     {
       System.out.println("Creating new policy " + "MyNewPolicy");
       policy = InfomodelObjectFactory.createPolicy();
     }
     else
     {
     	System.out.println("Overwriting existing policy " + "MyNewPolicy");
        policy = policies[0];
     }

     policy.clearPolicyEntries();
     policy.clearValidityPeriod();





     final int[] salesRepPerms =
     {
       Permission.OPEN_ONLINE,
       Permission.OPEN_OFFLINE,
       Permission.PRINT_HIGH,
       Permission.COPY,
       Permission.POLICY_SWITCH,
       Permission.REVOKE,
       Permission.CHANGES_COMMENTING_FORM_FILL_IN_AND_SIGNING
     };

     //
     // A customer can:
     //

     final int[] customerPerms =
     {
       Permission.OPEN_ONLINE,
       Permission.PRINT_HIGH,
       Permission.CHANGES_FORM_FILL_IN_AND_SIGNING
     };





        PolicyEntry pe = InfomodelObjectFactory.createPolicyEntry();

		pe.setPrincipal(InfomodelObjectFactory.createSpecialPrincipal
		   (InfomodelObjectFactory.PUBLISHER_PRINCIPAL));

		 for (int i = 0; i < salesRepPerms.length; i++)
	     {
	       Permission perm = InfomodelObjectFactory.createPermission
	         (salesRepPerms[i]);
	       pe.addPermission(perm);
	     }

	     policy.addPolicyEntry(pe);






	      pe = InfomodelObjectFactory.createPolicyEntry();
	      pe.setPrincipal(customers[0]);
	      for (int i = 0; i < customerPerms.length; i++)
	      {
	        Permission perm = InfomodelObjectFactory.createPermission
	          (customerPerms[i]);
	        pe.addPermission(perm);
	      }
	      policy.addPolicyEntry(pe);



	      policy.setName("MyNewPolicy");
	      policy.setTracked(true);




	      String policyId;
	      if (policies == null || policies.length == 0)
	      {

	        policyId = pm.registerPolicy(policy);
	      }
	      else
	      {

	        policyId = policy.getId();
	        pm.updatePolicy(policy);
	      }

          System.out.println("policyID is:"+ policyId);




     } catch (SDKException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
}
