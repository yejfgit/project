package com.ulic.ulweb.ulweb2.service.impl.task;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.service.IAttachmentService;
import com.ulic.ulweb.ulweb2.service.ITimerTask;

public class CheckAttachmentStatus extends ITimerTask{
	
	@Override
	public void runBody() {
		
		IAttachmentService as  = (IAttachmentService)ServiceLocator.getService("attachmentService");
		
		
		
		
		
	}
	
	
		

}
