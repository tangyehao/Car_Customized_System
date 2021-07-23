package cn.com.services;


import java.util.List;

import cn.com.beans.Firm;


public interface FirmManageServiseInf {
	List<Firm> firmExport();
	boolean firmUpdate(Firm f);
	boolean firmAdd(Firm f);
	boolean firmDelete(Firm f);
	List<Firm> firmExportByName(String fName);
}
