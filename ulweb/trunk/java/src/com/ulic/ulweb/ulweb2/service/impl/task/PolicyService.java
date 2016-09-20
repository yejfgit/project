package com.ulic.ulweb.ulweb2.service.impl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adobe.edc.sdk.EDCFactory;
import com.adobe.edc.sdk.PolicyManager;
import com.adobe.edc.sdk.SDKException;
import com.adobe.edc.sdk.UserManager;
import com.adobe.edc.sdk.infomodel.InfomodelObjectFactory;
import com.adobe.edc.sdk.infomodel.PDRLException;
import com.adobe.edc.sdk.infomodel.Permission;
import com.adobe.edc.sdk.infomodel.Policy;
import com.adobe.edc.sdk.infomodel.PolicyEntry;
import com.adobe.edc.sdk.infomodel.PolicySearchFilter;
import com.adobe.edc.sdk.infomodel.Principal;
import com.adobe.edc.sdk.infomodel.PrincipalSearchFilter;
import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

public class PolicyService implements IService {

	private static Log _logger = LogFactory.getLog(PolicyService.class);
	
	private EDCFactory apsSession = null;

	private Properties apsProperty = new Properties();

	private String username;

	private static Permission openONlinePermission;

	private static Permission printPermission;
	static {
		try {
			openONlinePermission = InfomodelObjectFactory
					.createPermission(Permission.OPEN_ONLINE);

			printPermission = InfomodelObjectFactory
					.createPermission(Permission.PRINT_HIGH);
		} catch (PDRLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SDKException{
		Properties apsProperty = new Properties();
		apsProperty.setProperty(EDCFactory.USERNAME_PROPERTY_NAME, "pdfpolicy");
		apsProperty.setProperty(EDCFactory.PASSWORD_PROPERTY_NAME, "policyView");
		apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME,
				"SOAP");
		//apsProperty.setProperty(Context.INITIAL_CONTEXT_FACTORY,
		//				"org.jnp.interfaces.NamingContextFactory");
		apsProperty.setProperty(EDCFactory.URL_PROPERTY_NAME, "HTTP://10.17.2.11:8080/edcws/services/EDCPolicyService?wsdl");
		//apsProperty.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		EDCFactory.connect(apsProperty);
		
	}

	private static Map<String, PolicyService> map = new java.util.HashMap<String, PolicyService>();

	private PolicyService(String username, String password) {

		_logger.debug("username = " + username + " password = " + password);

		this.username = username;
		apsProperty.setProperty(EDCFactory.USERNAME_PROPERTY_NAME, username);
		apsProperty.setProperty(EDCFactory.PASSWORD_PROPERTY_NAME, password);
		apsProperty.setProperty(EDCFactory.URL_PROPERTY_NAME, ConfigManager.config
				.getString(Context.PROVIDER_URL));
		apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME,
				ConfigManager.config.getString(EDCFactory.MODE_PROPERTY_NAME));
		/*apsProperty.setProperty(EDCFactory.MODE_PROPERTY_NAME,
				ConfigManager.config.getString(EDCFactory.MODE_PROPERTY_NAME));
		apsProperty
				.setProperty(Context.INITIAL_CONTEXT_FACTORY,
						ConfigManager.config
								.getString(Context.INITIAL_CONTEXT_FACTORY));
		apsProperty.setProperty(Context.PROVIDER_URL, ConfigManager.config
				.getString(Context.PROVIDER_URL));
		apsProperty.setProperty(Context.URL_PKG_PREFIXES, ConfigManager.config
				.getString(Context.URL_PKG_PREFIXES));
				*/

	}

	public static PolicyService getInstance(String username, String password)
			throws SDKException {
		PolicyService policyService = map.get(username);
		if (policyService == null) {
			synchronized (map) {
				if (policyService == null) {
					policyService = new PolicyService(username, password);
					policyService.connect();
					map.put(username, policyService);
				}
			}
		}

		return policyService;
	}

	/**
	 * 向policy server 注册一个policy
	 * 
	 * @param policy
	 * @return 返回注册的policy的id，36位的字符串
	 * @throws SDKException
	 */
	public String registpolicy(Policy policy) throws SDKException {
		connect();
		PolicyManager policyManager = apsSession.getPolicyManager();
		String policyId = policyManager.registerPolicy(policy);
		return policyId;

	}

	/**
	 * 获取policy server的所有policy的集合
	 * 
	 * @return
	 * @throws SDKException
	 */
	public Policy[] listPolicy(String canonName) throws SDKException {
		connect();
		// 创建 Policy Server Manager 对象
		PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		// Create a Policy Search Filter object
		PolicySearchFilter polsf = new PolicySearchFilter();
//		polsf.setOwner(getUserPrincipal(ConfigManager.getCreatePolicyUsername()));
		//polsf.setType(Policy.ORGANIZATIONAL_POLICY);
		Policy[] allPolicies = apsPolicyManager.getPolicies(polsf, Integer.MAX_VALUE);
		
		if(allPolicies.length>0){
			for (int i = 0; i < allPolicies.length; i++) {
				if(allPolicies[i].isDeleted()){
					allPolicies[i] = null;
				} else if(Policy.USER_POLICY.equals(allPolicies[i].getType())){
					allPolicies[i] = null;
				}
			}
		}
		return allPolicies;
	}

	/**
	 * 全系统访问策略
	 * @param name
	 * @param desc
	 * @param secure
	 * @return
	 * @throws PDRLException
	 * @throws SDKException
	 */
	public String registpolicyForAllUsers(String name, String desc, String secure, 
			String users) throws PDRLException, SDKException {
		connect();
		List<Principal> principalList = new ArrayList<Principal>();
		Principal allUsersPrincipal = InfomodelObjectFactory.createSpecialPrincipal(
				InfomodelObjectFactory.ALL_AUTHENTICATED_USERS_PRINCIPAL);
		principalList.add(allUsersPrincipal);
		toListFromUser(users, principalList);
		Policy policy = createPolicy(name, desc, secure, principalList);
		String policyId = registpolicy(policy);
		return policyId;
	}
	
