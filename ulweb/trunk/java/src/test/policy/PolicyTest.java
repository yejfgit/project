package test.policy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.xml.registry.infomodel.User;

import junit.framework.TestCase;

import com.adobe.edc.sdk.EDCFactory;
import com.adobe.edc.sdk.PolicyManager;
import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.UserManager;
import com.adobe.edc.sdk.WatermarkManager;
import com.adobe.edc.sdk.infomodel.InfomodelObjectFactory;
import com.adobe.edc.sdk.infomodel.PDRLException;
import com.adobe.edc.sdk.infomodel.Permission;
import com.adobe.edc.sdk.infomodel.Policy;
import com.adobe.edc.sdk.infomodel.PolicyEntry;
import com.adobe.edc.sdk.infomodel.PolicySearchFilter;
import com.adobe.edc.sdk.infomodel.Principal;
import com.adobe.edc.sdk.infomodel.PrincipalSearchFilter;
import com.adobe.edc.sdk.infomodel.Watermark;
import com.ulic.ulweb.ulweb2.service.impl.task.PolicyService;

public class PolicyTest extends TestCase {

	EDCFactory apsSession = null;

	@Override
	protected void setUp() throws Exception {
		Properties apsProperty = new Properties();
		String username = "administrator";
		String password = "password";

		apsProperty.setProperty(EDCFactory.USERNAME_PROPERTY_NAME, username);
		apsProperty.setProperty(EDCFactory.PASSWORD_PROPERTY_NAME, password);
		apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME, "ejb");
		apsProperty.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		apsProperty.setProperty(Context.PROVIDER_URL,
				"jnp://172.86.50.49:1099/");
		apsProperty.setProperty(Context.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");

		try {
			apsSession = EDCFactory.connect(apsProperty);

		} catch (SDKException e) {
			e.printStackTrace();
		}

	}

