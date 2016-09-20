package com.ulic.ulweb.ulweb2.util;

import java.util.HashMap;
import java.util.Map;

public final class StatusMode implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Map<Integer, StatusMode> INSTANCES = new HashMap<Integer, StatusMode>();

	private final int id;

	private final String name;

	private StatusMode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static final StatusMode DO_NOTHING = new StatusMode(6, "不作处理");

	public static final StatusMode TO_CONVERT = new StatusMode(0, "待转换");

	public static final StatusMode CONVERTING = new StatusMode(1, "转换中");

	public static final StatusMode COVERT_SUCCESS = new StatusMode(2, "转换成功");

	public static final StatusMode CONVERT_FAILURE = new StatusMode(-2, "转换失败");

	public static final StatusMode TO_SECURE = new StatusMode(3, "待加密");

	public static final StatusMode SECURING = new StatusMode(4, "加密中");

	public static final StatusMode SECURE_SUCCESS = new StatusMode(5, "加密成功");

	public static final StatusMode SECURE_FAILURE = new StatusMode(-5, "加密失败");

	static {
		INSTANCES.put(DO_NOTHING.id, DO_NOTHING);
		INSTANCES.put(TO_CONVERT.id, TO_CONVERT);
		INSTANCES.put(CONVERTING.id, CONVERTING);
		INSTANCES.put(COVERT_SUCCESS.id, COVERT_SUCCESS);
		INSTANCES.put(CONVERT_FAILURE.id, CONVERT_FAILURE);
		INSTANCES.put(TO_SECURE.id, TO_SECURE);
		INSTANCES.put(SECURING.id, SECURING);
		INSTANCES.put(SECURE_SUCCESS.id, SECURE_SUCCESS);
		INSTANCES.put(SECURE_FAILURE.id, SECURE_FAILURE);

	}

	public static StatusMode parse(int id) {
		return (StatusMode) INSTANCES.get(id);
	}
}
