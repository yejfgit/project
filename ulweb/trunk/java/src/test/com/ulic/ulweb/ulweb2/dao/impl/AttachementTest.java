//package test.com.ulic.ulweb.ulweb2.dao.impl;
//
//import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
//
//import com.ulic.ulweb.frame.service.ServiceLocator;
//import com.ulic.ulweb.ulweb2.dao.IAttachmentDao;
//import com.ulic.ulweb.ulweb2.dao.impl.AttachmentDao;
//import com.ulic.ulweb.ulweb2.entity.AttachmentEntity;
//import com.ulic.ulweb.ulweb2.service.IAttachmentService;
//
//import junit.framework.TestCase;
//
//public class AttachementTest extends TestCase {
//	IAttachmentDao attachmentDao = new AttachmentDao();
//	
//	public void testAddAttachement() {
//		 AttachmentEntity ae = new AttachmentEntity();
//		 ae.setAttachmentPath("/a/b/c");
//		 ae.setIsDelete(0);
//		 ae.setNeedGenerate(1);
//		 ae.setNeedSecure(1);
//		 ae.setPdfPath("/a/b/c/paf");
//		 ae.setSecurePath("/a/b/c/secure");
//		 ae.setPolicyEntityId("12");
//		 ae.setStatus(0);
//		 ae.setUploadUser(11);
//		 
//		 IAttachmentService attachmentService = (IAttachmentService) ServiceLocator.getService("attachmentAdminService");
//		
//		 try {
//			 attachmentService.addAttachment(ae);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void testGetAttachmentById() {
//		fail("Not yet implemented");
//	}
//
//	public void testListAttachmentByStatus() {
//		fail("Not yet implemented");
//	}
//
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//}
