package com.ulic.ulweb.ulweb2.service.impl.task;

import com.ulic.ulweb.ulweb.web.action.IndexAction;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.util.WebUtil;

public class ContentEventListener {

	public static void onContentAdd(ContentEntity c) {
		onUpdate();
	}

	public static void onContentEdit(ContentEntity c) {
		onUpdate();
	}

	public static void onContentDel(ContentEntity c) {
		onUpdate();
	}

	private static void onUpdate() {
		// 清除缓存
		WebUtil.clearAllCache();
		
		
	}
}
