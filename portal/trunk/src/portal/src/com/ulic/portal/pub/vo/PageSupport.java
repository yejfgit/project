package com.ulic.portal.pub.vo;
import java.util.List;   
/**  
 */  
public class PageSupport implements java.io.Serializable{   
    /**
	 * @author zhangwei009
	 * @2010-5-26
	 */
	private static final long serialVersionUID = -2717667557326907908L;
	// Default page size   
    public static final int PAGESIZE = 10;   

    private int totalRowsAmount;   
    private int pageSize = PAGESIZE;   
    private int totalPages = 1;   
    // current page number   
    private int currentPage = 1;   
    // next page number   
    private int nextPage;   
    // previous page number   
    private int previousPage;   
    // is has next page   
    private boolean hasNext;   
    // is has previous page   
    private boolean hasPrevious;   
    // current page start row number   
    private int pageStartRow;   

    private List items;   
    private String pageContent;

	public PageSupport() {  
    }   

	public void setPageSize(int pageSize) {   
        this.pageSize = pageSize;   
    }   
    public void setTotalPages(int totalPages) {   
        this.totalPages = totalPages;   
    }   
    public void setNextPage(int nextPage) {   
        this.nextPage = nextPage;   
    }   
    public void setPreviousPage(int previousPage) {   
        this.previousPage = previousPage;   
    }   
    public void setHasNext(boolean hasNext) {   
        this.hasNext = hasNext;   
    }   
    public void setHasPrevious(boolean hasPrevious) {   
        this.hasPrevious = hasPrevious;   
    }   
    public void setPageStartRow(int pageStartRow) {   
        this.pageStartRow = pageStartRow;   
    }   
    public List getItems() {   
        return items;   
    }   
    public void setItems(List items) {   
        this.items = items;   
    }   

    public PageSupport(List items, int totalCount, int pageSize,   
            int currentPage) {   
        setPageSize(pageSize);   
        setItems(items);   
        this.setPSupport(totalCount, currentPage);   
    }  

    public void fillPageList(List items, int totalCount, int pageSize,   
            int currentPage) {   
        setPageSize(pageSize);   
        setItems(items);   
        setPSupport(totalCount, currentPage);   
    }  

    public void setPSupport(int totalRows, int currentPage) {   
        // 获取总页码，通过对象总数还是每页多少行的关系   
        setTotalRows(totalRows);   
        iniPageInfo(currentPage);   
    }   

