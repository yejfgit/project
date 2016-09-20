package test.policy;

import com.adobe.edc.sdk.EDCFactory;
import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.infomodel.PDRLException;
import com.adobe.edc.sdk.infomodel.Policy;
import com.adobe.edc.sdk.infomodel.impl.PolicyImpl;
import com.ulic.ulweb.ulweb2.service.impl.task.PolicyService;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

import junit.framework.TestCase;

public class PolicyServiceTest extends TestCase {
	PolicyService policyService = null;

	@Override
	protected void setUp() throws Exception {
		policyService = PolicyService.getInstance("administrator", "password");
	}

	public void testRegistpolicy() {
		fail("Not yet implemented");
	}

	public void testSecure() {
		fail("Not yet implemented");
	}

	public void testListPolicy() {
		try {
			Policy[] policyAry = policyService.listPolicy("administrator");
			if (policyAry != null)
				for (Policy policy2 : policyAry) {
					System.out.println("id : " + policy2.getId() + " name : "
							+ policy2.getName());
				}
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testCreatePolicy() {
		fail("Not yet implemented");
	}

	public void tempListPolicy() throws PDRLException {
		Policy[] allPolicies = new Policy[4];
		for (int i = 0; i < allPolicies.length; i++) {
			Policy policy = new PolicyImpl();
			policy.setName("policyName" + i);
			policy.setAlternateId(String.valueOf(i));
			allPolicies[i] = policy;
		}
	}

	public void getPrincipalTest() {
		// try {
		// // policyService.getGroupPrincipal("");
		// } catch (SDKException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void registPolicy() {
		try {
			String a = "cn=dnsupdateproxy,cn=users,dc=test,dc=indigo%cn=ras and ias servers,cn=users,dc=test,dc=indigo%cn=__vmware__,cn=users,dc=test,dc=indigo%cn=telnetclients,cn=users,dc=test,dc=indigo";
			String policyId = policyService.registpolicy(null, "sss",
					"1", a,"cn=zhanglei,cn=users,dc=test,dc=indigo%cn=zhanglei,cn=users,dc=test,dc=indigo");
			System.out.println(policyId + "sss");
		} catch (PDRLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listPolicyTest() {
		try {
		
		
			Policy[] policyAry = policyService.listPolicy("administrator");
			System.out.println(" length : " + policyAry.length);
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPolicyTest() {
		Policy policy;
		try {
			PolicyService policyService = PolicyService.getInstance("administrator",
			"password");
			policy = policyService
					.getPolicyById("2AB0C81F-2B73-D9A8-3D66-692E625DB514");
			System.out.println(policy.getName());
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void secureTest() {
		
		try {
			PolicyService policyService =PolicyService.getInstance("administrator","password");
//			String result = policyService
//					.secure(
//							"D:\\work_area\\ulweb\\WebRoot\\fileupload\\.eclipseproduct",
//							"CD0F08D3-940D-19AF-5DA9-8E1C0EFC0658");
//			System.out.println("result : "+result);
		} catch (SDKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
