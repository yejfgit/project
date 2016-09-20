package test.dao;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ulic.ulweb.ulweb2.dao.impl.GroupDao;
import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipalentity;
import com.ulic.ulweb.ulweb2.entity.Edcprincipalgroupentity;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;

public class GroupDaoTest extends TestCase {

	GroupDao groupDao = null;

	@Override
	protected void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/ulic/ulweb/config/app-bean-ulweb3.xml");
		groupDao = (GroupDao) ac.getBean("groupDao");
	}

	public void listGroupTest() {
		List<CusEdcprincipalentitytype> list = groupDao.listGroupByType("A");
		System.out.println(list);
		if (list != null) {
			System.out.println(list.size());
			for (CusEdcprincipalentitytype groupEntity : list) {
				System.err
						.println(groupEntity.getId()
								+ " name : "
								+ groupEntity.getEdcprincipalentity()
										.getFriendlyname());
				System.out.println(" sss " + groupEntity.getName());
			}
		} else {
			System.out.println("list is null.");
		}

	}

	public void findUsersTest() {
			List<Edcprincipaluserentity> list = groupDao.findUsers("王");
			System.out.println(list);
			if (list != null) {
				System.out.println("ssssssssss "+list.size());
				for (Edcprincipaluserentity userEntity : list) {
					System.err.println(userEntity.getId()
							+ " canon name : "
							+ userEntity.getEdcprincipalentity()
									.getCanonicalname() + " friendlyName : " + userEntity.getEdcprincipalentity().getFriendlyname());
				}
			} else {
				System.out.println("list is null.");
			}
			
	}
	
	public void testSave(){
		CusEdcprincipalentitytype cusEdcprincipalentitytype = new CusEdcprincipalentitytype();
		cusEdcprincipalentitytype.setCusIsHidden(0);
		cusEdcprincipalentitytype.setCusType("Z");
		cusEdcprincipalentitytype.setName("saveTest");
		cusEdcprincipalentitytype.setId(100);
		
		Edcprincipalentity entity = new Edcprincipalentity();
		entity.setId("220F4A66-6583-399E-D6E1-3AE0BF8991A1");
		cusEdcprincipalentitytype.setEdcprincipalentity(new Edcprincipalentity());
		
	}
}
