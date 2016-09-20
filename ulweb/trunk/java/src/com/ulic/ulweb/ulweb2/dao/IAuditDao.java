package com.ulic.ulweb.ulweb2.dao;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.AuditEntity;

public interface IAuditDao extends IService {

	boolean save(AuditEntity d);

}
