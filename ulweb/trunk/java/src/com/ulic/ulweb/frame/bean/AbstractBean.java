package com.ulic.ulweb.frame.bean;

import java.io.Serializable;

public abstract class AbstractBean implements Serializable {
	private BeanStatus beanstatus = BeanStatus.NONE;

	public BeanStatus getBeanstatus() {
		return beanstatus;
	}

	public void setBeanstatus(BeanStatus beanstatus) {
		if(this.beanstatus != BeanStatus.ADDED && this.beanstatus !=BeanStatus.DELETED)
			this.beanstatus = beanstatus;
		else
			//������������б�ɾ����Ӧ��ֱ���ڼ�����ɾ��������������״̬ΪDelete
			if(this.beanstatus == BeanStatus.ADDED && beanstatus == BeanStatus.DELETED)
				this.beanstatus = BeanStatus.NONE;
	}

}
