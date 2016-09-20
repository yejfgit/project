package test.policy;

public class Hello {
	public String hello(String name) {
		if (name == null)
			name = "";
		return "你好" + name + "，欢迎来到Web服务的世界！";
	}
}