	public String registpolicy(String name, String desc, String secure,
			String groups, String users) throws PDRLException, SDKException {
		connect();
		List<Principal> principalList = new ArrayList<Principal>();
		toListFromGroup(groups, principalList);
		toListFromUser(users, principalList);
		Policy policy = createPolicy(name, desc, secure, principalList);
		String policyId = registpolicy(policy);
		return policyId;
	}

	public String registpolicy(String name, String desc, String secure,
			List<CusEdcprincipalentitytype> groups, String users)
			throws PDRLException, SDKException {
		connect();
		List<Principal> principalList = new ArrayList<Principal>();
		toListFromGroup(groups, principalList);

		
		toListFromUser(users, principalList);

		Policy policy = createPolicy(name, desc, secure, principalList);

		String policyId = registpolicy(policy);
		return policyId;
	}

	private void toListFromGroup(List<CusEdcprincipalentitytype> groupList,
			List<Principal> list) throws SDKException {
		if (groupList == null || groupList.size() == 0) {
			return;
		}
		for (CusEdcprincipalentitytype cusEdcprincipalentitytype : groupList) {
			String name = cusEdcprincipalentitytype.getEdcprincipalentity()
					.getCanonicalname();
			Principal principal = getGroupPrincipal(name);
			if (principal != null) {
				list.add(principal);
			}
		}

	}

	private void toListFromGroup(String groups, List<Principal> list)
			throws SDKException {
		if (groups != null && !"".equals(groups)) {
			String[] groupNames = groups.split("%");

			if (groupNames != null && groupNames.length > 0) {
				for (String groupName : groupNames) {
					if (groupName != null) {
						Principal principal = getGroupPrincipal(groupName);
						if (principal != null) {
							list.add(principal);
						}
					}
				}
			}
		}
	}

	private void toListFromUser(String users, List<Principal> list)
			throws SDKException {
		if (users != null && !"".equals(users)) {
			String[] userNames = users.split("%");

			if (userNames != null && userNames.length > 0) {
				for (String userName : userNames) {
					if (userName != null) {
						Principal principal = getUserPrincipal(userName);
						if (principal != null) {
							list.add(principal);
						}

					}
				}
			}
		}
	}

	public Policy createPolicy(String name, String desc, String secure,
			List<Principal> principalList) throws PDRLException, SDKException {
		connect();
		Policy policy = null;
		// Create the Policy Object
		policy = InfomodelObjectFactory.createPolicy();

		policy.setName(name);
		policy.setDescription(desc);
		
		List<Permission> permissionList = new ArrayList<Permission>();
		permissionList.add(openONlinePermission);

		if ("1".equals(secure)) {
			permissionList.add(printPermission);

		}

		if (principalList != null && principalList.size() > 0) {

			for (Principal principal : principalList) {
				addPolicyEntity(policy, permissionList, principal);
			}
		}

		return policy;
	}

	private void addPolicyEntity(Policy policy,
			List<Permission> permissionList, Principal principal)
			throws PDRLException {

		PolicyEntry policyentry = InfomodelObjectFactory.createPolicyEntry();
		policyentry.setPrincipal(principal);
		if (permissionList != null && permissionList.size() > 0) {
			for (Permission permission : permissionList) {
				policyentry.addPermission(permission);
			}
		}
		policy.addPolicyEntry(policyentry);
	}

	private Principal getGroupPrincipal(String name) throws SDKException {
		PrincipalSearchFilter psf = new PrincipalSearchFilter();
		// psf.setDomainName("newDomain");
		psf.setCanonicalName(name);
		UserManager userManager = this.apsSession.getUserManager();
		Principal[] allPrincipals = userManager.getGroups(psf, 1);
		if (allPrincipals == null || allPrincipals.length == 0) {
			_logger.error(" get error: " + name);
			return null;
		}
		return allPrincipals[0];
	}

	private Principal getUserPrincipal(String name) throws SDKException {
		PrincipalSearchFilter psf = new PrincipalSearchFilter();
		// psf.setDomainName("newDomain");
		psf.setCanonicalName(name);
		UserManager userManager = this.apsSession.getUserManager();
		Principal[] allPrincipals = userManager.getUsers(psf, 1);
		if (allPrincipals == null || allPrincipals.length == 0) {
			_logger.error(" get Principal error: " + name);
			return null;
		}
		return allPrincipals[0];
	}

	/**
	 * 建立于policy server 的连接
	 * 
	 * @throws SDKException
	 */
	private void connect() throws SDKException {
		if (apsSession == null) {
			apsSession = EDCFactory.connect(apsProperty);
		}
	}

	/**
	 * 断开于policy server 的连接
	 */
	public void close() {
		if (apsSession != null) {
			apsSession.closeConnection();
			apsSession = null;
			map.remove(username);
		}

	}

	/**
	 * 根据policyId来获取一个policy对象
	 * 
	 * @param id
	 * @return
	 * @throws SDKException
	 */
	public Policy getPolicyById(String id) throws SDKException {
		connect();
		PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		Policy policy = apsPolicyManager.getPolicy(id);
		return policy;
	}
	
	public void deletePolicyById(String id) throws SDKException {
		connect();
		PolicyManager apsPolicyManager = apsSession.getPolicyManager();
		//Policy policy = apsPolicyManager.getPolicy(id);
		apsPolicyManager.deletePolicy(id);
	}

}