	public void registPolicy() {

		try {

			PolicyManager policyManager = apsSession.getPolicyManager();
			Policy myPolicy = createPolicy();
			myPolicy.setName("policy3");

			addPermission(myPolicy);

			String id = policyManager.registerPolicy(myPolicy);
			System.out.println("id : " + id);
			System.out.println("name : " + myPolicy.getName());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testRegistPolicy() {

//		try {
//			PolicyService policyService = new PolicyService("administrator","password");
//			Policy policy = policyService.createPolicy("policyName",
//					"policyDesc", "", "","");
//
//			policyService.registpolicy(policy);
//		} catch (PDRLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SDKException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private Policy createPolicy() {
		Policy myPolicy = null;
		try {
			// Create the Policy Object
			myPolicy = InfomodelObjectFactory.createPolicy();

			myPolicy.setName("EX5_7 Created on Server");
			myPolicy.setPlaintextMetadata(true);
			myPolicy.setDescription("This policy was created programatically");
			myPolicy.setTracked(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myPolicy;

	}

	public void addPermission(Policy myPolicy) throws PDRLException,
			SDKException {

		PolicyEntry myPolicyEntry = InfomodelObjectFactory.createPolicyEntry();
		// 允许打印
		Permission printPermission = InfomodelObjectFactory
				.createPermission(Permission.PRINT_HIGH);

		// 必须给的权限
		Permission switchPermission = InfomodelObjectFactory
				.createPermission(Permission.POLICY_SWITCH);
		Permission revokePermission = InfomodelObjectFactory
				.createPermission(Permission.REVOKE);

		myPolicyEntry.addPermission(printPermission);
		myPolicyEntry.addPermission(switchPermission);
		myPolicyEntry.addPermission(revokePermission);

		// 加密信息

		Principal publisherPrincipal = InfomodelObjectFactory
				.createSpecialPrincipal(InfomodelObjectFactory.PUBLISHER_PRINCIPAL);
		// Add a principal object to the policy entry
		myPolicyEntry.setPrincipal(publisherPrincipal);

		myPolicy.addPolicyEntry(myPolicyEntry);
	}

	// public void testCreatePolicy() {
	//
	// try {
	// // Create the Policy Object
	// Policy myPolicy = InfomodelObjectFactory.createPolicy();
	// // //Create WaterMark Manager Object
	// // WatermarkManager apsWMManager = apsSession.getWatermarkManager();
	// // //Return an existing Watermark
	// // Watermark wm = apsWMManager.getWatermarkByName("TestWM");
	// myPolicy.setName("EX5_6 Created on Server");
	// // Set the Policy attributes to the PolicyObject
	// // myPolicy.setOfflineLeasePeriod(5);
	// myPolicy.setPlaintextMetadata(true);
	// myPolicy.setDescription("This policy was created programatically");
	// myPolicy.setTracked(true);
	// // myPolicy.setAlternateId("Ex1Policy");
	// // myPolicy.setWatermarkId(wm.getId());
	//
	// // 允许打印
	// // Permission printPermission = InfomodelObjectFactory
	// // .createPermission(Permission.PRINT_HIGH);
	// //
	// // // 必须给的权限
	// // Permission switchPermission = InfomodelObjectFactory
	// // .createPermission(Permission.POLICY_SWITCH);
	// // Permission revokePermission = InfomodelObjectFactory
	// // .createPermission(Permission.REVOKE);
	// //
	// // // 加密信息
	// // PolicyEntry myPolicyEntry = InfomodelObjectFactory
	// // .createPolicyEntry();
	// //
	// // myPolicyEntry.addPermission(switchPermission);
	// // myPolicyEntry.addPermission(revokePermission);
	// //
	// // // 设置打印权限
	// // myPolicyEntry.addPermission(printPermission);
	//
	// PolicyManager policyManager = apsSession.getPolicyManager();
	//
	// // myPolicy.addPolicyEntry(myPolicyEntry);
	// String id = policyManager.registerPolicy(myPolicy);
	// System.out.println("id : " + myPolicy.getId());
	// System.out.println("name : " + myPolicy.getName());
	// } catch (PDRLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SDKException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// apsSession.closeConnection();
	// }
	// }

	public void testUpdatePolicy() {
		// Create Policy Server Manager Object
		PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		// Create a Policy Search Filter object
		PolicySearchFilter Polsf = new PolicySearchFilter();
		// Set the search criteria to a known Policy Name
		Polsf.setName("EX5_2 Created on Server");
		// Get the policy that has the name supplied to the PolicySearchFilter
		// Store the returned object in an array
		Policy[] allPolicies;
		try {
			allPolicies = apsPolicyManager.getPolicies(Polsf, 1);
			// Create a PolicyObject named myPolicy and initialize it to the
			// contents
			// of the array item 0
			Policy myPolicy = (Policy) allPolicies[0];
			apsPolicyManager.updatePolicy(myPolicy);
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listPolicy() {
		// Create Policy Server Manager Object
		PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		// Create a Policy Search Filter object
		PolicySearchFilter Polsf = new PolicySearchFilter();
		// Set the search criteria to a known Policy Name
		// Polsf.setName("Created on Server");
		// Get the policy that has the name supplied to the PolicySearchFilter
		// Store the returned object in an array
		Policy[] allPolicies;
		try {
			allPolicies = apsPolicyManager.getPolicies(Polsf, 2);
			// Create a PolicyObject named myPolicy and initialize it to the
			// contents
			// of the array item 0
			for (int i = 0; i < allPolicies.length; i++) {
				Policy myPolicy = (Policy) allPolicies[i];
				System.out.println(myPolicy.getName());
			}

			// apsPolicyManager.updatePolicy(myPolicy);
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private PolicyEntry createAuthorPolicyEntry(Principal addPrincipal,
			String forPrint) throws Exception {
		PolicyEntry myPolicyEntry = InfomodelObjectFactory.createPolicyEntry();

		// Specify the permissions
		Permission onlinePermission = InfomodelObjectFactory
				.createPermission(Permission.OPEN_ONLINE);
		Permission copyPermission = InfomodelObjectFactory
				.createPermission(Permission.COPY);

		myPolicyEntry.addPermission(InfomodelObjectFactory
				.createPermission(Permission.OPEN_OFFLINE));

		// Add permissions to the policy entry
		myPolicyEntry.addPermission(onlinePermission);

		myPolicyEntry.addPermission(copyPermission);
		if (forPrint.equals("1")) {
			myPolicyEntry.addPermission(InfomodelObjectFactory
					.createPermission(Permission.PRINT_HIGH));

		}
		// myPolicyEntry.addPermission(InfomodelObjectFactory.createPermission(Permission.CHANGES_INSERT_DELETE_ROTATE_PAGES));
		// myPolicyEntry.addPermission(InfomodelObjectFactory.createPermission(Permission.CHANGES_COMMENTING_FORM_FILL_IN_AND_SIGNING));
		// myPolicyEntry.addPermission(InfomodelObjectFactory.createPermission(Permission.CHANGES_FORM_FILL_IN_AND_SIGNING));
		myPolicyEntry
				.addPermission(InfomodelObjectFactory
						.createPermission(Permission.CHANGES_ALL_EXCEPT_EXTRACT_CONTENT));

		// myPolicyEntry.addPermission(InfomodelObjectFactory.createPermission(Permission.ACCESSIBLE));

		// Create principal object
		// Principal publisherPrincipal =
		// InfomodelObjectFactory.createSpecialPrincipal(InfomodelObjectFactory.PUBLISHER_PRINCIPAL);

		// Add a principal object to the policy entry
		myPolicyEntry.setPrincipal(addPrincipal);

		return myPolicyEntry;
	}

}
