package cn.com.dao;

import java.sql.Connection;
import java.util.List;

import cn.com.beans.Job;

public interface JobInfoDaoInf {
	List<Job> jobExport(Connection con,String sql);

}
