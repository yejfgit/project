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
			//如果是新增的行被删除，应该直接在集合中删除而不是设置其状态为Delete
			if(this.beanstatus == BeanStatus.ADDED && beanstatus == BeanStatus.DELETED)
				this.beanstatus = BeanStatus.NONE;
	}

}
