package cn.com.utils;

public interface Utils {
	String STOCK_BILL = "进货单";
	String SELL_BILL = "销售单";
	String CLIENTBACK_BILL = "顾客退货单";
	String BACK_BILL = "公司退货单";

	String SELL_JURISDICTION = "销售权限"; //销售和顾客退货
	String PURCHASE_JURISDICTION = "采购权限";//采购和退货
	String WAREHOUSE_JURISDICTION = "仓库权限";//仓库权限
	String BILL_JURISDICTION = "财务权限";//账单权限
	String PARTS_JURISDICTION = "零件权限";//供货商权限
	String CLIENT_JURISDICTION = "客户权限";//客户权限
	String FIRM_JURISDICTION = "厂商权限";//厂商权限
	String USER_JURISDICTION = "用户权限";//用户权限

	String INVENTORY_PUT = "入库";
	String INVENTORY_OUT = "出库库";

	String WHARHOUSE_LEISURE = "空闲";
	String WHARHOUSE_FORBIDDEN = "禁用";
	String WHARHOUSE_FULL = "饱和";

	String USER_FORBIDDEN = "禁用";
	String USER_NORMAL = "正常";

	String COLOR_RED = "红色";
	String COLOR_YELLOW = "黄色";
	String COLOR_GREEN = "绿色";
}
