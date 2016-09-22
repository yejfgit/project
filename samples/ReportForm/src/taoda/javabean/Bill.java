package taoda.javabean;

/**
 * 
 * 
 * 
 * Package&FileName: ds.javabean.Student
 */
public class Bill {
	// ~ Instance fields
	// ********************************************************

	// 编号
	private String numberId;
	// 年
	private String year;
	// 月
	private String mon;
	// 日
	private String day;

	// 客户号码
	private String cumNumb;

	// 客户名称
	private String cumName;

	// 金额

	private double money;

	// 大写金额

	private String capitalMoney;
	// 网店编号
	private String shopNum;
	
	public Bill(String numberId, String year, String mon, String day,
			String cumNumb, String cumName, double money, String capitalMoney,
			String shopNum) {
		super();
		this.numberId = numberId;
		this.year = year;
		this.mon = mon;
		this.day = day;
		this.cumNumb = cumNumb;
		this.cumName = cumName;
		this.money = money;
		this.capitalMoney = capitalMoney;
		this.shopNum = shopNum;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCumNumb() {
		return cumNumb;
	}
	public void setCumNumb(String cumNumb) {
		this.cumNumb = cumNumb;
	}
	public String getCumName() {
		return cumName;
	}
	public void setCumName(String cumName) {
		this.cumName = cumName;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCapitalMoney() {
		return capitalMoney;
	}
	public void setCapitalMoney(String capitalMoney) {
		this.capitalMoney = capitalMoney;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	

}