    /**  
     * 设置总行数。  
     *   
     * @param rows  
     *            总行数。  
     */  
    private void setTotalRows(int rows) {   
        if (rows < 0) {   
            totalRowsAmount = 0;   
        } else {   
            totalRowsAmount = rows;   
        }   
        if (totalRowsAmount % pageSize == 0) {   
            totalPages = totalRowsAmount / pageSize;   
        } else {   
            totalPages = totalRowsAmount / pageSize + 1;   
        }   
    }   
    /**  
     *设置当前页数。  
     *   
     * @param curPage  
     */  
    private void iniPageInfo(int curPage) {   
//    	System.out.println("cpage: " + curPage);
        if (curPage <= 0) {   
            currentPage = 1;   
        } else if (curPage > totalPages) {   
            currentPage = totalPages;   
        } else {   
            currentPage = curPage;   
        }   
//    	System.out.println("currentPage: " + currentPage);

        if (currentPage == 1 || currentPage == 0) {   
            hasPrevious = false;   
        } else {   
            hasPrevious = true;   
        }   
        if (currentPage >= totalPages) {   
            hasNext = false;   
        } else {   
            hasNext = true;   
        }   
        nextPage = currentPage + 1;   
        previousPage = currentPage - 1;   
        // 计算当前页开始行和结束行   
        pageStartRow = (currentPage - 1) * pageSize + 1;   
        // pageStartRow = (currentPage - 1) * pageSize;   
        // 记录索引从0开始   
        pageStartRow -= 1;   
//        pageEndRow = pageStartRow + pageSize;   
    }   
    public int getCurrentPage() {   
        return currentPage;   
    }   
    public boolean isHasNext() {   
        return hasNext;   
    }   
    public boolean isHasPrevious() {   
        return hasPrevious;   
    }   
    public int getNextPage() {   
        return nextPage;   
    }   
    public int getPageSize() {   
        return pageSize;   
    }   
    public int getPreviousPage() {   
        return previousPage;   
    }   
    public int getTotalPages() {   
        return totalPages;   
    }   
    public int getTotalRowsAmount() {   
        return totalRowsAmount;   
    }   
    public int getStartRow(int rows) { 
    	setTotalRows(rows);
        if (currentPage <= 0) {   
            currentPage = 1;   
        } else if (currentPage > totalPages) {   
            currentPage = totalPages;   
        } 
        pageStartRow = (currentPage - 1) * pageSize;
        return pageStartRow;
    }   
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public void setTotalRowsAmount(int totalRowsAmount)
	{
		this.totalRowsAmount = totalRowsAmount;
	}
	public int getPageStartRow()
	{
		return pageStartRow;
	}
    public String getPageContent()
	{
    	if(this.totalRowsAmount > this.pageSize)
    	{
	    	StringBuffer pc = new StringBuffer();
	        pc.append("<table width=\"99%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"tablepage\">");
	        pc.append("<tr class=\"titleColorPage\" align=\"right\">");
	        pc.append("<td align=\"center\">");
	        pc.append("<input type=\"hidden\" name=\"page.currentPage\" value=\"" + currentPage + "\"/>");
	        pc.append("<input type=\"hidden\" name=\"page.previousPage\" value=\"" + previousPage + "\"/>");
	        pc.append("<input type=\"hidden\" name=\"page.nextPage\" value=\"" + nextPage + "\"/>");
	        pc.append("<input type=\"hidden\" name=\"page.totalPages\" value=\"" + totalPages + "\"/>");
	        pc.append("<input type=\"hidden\" name=\"page.totalRowsAmount\" value=\"" + totalRowsAmount + "\"/>");
	        pc.append("<input type=\"hidden\" name=\"page.pageStartRow\" value=\"" + pageStartRow + "\"/>");
	        pc.append("<span class=\"page-edge\">共&nbsp;");
	        //pc.append("页次&nbsp;<input name=\"curPage\" class=\"inputpage\" value=\"" + currentPage + "\" maxlength=\"10\" onkeypress=\"CheckJump();\">&nbsp;/&nbsp;");
	        pc.append(totalPages + "&nbsp;页</span>");
	        pc.append("&nbsp;&nbsp;");
	        if(hasPrevious) {
	        	pc.append("<a href=\"javascript:void(0)\" onclick=\"firstPage();return false;\" class=\"page\">首页</a>");
	        	pc.append("<a href=\"javascript:void(0)\" onclick=\"prevPage();return false;\" class=\"page\">上一页</a>");
	        }
	        
	        pc.append(getPageNums(currentPage, totalPages, 5));
	        
	        if(hasNext) {
	        	pc.append("<a href=\"javascript:void(0)\" onclick=\"nextPage();return false;\" class=\"page\">下一页</a>");
	        	pc.append("<a href=\"javascript:void(0)\" onclick=\"lastPage();return false;\" class=\"page\">尾页</a>");        	
	        } 
	        pc.append("</td>");
	        pc.append("</tr>");
	        pc.append("</table>");
	    	this.pageContent = pc.toString();
			return pageContent;
    	}else
    		return "";
	}
    
    /**
     * 获取多个页码效果
     * @param currentPage
     * @param totalPages
     * @param edge		当前页左右的页码个数
     * @return
     */
	private String getPageNums(int currentPage, int totalPages, int edge) {
		
		StringBuffer sb = new StringBuffer();
		
		if (currentPage - 1 > edge) {
			sb.append("<a class=\"page-edge\">...</a>");
		}

		int start = currentPage - 1 > edge ? currentPage - edge : 1;
		int end = totalPages - currentPage > edge ? currentPage + edge : totalPages;
		for (int i = start; i <= end; i++) {
			if (i == currentPage) {
				sb.append("<a class=\"page-sel\">" + i + "</a>");
			} else {
				sb.append("<a href=\"javascript:void(0)\" onclick=\"goPage(" + i + ");return false;\" class=\"page\">" + i + "</a>");
			}
			
		}

		if (totalPages - currentPage > edge) {
			sb.append("<a class=\"page-edge\">...</a>");
		}
		
		return sb.toString();
	}
    

}  


