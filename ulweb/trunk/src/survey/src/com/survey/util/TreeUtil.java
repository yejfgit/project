package com.survey.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.survey.vo.Dept;

/**
 * 构造树的工具类，根据组织架构的list，生成树型html代码
 * 
 * @author wengxf
 * 
 */
public class TreeUtil {

	static Log log = LogFactory.getLog(TreeUtil.class);
	
	private static List<Dept> list;

	private static StringBuffer sb;


	
	
	/**
	 * 用于在框架中显示机构树页面，具有根据某子节点自动展开树的功能
	 * @param slist
	 * @param deptId
	 * @return
	 */
	public static Map getTreeByList(List<Dept> slist, int deptId) {

		return getDeptTreeByList(slist, deptId);
	}
	
	/**
	 * 用于在对话框中显示机构树，不需要展开
	 * @param slist
	 * @param deptId
	 * @return
	 */
	public static String getTreeDialogByList(List<Dept> slist) {

		return (String) getDeptTreeByList(slist, 0).get("tree");
	}

	
	

	/**
	 * 显示结果
	 */
	private static void display() {

		log.info(sb.toString());

	}

	/**
	 * 把构造好的树html输出到页面
	 * deptId: 需要展开的节点ID
	 */
	private static Map getDeptTreeByList(List<Dept> slist, int deptId) {
		list = slist;

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("oList", getChainById(deptId));

		sb = new StringBuffer();
		sb.append("<style>div{padding: 1px}</style>");
		long s = System.currentTimeMillis();
		getDeptsByDeptId(21, 0);
		long e = System.currentTimeMillis();
		//display();
		//log.info("********** tree cost: " + ((double) (e - s) / 1000));

		map.put("tree", sb.toString());

		return map;
	}
	

	
	/**
	 * 根据id找到对应的节点
	 * 
	 * @param deptId
	 * @return
	 */
	private static Dept getDeptById(int deptId) {
		// System.out.println(list.size());
		for (Dept dept : list) {
			if (dept.getId() == deptId) {
				return dept;
			}
		}
		return null;
	}

	/**
	 * 根据id找到子节点列表
	 * 
	 * @param parentId
	 * @return
	 */
	private static List<Dept> getDeptByParentId(int parentId) {
		List<Dept> cList = new ArrayList<Dept>();
		for (Dept dept : list) {
			if (dept.getParentId() == parentId) {
				cList.add(dept);
			}
		}
		return cList;
	}

	/**
	 * 显示一个节点以下的所有树节点
	 */
	private static void getDeptsByDeptId(int deptId, int indent) {

		Dept dept = getDeptById(deptId);
		list.remove(dept);
		// 本节点是否存在
		if (dept == null) {
			return;
		}
		// 查找子节点
		List<Dept> cList = getDeptByParentId(deptId);
		int nChild = cList.size();

		// 组装名称和链接字符串
		String deptName = dept.getDeptName() == null ?
				"未命名" : dept.getDeptName().replace("[^w]*", "");
		
		String link;
//		if (dept.getIsDisplay() == 0) {
//			link = "<span id='de" + deptId + "' class='hide'>" + deptName + "</span>";
//		} else {
			link = "<a id='de" + deptId + "' href='javascript:;' onclick='list(" + deptId
			+ "," + dept.getParentId() + ",this)'>" + deptName
			+ "</a>";

//		}

		// 叶子节点
		if (nChild == 0) {
			sb.append("<div style=\"text-indent:" + writeSpace(indent + 1) + "px\">" + link + "</div>\n");
			return;
		}
		// 非叶子节点展开
		sb.append("<div style=\"text-indent:" + writeSpace(indent) + "px\">"
				+ "<a href='javascript:;' id='da" + deptId + "' onclick='o(" + deptId
				+ ")'>＋</a>" + link + "</div>\n" + "<div id='dd" + deptId
				+ "' style='display:none'>\n");
		indent++;
		for (Dept dept0 : cList) {
			getDeptsByDeptId(dept0.getId(), indent);
		}
		sb.append("</div>\n");

	}

	/**
	 * 根据缩进数量返回间隔符
	 * 
	 * @param indent
	 * @return
	 */
	private static String writeSpace(int indent) {

		return String.valueOf(indent * 10);
	}

	/**
	 * 根据id得到本节点的所有父节点序列
	 * 
	 * @param deptId
	 * @return
	 */
	private static List<Dept> getChainById(int deptId) {
		List<Dept> cList = new ArrayList<Dept>();
		if (deptId == 0) {
			return cList;
		}
		Dept dept = getDeptById(deptId);
		//log.info("************** get chain list");
		while (dept != null && dept.getParentId() != 0) {
			// System.out.println("chain deptId" +
			// getDeptById(dept.getParentId()).getDeptId());
			cList.add(getDeptById(dept.getParentId()));
			dept = getDeptById(dept.getParentId());
		}
		return cList;
	}

	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init();
		long s = System.currentTimeMillis();
		getDeptsByDeptId(0, 0);
		long e = System.currentTimeMillis();
		// display();
		
		log.info("*************** cost: " + ((double) (e - s) / 1000));
		// getChainById(6);
	}
	
	
	
	
}
